package data;

import java.sql.PreparedStatement;
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
			tv.setPorcentajeMultiplicador(rs.getDouble("porcentajeMultiplicador"));
			
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
			PreparedStatement pstmt = FactoryConnection.getInstancia().getConn().prepareStatement("select * from tipos_vehiculos where idTipo = ?");
			pstmt.setInt(1, idTipo);
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()) {
				tv=new TipoVehiculo();
				
				tv.setIdTipo(rs.getInt("idTipo"));
				tv.setDescripcion(rs.getString("descripcion"));
				tv.setPorcentajeMultiplicador(rs.getDouble("porcentajeMultiplicador"));
				
			}
			
			if(rs!=null){rs.close();}
			if(pstmt!=null){pstmt.close();}
			FactoryConnection.getInstancia().releaseConn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

		return tv;
	}
	
	public void deleteOne(int idTipo) {
		try {
			PreparedStatement pstmt = FactoryConnection.getInstancia().getConn().prepareStatement("delete from tipos_vehiculos where idTipo = ?");
			pstmt.setInt(1, idTipo);
			pstmt.executeUpdate();
			if(pstmt!=null){pstmt.close();}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void insertOne(TipoVehiculo tv) {
		try {
			PreparedStatement pstmt = FactoryConnection.getInstancia().getConn().prepareStatement
			("insert into tipos_vehiculos (descripcion, porcentajeMultiplicador) values (?,?)");
			pstmt.setString(1, tv.getDescripcion());
			pstmt.setDouble(2, tv.getPorcentajeMultiplicador());
			
			pstmt.executeUpdate();
			
			if(pstmt!=null){pstmt.close();}
			FactoryConnection.getInstancia().releaseConn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateOne(TipoVehiculo tv) {
		try {
			PreparedStatement pstmt = FactoryConnection.getInstancia().getConn().prepareStatement
			("update tipos_vehiculos set descripcion = ? , porcentajeMultiplicador = ? where idTipo = ? ");
			pstmt.setString(1, tv.getDescripcion());
			pstmt.setDouble(2, tv.getPorcentajeMultiplicador());
			pstmt.setInt(3, tv.getIdTipo());
			
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
