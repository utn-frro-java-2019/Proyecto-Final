package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.*;
import util.CustomExceptions.DatabaseAccessException;

public class TurnoData {

	public ArrayList<Turno> getAll() {
		ArrayList<Turno> turnos = new ArrayList<Turno>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from turnos");

			while (rs.next()) {
				Turno t = new Turno();

				t.setIdTurno(rs.getInt("idTurno"));
				t.setDescripcion(rs.getString("descripcion"));
				t.setHoraInicio(rs.getTime("horaInicio"));
				t.setHoraFin(rs.getTime("horaFin"));

				turnos.add(t);
			}

		} catch (SQLException e) {
	        throw new DatabaseAccessException("Error SQL al intentar recuperar turnos en la base de datos", e);
		} catch (Exception e) {
	        throw new DatabaseAccessException("Error SQL al intentar recuperar turnos en la base de datos", e);
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
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al recuperar turnos", e);
	        }		
		}

		return turnos;
	}

	public Turno getOne(int id) {
		Turno t = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from turnos where idTurno=" + id);
			while (rs.next()) {
				t = new Turno();

				t.setIdTurno(rs.getInt("idTurno"));
				t.setDescripcion(rs.getString("descripcion"));
				t.setHoraInicio(rs.getTime("horaInicio"));
				t.setHoraFin(rs.getTime("horaFin"));
			}

		} catch (SQLException e) {
	        throw new DatabaseAccessException("Error SQL al intentar recuperar un turno en la base de datos", e);
		} catch (Exception e) {
	        throw new DatabaseAccessException("Error al intentar recuperar un turno en la base de datos", e);
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
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al recuperar un turno", e);
	        }		
		}

		return t;
	}
}
