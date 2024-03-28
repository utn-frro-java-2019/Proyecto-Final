package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class UtilsData {

	public Date getToday() {
		Date fecha = new Date();
		try {
			PreparedStatement pstmt = FactoryConnection.getInstancia().getConn()
					.prepareStatement("select now() as fecha");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				java.util.Calendar cal = Calendar.getInstance();
				cal.setTimeZone(TimeZone.getTimeZone("GMT-3"));

				fecha = rs.getTimestamp("fecha", cal);
			}

			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			FactoryConnection.getInstancia().releaseConn();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Error al recuperar la fecha actual");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Error al recuperar la fecha actual");
		}

		return fecha;
	}

}
