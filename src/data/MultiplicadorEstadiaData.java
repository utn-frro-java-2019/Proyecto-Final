package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.*;
import util.CustomExceptions.DatabaseAccessException;

public class MultiplicadorEstadiaData {

	public ArrayList<MultiplicadorEstadia> getAll() {
		ArrayList<MultiplicadorEstadia> multiplicadoresEstadias = new ArrayList<MultiplicadorEstadia>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from multiplicadores_estadias");

			while (rs.next()) {
				MultiplicadorEstadia me = new MultiplicadorEstadia();

				me.setMultiplicadorDesde(rs.getInt("multiplicadorDesde"));
				me.setPorcentajeMultiplicador(rs.getDouble("porcentajeMultiplicador"));

				multiplicadoresEstadias.add(me);
			}

		} catch (SQLException e) {
	        throw new DatabaseAccessException("Error SQL al intentar obtener los multiplicadores de estadias en la base de datos", e);
		} catch (Exception e) {
	        throw new DatabaseAccessException("Error SQL al intentar obtener los multiplicadores de estadias en la base de datos", e);
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
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al obtener los multiplicadores de estadia", e);
	        }		
		}

		return multiplicadoresEstadias;
	}

	public MultiplicadorEstadia getOne(int multiplicadorDesde) {
		MultiplicadorEstadia me = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			rs = stmt
					.executeQuery(
							"select * from multiplicadores_estadias where multiplicadorDesde =" + multiplicadorDesde);
			while (rs.next()) {
				me = new MultiplicadorEstadia();

				me.setMultiplicadorDesde(rs.getInt("multiplicadorDesde"));
				me.setPorcentajeMultiplicador(rs.getDouble("porcentajeMultiplicador"));
			}


		} catch (SQLException e) {
	        throw new DatabaseAccessException("Error SQL al intentar obtener un multiplicador de estadias en la base de datos", e);
		} catch (Exception e) {
			System.out.println(e.getMessage());
	        throw new DatabaseAccessException("Error al intentar obtener un multiplicador de estadias en la base de datos", e);
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
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al obtener un multiplicador de estadia", e);
	        }		
		}
		

		return me;
	}

	public void deleteOne(int multiplicadorDesde) {
		PreparedStatement pstmt = null;
		try {
			pstmt = FactoryConnection.getInstancia().getConn()
					.prepareStatement("delete from multiplicadores_estadias where multiplicadorDesde = ?");
			pstmt.setInt(1, multiplicadorDesde);
			pstmt.executeUpdate();
			if (pstmt != null) {
				pstmt.close();
			}

		} catch (SQLException e) {
	        throw new DatabaseAccessException("Error SQL al intentar eliminar un multiplicador de estadias en la base de datos", e);
		} catch (Exception e) {
	        throw new DatabaseAccessException("Error al intentar eliminar un multiplicador de estadias en la base de datos", e);
		}
		finally {
	        try {
	            if (pstmt != null) {
	                pstmt.close();
	            }
	        } catch (SQLException e) {
	            throw new DatabaseAccessException("Error al intentar cerrar el statement conexión al eliminar un multiplicador de estadia", e);
	        }		
		}
	}

	public void insertOne(MultiplicadorEstadia me) {
		PreparedStatement pstmt = null;
		try {
			pstmt = FactoryConnection.getInstancia().getConn().prepareStatement(
					"insert into multiplicadores_estadias (multiplicadorDesde, porcentajeMultiplicador) values (?,?)");
			pstmt.setInt(1, me.getMultiplicadorDesde());
			pstmt.setDouble(2, me.getPorcentajeMultiplicador());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
	        throw new DatabaseAccessException("Error SQL al intentar insertar un multiplicador de estadias en la base de datos", e);
		} catch (Exception e) {
			System.out.println(e.getMessage());
	        throw new DatabaseAccessException("Error al intentar insertar un multiplicador de estadias en la base de datos", e);
		}
		finally {
	        try {
	            if (pstmt != null) {
	                pstmt.close();
	            }
	            FactoryConnection.getInstancia().releaseConn();
	        } catch (SQLException e) {
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al insertar un multiplicador de estadia", e);
	        }		
		}
	}
}
