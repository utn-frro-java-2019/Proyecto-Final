package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import domain.PrecioPorHora;
import util.CustomExceptions.DatabaseAccessException;

public class PrecioPorHoraData {

	public PrecioPorHora getPrecioPorHora() {
		PrecioPorHora p = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from precio_por_hora where idPrecio = 1");

			while (rs.next()) {
				p = new PrecioPorHora();
				p.setPrecio(rs.getDouble("precio"));
			}

		} catch (SQLException e) {
	        throw new DatabaseAccessException("Error SQL al intentar obtener el precio por hora en la base de datos", e);
		} catch (Exception e) {
	        throw new DatabaseAccessException("Error al intentar obtener el precio por hora en la base de datos", e);
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
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al obtener el precio por hora", e);
	        }		
		}

		return p;
	}

	public void updatePrecioPorHora(PrecioPorHora p) {
		PreparedStatement pstmt = null;
		try {
			pstmt = FactoryConnection.getInstancia().getConn()
					.prepareStatement("update precio_por_hora set precio = ? where idPrecio = 1");

			pstmt.setDouble(1, p.getPrecio());

			pstmt.executeUpdate();


		} catch (SQLException e) {
	        throw new DatabaseAccessException("Error SQL al intentar actualizar el precio por hora en la base de datos", e);
		} catch (Exception e) {
	        throw new DatabaseAccessException("Error al intentar actualizar el precio por hora en la base de datos", e);
		}
		finally {
	        try {
	            if (pstmt != null) {
	                pstmt.close();
	            }
	            FactoryConnection.getInstancia().releaseConn();
	        } catch (SQLException e) {
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al actualizar el precio por hora", e);
	        }		
		}
	}
}
