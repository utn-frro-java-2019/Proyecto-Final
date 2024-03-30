package business;

import java.util.ArrayList;
import java.util.Date;

import data.EstadiaData;
import domain.*;
import util.UUIDGenerator;

public class EstadiaController extends IngresoController {
	public static ArrayList<Estadia> getAllByCochera(String idCochera) {
		return new EstadiaData().getAllByCochera(idCochera);
	}

	public static Estadia getOneActiveByComprobante(String comprobante) {
		return new EstadiaData().getOneActiveByComprobante(comprobante);
	}

	public static Estadia generateNew(String patent, Integer idCochera, Double precioFinal, Date fechaEgreso) {
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

		Estadia estadia = new Estadia();

		estadia.setComprobante(UUIDGenerator.randomStringUUID());
		estadia.setVehiculo(vehicle);
		estadia.setCochera(CocheraController.getOne(idCochera));
		estadia.setLugar(lugar);
		estadia.setPrecioFinal(precioFinal);
		estadia.setAutoEnCochera(true);
		estadia.setFechaRetiro(fechaEgreso);

		try {
			new EstadiaData().insertOne(estadia);
			lugar.setOcupado(true);
			LugarController.updateOne(lugar);

			return new EstadiaData().getOneActiveByComprobante(estadia.getComprobante());
		} catch (Exception e) {
			lugar.setOcupado(false);
			LugarController.updateOne(lugar);
			throw new RuntimeException("Error al intentar guardar el ingreso en la base de datos");
		}
	}

	public static Estadia finalizeOne(Estadia d, Double price) {
		// TODO: implementar
		Estadia diario = new EstadiaData().finalizeOne(d, price);
		Lugar lugar = d.getLugar();
		lugar.setOcupado(false);
		LugarController.updateOne(lugar);
		return diario;
	}
}
