package data;

import java.sql.PreparedStatement;
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
				d.setComprobante(rs.getString("comprobante"));
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
			throw new RuntimeException("Error al intentar obtener los ingresos en la base de datos");
		} catch (Exception e) {
			throw new RuntimeException("Error al intentar obtener los ingresos en la base de datos");
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
				d.setComprobante(rs.getString("comprobante"));
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
			throw new RuntimeException("Error al intentar obtener el ingreso en la base de datos");
		} catch (Exception e) {
			throw new RuntimeException("Error al intentar obtener el ingreso en la base de datos");
		}

		return d;
	}

	public Diario getOneByComprobante(String comprobante) {
		Diario d = null;
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs = stmt
					.executeQuery("select * from ingresos where comprobante='" + comprobante + "' and tipoIngreso='diario'");

			while (rs.next()) {
				d = new Diario();

				d.setIdIngreso(rs.getInt("idIngreso"));
				d.setComprobante(rs.getString("comprobante"));
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
			System.out.println(e.getMessage());
			throw new RuntimeException("Error al intentar obtener el ingreso en la base de datos");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Error al intentar obtener el ingreso en la base de datos");
		}

		return d;
	}

	public Diario insertOne(Diario diario) {
		try {
			PreparedStatement pstmt = FactoryConnection.getInstancia().getConn().prepareStatement(
					"insert into ingresos (comprobante, idCochera, nroLugar, patente, fechaIngreso, estado, tipoIngreso) values (?, ?, ?, ?, NOW(), 'activo', 'diario')");

			pstmt.setString(1, diario.getComprobante());
			pstmt.setInt(2, diario.getCochera().getIdCochera());
			pstmt.setInt(3, diario.getLugar().getNroLugar());
			pstmt.setString(4, diario.getVehiculo().getPatente());

			pstmt.executeUpdate();

			if (pstmt != null) {
				pstmt.close();
			}
			FactoryConnection.getInstancia().releaseConn();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Error al intentar guardar el ingreso en la base de datos");
		} catch (Exception e) {
			throw new RuntimeException("Error al intentar guardar el ingreso en la base de datos");
		}

		return diario;
	}

	public Diario finalizeOne(Diario diario) {
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			stmt.executeUpdate(
					"update ingresos set fechaRetiro=" + "NOW()"
							+ ", precioFinal=" + diario.getPrecioFinal() + ", estado='finalizado' where idIngreso="
							+ diario.getIdIngreso());

			if (stmt != null) {
				stmt.close();
			}
			FactoryConnection.getInstancia().releaseConn();

		} catch (SQLException e) {
			throw new RuntimeException("Error al intentar finalizar el ingreso en la base de datos");
		} catch (Exception e) {
			throw new RuntimeException("Error al intentar finalizar el ingreso en la base de datos");
		}

		return diario;
	}

}
