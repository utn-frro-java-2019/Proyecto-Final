package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.Cochera;
import domain.Vehiculo;
import data.*;

public class VehiculoData {
private static String driver="com.mysql.jdbc.Driver";
	
	public static ArrayList<Vehiculo> getAll() {
		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		try {

			Class.forName(driver);
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cocheradb?serverTimezone=UTC", "root", "admin");
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery("select * from cocheradb.vehiculos");

			while(rs.next()) {
				Vehiculo v=new Vehiculo();
				
				v.setPatente(rs.getString("patente"));
				v.setMarca(rs.getString("marca"));
				v.setModelo(rs.getString("modelo"));
				v.setDescripcion(rs.getString("descripcion"));
				v.setTipo(TipoVehiculoData.getOne(rs.getInt("idTipo")));
				
				vehiculos.add(v);
				
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

		return vehiculos;
	}
	
	public static Vehiculo getOne(int patente) {
		Vehiculo v=null;
		try {

			Class.forName(driver);
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cocheradb?serverTimezone=UTC", "root", "admin");
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery("select * from cocheradb.vehiculos where patente ="+ patente);
			while(rs.next()) {
				v=new Vehiculo();
				
				v.setPatente(rs.getString("patente"));
				v.setMarca(rs.getString("marca"));
				v.setModelo(rs.getString("modelo"));
				v.setDescripcion(rs.getString("descripcion"));
				v.setTipo(TipoVehiculoData.getOne(rs.getInt("idTipo")));
				
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

		return v;
	}
}
