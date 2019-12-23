package data;

import java.sql.*;
import java.util.ArrayList;

import domain.*;

public class CocheraData {

	public ArrayList<Cochera> getAll() {
		ArrayList<Cochera> cocheras = new ArrayList<Cochera>();
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs= stmt.executeQuery("select * from cocheras");

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
			PreparedStatement pstmt = FactoryConnection.getInstancia().getConn().prepareStatement("select * from cocheras where idCochera = ?");
			pstmt.setInt(1, idCochera);
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()) {
				c=new Cochera();
				
				c.setIdCochera(rs.getInt("idCochera"));
				c.setDescripcion(rs.getString("descripcion"));	
				c.setUbicacion(rs.getString("ubicacion"));
				c.setCapacidad(rs.getInt("capacidad"));
				
			}
			
			if(rs!=null){rs.close();}
			if(pstmt!=null){pstmt.close();}
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
			PreparedStatement pstmt = FactoryConnection.getInstancia().getConn().prepareStatement("delete from cocheras where idCochera = ?");
			pstmt.setInt(1, idCochera);
			pstmt.executeUpdate();
			if(pstmt!=null){pstmt.close();}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertOne(Cochera c) {
		try {
			PreparedStatement pstmt = FactoryConnection.getInstancia().getConn().prepareStatement
			("insert into cocheras (ubicacion, descripcion, capacidad) values (?,?,?)");
			pstmt.setString(1, c.getUbicacion());
			pstmt.setString(2, c.getDescripcion());
			pstmt.setInt(3, c.getCapacidad());
			
			pstmt.executeUpdate();
			
			if(pstmt!=null){pstmt.close();}
			FactoryConnection.getInstancia().releaseConn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateOne(Cochera c) {
		try {
			PreparedStatement pstmt = FactoryConnection.getInstancia().getConn().prepareStatement
			("update cocheras set ubicacion = ? , descripcion = ? , capacidad = ? where idCochera = ? ");
			pstmt.setString(1, c.getUbicacion());
			pstmt.setString(2, c.getDescripcion());
			pstmt.setInt(3, c.getCapacidad());
			pstmt.setInt(4, c.getIdCochera());
			
			pstmt.executeUpdate();
			
			if(pstmt!=null){pstmt.close();}
			FactoryConnection.getInstancia().releaseConn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
