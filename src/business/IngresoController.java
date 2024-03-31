package business;

import java.util.ArrayList;

import data.IngresoData;
import domain.Ingreso;
import util.CustomExceptions.DatabaseAccessException;

public class IngresoController {
	public static Boolean checkThatVehicleIsNotInParking(String patent) {
		try {
			return new IngresoData().checkThatVehicleIsNotInParking(patent);
		} catch (DatabaseAccessException e) {
			throw new DatabaseAccessException("Error al intentar chequear que el vehiculo esta estacionado", e);
		}
	}

	public static Boolean checkThatVehicleNeverParked(String patent) {
		try {
			return new IngresoData().checkThatVehicleNeverParked(patent);
		} catch (DatabaseAccessException e) {
			throw new DatabaseAccessException("Error al intentar chequear que el vehiculo se encuentra estacionado", e);
		}
	}

	public static ArrayList<Ingreso> getActivosByCochera(Integer idCochera) {
		try {
			return new IngresoData().getActivosByCochera(idCochera);
		} catch (DatabaseAccessException e) {
			throw new DatabaseAccessException("Error al intentar chequear los vehiculos activos en la cochera", e);
		}
	}

	public static ArrayList<Ingreso> getAllByCochera(Integer idCochera) {
		try {
			return new IngresoData().getAllByCochera(idCochera);
		} catch (DatabaseAccessException e) {
			throw new DatabaseAccessException("Error al intentar obtener los vehiculos en la cochera", e);
		}
	}
}
