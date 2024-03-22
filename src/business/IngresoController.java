package business;

import data.IngresoData;

public class IngresoController {
    public static Boolean checkThatVehicleIsNotInParking(String patent) {
        return new IngresoData().checkThatVehicleIsNotInParking(patent);
    }
}
