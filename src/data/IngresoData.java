package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.Ingreso;

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

    public ArrayList<Ingreso> getActivosByCochera(Integer idCochera) {
        ArrayList<Ingreso> ingresos = new ArrayList<Ingreso>();
        try {
            Statement stmt = FactoryConnection.getInstancia().getConn().createStatement();
            ResultSet rs = stmt.executeQuery("select * from ingresos where estado='activo' and idCochera='"
                    + idCochera + "' order by fechaIngreso desc");

            while (rs.next()) {
                Ingreso i = new Ingreso();

                i.setIdIngreso(rs.getInt("idIngreso"));
                i.setComprobante(rs.getString("comprobante"));
                i.setCochera(new data.CocheraData().getOne(rs.getInt("idCochera")));
                i.setLugar(new data.LugarData().getOne(rs.getInt("nroLugar"), rs.getInt("idCochera")));
                i.setVehiculo(new data.VehiculoData().getOne(rs.getString("patente")));
                i.setFechaIngreso(rs.getTimestamp("fechaIngreso"));
                i.setFechaRetiro(rs.getTimestamp("fechaRetiro"));
                i.setPrecioFinal(rs.getDouble("precioFinal"));
                i.setEstado(rs.getString("estado"));
                i.setPrecioFinal(rs.getDouble("precioFinal"));
                i.setAutoEnCochera(rs.getBoolean("autoEnCochera"));
                i.setTipo(rs.getString("tipoIngreso"));

                ingresos.add(i);
            }

            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            FactoryConnection.getInstancia().releaseConn();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Error al intentar obtener los ingresos en la base de datos");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Error al intentar obtener los ingresos en la base de datos");
        }

        return ingresos;
    }
}
