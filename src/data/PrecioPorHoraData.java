package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import domain.PrecioPorHora;

public class PrecioPorHoraData {

	public PrecioPorHora getPrecioPorHora() {
		PrecioPorHora p = null;
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs = stmt.executeQuery("select * from precio_por_hora where idPrecio = 1");

			while (rs.next()) {
				p = new PrecioPorHora();
				p.setPrecio(rs.getDouble("precio"));
			}

			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			FactoryConnection.getInstancia().releaseConn();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Error al recuperar el precio por hora");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Error al recuperar el precio por hora");
		}

		return p;
	}

	public void updatePrecioPorHora(PrecioPorHora p) {
		try {
			PreparedStatement pstmt = FactoryConnection.getInstancia().getConn()
					.prepareStatement("update precio_por_hora set precio = ? where idPrecio = 1");

			pstmt.setDouble(1, p.getPrecio());

			pstmt.executeUpdate();

			if (pstmt != null) {
				pstmt.close();
			}
			FactoryConnection.getInstancia().releaseConn();

		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
			throw new RuntimeException("Error al actualizar el precio por hora");
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
			throw new RuntimeException("Error al actualizar el precio por hora");
		}
	}
}
