package data;

import java.sql.*;
import java.util.ArrayList;
import domain.*;
import data.CocheraData;
import data.TurnoData;

public class EmpleadoData {
	
	public ArrayList<Empleado> getAll() {
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		try {
			Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
			ResultSet rs= stmt.executeQuery("select * from empleados");

			while(rs.next()) {
				Empleado e=new Empleado();
				
				e.setNombre(rs.getString("nombre"));
				e.setApellido(rs.getString("apellido"));
				e.setEmail(rs.getString("email"));
				e.setTelefono1(rs.getString("telefono1"));
				e.setTelefono2(rs.getString("telefono2"));
				e.setUsuario(rs.getString("usuario"));
				e.setPassword(rs.getString("password"));
				e.setDni(rs.getString("dni"));
				e.setCochera(new CocheraData().getOne(rs.getInt("idCochera")));
				e.setTurno(new TurnoData().getOne(rs.getInt("idTurno")));
				
				empleados.add(e);
			}
			
			if(rs!=null){rs.close();}
			if(stmt!=null){stmt.close();}
			FactoryConnection.getInstancia().releaseConn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

		return empleados;
	}

	
	public Empleado getOne(String dni) {
		Empleado e=null;
		try {
			PreparedStatement pstmt = FactoryConnection.getInstancia().getConn().prepareStatement("Select * from empleados where dni = ?");
			pstmt.setString(1, dni);
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()) {
				e=new Empleado();
				
				e.setDni(rs.getString("dni"));
				e.setNombre(rs.getString("nombre"));
				e.setApellido(rs.getString("apellido"));
				e.setEmail(rs.getString("email"));
				e.setTelefono1(rs.getString("telefono1"));
				e.setTelefono2(rs.getString("telefono2"));
				e.setUsuario(rs.getString("usuario"));
				e.setPassword(rs.getString("password"));
				e.setCochera(new CocheraData().getOne(rs.getInt("idCochera")));
				e.setTurno(new TurnoData().getOne(rs.getInt("idTurno")));
			}
			
			if(rs!=null){rs.close();}
			if(pstmt!=null){pstmt.close();}
			FactoryConnection.getInstancia().releaseConn();
			
		} catch (SQLException ee) {
			ee.printStackTrace();
		}catch (Exception ee) {
			ee.printStackTrace();
		}

		return e;
	}
	
	public void deleteOne(String dni) {
		try {
			PreparedStatement pstmt = FactoryConnection.getInstancia().getConn().prepareStatement("delete from empleados where dni = ?");
			pstmt.setString(1, dni);
			pstmt.executeUpdate();
			if(pstmt!=null){pstmt.close();}
			FactoryConnection.getInstancia().releaseConn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertOne(Empleado e) {
		try {
			PreparedStatement pstmt = FactoryConnection.getInstancia().getConn().prepareStatement
			("insert into empleados(dni,nombre,apellido,email,telefono1,telefono2,usuario,password) values(?,?,?,?,?,?,?,?)");
			
			pstmt.setString(1, e.getDni());
			pstmt.setString(2, e.getNombre());
			pstmt.setString(3, e.getApellido());
			pstmt.setString(4, e.getEmail());
			pstmt.setString(5, e.getTelefono1());
			pstmt.setString(6, e.getTelefono2());
			pstmt.setString(7, e.getUsuario());
			pstmt.setString(8, e.getPassword());
			
			pstmt.executeUpdate();
			
			if(pstmt!=null){pstmt.close();}
			FactoryConnection.getInstancia().releaseConn();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void updateOne(Empleado e) {
		try {
			PreparedStatement pstmt = FactoryConnection.getInstancia().getConn().prepareStatement
			("update empleados set  nombre = ? , apellido = ? , email = ? , telefono1 = ? , telefono2 = ? , usuario = ? , password = ? where dni = ?");
			
			pstmt.setString(1, e.getNombre());
			pstmt.setString(2, e.getApellido());
			pstmt.setString(3, e.getEmail());
			pstmt.setString(4, e.getTelefono1());
			pstmt.setString(5, e.getTelefono2());
			pstmt.setString(6, e.getUsuario());
			pstmt.setString(7, e.getPassword());
			pstmt.setString(8, e.getDni());
			
			pstmt.executeUpdate();
			
			if(pstmt!=null){pstmt.close();}
			FactoryConnection.getInstancia().releaseConn();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
