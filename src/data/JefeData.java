package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.*;

public class JefeData {
	public Jefe get() {
		ArrayList<Jefe> jefes = new ArrayList<Jefe>();
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs = stmt.executeQuery("select * from jefes");

			while (rs.next()) {
				Jefe j = new Jefe();

				j.setNombre(rs.getString("nombre"));
				j.setApellido(rs.getString("apellido"));
				j.setEmail(rs.getString("email"));
				j.setPassword(rs.getString("password"));

				jefes.add(j);
			}

			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			FactoryConnection.getInstancia().releaseConn();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jefes.get(0);
	}
}
