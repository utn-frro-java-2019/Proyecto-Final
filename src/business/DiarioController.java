package business;

import java.util.ArrayList;
import data.DiarioData;
import domain.*;
import util.UUIDGenerator;

public class DiarioController extends IngresoController {
	public static Diario getOne(int idIngreso) {
		return new DiarioData().getOne(idIngreso);
	}

	public static ArrayList<Diario> getAll() {
		return new DiarioData().getAll();
	}

	public static Diario getOneActiveByComprobante(String comprobante) {
		return new DiarioData().getOneActiveByComprobante(comprobante);
	}

	public static Diario generateNew(String patent, Integer idCochera) {
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

		diario.setComprobante(UUIDGenerator.randomStringUUID());
		diario.setVehiculo(vehicle);
		diario.setCochera(CocheraController.getOne(idCochera));
		diario.setLugar(lugar);

		try {
			new DiarioData().insertOne(diario);
			lugar.setOcupado(true);
			LugarController.updateOne(lugar);

			return new DiarioData().getOneActiveByComprobante(diario.getComprobante());
		} catch (Exception e) {
			throw new RuntimeException("Error al intentar guardar el ingreso en la base de datos");
		}
	}

	public static Diario finalizeOne(Diario d) {
		// TODO: Calculate price
		Diario diario = new DiarioData().finalizeOne(d);
		Lugar lugar = d.getLugar();
		lugar.setOcupado(false);
		LugarController.updateOne(lugar);
		return diario;
	}
}
