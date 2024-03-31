package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import domain.Ingreso;
import util.CustomExceptions.DatabaseAccessException;

public class IngresoData {
    public Boolean checkThatVehicleIsNotInParking(String patent) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = FactoryConnection.getInstancia().getConn().createStatement();
            rs = stmt
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
            throw new DatabaseAccessException(
                    "Error SQL al intentar chequear si el vehiculo se encuentra en estacionamiento en la base de datos",
                    e);
        } catch (Exception e) {
            throw new DatabaseAccessException(
                    "Error al intentar chequear si el vehiculo se encuentra en estacionamiento en la base de datos", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                FactoryConnection.getInstancia().releaseConn();
            } catch (SQLException e) {
                throw new DatabaseAccessException(
                        "Error al intentar cerrar la conexión o el statement al chequear si el vehiculo se encuentra en estacionamiento",
                        e);
            }
        }

        return true;

    }

    public Boolean checkThatVehicleNeverParked(String patent) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = FactoryConnection.getInstancia().getConn().createStatement();
            rs = stmt
                    .executeQuery("select * from ingresos where patente='" + patent + "'");

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
            throw new DatabaseAccessException(
                    "Error SQL al intentar chequear si el vehiculo ha ingresado alguna vez",
                    e);
        } catch (Exception e) {
            throw new DatabaseAccessException(
                    "Error al intentar chequear si el vehiculo ha ingresado alguna vez", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                FactoryConnection.getInstancia().releaseConn();
            } catch (SQLException e) {
                throw new DatabaseAccessException(
                        "Error al intentar cerrar la conexión o el statement al chequear si el vehiculo ha ingresado alguna vez",
                        e);
            }
        }

        return true;

    }

    public ArrayList<Ingreso> getActivosByCochera(Integer idCochera) {
        ArrayList<Ingreso> ingresos = new ArrayList<Ingreso>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = FactoryConnection.getInstancia().getConn().createStatement();
            rs = stmt.executeQuery("select * from ingresos where estado='activo' and idCochera='"
                    + idCochera + "' order by fechaIngreso desc");

            while (rs.next()) {
                Ingreso i = new Ingreso();

                java.util.Calendar cal = Calendar.getInstance();
                cal.setTimeZone(TimeZone.getTimeZone("GMT-3"));

                i.setIdIngreso(rs.getInt("idIngreso"));
                i.setComprobante(rs.getString("comprobante"));
                i.setCochera(new data.CocheraData().getOne(rs.getInt("idCochera")));
                i.setLugar(new data.LugarData().getOne(rs.getInt("nroLugar"), rs.getInt("idCochera")));
                i.setVehiculo(new data.VehiculoData().getOne(rs.getString("patente")));
                i.setFechaIngreso(rs.getTimestamp("fechaIngreso", cal));
                i.setFechaRetiro(rs.getTimestamp("fechaRetiro", cal));
                i.setPrecioFinal(rs.getDouble("precioFinal"));
                i.setEstado(rs.getString("estado"));
                i.setPrecioFinal(rs.getDouble("precioFinal"));
                i.setAutoEnCochera(rs.getBoolean("autoEnCochera"));
                i.setTipo(rs.getString("tipoIngreso"));

                ingresos.add(i);
            }

        } catch (SQLException e) {
            throw new DatabaseAccessException(
                    "Error SQL al intentar obtener los ingresos activos por cochera en la base de datos", e);
        } catch (Exception e) {
            throw new DatabaseAccessException(
                    "Error al intentar obtener los ingresos activos por cochera en la base de datos", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                FactoryConnection.getInstancia().releaseConn();
            } catch (SQLException e) {
                throw new DatabaseAccessException(
                        "Error al intentar cerrar la conexión o el statement al obtener los ingresos activos por cochera",
                        e);
            }
        }

        return ingresos;
    }

    public ArrayList<Ingreso> getAllByCochera(Integer idCochera) {
        ArrayList<Ingreso> ingresos = new ArrayList<Ingreso>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = FactoryConnection.getInstancia().getConn().createStatement();
            rs = stmt.executeQuery("select * from ingresos where idCochera='"
                    + idCochera + "' order by fechaIngreso desc");

            while (rs.next()) {
                Ingreso i = new Ingreso();

                java.util.Calendar cal = Calendar.getInstance();
                cal.setTimeZone(TimeZone.getTimeZone("GMT-3"));

                i.setIdIngreso(rs.getInt("idIngreso"));
                i.setComprobante(rs.getString("comprobante"));
                i.setCochera(new data.CocheraData().getOne(rs.getInt("idCochera")));
                i.setLugar(new data.LugarData().getOne(rs.getInt("nroLugar"), rs.getInt("idCochera")));
                i.setVehiculo(new data.VehiculoData().getOne(rs.getString("patente")));
                i.setFechaIngreso(rs.getTimestamp("fechaIngreso", cal));
                i.setFechaRetiro(rs.getTimestamp("fechaRetiro", cal));
                i.setPrecioFinal(rs.getDouble("precioFinal"));
                i.setEstado(rs.getString("estado"));
                i.setPrecioFinal(rs.getDouble("precioFinal"));
                i.setAutoEnCochera(rs.getBoolean("autoEnCochera"));
                i.setTipo(rs.getString("tipoIngreso"));

                ingresos.add(i);
            }

        } catch (SQLException e) {
            throw new DatabaseAccessException(
                    "Error SQL al intentar obtener los ingresos por cochera en la base de datos", e);
        } catch (Exception e) {
            throw new DatabaseAccessException(
                    "Error al intentar obtener los ingresos por cochera en la base de datos", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                FactoryConnection.getInstancia().releaseConn();
            } catch (SQLException e) {
                throw new DatabaseAccessException(
                        "Error al intentar cerrar la conexión o el statement al obtener los ingresos por cochera",
                        e);
            }
        }

        return ingresos;
    }
}
