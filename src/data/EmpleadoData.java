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
				e.setContraseña(rs.getString("contraseña"));
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

	
	public Empleado getOne(int dni) {
		Empleado e=null;
		try {
			PreparedStatement pstmt = FactoryConnection.getInstancia().getConn().prepareStatement("Select * from empleados where dni = ?");
			pstmt.setInt(1, dni);
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
				e.setContraseña(rs.getString("contraseña"));
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
	
	public void deleteOne(int dni) {
		try {
			PreparedStatement pstmt = FactoryConnection.getInstancia().getConn().prepareStatement("delete from empleados where dni = ?");
			pstmt.setInt(1, dni);
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
		String dni = e.getDni();
		String nom = e.getNombre();
		String ap = e.getApellido();
		String email = e.getEmail();
		String tel1 = e.getTelefono1();
		String tel2 = e.getTelefono2();
		String us = e.getUsuario();
		String pw = e.getContraseña();
		int c = e.getCochera().getIdCochera();
		int t = e.getTurno().getIdTurno();
		try {
			PreparedStatement pstmt= FactoryConnection.getInstancia().getConn().prepareStatement
			("insert into empleados(dni,idCochera,idTurno,nombre,apellido,email,telefono1,telefono2,usuario,contraseña) values(?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, dni);
			pstmt.setInt(2, c);
			pstmt.setInt(3, t);
			pstmt.setString(4, nom);
			pstmt.setString(5, ap);
			pstmt.setString(6, email);
			pstmt.setString(7, tel1);
			pstmt.setString(8, tel2);
			pstmt.setString(9, us);
			pstmt.setString(10, pw);
			
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
		String dni = e.getDni();
		String nom = e.getNombre();
		String ap = e.getApellido();
		String email = e.getEmail();
		String tel1 = e.getTelefono1();
		String tel2 = e.getTelefono2();
		String us = e.getUsuario();
		String pw = e.getContraseña();
		int c = e.getCochera().getIdCochera();
		int t = e.getTurno().getIdTurno();
		try {
			PreparedStatement pstmt= FactoryConnection.getInstancia().getConn().prepareStatement
			("update empleados set idCochera = ? , idTurno = ? , nombre = ? , apellido = ? , email = ? , telefono1 = ? , telefono2 = ? , "
			+ "usuario = ? , contraseña = ? where dni = ?");
			pstmt.setInt(1, c);
			pstmt.setInt(2, t);
			pstmt.setString(3, nom);
			pstmt.setString(4, ap);
			pstmt.setString(5, email);
			pstmt.setString(6, tel1);
			pstmt.setString(7, tel2);
			pstmt.setString(8, us);
			pstmt.setString(9, pw);
			pstmt.setString(10, dni);
			
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
