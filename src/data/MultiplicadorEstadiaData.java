package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.*;

public class MultiplicadorEstadiaData {

	public ArrayList<MultiplicadorEstadia> getAll() {
		ArrayList<MultiplicadorEstadia> multiplicadoresEstadias = new ArrayList<MultiplicadorEstadia>();
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs = stmt.executeQuery("select * from multiplicadores_estadias");

			while (rs.next()) {
				MultiplicadorEstadia me = new MultiplicadorEstadia();

				me.setMultiplicadorDesde(rs.getInt("multiplicadorDesde"));
				me.setPorcentajeMultiplicador(rs.getDouble("porcentajeMultiplicador"));

				multiplicadoresEstadias.add(me);
			}

			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			FactoryConnection.getInstancia().releaseConn();

		} catch (SQLException e) {
			new RuntimeException("Error al recuperar los multiplicadores de estadia");
		} catch (Exception e) {
			new RuntimeException("Error al recuperar los multiplicadores de estadia");
		}

		return multiplicadoresEstadias;
	}

	public MultiplicadorEstadia getOne(int multiplicadorDesde) {
		MultiplicadorEstadia me = null;
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs = stmt
					.executeQuery("select * from multiplicadores_estadias where multiplicadorDesde =" + multiplicadorDesde);
			while (rs.next()) {
				me = new MultiplicadorEstadia();

				me.setMultiplicadorDesde(rs.getInt("multiplicadorDesde"));
				me.setPorcentajeMultiplicador(rs.getDouble("porcentajeMultiplicador"));
			}

			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			FactoryConnection.getInstancia().releaseConn();

		} catch (SQLException e) {
			new RuntimeException("Error al recuperar el multiplicador de estadia");
		} catch (Exception e) {
			new RuntimeException("Error al recuperar el multiplicador de estadia");
		}

		return me;
	}

	public void deleteOne(int multiplicadorDesde) {
		try {
			PreparedStatement pstmt = FactoryConnection.getInstancia().getConn()
					.prepareStatement("delete from multiplicadores_estadias where multiplicadorDesde = ?");
			pstmt.setInt(1, multiplicadorDesde);
			pstmt.executeUpdate();
			if (pstmt != null) {
				pstmt.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertOne(MultiplicadorEstadia me) {
		try {
			PreparedStatement pstmt = FactoryConnection.getInstancia().getConn().prepareStatement(
					"insert into multiplicadores_estadias (multiplicadorDesde, porcentajeMultiplicador) values (?,?)");
			pstmt.setInt(1, me.getMultiplicadorDesde());
			pstmt.setDouble(2, me.getPorcentajeMultiplicador());

			pstmt.executeUpdate();

			if (pstmt != null) {
				pstmt.close();
			}
			FactoryConnection.getInstancia().releaseConn();

		} catch (SQLException e) {
			new RuntimeException("Error al crear el multiplicador de estadia");
		} catch (Exception e) {
			new RuntimeException("Error al crear el multiplicador de estadia");
		}
	}
}
