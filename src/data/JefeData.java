package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.Jefe;

public class JefeData {
private static String driver="com.mysql.jdbc.Driver";
	
	public static ArrayList<Jefe> getAll() {
		ArrayList<Jefe> jefes = new ArrayList<Jefe>();
		try {

			Class.forName(driver);
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cocheradb?serverTimezone=UTC", "root", "admin");
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery("select * from cocheradb.jefes");

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
			conn.close(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

		return jefes;
	}

	
	public static Jefe getOne(int dni) {
		Jefe j=null;
		try {

			Class.forName(driver);
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cocheradb?serverTimezone=UTC", "root", "admin");
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery("select * from cocheradb.jefes where dni ="+ dni);
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
			conn.close(); 
			
		} catch (SQLException ee) {
			ee.printStackTrace();
		} catch (ClassNotFoundException ee) {
			// TODO Auto-generated catch block
			ee.printStackTrace();
		}catch (Exception ee) {
			ee.printStackTrace();
		}

		return j;
	}
}
