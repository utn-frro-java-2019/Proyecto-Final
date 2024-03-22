package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.*;

public class DiarioData extends IngresoData {

	public ArrayList<Diario> getAll() {
		ArrayList<Diario> ingresos = new ArrayList<Diario>();
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs = stmt.executeQuery("select * from ingresos where tipoIngreso='diario'");

			while (rs.next()) {
				Diario d = new Diario();

				d.setIdIngreso(rs.getInt("idIngreso"));
				d.setCochera(new data.CocheraData().getOne(rs.getInt("idCochera")));
				d.setLugar(new data.LugarData().getOne(rs.getInt("nroLugar"), rs.getInt("idCochera")));
				d.setVehiculo(new data.VehiculoData().getOne(rs.getString("patente")));
				d.setFechaIngreso(rs.getTimestamp("fechaIngreso"));
				d.setFechaRetiro(rs.getTimestamp("fechaRetiro"));
				d.setPrecioFinal(rs.getDouble("precioFinal"));
				d.setEstado(rs.getString("estado"));
				d.setPrecioFinal(rs.getDouble("precioFinal"));
				d.setAutoEnCochera(rs.getBoolean("autoEnCochera"));

				ingresos.add(d);
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

		return ingresos;
	}

	public Diario getOne(int idIngreso) {
		Diario d = null;
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs = stmt
					.executeQuery("select * from ingresos where idIngreso=" + idIngreso + " and tipoIngreso='diario'");

			while (rs.next()) {
				d = new Diario();

				d.setIdIngreso(rs.getInt("idIngreso"));
				d.setCochera(new data.CocheraData().getOne(rs.getInt("idCochera")));
				d.setLugar(new data.LugarData().getOne(rs.getInt("nroLugar"), rs.getInt("idCochera")));
				d.setVehiculo(new data.VehiculoData().getOne(rs.getString("patente")));
				d.setFechaIngreso(rs.getTimestamp("fechaIngreso"));
				d.setFechaRetiro(rs.getTimestamp("fechaRetiro"));
				d.setPrecioFinal(rs.getDouble("precioFinal"));
				d.setEstado(rs.getString("estado"));
				d.setPrecioFinal(rs.getDouble("precioFinal"));
				d.setAutoEnCochera(rs.getBoolean("autoEnCochera"));
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

		return d;
	}

	public Diario insertOne(Diario diario) {
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			stmt.executeUpdate(
					"insert into ingresos (patente, idCochera, nroLugar, fechaIngreso, estado, tipoIngreso) values ('"
							+ diario.getVehiculo().getPatente() + "', " + diario.getCochera().getIdCochera() + ", "
							+ diario.getLugar().getNroLugar() + ", '"
							+ new java.sql.Timestamp(diario.getFechaIngreso().getTime())
							+ "', '" + diario.getEstado() + "', 'diario')");

			if (stmt != null) {
				stmt.close();
			}
			FactoryConnection.getInstancia().releaseConn();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return diario;
	}

	public Diario finalizeOne(Diario diario) {
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			stmt.executeUpdate(
					"update ingresos set fechaRetiro='" + new java.sql.Timestamp(diario.getFechaRetiro().getTime())
							+ "', precioFinal=" + diario.getPrecioFinal() + ", estado='finalizado' where idIngreso="
							+ diario.getIdIngreso());

			if (stmt != null) {
				stmt.close();
			}
			FactoryConnection.getInstancia().releaseConn();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return diario;
	}

}
