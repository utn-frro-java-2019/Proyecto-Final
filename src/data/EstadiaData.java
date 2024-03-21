package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.*;

public class EstadiaData extends IngresoData {
	
	public ArrayList<Estadia> getAll() {
		ArrayList<Estadia> ingresos = new ArrayList<Estadia>();
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs= stmt.executeQuery("select * from ingresos");

			while(rs.next()) {
				Estadia es=new Estadia();
				
				es.setCochera(new data.CocheraData().getOne(rs.getInt("idCochera")));
				es.setVehiculo(new data.VehiculoData().getOne(rs.getString("patente")));
				es.setEstado(rs.getString("estado"));
				es.setFechaIngreso(rs.getTimestamp("fechaIngreso"));
				es.setFechaRetiro(rs.getTimestamp("fechaRetiro"));
				es.setPrecioFinal(rs.getDouble("precioFinal"));
				
				ingresos.add(es);
			}
			
			if(rs!=null){rs.close();}
			if(stmt!=null){stmt.close();}
			FactoryConnection.getInstancia().releaseConn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

		return ingresos;
	}
	
	public Estadia getOne(int idIngreso) {
		Estadia es = null;
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs= stmt.executeQuery("select * from ingresos where idIngreso="+idIngreso);

			while(rs.next()) {
				es=new Estadia();
				
				es.setCochera(new data.CocheraData().getOne(rs.getInt("idCochera")));
				es.setVehiculo(new data.VehiculoData().getOne(rs.getString("patente")));
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
}
