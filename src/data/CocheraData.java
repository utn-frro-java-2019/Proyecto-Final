package data;

import java.sql.*;
import java.util.ArrayList;

import domain.*;

public class CocheraData {

	public ArrayList<Cochera> getAll() {
		ArrayList<Cochera> cocheras = new ArrayList<Cochera>();
		try {
			String consulta = "select * from cocheras ";
			Connection conexion= DriverManager.getConnection("jdbc:mysql://localhost/cocheras", "root", "39855209");
			PreparedStatement sentencia= conexion.prepareStatement(consulta);
			ResultSet rs = sentencia.executeQuery();
			while(rs.next()) {
				Cochera c=new Cochera();
				
				//Autoincrementar id desde java
				//ResultSet rs2 = stmt.executeQuery("select max(idCochera)+1 id from cocheras");
				//int id = rs2.getInt("id");
				
				c.setIdCochera(rs.getInt("idCochera"));
				c.setDescripcion(rs.getString("descripcion"));
				c.setUbicacion(rs.getString("ubicacion"));
				c.setCapacidad(rs.getInt("capacidad"));
				
				
				cocheras.add(c);
				
			}
			
			if(rs!=null){rs.close();}
			if(sentencia!=null){sentencia.close();}
			FactoryConnection.getInstancia().releaseConn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

		return cocheras;
	}
	
	public Cochera getOne(int idCochera) {
		Cochera c=null;
		try {
			String consulta = "select * from cocheras where idCochera = ? ";
			Connection conexion= DriverManager.getConnection("jdbc:mysql://localhost/cocheras", "root", "39855209");
			PreparedStatement sentencia= conexion.prepareStatement(consulta);
			sentencia.setString(1, Integer.toString(idCochera));
			ResultSet rs = sentencia.executeQuery();
			while(rs.next()) {
				c=new Cochera();
				
				c.setIdCochera(rs.getInt("idCochera"));
				c.setDescripcion(rs.getString("descripcion"));	
				c.setUbicacion(rs.getString("ubicacion"));
				c.setCapacidad(rs.getInt("capacidad"));
				
			}
			
			if(rs!=null){rs.close();}
			if(sentencia!=null){sentencia.close();}
			FactoryConnection.getInstancia().releaseConn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

		return c;
	}
	
	public void deleteOne(int idCochera) {
		try {
			String consulta = "delete * from cocheras where idCochera = ? ";
			Connection conexion= DriverManager.getConnection("jdbc:mysql://localhost/cocheras", "root", "39855209");
			PreparedStatement sentencia= conexion.prepareStatement(consulta);
			sentencia.setString(1, Integer.toString(idCochera));
			ResultSet rs = sentencia.executeQuery();
			
			if(rs!=null){rs.close();}
			if(sentencia!=null){sentencia.close();}
			FactoryConnection.getInstancia().releaseConn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertOne(Cochera c) {
		String u = c.getUbicacion();
		String d = c.getDescripcion();
		int ca = c.getCapacidad();
		try {
			
			String consulta = " insert into cocheras (ubicacion, descripcion, capacidad)" + " values (?, ?, ?)";
			Connection conexion= DriverManager.getConnection("jdbc:mysql://localhost/cocheras", "root", "39855209");
			PreparedStatement sentencia= conexion.prepareStatement(consulta);
			sentencia.setString(1,u);
			sentencia.setString(2,d);
			sentencia.setString(3,Integer.toString(ca));
			ResultSet rs = sentencia.executeQuery();
			
			if(rs!=null){rs.close();}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateOne(Cochera c) {
		int id = c.getIdCochera();
		String u = c.getUbicacion();
		String d = c.getDescripcion();
		int ca = c.getCapacidad();
		try {
			
			String consulta = " update  cocheras set ubicacion = ?, descripcion = ?, capacidad = ? where id=?" ;
			Connection conexion= DriverManager.getConnection("jdbc:mysql://localhost/cocheras", "root", "39855209");
			PreparedStatement sentencia= conexion.prepareStatement(consulta);
			sentencia.setString(1,u);
			sentencia.setString(2,d);
			sentencia.setString(3,Integer.toString(ca));
			sentencia.setString(4,Integer.toString(id));
			ResultSet rs = sentencia.executeQuery();
			if(rs!=null){rs.close();}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
