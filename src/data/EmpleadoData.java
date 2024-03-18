package data;

import java.sql.*;
import java.util.ArrayList;
import domain.*;

public class EmpleadoData {

	public ArrayList<Empleado> getAll() {
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs = stmt.executeQuery("select * from empleados");

			while (rs.next()) {
				Empleado e = new Empleado();

				e.setNombre(rs.getString("nombre"));
				e.setApellido(rs.getString("apellido"));
				e.setEmail(rs.getString("email"));
				e.setTelefono1(rs.getString("telefono1"));
				e.setTelefono2(rs.getString("telefono2"));
				e.setUsuario(rs.getString("usuario"));
				e.setPassword(rs.getString("password"));
				e.setDni(rs.getString("dni"));
				e.setCochera(new CocheraData().getOne(rs.getInt("idCochera")));
				e.setTurno(new TurnoData().getOne(rs.getInt("idTurno")));

				empleados.add(e);
			}

			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			FactoryConnection.getInstancia().releaseConn();

		} catch (SQLException e) {
			throw new RuntimeException("Error al recuperar los empleados");
		} catch (Exception e) {
			throw new RuntimeException("Error al recuperar los empleados");
		}

		return empleados;
	}

	public Empleado getOne(String dni) {
		Empleado e = null;
		try {
			PreparedStatement pstmt = FactoryConnection.getInstancia().getConn()
					.prepareStatement("Select * from empleados where dni = ?");
			pstmt.setString(1, dni);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				e = new Empleado();

				e.setDni(rs.getString("dni"));
				e.setNombre(rs.getString("nombre"));
				e.setApellido(rs.getString("apellido"));
				e.setEmail(rs.getString("email"));
				e.setTelefono1(rs.getString("telefono1"));
				e.setTelefono2(rs.getString("telefono2"));
				e.setUsuario(rs.getString("usuario"));
				e.setPassword(rs.getString("password"));
				e.setCochera(new CocheraData().getOne(rs.getInt("idCochera")));
				e.setTurno(new TurnoData().getOne(rs.getInt("idTurno")));
			}

			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			FactoryConnection.getInstancia().releaseConn();

		} catch (SQLException ee) {
			throw new RuntimeException("Error al recuperar el empleado");
		} catch (Exception ee) {
			throw new RuntimeException("Error al recuperar el empleado");
		}

		return e;
	}

	public Empleado getOneByEmail(String email) {
		Empleado e = null;
		try {
			PreparedStatement pstmt = FactoryConnection.getInstancia().getConn()
					.prepareStatement("Select * from empleados where email = ?");
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				e = new Empleado();

				e.setDni(rs.getString("dni"));
				e.setNombre(rs.getString("nombre"));
				e.setApellido(rs.getString("apellido"));
				e.setEmail(rs.getString("email"));
				e.setTelefono1(rs.getString("telefono1"));
				e.setTelefono2(rs.getString("telefono2"));
				e.setUsuario(rs.getString("usuario"));
				e.setPassword(rs.getString("password"));
				e.setCochera(new CocheraData().getOne(rs.getInt("idCochera")));
				e.setTurno(new TurnoData().getOne(rs.getInt("idTurno")));
			}

			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			FactoryConnection.getInstancia().releaseConn();

		} catch (SQLException ee) {
			throw new RuntimeException("Error al recuperar el empleado");
		} catch (Exception ee) {
			throw new RuntimeException("Error al recuperar el empleado");
		}

		return e;
	}

	public void deleteOne(String dni) {
		try {
			PreparedStatement pstmt = FactoryConnection.getInstancia().getConn()
					.prepareStatement("delete from empleados where dni = ?");
			pstmt.setString(1, dni);
			pstmt.executeUpdate();
			if (pstmt != null) {
				pstmt.close();
			}
			FactoryConnection.getInstancia().releaseConn();

		} catch (SQLException e) {
			throw new RuntimeException("Error al eliminar empleado");
		} catch (Exception e) {
			throw new RuntimeException("Error al eliminar empleado");
		}
	}

	public void insertOne(Empleado e) {
		try {
			PreparedStatement pstmt = FactoryConnection.getInstancia().getConn().prepareStatement(
					"insert into empleados(dni,nombre,apellido,email,telefono1,telefono2,usuario,password,idCochera,idTurno) values(?,?,?,?,?,?,?,?,?,?)");

			pstmt.setString(1, e.getDni());
			pstmt.setString(2, e.getNombre());
			pstmt.setString(3, e.getApellido());
			pstmt.setString(4, e.getEmail());
			pstmt.setString(5, e.getTelefono1());
			pstmt.setString(6, e.getTelefono2());
			pstmt.setString(7, e.getUsuario());
			pstmt.setString(8, e.getPassword());
			pstmt.setInt(9, e.getTurno().getIdTurno());
			pstmt.setInt(10, e.getCochera().getIdCochera());	
			

			pstmt.executeUpdate();

			if (pstmt != null) {
				pstmt.close();
			}
			FactoryConnection.getInstancia().releaseConn();

		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new RuntimeException("Error al crear empleado");
		} catch (Exception e1) {
			throw new RuntimeException("Error al crear empleado");
		}
	}

	public void updateOne(Empleado e) {
		try {
			PreparedStatement pstmt = FactoryConnection.getInstancia().getConn().prepareStatement(
					"update empleados set  nombre = ? , apellido = ? , email = ? , telefono1 = ? , telefono2 = ? , usuario = ? , password = ?, idCochera = ?, idTurno = ? where dni = ?");

			pstmt.setString(1, e.getNombre());
			pstmt.setString(2, e.getApellido());
			pstmt.setString(3, e.getEmail());
			pstmt.setString(4, e.getTelefono1());
			pstmt.setString(5, e.getTelefono2());
			pstmt.setString(6, e.getUsuario());
			pstmt.setString(7, e.getPassword());
			pstmt.setInt(8, e.getCochera().getIdCochera());
			pstmt.setInt(9, e.getTurno().getIdTurno());
			pstmt.setString(10, e.getDni());

			pstmt.executeUpdate();

			if (pstmt != null) {
				pstmt.close();
			}
			FactoryConnection.getInstancia().releaseConn();

		} catch (SQLException e1) {
			throw new RuntimeException("Error al actualizar empleado");
		} catch (Exception e1) {
			throw new RuntimeException("Error al actualizar empleado");
		}
	}
}
