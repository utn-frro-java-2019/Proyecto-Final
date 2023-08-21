package business;

import java.util.ArrayList;
import data.TipoVehiculoData;
import domain.*;

public class TipoVehiculoController {
	public static ArrayList<TipoVehiculo> getAll() {
		return new TipoVehiculoData().getAll();
	}

	public static TipoVehiculo getOne(int idTipo) {
		return new TipoVehiculoData().getOne(idTipo);
	}

	public static void deleteOne(int idTipo) {
		new TipoVehiculoData().deleteOne(idTipo);
	}

	public static void insertOne(TipoVehiculo tv) {
		new TipoVehiculoData().insertOne(tv);
	}

	public static void updateOne(TipoVehiculo tv) {
		new TipoVehiculoData().updateOne(tv);
	}
}
