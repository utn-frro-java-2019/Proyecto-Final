package business;

import java.util.ArrayList;

import data.IngresoData;
import domain.Ingreso;

public class IngresoController {
    public static Boolean checkThatVehicleIsNotInParking(String patent) {
        return new IngresoData().checkThatVehicleIsNotInParking(patent);
    }

    public static ArrayList<Ingreso> getActivosByCochera(Integer idCochera) {
        return new IngresoData().getActivosByCochera(idCochera);
    }
}
