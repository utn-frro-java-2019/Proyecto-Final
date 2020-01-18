package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import domain.*;

public class PrecioPorHoraData {
	
	public PrecioPorHora getPrecioPorHora() {
		PrecioPorHora p = null;
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs= stmt.executeQuery("select * from precio_por_hora");

			while(rs.next()) {
				p=new PrecioPorHora();
				
				p.setPrecio(rs.getDouble("precio"));
				
			}
			
			if(rs!=null){rs.close();}
			if(stmt!=null){stmt.close();}
			FactoryConnection.getInstancia().releaseConn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

		return p;
	}

}
