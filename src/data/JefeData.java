package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.*;

public class JefeData {
	
	public ArrayList<Jefe> getAll() {
		ArrayList<Jefe> jefes = new ArrayList<Jefe>();
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs= stmt.executeQuery("select * from jefes");

			while(rs.next()) {
				Jefe j=new Jefe();
				
				j.setNombre(rs.getString("nombre"));
				j.setApellido(rs.getString("apellido"));
				j.setEmail(rs.getString("email"));
				j.setUsuario(rs.getString("usuario"));
				j.setContraseña(rs.getString("contraseña"));
				j.setDni(rs.getString("dni"));
				
				jefes.add(j);
				
			}
			
			if(rs!=null){rs.close();}
			if(stmt!=null){stmt.close();}
			FactoryConnection.getInstancia().releaseConn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

		return jefes;
	}

	
	public Jefe getOne(int dni) {
		Jefe j=null;
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs= stmt.executeQuery("select * from jefes where dni ="+ dni);
			while(rs.next()) {
				j=new Jefe();
				
				j.setDni(rs.getString("dni"));
				j.setNombre(rs.getString("nombre"));
				j.setApellido(rs.getString("apellido"));
				j.setEmail(rs.getString("email"));
				j.setUsuario(rs.getString("usuario"));
				j.setContraseña(rs.getString("contraseña"));
			
			}
			
			if(rs!=null){rs.close();}
			if(stmt!=null){stmt.close();}
			FactoryConnection.getInstancia().releaseConn();
			
		} catch (SQLException ee) {
			ee.printStackTrace();
		}catch (Exception ee) {
			ee.printStackTrace();
		}

		return j;
	}
}
