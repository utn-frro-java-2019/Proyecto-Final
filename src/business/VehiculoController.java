package business;

import java.util.ArrayList;

import data.VehiculoData;
import domain.*;

public class VehiculoController {

	public static Vehiculo getOne(String patente) {
		return new VehiculoData().getOne(patente);
	}

	public static ArrayList<Vehiculo> getAll() {
		return new VehiculoData().getAll();
	}
}
