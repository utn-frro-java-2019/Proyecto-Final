package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import domain.*;
import util.CustomExceptions.DatabaseAccessException;;

public class DiarioData extends IngresoData {

	public ArrayList<Diario> getAllByCochera(String idCochera) {
		ArrayList<Diario> ingresos = new ArrayList<Diario>();
		Statement stmt = null;
	    ResultSet rs = null;
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from ingresos where tipoIngreso='diario' and idCochera='"
					+ idCochera + "' order by fechaIngreso desc");

			while (rs.next()) {
				Diario d = new Diario();

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

				ingresos.add(d);
			}


		} catch (SQLException e) {
	        throw new DatabaseAccessException("Error SQL al intentar obtener los ingresos en la base de datos", e);
		} catch (Exception e) {
	        throw new DatabaseAccessException("Error general al intentar obtener los ingresos en la base de datos", e);
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
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al obtener ingresos", e);
	        }		
		}
		return ingresos;
	}

	public Diario getOneActiveByComprobante(String comprobante) {
		Diario d = null;
		Statement stmt = null;
	    ResultSet rs = null;
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			rs = stmt
					.executeQuery("select * from ingresos where comprobante='" + comprobante
							+ "' and tipoIngreso='diario' and estado='activo'");

			while (rs.next()) {
				d = new Diario();

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
	        throw new DatabaseAccessException("Error SQL al intentar obtener un ingreso en la base de datos", e);
		} catch (Exception e) {
	        throw new DatabaseAccessException("Error general al intentar obtener un ingreso en la base de datos", e);
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
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al obtener un ingreso", e);
	        }		
		}

		return d;
	}

	public Diario insertOne(Diario diario) {
		PreparedStatement pstmt = null;
		try {
			pstmt = FactoryConnection.getInstancia().getConn().prepareStatement(
					"insert into ingresos (comprobante, idCochera, nroLugar, patente, fechaIngreso, estado, tipoIngreso) values (?, ?, ?, ?, NOW(), 'activo', 'diario')");

			pstmt.setString(1, diario.getComprobante());
			pstmt.setInt(2, diario.getCochera().getIdCochera());
			pstmt.setInt(3, diario.getLugar().getNroLugar());
			pstmt.setString(4, diario.getVehiculo().getPatente());

			pstmt.executeUpdate();


		} catch (SQLException e) {
	        throw new DatabaseAccessException("Error SQL al intentar insertar el ingreso en la base de datos", e);
		} catch (Exception e) {
	        throw new DatabaseAccessException("Error al intentar insertar el ingreso en la base de datos", e);
		}
		finally {
	        try {
	            if (pstmt != null) {
	            	pstmt.close();
	            }
	            FactoryConnection.getInstancia().releaseConn();
	        } catch (SQLException e) {
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al insertar un ingreso", e);
	        }		
		}

		return diario;
	}

	public Diario finalizeOne(Diario diario, Double price) {
		Diario d = new Diario();
		Statement stmt = null;
		Statement stmtGet = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			stmt.executeUpdate(
					"update ingresos set fechaRetiro=NOW(), precioFinal=" + price
							+ ", estado='finalizado' where idIngreso=" + diario.getIdIngreso());

			stmtGet = FactoryConnection.getInstancia().getConn().createStatement();
			rs = stmtGet
					.executeQuery(
							"select * from ingresos where comprobante='" + diario.getComprobante()
									+ "' and tipoIngreso='diario'");

			while (rs.next()) {
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

			FactoryConnection.getInstancia().releaseConn();

		} catch (SQLException e) {
	        throw new DatabaseAccessException("Error SQL al intentar finalizar el ingreso en la base de datos", e);
		} catch (Exception e) {
			throw new DatabaseAccessException("Error al intentar finalizar el ingreso en la base de datos");
		}
			finally {
		        try {
		            if (stmt != null) {
		            	stmt.close();
		            }
		            if (stmtGet != null) {
		            	stmtGet.close();
		            }
		            if (rs != null) {
		            	rs.close();
		            }
		            FactoryConnection.getInstancia().releaseConn();
		        } catch (SQLException e) {
		            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al finalizar un ingreso", e);
		        }		
			}

		return d;
	}
	
}
	
