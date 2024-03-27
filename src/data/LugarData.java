package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.*;

public class LugarData {

	public ArrayList<Lugar> getAllFromCochera(int idCochera) {
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs = stmt.executeQuery("select * from lugares where idCochera =" + idCochera);

			while (rs.next()) {
				Lugar l = new Lugar();

				l.setNroLugar(rs.getInt("nroLugar"));
				boolean ocupado = false;
				if (rs.getString("ocupado") == "true")
					ocupado = true;
				l.setOcupado(ocupado);
				l.setCochera(new data.CocheraData().getOne(rs.getInt("idCochera")));

				lugares.add(l);
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
			throw new RuntimeException("Error al intentar obtener los lugares en la base de datos");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Error al intentar obtener los lugares en la base de datos");
		}

		return lugares;
	}

	public void updateOne(Lugar l) {
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			stmt.executeUpdate("update lugares set ocupado = '" + l.isOcupado() + "' where nroLugar = "
					+ l.getNroLugar() + " and idCochera = " + l.getCochera().getIdCochera());

			if (stmt != null) {
				stmt.close();
			}
			FactoryConnection.getInstancia().releaseConn();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Error al intentar actualizar el lugar en la base de datos");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Error al intentar actualizar el lugar en la base de datos");
		}

	}

	public void insertOne(Lugar l) {
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			stmt.executeUpdate("insert into lugares (nroLugar, ocupado, idCochera) values (" + l.getNroLugar() + ", '"
					+ l.isOcupado() + "', " + l.getCochera().getIdCochera() + ")");

			if (stmt != null) {
				stmt.close();
			}
			FactoryConnection.getInstancia().releaseConn();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Error al intentar guardar el lugar en la base de datos");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Error al intentar guardar el lugar en la base de datos");
		}
	}

	public Lugar getOne(int nroLugar, int idCochera) {
		Lugar l = null;

		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs = stmt.executeQuery("select * from lugares where nroLugar=" + nroLugar + " and idCochera="
					+ idCochera);

			while (rs.next()) {
				l = new Lugar();

				l.setNroLugar(rs.getInt("nroLugar"));
				boolean ocupado = false;
				if (rs.getString("ocupado") == "true") {
					ocupado = true;
				}

				l.setOcupado(ocupado);
				l.setCochera(new data.CocheraData().getOne(rs.getInt("idCochera")));
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
			throw new RuntimeException("Error al recuperar el lugar");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Error al recuperar el lugar");
		}

		return l;
	}

	public Lugar getOneFree(int idCochera) {
		Lugar l = null;

		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs = stmt
					.executeQuery("select * from lugares where idCochera=" + idCochera + " and ocupado='false'");

			while (rs.next()) {
				l = new Lugar();

				l.setNroLugar(rs.getInt("nroLugar"));
				boolean ocupado = false;
				if (rs.getString("ocupado") == "true") {
					ocupado = true;
				}

				l.setOcupado(ocupado);
				l.setCochera(new data.CocheraData().getOne(rs.getInt("idCochera")));
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
			throw new RuntimeException("Error al recuperar un lugar libre");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Error al recuperar un lugar libre");
		}

		return l;
	}
}