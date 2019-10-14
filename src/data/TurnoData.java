package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.*;

public class TurnoData {
	private static String driver="com.mysql.jdbc.Driver";
	
	public static ArrayList<Turno> getAll() {
		ArrayList<Turno> turnos = new ArrayList<Turno>();
		try {

			Class.forName(driver);
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cocheradb?serverTimezone=UTC", "root", "admin");
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery("select * from cocheradb.turnos");

			while(rs.next()) {
				Turno t=new Turno();
				
				//Autoincrementar id desde java
				//ResultSet rs2 = stmt.executeQuery("select max(idCochera)+1 id from cocheras");
				//int id = rs2.getInt("id");
				
				t.setCochera(data.CocheraData.getOne(rs.getInt("idCochera")));
				t.setTipoTurno(data.TipoTurnoData.getOne(rs.getInt("idTipoTurno")));
				t.setEmpleado(data.EmpleadoData.getOne(rs.getInt("dni")));
				
				turnos.add(t);
				
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

		return turnos;
	}
}
