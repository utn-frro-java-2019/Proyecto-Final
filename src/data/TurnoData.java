package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.*;

public class TurnoData {

	public ArrayList<Turno> getAll() {
		ArrayList<Turno> turnos = new ArrayList<Turno>();
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs = stmt.executeQuery("select * from turnos");

			while (rs.next()) {
				Turno t = new Turno();

				t.setIdTurno(rs.getInt("idTurno"));
				t.setDescripcion(rs.getString("descripcion"));
				t.setHoraInicio(rs.getTime("horaInicio"));
				t.setHoraFin(rs.getTime("horaFin"));

				turnos.add(t);
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
			throw new RuntimeException("Error al recuperar los turnos");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Error al recuperar los turnos");
		}

		return turnos;
	}

	public Turno getOne(int id) {
		Turno t = null;
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs = stmt.executeQuery("select * from turnos where idTurno=" + id);
			while (rs.next()) {
				t = new Turno();

				t.setIdTurno(rs.getInt("idTurno"));
				t.setDescripcion(rs.getString("descripcion"));
				t.setHoraInicio(rs.getTime("horaInicio"));
				t.setHoraFin(rs.getTime("horaFin"));
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
			throw new RuntimeException("Error al recuperar el turno");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Error al recuperar el turno");
		}

		return t;
	}
}
