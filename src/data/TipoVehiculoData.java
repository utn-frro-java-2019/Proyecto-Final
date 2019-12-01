package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.*;

public class TipoVehiculoData {
	
public ArrayList<TipoVehiculo> getAll() {
	ArrayList<TipoVehiculo> tiposVehiculos = new ArrayList<TipoVehiculo>();
	try {
		Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
		ResultSet rs= stmt.executeQuery("select * from tipos_vehiculos");

		while(rs.next()) {		
			TipoVehiculo tv=new TipoVehiculo();
			
			tv.setIdTipo(rs.getInt("idTipo"));
			tv.setDescripcion(rs.getString("descripcion"));

			
			tiposVehiculos.add(tv);
			
		}
		
		if(rs!=null){rs.close();}
		if(stmt!=null){stmt.close();}
		FactoryConnection.getInstancia().releaseConn();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}catch (Exception e) {
		e.printStackTrace();
	}

	return tiposVehiculos;
}


	public TipoVehiculo getOne(int idTipo) {
		TipoVehiculo tv=null;
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs= stmt.executeQuery("select * from tipos_vehiculos where idTipo ="+ idTipo);
			while(rs.next()) {
				tv=new TipoVehiculo();
				
				tv.setIdTipo(rs.getInt("idTipo"));
				tv.setDescripcion(rs.getString("descripcion"));
				
			}
			
			if(rs!=null){rs.close();}
			if(stmt!=null){stmt.close();}
			FactoryConnection.getInstancia().releaseConn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

		return tv;
	}
}
