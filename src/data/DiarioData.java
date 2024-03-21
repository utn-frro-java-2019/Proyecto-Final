package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.*;

public class DiarioData extends IngresoData {
	
	public ArrayList<Diario> getAll() {
		ArrayList<Diario> ingresos = new ArrayList<Diario>();
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs= stmt.executeQuery("select * from ingresos");

			while(rs.next()) {
				Diario es=new Diario();
				
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
	
	public Diario getOne(int idIngreso) {
		Diario es = null;
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs= stmt.executeQuery("select * from ingresos where idIngreso="+idIngreso);

			while(rs.next()) {
				es=new Diario();
				
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
