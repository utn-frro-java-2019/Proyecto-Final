package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.*;

public class EstadiaData {
	
	public ArrayList<Estadia> getAll() {
		ArrayList<Estadia> estadias = new ArrayList<Estadia>();
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs= stmt.executeQuery("select * from estadias");

			while(rs.next()) {
				Estadia es=new Estadia();
				
				es.setCochera(new data.CocheraData().getOne(rs.getInt("idCochera")));
				es.setVehiculo(new data.VehiculoData().getOne(rs.getString("patente")));
				//es.setLugar(new data.LugarData().getOne(rs.getInt("nroLugar")));
				es.setEstado(rs.getString("estado"));
				es.setFechaIngreso(rs.getTimestamp("fechaIngreso"));
				es.setFechaRetiro(rs.getTimestamp("fechaRetiro"));
				es.setPrecioFinal(rs.getDouble("precioFinal"));
				
				estadias.add(es);
			}
			
			if(rs!=null){rs.close();}
			if(stmt!=null){stmt.close();}
			FactoryConnection.getInstancia().releaseConn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

		return estadias;
	}
	
	public Estadia getOne(int idEstadia) {
		Estadia es = null;
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs= stmt.executeQuery("select * from estadias where idEstadia="+idEstadia);

			while(rs.next()) {
				es=new Estadia();
				
				es.setCochera(new data.CocheraData().getOne(rs.getInt("idCochera")));
				es.setVehiculo(new data.VehiculoData().getOne(rs.getString("patente")));
				//es.setLugar(new data.LugarData().getOne(rs.getInt("nroLugar")));
				es.setEstado(rs.getString("estado"));
				es.setFechaIngreso(rs.getTimestamp("fechaIngreso"));
				es.setFechaRetiro(rs.getTimestamp("fechaRetiro"));
				es.setPrecioFinal(rs.getDouble("precioFinal"));
			}
			
			if(rs!=null){rs.close();}
			if(stmt!=null){stmt.close();}
			FactoryConnection.getInstancia().releaseConn(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

		return es;
	}
	
	/*public void insertOne(Estadia e) {
		try {
			
			String consulta = "insert into estadias (nombre, ubicacion, descripcion, capacidad) values (?, ?, ?, ?)";
			PreparedStatement stmt = FactoryConnection.getInstancia().getConn().prepareStatement(consulta);
			stmt.setString(1, c.getNombre());
			stmt.setString(2, c.getUbicacion());
			stmt.setString(3, c.getDescripcion());
			stmt.setString(4, Integer.toString(c.getCapacidad()));
			stmt.executeUpdate();
			
			if(stmt!=null){stmt.close();}
			FactoryConnection.getInstancia().releaseConn();
			
		} catch (SQLException e) {
			throw new RuntimeException("Error al crear la cochera");
		}catch (Exception e) {
			throw new RuntimeException("Error al crear la cochera");
		}
	}*/
}
