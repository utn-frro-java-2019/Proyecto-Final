package business;

import java.util.ArrayList;
import data.TipoVehiculoData;
import domain.*;

public class TipoVehiculoController {
	public static ArrayList<TipoVehiculo> getAll() {
		try {
			return new TipoVehiculoData().getAll();
		} catch (Exception e) {
			throw e;
		}
	}

	public static TipoVehiculo getOne(int idTipo) {
		try {
			return new TipoVehiculoData().getOne(idTipo);
		} catch (Exception e) {
			throw e;
		}
	}

	public static void deleteOne(int idTipo) {
		try {
			new TipoVehiculoData().deleteOne(idTipo);
		} catch (Exception e) {
			throw e;
		}
	}

	public static void insertOne(TipoVehiculo tv) {
		if (tv.getPorcentajeMultiplicador() < 0) {
			throw new RuntimeException("El porcentaje de multiplicación no puede ser negativo");
		} else if (tv.getPorcentajeMultiplicador() == 0) {
			throw new RuntimeException("El porcentaje de multiplicación debe ser mayor a 0");
		}

		try {
			new TipoVehiculoData().insertOne(tv);
		} catch (Exception e) {
			throw e;
		}
	}

	public static void updateOne(TipoVehiculo tv) {
		if (tv.getPorcentajeMultiplicador() < 0) {
			throw new RuntimeException("El porcentaje de multiplicación no puede ser negativo");
		} else if (tv.getPorcentajeMultiplicador() == 0) {
			throw new RuntimeException("El porcentaje de multiplicación debe ser mayor a 0");
		}

		try {
			new TipoVehiculoData().updateOne(tv);
		} catch (Exception e) {
			throw e;
		}
	}
}
