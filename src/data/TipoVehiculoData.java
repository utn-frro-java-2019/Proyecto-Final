package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.*;
import util.CustomExceptions.DatabaseAccessException;

public class TipoVehiculoData {

	public ArrayList<TipoVehiculo> getAll() {
		ArrayList<TipoVehiculo> tiposVehiculos = new ArrayList<TipoVehiculo>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from tipos_vehiculos");

			while (rs.next()) {
				TipoVehiculo tv = new TipoVehiculo();

				tv.setIdTipo(rs.getInt("idTipo"));
				tv.setDescripcion(rs.getString("descripcion"));
				tv.setPorcentajeMultiplicador(rs.getDouble("porcentajeMultiplicador"));

				tiposVehiculos.add(tv);
			}

		} catch (SQLException e) {
	        throw new DatabaseAccessException("Error SQL al intentar obtener los tipos de vehiculo en la base de datos", e);
		} catch (Exception e) {
	        throw new DatabaseAccessException("Error al intentar obtener los tipos de vehiculo en la base de datos", e);
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
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al obtener los tipos de vehiculo", e);
	        }		
		}

		return tiposVehiculos;
	}

	public TipoVehiculo getOne(int idTipo) {
		TipoVehiculo tv = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = FactoryConnection.getInstancia().getConn()
					.prepareStatement("select * from tipos_vehiculos where idTipo = ?");
			pstmt.setInt(1, idTipo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				tv = new TipoVehiculo();

				tv.setIdTipo(rs.getInt("idTipo"));
				tv.setDescripcion(rs.getString("descripcion"));
				tv.setPorcentajeMultiplicador(rs.getDouble("porcentajeMultiplicador"));
			}

		} catch (SQLException e) {
	        throw new DatabaseAccessException("Error SQL al intentar obtener un tipo de vehiculo en la base de datos", e);
		} catch (Exception e) {
	        throw new DatabaseAccessException("Error SQL al intentar obtener un tipo de vehiculo en la base de datos", e);
		}
		finally {
	        try {
	        	if (rs != null) {
	                rs.close();
	            }
	            if (pstmt != null) {
	                pstmt.close();
	            }
	            FactoryConnection.getInstancia().releaseConn();
	        } catch (SQLException e) {
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al obtener un tipo de vehiculo", e);
	        }		
		}

		return tv;
	}

	public void deleteOne(int idTipo) {
		PreparedStatement pstmt = null;
		try {
			pstmt = FactoryConnection.getInstancia().getConn()
					.prepareStatement("delete from tipos_vehiculos where idTipo = ?");
			pstmt.setInt(1, idTipo);
			pstmt.executeUpdate();
			

		} catch (SQLException e) {
	        throw new DatabaseAccessException("Error SQL al intentar eliminar un tipo de vehiculo en la base de datos", e);
		} catch (Exception e) {
	        throw new DatabaseAccessException("Error SQL al intentar eliminar un tipo de vehiculo en la base de datos", e);
		}
		finally {
	        try {
	            if (pstmt != null) {
	                pstmt.close();
	            }
	        } catch (SQLException e) {
	            throw new DatabaseAccessException("Error al intentar cerrar el statement al obtener un tipo de vehiculo", e);
	        }		
		}
	}

	public void insertOne(TipoVehiculo tv) {
		PreparedStatement pstmt = null;
		try {
			pstmt = FactoryConnection.getInstancia().getConn()
					.prepareStatement(
							"insert into tipos_vehiculos (descripcion, porcentajeMultiplicador) values (?,?)");
			pstmt.setString(1, tv.getDescripcion());
			pstmt.setDouble(2, tv.getPorcentajeMultiplicador());

			pstmt.executeUpdate();


		} catch (SQLException e) {
	        throw new DatabaseAccessException("Error SQL al intentar insertar un tipo de vehiculo en la base de datos", e);
		} catch (Exception e) {
	        throw new DatabaseAccessException("Error al intentar insertar un tipo de vehiculo en la base de datos", e);
		}
		finally {
	        try {
	            if (pstmt != null) {
	                pstmt.close();
	            }
	            FactoryConnection.getInstancia().releaseConn();
	        } catch (SQLException e) {
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al insertar un tipo de vehiculo", e);
	        }		
		}
	}

	public void updateOne(TipoVehiculo tv) {
		PreparedStatement pstmt = null;
		try {
			pstmt = FactoryConnection.getInstancia().getConn().prepareStatement(
					"update tipos_vehiculos set descripcion = ? , porcentajeMultiplicador = ? where idTipo = ? ");
			pstmt.setString(1, tv.getDescripcion());
			pstmt.setDouble(2, tv.getPorcentajeMultiplicador());
			pstmt.setInt(3, tv.getIdTipo());

			pstmt.executeUpdate();

		} catch (SQLException e) {
	        throw new DatabaseAccessException("Error SQL al intentar modificar un tipo de vehiculo en la base de datos", e);
		} catch (Exception e) {
	        throw new DatabaseAccessException("Error al intentar modificar un tipo de vehiculo en la base de datos", e);
		}
		finally {
	        try {
	            if (pstmt != null) {
	                pstmt.close();
	            }
	            FactoryConnection.getInstancia().releaseConn();
	        } catch (SQLException e) {
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al modificar un tipo de vehiculo", e);
	        }		
		}
	}
}
