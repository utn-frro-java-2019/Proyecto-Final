package data;
import java.sql.*;
import java.util.ArrayList;

import domain.*;

public class CocheraData {
	private static String driver="com.mysql.jdbc.Driver";
	
	public ArrayList<Cochera> getAll() {
		ArrayList<Cochera> cocheras = new ArrayList<Cochera>();
		try {

			Class.forName(driver);
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cocheradb?serverTimezone=UTC", "root", "admin");
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery("select * from cocheradb.cocheras");

			while(rs.next()) {
				Cochera c=new Cochera();
				
				//Autoincrementar id desde java
				//ResultSet rs2 = stmt.executeQuery("select max(idCochera)+1 id from cocheras");
				//int id = rs2.getInt("id");
				
				c.setIdCochera(rs.getInt("idCochera"));
				c.setDescripcion(rs.getString("descripcion"));
				c.setUbicacion(rs.getString("ubicacion"));
				
				
				cocheras.add(c);
				
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

		return cocheras;
	}
	
	public Cochera getOne(int idCochera) {
		Cochera c=null;
		try {

			Class.forName(driver);
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cocheradb?serverTimezone=UTC", "root", "admin");
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery("select * from cocheradb.cocheras where idCochera ="+ idCochera);
			while(rs.next()) {
				c=new Cochera();
				
				c.setIdCochera(rs.getInt("idCochera"));
				c.setDescripcion(rs.getString("descripcion"));	
				c.setUbicacion(rs.getString("ubicacion"));
				
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

		return c;
	}
}
