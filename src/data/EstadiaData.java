package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import domain.*;

public class EstadiaData extends IngresoData {

	public ArrayList<Estadia> getAll() {
		ArrayList<Estadia> ingresos = new ArrayList<Estadia>();
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs = stmt.executeQuery("select * from ingresos");

			while (rs.next()) {
				Estadia es = new Estadia();

				java.util.Calendar cal = Calendar.getInstance();
				cal.setTimeZone(TimeZone.getTimeZone("GMT-3"));

				es.setIdIngreso(rs.getInt("idIngreso"));
				es.setComprobante(rs.getString("comprobante"));
				es.setCochera(new data.CocheraData().getOne(rs.getInt("idCochera")));
				es.setLugar(new data.LugarData().getOne(rs.getInt("nroLugar"), rs.getInt("idCochera")));
				es.setVehiculo(new data.VehiculoData().getOne(rs.getString("patente")));
				es.setFechaIngreso(rs.getTimestamp("fechaIngreso", cal));
				es.setFechaRetiro(rs.getTimestamp("fechaRetiro", cal));
				es.setPrecioFinal(rs.getDouble("precioFinal"));
				es.setEstado(rs.getString("estado"));
				es.setPrecioFinal(rs.getDouble("precioFinal"));
				es.setAutoEnCochera(rs.getBoolean("autoEnCochera"));

				ingresos.add(es);
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
			throw new RuntimeException("Error al intentar obtener los ingresos en la base de datos");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Error al intentar obtener los ingresos en la base de datos");
		}

		return ingresos;
	}

	public Estadia getOne(int idIngreso) {
		Estadia es = null;
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs = stmt.executeQuery("select * from ingresos where idIngreso=" + idIngreso);

			while (rs.next()) {
				es = new Estadia();

				java.util.Calendar cal = Calendar.getInstance();
				cal.setTimeZone(TimeZone.getTimeZone("GMT-3"));

				es.setIdIngreso(rs.getInt("idIngreso"));
				es.setComprobante(rs.getString("comprobante"));
				es.setCochera(new data.CocheraData().getOne(rs.getInt("idCochera")));
				es.setLugar(new data.LugarData().getOne(rs.getInt("nroLugar"), rs.getInt("idCochera")));
				es.setVehiculo(new data.VehiculoData().getOne(rs.getString("patente")));
				es.setFechaIngreso(rs.getTimestamp("fechaIngreso", cal));
				es.setFechaRetiro(rs.getTimestamp("fechaRetiro", cal));
				es.setPrecioFinal(rs.getDouble("precioFinal"));
				es.setEstado(rs.getString("estado"));
				es.setPrecioFinal(rs.getDouble("precioFinal"));
				es.setAutoEnCochera(rs.getBoolean("autoEnCochera"));
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
			throw new RuntimeException("Error al intentar obtener el ingreso en la base de datos");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Error al intentar obtener el ingreso en la base de datos");
		}

		return es;
	}
}
