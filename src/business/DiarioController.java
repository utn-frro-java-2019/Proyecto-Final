package business;

import java.util.ArrayList;
import data.DiarioData;
import domain.*;

public class DiarioController extends IngresoController {
	public static Diario getOne(int idIngreso) {
		return new DiarioData().getOne(idIngreso);
	}

	public static ArrayList<Diario> getAll() {
		return new DiarioData().getAll();
	}

	public Diario generateNew(String patent, Integer idCochera) {
		Cochera cochera = CocheraController.getOne(idCochera);
		if (cochera == null) {
			throw new RuntimeException("La cochera no se encuentra en el sistema");
		}

		Vehiculo vehicle = VehiculoController.getOne(patent);
		if (vehicle == null) {
			throw new RuntimeException("El vehiculo no se encuentra en el sistema");
		}

		Boolean vehicleIsNotInParking = IngresoController.checkThatVehicleIsNotInParking(patent);
		if (!vehicleIsNotInParking) {
			throw new RuntimeException("El vehiculo ya se encuentra en el estacionamiento");
		}

		Lugar lugar = LugarController.getOneFree(idCochera);
		if (lugar == null) {
			throw new RuntimeException("No hay lugares disponibles en la cochera");
		}

		Diario diario = new Diario();

		diario.setVehiculo(vehicle);
		diario.setCochera(CocheraController.getOne(idCochera));
		diario.setLugar(lugar);
		diario.setEstado("activo");

		try {
			new DiarioData().insertOne(diario);
			return diario;
		} catch (Exception e) {
			throw new RuntimeException("Error al intentar guardar el ingreso en la base de datos");
		}
	}

	public void finalizeOne(Diario d) {
		new DiarioData().finalizeOne(d);
	}
}
