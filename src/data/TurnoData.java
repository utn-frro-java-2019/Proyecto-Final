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
	
	public ArrayList<Turno> getAll() {
		ArrayList<Turno> turnos = new ArrayList<Turno>();
		try {

			Class.forName(driver);
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cocheradb?serverTimezone=UTC", "root", "admin");
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery("select * from cocheradb.turnos");

			while(rs.next()) {
				Turno t=new Turno();
				
				t.setIdTurno(rs.getInt("idTurno"));
				t.setDescripcion(rs.getString("descripcion"));
				t.setHoraInicio(rs.getTime("horaInicio"));
				t.setHoraFin(rs.getTime("horaFin"));
				
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
	
	public Turno getOne(int id) {
		Turno t=null;
		try {

			Class.forName(driver);
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cocheradb?serverTimezone=UTC", "root", "admin");
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery("select * from cocheradb.turnos where idTurno="+id);
			while(rs.next()) {
				t = new Turno();
				
				t.setIdTurno(rs.getInt("idTurno"));
				t.setDescripcion(rs.getString("descripcion"));
				t.setHoraInicio(rs.getTime("horaInicio"));
				t.setHoraFin(rs.getTime("horaFin"));
				
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

		return t;
	}
}
