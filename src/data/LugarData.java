package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.*;

public class LugarData {

	
	public ArrayList<Lugar> getAll() {
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs= stmt.executeQuery("select * from lugares");

			while(rs.next()) {
				Lugar l=new Lugar();
				
				l.setNroLugar(rs.getInt("nroLugar"));
				boolean ocupado = false;
				if(rs.getString("ocupado") == "true") ocupado = true;
				l.setOcupado(ocupado);
				l.setCochera(new data.CocheraData().getOne(rs.getInt("idCochera")));
				
				lugares.add(l);
			}
			
			if(rs!=null){rs.close();}
			if(stmt!=null){stmt.close();}
			FactoryConnection.getInstancia().releaseConn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

		return lugares;
	}
	
	public Lugar getOne(int nroLugar) {
		Lugar l=null;
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs= stmt.executeQuery("select * from lugares where nroLugar ="+ nroLugar);
			while(rs.next()) {
				l=new Lugar();
				
				l.setNroLugar(rs.getInt("nroLugar"));
				boolean ocupado = false;
				if(rs.getString("ocupado") == "true") ocupado = true;
				l.setOcupado(ocupado);
				l.setCochera(new data.CocheraData().getOne(rs.getInt("idCochera")));	
			}
			
			if(rs!=null){rs.close();}
			if(stmt!=null){stmt.close();}
			FactoryConnection.getInstancia().releaseConn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

		return l;
	}
}