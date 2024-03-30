package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import util.CustomExceptions.DatabaseAccessException;

public class UtilsData {

	public Date getToday() {
		Date fecha = new Date();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = FactoryConnection.getInstancia().getConn()
					.prepareStatement("select now() as fecha");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				java.util.Calendar cal = Calendar.getInstance();
				cal.setTimeZone(TimeZone.getTimeZone("GMT-3"));

				fecha = rs.getTimestamp("fecha", cal);
			}

		} catch (SQLException e) {
	        throw new DatabaseAccessException("Error SQL al intentar recuperar la fecha actual", e);
		} catch (Exception e) {
	        throw new DatabaseAccessException("Error al intentar recuperar la fecha actual", e);
		}
		finally {
	        try {
	        	if (rs != null) {
	            	rs.close();
	            }
	            if (pstmt != null) {
	            	pstmt.close();
	            }
	            FactoryConnection.getInstancia().releaseConn();
	        } catch (SQLException e) {
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al recuperar la fecha actual", e);
	        }		
		}

		return fecha;
	}

}
