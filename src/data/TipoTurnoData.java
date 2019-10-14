package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.TipoTurno;
import domain.TipoVehiculo;

public class TipoTurnoData {
	private static String driver="com.mysql.jdbc.Driver";
	
	public static ArrayList<TipoTurno> getAll() {
		ArrayList<TipoTurno> tiposTurnos = new ArrayList<TipoTurno>();
		try {

			Class.forName(driver);
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cocheradb?serverTimezone=UTC", "root", "admin");
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery("select * from cocheradb.tipos_turnos");

			while(rs.next()) {		
				TipoTurno tt=new TipoTurno();
				
				tt.setIdTurno(rs.getInt("idTipoTurno"));
				tt.setDescripcion(rs.getString("descripcion"));
				
				tiposTurnos.add(tt);
				
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

		return tiposTurnos;
	}
	
	public static TipoTurno getOne(int idTipoTurno) {
		TipoTurno tt=null;
		try {

			Class.forName(driver);
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cocheradb?serverTimezone=UTC", "root", "admin");
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery("select * from cocheradb.tipos_turnos where idTipoTurno ="+ idTipoTurno);
			while(rs.next()) {
				tt=new TipoTurno();
				
				tt.setIdTurno(rs.getInt("idTipoTurno"));
				tt.setDescripcion(rs.getString("descripcion"));
				
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

		return tt;
	}
}
