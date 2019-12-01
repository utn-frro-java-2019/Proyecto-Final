package data;


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
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs= stmt.executeQuery("select * from vehiculos where patente ="+ patente);
			while(rs.next()) {
				v=new Vehiculo();
				
				v.setPatente(rs.getString("patente"));
				v.setMarca(rs.getString("marca"));
				v.setModelo(rs.getString("modelo"));
				v.setDescripcion(rs.getString("descripcion"));
				v.setTipo(new TipoVehiculoData().getOne(rs.getInt("idTipo")));
				
			}
			
			if(rs!=null){rs.close();}
			if(stmt!=null){stmt.close();}
			FactoryConnection.getInstancia().releaseConn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

		return v;
	}
}
