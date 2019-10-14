package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.*;

public class TipoVehiculoData {
private static String driver="com.mysql.jdbc.Driver";
	
public static ArrayList<TipoVehiculo> getAll() {
	ArrayList<TipoVehiculo> tiposVehiculos = new ArrayList<TipoVehiculo>();
	try {

		Class.forName(driver);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cocheradb?serverTimezone=UTC", "root", "admin");
		Statement stmt = conn.createStatement();
		ResultSet rs= stmt.executeQuery("select * from cocheradb.tipos_vehiculos");

		while(rs.next()) {		
			TipoVehiculo tv=new TipoVehiculo();
			
			tv.setIdTipo(rs.getInt("idTipo"));
			tv.setDescripcion(rs.getString("descripcion"));

			
			tiposVehiculos.add(tv);
			
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

	return tiposVehiculos;
}


	public static TipoVehiculo getOne(int idTipo) {
		TipoVehiculo tv=null;
		try {

			Class.forName(driver);
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cocheradb?serverTimezone=UTC", "root", "admin");
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery("select * from cocheradb.tipos_vehiculos where idTipo ="+ idTipo);
			while(rs.next()) {
				tv=new TipoVehiculo();
				
				tv.setIdTipo(rs.getInt("idTipo"));
				tv.setDescripcion(rs.getString("descripcion"));
				
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

		return tv;
	}
}
