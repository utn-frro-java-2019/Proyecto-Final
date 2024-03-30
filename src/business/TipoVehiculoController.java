package business;

import java.util.ArrayList;
import data.TipoVehiculoData;
import domain.*;
import util.CustomExceptions.*;

public class TipoVehiculoController {
	public static ArrayList<TipoVehiculo> getAll() {
		try {
			return new TipoVehiculoData().getAll();
		} catch (DatabaseAccessException e) {
			throw new DatabaseAccessException("Error al intentar obtener los tipos de vehiculo en la base de datos", e);
		}
	}

	public static TipoVehiculo getOne(int idTipo) {
		try {
			return new TipoVehiculoData().getOne(idTipo);
		} catch (DatabaseAccessException e) {
			throw new DatabaseAccessException("Error al intentar obtener un tipo de vehiculo en la base de datos", e);
		}
	}

	public static void deleteOne(int idTipo) {
		try {
			new TipoVehiculoData().deleteOne(idTipo);
		} catch (DatabaseAccessException e) {
			throw new DatabaseAccessException("Error al intentar eliminar un tipo de vehiculo en la base de datos", e);
		}
	}

	public static void insertOne(TipoVehiculo tv) {
		if (tv.getPorcentajeMultiplicador() < 0) {
			throw new PorcentajeMultiplicadorInvalidoException("El porcentaje de multiplicación no puede ser negativo");
		} else if (tv.getPorcentajeMultiplicador() == 0) {
			throw new PorcentajeMultiplicadorInvalidoException("El porcentaje de multiplicación debe ser mayor a 0");
		}

		try {
			new TipoVehiculoData().insertOne(tv);
		} catch (DatabaseAccessException e) {
			throw new DatabaseAccessException("Error al intentar insertar un tipo de vehiculo en la base de datos", e);
		}
	}

	public static void updateOne(TipoVehiculo tv) {
		if (tv.getPorcentajeMultiplicador() < 0) {
			throw new PorcentajeMultiplicadorInvalidoException("El porcentaje de multiplicación no puede ser negativo");
		} else if (tv.getPorcentajeMultiplicador() == 0) {
			throw new PorcentajeMultiplicadorInvalidoException("El porcentaje de multiplicación debe ser mayor a 0");
		}

		try {
			new TipoVehiculoData().updateOne(tv);
		} catch (DatabaseAccessException e) {
			throw new DatabaseAccessException("Error al intentar modificar un tipo de vehiculo en la base de datos", e);
		}
	}
}
