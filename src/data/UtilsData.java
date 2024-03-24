package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class UtilsData {

	public Date getToday() {
		Date fecha = new Date();
		try {
			PreparedStatement pstmt = FactoryConnection.getInstancia().getConn()
					.prepareStatement("select now() as fecha");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				fecha = rs.getTimestamp("fecha");
			}

			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			FactoryConnection.getInstancia().releaseConn();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return fecha;
	}

}
