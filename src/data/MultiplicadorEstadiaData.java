package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.MultiplicadorEstadia;

public class MultiplicadorEstadiaData {
private static String driver="com.mysql.jdbc.Driver";
	
	public static ArrayList<MultiplicadorEstadia> getAll() {
		ArrayList<MultiplicadorEstadia> multiplicadoresEstadias = new ArrayList<MultiplicadorEstadia>();
		try {

			Class.forName(driver);
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cocheradb?serverTimezone=UTC", "root", "admin");
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery("select * from cocheradb.multiplicadores_estadias");

			while(rs.next()) {
				MultiplicadorEstadia me=new MultiplicadorEstadia();
				
				me.setMultiplicadorDesde(rs.getInt("multiplicadorDesde"));
				me.setPorcentajeMultiplicador(rs.getDouble("porcentajeMultiplicador"));

				
				multiplicadoresEstadias.add(me);
				
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

		return multiplicadoresEstadias;
	}

	
	public static MultiplicadorEstadia getOne(int multiplicadorDesde) {
		MultiplicadorEstadia me=null;
		try {

			Class.forName(driver);
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cocheradb?serverTimezone=UTC", "root", "admin");
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery("select * from cocheradb.multiplicadores_estadias where multiplicadorDesde ="+ multiplicadorDesde);
			while(rs.next()) {
				me=new MultiplicadorEstadia();
				
				me.setMultiplicadorDesde(rs.getInt("multiplicadorDesde"));
				me.setPorcentajeMultiplicador(rs.getDouble("porcentajeMultiplicador"));
			
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

		return me;
	}
}
