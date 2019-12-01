package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.*;

public class MultiplicadorEstadiaData {
	
	public ArrayList<MultiplicadorEstadia> getAll() {
		ArrayList<MultiplicadorEstadia> multiplicadoresEstadias = new ArrayList<MultiplicadorEstadia>();
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs= stmt.executeQuery("select * from multiplicadores_estadias");

			while(rs.next()) {
				MultiplicadorEstadia me=new MultiplicadorEstadia();
				
				me.setMultiplicadorDesde(rs.getInt("multiplicadorDesde"));
				me.setPorcentajeMultiplicador(rs.getDouble("porcentajeMultiplicador"));

				
				multiplicadoresEstadias.add(me);
				
			}
			
			if(rs!=null){rs.close();}
			if(stmt!=null){stmt.close();}
			FactoryConnection.getInstancia().releaseConn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

		return multiplicadoresEstadias;
	}

	
	public MultiplicadorEstadia getOne(int multiplicadorDesde) {
		MultiplicadorEstadia me=null;
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs= stmt.executeQuery("select * from multiplicadores_estadias where multiplicadorDesde ="+ multiplicadorDesde);
			while(rs.next()) {
				me=new MultiplicadorEstadia();
				
				me.setMultiplicadorDesde(rs.getInt("multiplicadorDesde"));
				me.setPorcentajeMultiplicador(rs.getDouble("porcentajeMultiplicador"));
			
			}
			
			if(rs!=null){rs.close();}
			if(stmt!=null){stmt.close();}
			FactoryConnection.getInstancia().releaseConn();
			
		} catch (SQLException ee) {
			ee.printStackTrace();
		}catch (Exception ee) {
			ee.printStackTrace();
		}

		return me;
	}
}
