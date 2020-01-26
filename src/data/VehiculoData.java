package data;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.*;

public class VehiculoData {
	
	public ArrayList<Vehiculo> getAll() {
		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs= stmt.executeQuery("select * from vehiculos");

			while(rs.next()) {
				Vehiculo v=new Vehiculo();
				
				v.setPatente(rs.getString("patente"));
				v.setMarca(rs.getString("marca"));
				v.setModelo(rs.getString("modelo"));
				v.setDescripcion(rs.getString("descripcion"));
				v.setPropietario(rs.getString("propietario"));
				v.setTelefonoContacto(rs.getString("telefonoContacto"));
				v.setTipo(new TipoVehiculoData().getOne(rs.getInt("idTipo")));
				
				vehiculos.add(v);
			}
			
			if(rs!=null){rs.close();}
			if(stmt!=null){stmt.close();}
			FactoryConnection.getInstancia().releaseConn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

		return vehiculos;
	}
	
	public Vehiculo getOne(String patente) {
		Vehiculo v=null;
		try {
			PreparedStatement pstmt = FactoryConnection.getInstancia().getConn().prepareStatement("select * from vehiculos where patente = ?");
			pstmt.setString(1, patente);
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()) {
				v=new Vehiculo();
				
				v.setPatente(rs.getString("patente"));
				v.setMarca(rs.getString("marca"));
				v.setModelo(rs.getString("modelo"));
				v.setDescripcion(rs.getString("descripcion"));
				v.setPropietario(rs.getString("propietario"));
				v.setTelefonoContacto(rs.getString("telefonoContacto"));
				v.setTipo(new TipoVehiculoData().getOne(rs.getInt("idTipo")));
			}
			
			if(rs!=null){rs.close();}
			if(pstmt!=null){pstmt.close();}
			FactoryConnection.getInstancia().releaseConn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

		return v;
	}
	
	public void deleteOne(String patente) {
		try {
			PreparedStatement pstmt = FactoryConnection.getInstancia().getConn().prepareStatement("delete from vehiculos where patente = ?");
			pstmt.setString(1, patente);
			pstmt.executeUpdate();
			if(pstmt!=null){pstmt.close();}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertOne(Vehiculo v) {
		try {
			PreparedStatement pstmt = FactoryConnection.getInstancia().getConn().prepareStatement
			("insert into vehiculos (patente, modelo, descripcion, marca, idTipo, propietario, telefonoContacto) values (?,?,?,?,?,?,?)");
			pstmt.setString(1, v.getPatente());
			pstmt.setString(2, v.getModelo());
			pstmt.setString(3, v.getDescripcion());
			pstmt.setString(4, v.getMarca());
			pstmt.setInt(5, v.getTipo().getIdTipo());
			pstmt.setString(6, v.getPropietario());
			pstmt.setString(7, v.getTelefonoContacto());
			pstmt.executeUpdate();
			
			if(pstmt!=null){pstmt.close();}
			FactoryConnection.getInstancia().releaseConn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateOne(Vehiculo v) {
		//TODO
	}
}
