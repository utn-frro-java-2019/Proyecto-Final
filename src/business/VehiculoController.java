package business;

import java.util.ArrayList;
import data.VehiculoData;
import domain.*;

public class VehiculoController {
	public static ArrayList<Vehiculo> getAll() {
		try {
			return new VehiculoData().getAll();
		} catch (Exception e) {
			throw e;
		}
	}

	public static Vehiculo getOne(String patente) {
		try {
			return new VehiculoData().getOne(patente);
		} catch (Exception e) {
			throw e;
		}
	}

	public static void deleteOne(String patente) {
		try {
			new VehiculoData().deleteOne(patente);
		} catch (Exception e) {
			throw e;
		}
	}

	public static void insertOne(Vehiculo v) {
		try {
			new VehiculoData().insertOne(v);
		} catch (Exception e) {
			throw e;
		}
	}

	public static void updateOne(Vehiculo v) {
		try {
			new VehiculoData().updateOne(v);
		} catch (Exception e) {
			throw e;
		}
	}
}
