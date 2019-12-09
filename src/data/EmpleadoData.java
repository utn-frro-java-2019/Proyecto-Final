package data;

import java.sql.*;
import java.util.ArrayList;
import domain.*;
import data.CocheraData;
import data.TurnoData;

public class EmpleadoData {
	
	public ArrayList<Empleado> getAll() {
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs= stmt.executeQuery("select * from empleados");

			while(rs.next()) {
				Empleado e=new Empleado();
				
				e.setNombre(rs.getString("nombre"));
				e.setApellido(rs.getString("apellido"));
				e.setEmail(rs.getString("email"));
				e.setTelefono1(rs.getString("telefono1"));
				e.setTelefono2(rs.getString("telefono2"));
				e.setUsuario(rs.getString("usuario"));
				e.setContraseña(rs.getString("contraseña"));
				e.setDni(rs.getString("dni"));
				e.setCochera(new CocheraData().getOne(rs.getInt("idCochera")));
				e.setTurno(new TurnoData().getOne(rs.getInt("idTurno")));
				
				empleados.add(e);
				
			}
			
			if(rs!=null){rs.close();}
			if(stmt!=null){stmt.close();}
			FactoryConnection.getInstancia().releaseConn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

		return empleados;
	}

	
	public Empleado getOne(int dni) {
		Empleado e=null;
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs= stmt.executeQuery("select * from empleados where dni ="+ dni);
			while(rs.next()) {
				e=new Empleado();
				
				e.setDni(rs.getString("dni"));
				e.setNombre(rs.getString("nombre"));
				e.setApellido(rs.getString("apellido"));
				e.setEmail(rs.getString("email"));
				e.setTelefono1(rs.getString("telefono1"));
				e.setTelefono2(rs.getString("telefono2"));
				e.setUsuario(rs.getString("usuario"));
				e.setContraseña(rs.getString("contraseña"));
				e.setCochera(new CocheraData().getOne(rs.getInt("idCochera")));
				e.setTurno(new TurnoData().getOne(rs.getInt("idTurno")));
			
			}
			
			if(rs!=null){rs.close();}
			if(stmt!=null){stmt.close();}
			FactoryConnection.getInstancia().releaseConn();
			
		} catch (SQLException ee) {
			ee.printStackTrace();
		}catch (Exception ee) {
			ee.printStackTrace();
		}

		return e;
	}
	
	public void deleteOne(int dni) {
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			stmt.executeUpdate("delete from empleados where dni ="+ dni);
			if(stmt!=null){stmt.close();}
			FactoryConnection.getInstancia().releaseConn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
