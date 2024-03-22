package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IngresoData {
    public Boolean checkThatVehicleIsNotInParking(String patent) {
        try {
            Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
            ResultSet rs = stmt
                    .executeQuery("select * from ingresos where patente='" + patent + "' and estado='activo'");

            while (rs.next()) {
                return false;
            }

            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            FactoryConnection.getInstancia().releaseConn();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }
}
