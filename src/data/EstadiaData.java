package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.*;

public class EstadiaData {
private static String driver="com.mysql.jdbc.Driver";
	
	public static ArrayList<Estadia> getAll() {
		ArrayList<Estadia> estadias = new ArrayList<Estadia>();
		try {

			Class.forName(driver);
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cocheradb?serverTimezone=UTC", "root", "admin");
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery("select * from cocheradb.estadias");

			while(rs.next()) {
				Estadia es=new Estadia();
				
				es.setCochera(data.CocheraData.getOne(rs.getInt("idCochera")));
				es.setVehiculo(data.VehiculoData.getOne(rs.getInt("patente")));
				es.setLugar(data.LugarData.getOne(rs.getInt("nroLugar")));
				es.setEstado(rs.getString("estado"));
				es.setFechaIngreso(rs.getTimestamp("fechaIngreso"));
				es.setFechaRetiro(rs.getTimestamp("fechaRetiro"));
				es.setPrecioFinal(rs.getDouble("precioFinal"));
				
				estadias.add(es);
				
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

		return estadias;
	}
}
