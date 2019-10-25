package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.*;

public class LugarData {

private static String driver="com.mysql.jdbc.Driver";
	
	public ArrayList<Lugar> getAll() {
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		try {

			Class.forName(driver);
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cocheradb?serverTimezone=UTC", "root", "admin");
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery("select * from cocheradb.lugares");

			while(rs.next()) {
				Lugar l=new Lugar();
				
				l.setNroLugar(rs.getInt("nroLugar"));
				boolean ocupado = false;
				if(rs.getString("ocupado") == "true") ocupado = true;
				l.setOcupado(ocupado);
				l.setCochera(new data.CocheraData().getOne(rs.getInt("idCochera")));
				
				lugares.add(l);
				
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

		return lugares;
	}
	
	public Lugar getOne(int nroLugar) {
		Lugar l=null;
		try {

			Class.forName(driver);
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cocheradb?serverTimezone=UTC", "root", "admin");
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery("select * from cocheradb.lugares where nroLugar ="+ nroLugar);
			while(rs.next()) {
				l=new Lugar();
				
				l.setNroLugar(rs.getInt("nroLugar"));
				boolean ocupado = false;
				if(rs.getString("ocupado") == "true") ocupado = true;
				l.setOcupado(ocupado);
				l.setCochera(new data.CocheraData().getOne(rs.getInt("idCochera")));
				
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

		return l;
	}
}
