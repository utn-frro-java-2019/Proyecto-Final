package business;

import java.util.ArrayList;

import data.TipoVehiculoData;
import domain.*;

public class TipoVehiculoController {

	public static TipoVehiculo getOne(int idTipo) {
		return new TipoVehiculoData().getOne(idTipo);
	}

	public static ArrayList<TipoVehiculo> getAll() {
		return new TipoVehiculoData().getAll();
	}
}
