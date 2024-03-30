package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import domain.*;
import util.CustomExceptions.DatabaseAccessException;

public class EstadiaData extends IngresoData {

	public ArrayList<Estadia> getAllByCochera(String idCochera) {
		ArrayList<Estadia> ingresos = new ArrayList<Estadia>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from ingresos where tipoIngreso='estadia' and idCochera='"
					+ idCochera + "' order by fechaIngreso desc");

			while (rs.next()) {
				Estadia e = new Estadia();

				java.util.Calendar cal = Calendar.getInstance();
				cal.setTimeZone(TimeZone.getTimeZone("GMT-3"));

				e.setIdIngreso(rs.getInt("idIngreso"));
				e.setComprobante(rs.getString("comprobante"));
				e.setCochera(new data.CocheraData().getOne(rs.getInt("idCochera")));
				e.setLugar(new data.LugarData().getOne(rs.getInt("nroLugar"), rs.getInt("idCochera")));
				e.setVehiculo(new data.VehiculoData().getOne(rs.getString("patente")));
				e.setFechaIngreso(rs.getTimestamp("fechaIngreso", cal));
				e.setFechaRetiro(rs.getTimestamp("fechaRetiro", cal));
				e.setPrecioFinal(rs.getDouble("precioFinal"));
				e.setEstado(rs.getString("estado"));
				e.setPrecioFinal(rs.getDouble("precioFinal"));
				e.setAutoEnCochera(rs.getBoolean("autoEnCochera"));

				ingresos.add(e);
			}

		} catch (SQLException e) {
			throw new DatabaseAccessException("Error SQL al intentar insertar una estadia en la base de datos", e);
		} catch (Exception e) {
			throw new DatabaseAccessException("Error al intentar insertar una estadia en la base de datos", e);
		}
		finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (stmt != null) {
	                stmt.close();
	            }
	            FactoryConnection.getInstancia().releaseConn();
	        } catch (SQLException e) {
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al insertar una estadia", e);
	        }		
		}

		return ingresos;
	}

	public Estadia getOneActiveByComprobante(String comprobante) {
		Estadia d = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			rs = stmt
					.executeQuery("select * from ingresos where comprobante='" + comprobante
							+ "' and tipoIngreso='estadia' and estado='activo'");

			while (rs.next()) {
				d = new Estadia();

				java.util.Calendar cal = Calendar.getInstance();
				cal.setTimeZone(TimeZone.getTimeZone("GMT-3"));

				d.setIdIngreso(rs.getInt("idIngreso"));
				d.setComprobante(rs.getString("comprobante"));
				d.setCochera(new data.CocheraData().getOne(rs.getInt("idCochera")));
				d.setLugar(new data.LugarData().getOne(rs.getInt("nroLugar"), rs.getInt("idCochera")));
				d.setVehiculo(new data.VehiculoData().getOne(rs.getString("patente")));
				d.setFechaIngreso(rs.getTimestamp("fechaIngreso", cal));
				d.setFechaRetiro(rs.getTimestamp("fechaRetiro", cal));
				d.setPrecioFinal(rs.getDouble("precioFinal"));
				d.setEstado(rs.getString("estado"));
				d.setPrecioFinal(rs.getDouble("precioFinal"));
				d.setAutoEnCochera(rs.getBoolean("autoEnCochera"));
			}

		} catch (SQLException e) {
			throw new DatabaseAccessException("Error SQL al intentar obtener una estadia activa por comprobante", e);
		} catch (Exception e) {
			throw new DatabaseAccessException("Error al intentar obtener una estadia activa por comprobante", e);
		}
		finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (stmt != null) {
	                stmt.close();
	            }
	            FactoryConnection.getInstancia().releaseConn();
	        } catch (SQLException e) {
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al obtener una estadia activa por comprobante", e);
	        }		
		}

		return d;
	}

	public Estadia insertOne(Estadia estadia) {
		PreparedStatement pstmt = null;
		try {
			pstmt = FactoryConnection.getInstancia().getConn().prepareStatement(
					"insert into ingresos (comprobante, idCochera, nroLugar, patente, fechaIngreso, estado, tipoIngreso, fechaRetiro, precioFinal, autoEnCochera) values (?, ?, ?, ?, NOW(), 'activo', 'estadia', ?, ?, ?)");

			pstmt.setString(1, estadia.getComprobante());
			pstmt.setInt(2, estadia.getCochera().getIdCochera());
			pstmt.setInt(3, estadia.getLugar().getNroLugar());
			pstmt.setString(4, estadia.getVehiculo().getPatente());
			pstmt.setTimestamp(5, new java.sql.Timestamp(estadia.getFechaRetiro().getTime()));
			pstmt.setDouble(6, estadia.getPrecioFinal());
			pstmt.setBoolean(7, estadia.getAutoEnCochera());

			pstmt.executeUpdate();

			if (pstmt != null) {
				pstmt.close();
			}
			FactoryConnection.getInstancia().releaseConn();

		} catch (SQLException e) {
			throw new DatabaseAccessException("Error SQL al intentar insertar una estadia en la base de datos", e);
		} catch (Exception e) {
			throw new DatabaseAccessException("Error al intentar insertar una estadia en la base de datos", e);
		}
		finally {
	        try {
	            if (pstmt != null) {
	                pstmt.close();
	            }
	            FactoryConnection.getInstancia().releaseConn();
	        } catch (SQLException e) {
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al insertaruna estadia", e);
	        }		
		}

		return estadia;
	}

	public void salidaVehiculo(Integer idIngreso) {
		Statement stmt = null;
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			stmt.executeUpdate("update ingresos set autoEnCochera=false where idIngreso=" + idIngreso);

		} catch (SQLException e) {
			throw new DatabaseAccessException("Error SQL al intentar modificar la salida de vehiculo en la base de datos", e);
		} catch (Exception e) {
			throw new DatabaseAccessException("Error al intentar modificar la salida de vehiculo en la base de datos", e);
		}
		finally {
	        try {
	            if (stmt != null) {
	                stmt.close();
	            }
	            FactoryConnection.getInstancia().releaseConn();
	        } catch (SQLException e) {
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al modificar la salida de vehiculo", e);
	        }		
		}

	}

	public void ingresoVehiculo(Integer idIngreso) {
		Statement stmt = null;
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			stmt.executeUpdate("update ingresos set autoEnCochera=true where idIngreso=" + idIngreso);

		} catch (SQLException e) {
			throw new DatabaseAccessException("Error SQL al intentar actualizar el ingreso de vehiculo al lugar por estadia en la base de datos", e);
		} catch (Exception e) {
			throw new DatabaseAccessException("Error al intentar actualizar el ingreso de vehiculo al lugar por estadia en la base de datos", e);
		}
		finally {
	        try {
	            if (stmt != null) {
	                stmt.close();
	            }
	            FactoryConnection.getInstancia().releaseConn();
	        } catch (SQLException e) {
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al actualizar el ingreso de vehiculo al lugar por estadia", e);
	        }		
		}

	}

	public void finalizeOne(Integer idIngreso) {
		Statement stmt = null;
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			stmt.executeUpdate("update ingresos set estado='finalizado' where idIngreso=" + idIngreso);

		} catch (SQLException e) {
			throw new DatabaseAccessException("Error SQL al intentar finalizar la estadia la base de datos", e);
		} catch (Exception e) {
			throw new DatabaseAccessException("Error al intentar finalizar la estadia la base de datos", e);
		}
		finally {
	        try {
	            if (stmt != null) {
	                stmt.close();
	            }
	            FactoryConnection.getInstancia().releaseConn();
	        } catch (SQLException e) {
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al intentar finalizar la estadia", e);
	        }		
		}
	}

}
