package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import domain.*;
import util.CustomExceptions.DatabaseAccessException;

public class JefeData {
	public Jefe get() {
		Statement stmt = null;
		ResultSet rs = null;
		Jefe j = new Jefe();
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from jefes");

			if (rs.next()) { 
	            j.setNombre(rs.getString("nombre"));
	            j.setApellido(rs.getString("apellido"));
	            j.setEmail(rs.getString("email"));
	            j.setPassword(rs.getString("password"));
	        } else {
	            throw new DatabaseAccessException("No se encontró ningún jefe en la base de datos");
	        }

		} catch (SQLException e) {
	        throw new DatabaseAccessException("Error SQL al intentar obtener el jefe en la base de datos", e);
		} catch (Exception e) {
	        throw new DatabaseAccessException("Error al intentar obtener el jefe en la base de datos", e);
		}
		finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (stmt != null) {
	                stmt.close();
	            }
	            FactoryConnection.getInstancia().releaseConn();
	        } catch (SQLException e) {
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al obtener el jefe", e);
	        }		
		}

		return j;
	}
}
