package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import domain.*;

public class EstadiaData extends IngresoData {

	public ArrayList<Estadia> getAllByCochera(String idCochera) {
		ArrayList<Estadia> ingresos = new ArrayList<Estadia>();
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs = stmt.executeQuery("select * from ingresos where tipoIngreso='estadia' and idCochera='"
					+ idCochera + "' order by fechaIngreso desc");

			while (rs.next()) {
				Estadia e = new Estadia();

				java.util.Calendar cal = Calendar.getInstance();
				cal.setTimeZone(TimeZone.getTimeZone("GMT-3"));

				e.setIdIngreso(rs.getInt("idIngreso"));
				e.setComprobante(rs.getString("comprobante"));
				e.setCochera(new data.CocheraData().getOne(rs.getInt("idCochera")));
				e.setLugar(new data.LugarData().getOne(rs.getInt("nroLugar"), rs.getInt("idCochera")));
				e.setVehiculo(new data.VehiculoData().getOne(rs.getString("patente")));
				e.setFechaIngreso(rs.getTimestamp("fechaIngreso", cal));
				e.setFechaRetiro(rs.getTimestamp("fechaRetiro", cal));
				e.setPrecioFinal(rs.getDouble("precioFinal"));
				e.setEstado(rs.getString("estado"));
				e.setPrecioFinal(rs.getDouble("precioFinal"));
				e.setAutoEnCochera(rs.getBoolean("autoEnCochera"));

				ingresos.add(e);
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

	public Estadia getOneActiveByComprobante(String comprobante) {
		Estadia d = null;
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs = stmt
					.executeQuery("select * from ingresos where comprobante='" + comprobante
							+ "' and tipoIngreso='estadia' and estado='activo'");

			while (rs.next()) {
				d = new Estadia();

				java.util.Calendar cal = Calendar.getInstance();
				cal.setTimeZone(TimeZone.getTimeZone("GMT-3"));

				d.setIdIngreso(rs.getInt("idIngreso"));
				d.setComprobante(rs.getString("comprobante"));
				d.setCochera(new data.CocheraData().getOne(rs.getInt("idCochera")));
				d.setLugar(new data.LugarData().getOne(rs.getInt("nroLugar"), rs.getInt("idCochera")));
				d.setVehiculo(new data.VehiculoData().getOne(rs.getString("patente")));
				d.setFechaIngreso(rs.getTimestamp("fechaIngreso", cal));
				d.setFechaRetiro(rs.getTimestamp("fechaRetiro", cal));
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
			System.out.println(e.getMessage());
			throw new RuntimeException("Error al intentar obtener el ingreso en la base de datos");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Error al intentar obtener el ingreso en la base de datos");
		}

		return d;
	}

	public Estadia insertOne(Estadia estadia) {
		try {
			PreparedStatement pstmt = FactoryConnection.getInstancia().getConn().prepareStatement(
					"insert into ingresos (comprobante, idCochera, nroLugar, patente, fechaIngreso, estado, tipoIngreso, fechaRetiro, precioFinal, autoEnCochera) values (?, ?, ?, ?, NOW(), 'activo', 'estadia', ?, ?, ?)");
			
			pstmt.setString(1, estadia.getComprobante());
			pstmt.setInt(2, estadia.getCochera().getIdCochera());
			pstmt.setInt(3, estadia.getLugar().getNroLugar());
			pstmt.setString(4, estadia.getVehiculo().getPatente());
			pstmt.setTimestamp(5, new java.sql.Timestamp(estadia.getFechaRetiro().getTime()));
			pstmt.setDouble(6, estadia.getPrecioFinal());
			pstmt.setBoolean(7, estadia.getAutoEnCochera());

			pstmt.executeUpdate();

			if (pstmt != null) {
				pstmt.close();
			}
			FactoryConnection.getInstancia().releaseConn();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Error al intentar guardar el ingreso en la base de datos");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Error al intentar guardar el ingreso en la base de datos");
		}

		return estadia;
	}

	public Estadia finalizeOne(Estadia estadia, Double price) {
		// TODO: Implementar
		Estadia d = new Estadia();
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			stmt.executeUpdate(
					"update ingresos set fechaRetiro=NOW(), precioFinal=" + price
							+ ", estado='finalizado' where idIngreso=" + estadia.getIdIngreso());

			Statement stmtGet = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs = stmtGet
					.executeQuery(
							"select * from ingresos where comprobante='" + estadia.getComprobante()
									+ "' and tipoIngreso='estadia'");

			while (rs.next()) {
				java.util.Calendar cal = Calendar.getInstance();
				cal.setTimeZone(TimeZone.getTimeZone("GMT-3"));

				d.setIdIngreso(rs.getInt("idIngreso"));
				d.setComprobante(rs.getString("comprobante"));
				d.setCochera(new data.CocheraData().getOne(rs.getInt("idCochera")));
				d.setLugar(new data.LugarData().getOne(rs.getInt("nroLugar"), rs.getInt("idCochera")));
				d.setVehiculo(new data.VehiculoData().getOne(rs.getString("patente")));
				d.setFechaIngreso(rs.getTimestamp("fechaIngreso", cal));
				d.setFechaRetiro(rs.getTimestamp("fechaRetiro", cal));
				d.setPrecioFinal(rs.getDouble("precioFinal"));
				d.setEstado(rs.getString("estado"));
				d.setPrecioFinal(rs.getDouble("precioFinal"));
				d.setAutoEnCochera(rs.getBoolean("autoEnCochera"));
			}

			if (stmt != null) {
				stmt.close();
			}

			if (stmtGet != null) {
				stmtGet.close();
			}

			if (rs != null) {
				rs.close();
			}

			FactoryConnection.getInstancia().releaseConn();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Error al intentar finalizar el ingreso en la base de datos");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Error al intentar finalizar el ingreso en la base de datos");
		}

		return d;
	}

}
