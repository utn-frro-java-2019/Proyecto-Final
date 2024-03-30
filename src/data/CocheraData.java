package data;

import java.sql.*;
import java.util.ArrayList;

import domain.*;
import util.CustomExceptions.CocheraConEmpleadosException;
import util.CustomExceptions.DatabaseAccessException;

public class CocheraData {

	public ArrayList<Cochera> getAll() {
		ArrayList<Cochera> cocheras = new ArrayList<Cochera>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String consulta = "select * from cocheras where eliminado is not true";
			stmt = FactoryConnection.getInstancia().getConn().prepareStatement(consulta);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Cochera c = new Cochera();
				c.setIdCochera(rs.getInt("idCochera"));
				c.setNombre(rs.getString("nombre"));
				c.setDescripcion(rs.getString("descripcion"));
				c.setUbicacion(rs.getString("ubicacion"));
				c.setCapacidad(rs.getInt("capacidad"));
				cocheras.add(c);
			}

		} catch (SQLException e) {
	        throw new DatabaseAccessException("Error SQL al intentar obtener las cocheras en la base de datos", e);
		} catch (Exception e) {
	        throw new DatabaseAccessException("Error al intentar obtener las cocheras en la base de datos", e);
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
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al obtener las cocheras", e);
	        }		
		}

		return cocheras;
	}

	public Cochera getOne(int idCochera) {
		Cochera c = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {

			String consulta = "select * from cocheras where idCochera = ? ";
			stmt = FactoryConnection.getInstancia().getConn().prepareStatement(consulta);
			stmt.setString(1, Integer.toString(idCochera));
			rs = stmt.executeQuery();

			while (rs.next()) {
				c = new Cochera();

				c.setIdCochera(rs.getInt("idCochera"));
				c.setNombre(rs.getString("nombre"));
				c.setDescripcion(rs.getString("descripcion"));
				c.setUbicacion(rs.getString("ubicacion"));
				c.setCapacidad(rs.getInt("capacidad"));

			}

		} catch (SQLException e) {
	        throw new DatabaseAccessException("Error SQL al intentar obtener una cochera en la base de datos", e);
		} catch (Exception e) {
	        throw new DatabaseAccessException("Error al intentar obtener una cochera en la base de datos", e);
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
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al obtener una cochera", e);
	        }		
		}

		return c;
	}

	public void deleteOne(int idCochera) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PreparedStatement eStmt = null;
		try {
			String empleadosCheck = "select * from empleados where idCochera = ?";
			eStmt = FactoryConnection.getInstancia().getConn().prepareStatement(empleadosCheck);
			eStmt.setString(1, Integer.toString(idCochera));
			rs = eStmt.executeQuery();
			if (rs.next()) {
				throw new CocheraConEmpleadosException("No se puede eliminar la cochera porque tiene empleados asignados");
			}

			String consulta = "update cocheras set eliminado = 1 where idCochera = ?";
			pstmt = FactoryConnection.getInstancia().getConn().prepareStatement(consulta);
			pstmt.setString(1, Integer.toString(idCochera));
			pstmt.executeUpdate();

		} catch (SQLException e) {
	        throw new DatabaseAccessException("Error SQL al intentar borrar una cochera en la base de datos", e);
		} catch (Exception e) {
	        throw new DatabaseAccessException("Error al intentar borrar una cochera en la base de datos", e);
		}
		finally {
	        try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
				if (eStmt != null) {
					eStmt.close();
				}
	        } catch (SQLException e) {
	            throw new DatabaseAccessException("Error al intentar cerrar el statement al borrar una cochera", e);
	        }		
		}
	}

	public Integer insertOne(Cochera c) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PreparedStatement stmtID = null;
		Integer id = 0;
		try {
			String getID = "select max(idCochera)+1 id from cocheras";
			stmtID = FactoryConnection.getInstancia().getConn().prepareStatement(getID);
			rs = stmtID.executeQuery();
			
			while (rs.next()) {
				id = rs.getInt("id");
			}

			String consulta = "insert into cocheras (nombre, ubicacion, descripcion, capacidad, idCochera) values (?, ?, ?, ?, ?)";
			pstmt = FactoryConnection.getInstancia().getConn().prepareStatement(consulta);
			pstmt.setString(1, c.getNombre());
			pstmt.setString(2, c.getUbicacion());
			pstmt.setString(3, c.getDescripcion());
			pstmt.setString(4, Integer.toString(c.getCapacidad()));
			pstmt.setString(5, Integer.toString(id));
			pstmt.executeUpdate();

		} catch (SQLException e) {
	        throw new DatabaseAccessException("Error SQL al intentar insertar una cochera en la base de datos", e);
		} catch (Exception e) {
			System.out.println(e.getMessage());
	        throw new DatabaseAccessException("Error al intentar insertar una cochera en la base de datos", e);
		}
		finally {
	        try {
	        	if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (stmtID != null) {
					stmtID.close();
				}
				FactoryConnection.getInstancia().releaseConn();
	        } catch (SQLException e) {
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al insertar una cochera", e);
	        }		
		}
		return id;
	}

	public void updateOne(Cochera c) {
		PreparedStatement pstmt = null;
		try {
			String consulta = "update cocheras set nombre = ?, ubicacion = ?, descripcion = ? where idCochera = ?";
			pstmt = FactoryConnection.getInstancia().getConn().prepareStatement(consulta);
			pstmt.setString(1, c.getNombre());
			pstmt.setString(2, c.getUbicacion());
			pstmt.setString(3, c.getDescripcion());
			pstmt.setString(4, Integer.toString(c.getIdCochera()));
			pstmt.executeUpdate();

		} catch (SQLException e) {
	        throw new DatabaseAccessException("Error SQL al intentar modificar una cochera en la base de datos", e);
		} catch (Exception e) {
	        throw new DatabaseAccessException("Error al intentar modificar una cochera en la base de datos", e);
		}
		finally {
	        try {
				if (pstmt != null) {
					pstmt.close();
				}
				FactoryConnection.getInstancia().releaseConn();
	        } catch (SQLException e) {
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al modificar una cochera", e);
	        }		
		}
	}
}
