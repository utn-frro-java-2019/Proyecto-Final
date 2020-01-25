package data;

import java.sql.*;
import java.util.ArrayList;

import domain.*;

public class CocheraData {

	public ArrayList<Cochera> getAll() {
		ArrayList<Cochera> cocheras = new ArrayList<Cochera>();
		try {
			String consulta = "select * from cocheras ";
			PreparedStatement stmt = FactoryConnection.getInstancia().getConn().prepareStatement(consulta);
			ResultSet rs = stmt.executeQuery();
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
			if(stmt!=null){stmt.close();}
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
			PreparedStatement stmt = FactoryConnection.getInstancia().getConn().prepareStatement(consulta);
			stmt.setString(1, Integer.toString(idCochera));
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				c=new Cochera();
				
				c.setIdCochera(rs.getInt("idCochera"));
				c.setDescripcion(rs.getString("descripcion"));	
				c.setUbicacion(rs.getString("ubicacion"));
				c.setCapacidad(rs.getInt("capacidad"));
				
			}
			
			if(rs!=null){rs.close();}
			if(stmt!=null){stmt.close();}
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

			String consulta = "delete from cocheras where idCochera = ?";
			PreparedStatement stmt = FactoryConnection.getInstancia().getConn().prepareStatement(consulta);
			stmt.setString(1, Integer.toString(idCochera));
			stmt.executeUpdate();
			
			if(stmt!=null){stmt.close();}
			FactoryConnection.getInstancia().releaseConn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertOne(Cochera c) {
		try {
			
			String consulta = "insert into cocheras (ubicacion, descripcion, capacidad) values (?, ?, ?)";
			PreparedStatement stmt = FactoryConnection.getInstancia().getConn().prepareStatement(consulta);
			stmt.setString(1,c.getUbicacion());
			stmt.setString(2, c.getDescripcion());
			stmt.setString(3,Integer.toString(c.getCapacidad()));
			stmt.executeUpdate();
			
			if(stmt!=null){stmt.close();}
			FactoryConnection.getInstancia().releaseConn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateOne(Cochera c) {
		try {

			String consulta = "update  cocheras set ubicacion = ?, descripcion = ?, capacidad = ? where idCochera = ?";
			PreparedStatement stmt = FactoryConnection.getInstancia().getConn().prepareStatement(consulta);
			stmt.setString(1,c.getUbicacion());
			stmt.setString(2,c.getDescripcion());
			stmt.setString(3,Integer.toString(c.getCapacidad()));
			stmt.setString(4,Integer.toString(c.getIdCochera()));
			stmt.executeUpdate();
			
			if(stmt!=null){stmt.close();}
			FactoryConnection.getInstancia().releaseConn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
