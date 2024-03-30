package business;

import java.util.ArrayList;
import data.VehiculoData;
import domain.*;
import util.CustomExceptions.*;

public class VehiculoController {
	public static ArrayList<Vehiculo> getAll() {
		try {
			return new VehiculoData().getAll();
		} catch (DatabaseAccessException e) {
            throw new DatabaseAccessException("Error al intentar obtener los vehiculos en la base de datos", e);
		}
	}

	public static Vehiculo getOne(String patente) {
		try {
			return new VehiculoData().getOne(patente);
		} catch (DatabaseAccessException e) {
            throw new DatabaseAccessException("Error al intentar obtener un vehiculo en la base de datos", e);
		}
	}

	public static void deleteOne(String patente) {
		try {
			Boolean yaTieneIngresosRealizados = IngresoController.checkThatVehicleNeverParked(patente);
			if (!yaTieneIngresosRealizados) {
				throw new VehiculoExistenteException("No se puede eliminar un vehiculo que ya ha ingresado al estacionamiento");
			}

			new VehiculoData().deleteOne(patente);
		} catch (DatabaseAccessException e) {
            throw new DatabaseAccessException("Error al intentar eliminar un vehiculo en la base de datos", e);
		}
	}

	public static void insertOne(Vehiculo v) {
		try {
			new VehiculoData().insertOne(v);
		} catch (DatabaseAccessException e) {
            throw new DatabaseAccessException("Error al intentar insertar un vehiculo en la base de datos", e);
		}
	}

	public static void updateOne(Vehiculo v) {
		try {
			new VehiculoData().updateOne(v);
		} catch (DatabaseAccessException e) {
            throw new DatabaseAccessException("Error al intentar modificar un vehiculo en la base de datos", e);
		}
	}
}
