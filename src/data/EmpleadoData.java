package data;
import java.sql.*;
import java.util.ArrayList;
import domain.*;

public class EmpleadoData {
private static String driver="com.mysql.jdbc.Driver";
	
	public static ArrayList<Empleado> getAll() {
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		try {

			Class.forName(driver);
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cocheradb?serverTimezone=UTC", "root", "admin");
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery("select * from cocheradb.empleados");

			while(rs.next()) {
				Empleado e=new Empleado();
				
				e.setNombre(rs.getString("nombre"));
				e.setApellido(rs.getString("apellido"));
				e.setEmail(rs.getString("email"));
				e.setUsuario(rs.getString("usuario"));
				e.setContrase�a(rs.getString("contrase�a"));
				e.setDni(rs.getString("dni"));
				
				empleados.add(e);
				
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

		return empleados;
	}

	
	public static Empleado getOne(int dni) {
		Empleado e=null;
		try {

			Class.forName(driver);
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cocheradb?serverTimezone=UTC", "root", "admin");
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery("select * from cocheradb.empleados where dni ="+ dni);
			while(rs.next()) {
				e=new Empleado();
				
				e.setDni(rs.getString("dni"));
				e.setNombre(rs.getString("nombre"));
				e.setApellido(rs.getString("apellido"));
				e.setEmail(rs.getString("email"));
				e.setUsuario(rs.getString("usuario"));
				e.setContrase�a(rs.getString("contrase�a"));
			
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

		return e;
	}
}
