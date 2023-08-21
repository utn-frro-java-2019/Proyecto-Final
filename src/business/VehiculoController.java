package business;

import java.util.ArrayList;
import data.VehiculoData;
import domain.*;

public class VehiculoController {
	public static ArrayList<Vehiculo> getAll() {
		return new VehiculoData().getAll();
	}

	public static Vehiculo getOne(String patente) {
		return new VehiculoData().getOne(patente);
	}

	public static void deleteOne(String patente) {
		new VehiculoData().deleteOne(patente);
	}

	public static void insertOne(Vehiculo v) {
		new VehiculoData().insertOne(v);
	}

	public static void updateOne(Vehiculo v) {
		// TODO
	}
}
