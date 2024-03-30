package business;

import java.util.ArrayList;
import data.DiarioData;
import domain.*;
import util.UUIDGenerator;
import util.CustomExceptions.*;

public class DiarioController extends IngresoController {
	public static ArrayList<Diario> getAllByCochera(String idCochera) {
		try {
		return new DiarioData().getAllByCochera(idCochera);
		}
		catch(DatabaseAccessException e){
			throw new DatabaseAccessException("Error al intentar obtener los ingresos en la base de datos", e);
		}
	}

	public static Diario getOneActiveByComprobante(String comprobante) {
		try {
		return new DiarioData().getOneActiveByComprobante(comprobante);
		}
		catch(DatabaseAccessException e){
			throw new DatabaseAccessException("Error al intentar obtener un ingreso por comprobante en la base de datos", e);
		}
		
	}

	public static Diario generateNew(String patent, Integer idCochera) {
		Cochera cochera = CocheraController.getOne(idCochera);
		if (cochera == null) {
			throw new CocheraNullException("La cochera no se encuentra en el sistema");
		}

		Vehiculo vehicle = VehiculoController.getOne(patent);
		if (vehicle == null) {
			throw new VehiculoNullException("El vehiculo no se encuentra en el sistema");
		}

		Boolean vehicleIsNotInParking = IngresoController.checkThatVehicleIsNotInParking(patent);
		if (!vehicleIsNotInParking) {
			throw new VehiculoEstacionadoException("El vehiculo ya se encuentra en el estacionamiento");
		}

		Lugar lugar = LugarController.getOneFree(idCochera);
		if (lugar == null) {
			throw new LugarNullException("No hay lugares disponibles en la cochera");
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
		} catch (DatabaseAccessException e) {
			lugar.setOcupado(false);
			LugarController.updateOne(lugar);
			throw new DatabaseAccessException("Error al intentar guardar el ingreso en la base de datos", e);
		}
	}

	public static Diario finalizeOne(Diario d, Double price) {
		try {
			Diario diario = new DiarioData().finalizeOne(d, price);
			Lugar lugar = d.getLugar();
			lugar.setOcupado(false);
			LugarController.updateOne(lugar);
			return diario;
		} catch (DatabaseAccessException e) {
			throw new DatabaseAccessException("Error al intentar finalizar el ingreso en la base de datos", e);
		}
	}
}
