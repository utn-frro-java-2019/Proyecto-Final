package business;

import java.util.ArrayList;

import data.CocheraData;
import domain.*;
import util.CustomExceptions.*;

public class CocheraController {
	public static ArrayList<Cochera> getAll() {
		try {
		return new CocheraData().getAll();
		}
		catch(DatabaseAccessException e){
			throw new DatabaseAccessException("Error al intentar obtener las cocheras en la base de datos", e);
		}
	}

	public static Cochera getOne(int idCochera) {
		try {
			return new CocheraData().getOne(idCochera);
		} catch (DatabaseAccessException e) {
			throw new DatabaseAccessException("Error al intentar obtener una cochera en la base de datos", e);
		}
	}

	public static void deleteOne(int idCochera) {
		try {
			new CocheraData().deleteOne(idCochera);
		} catch (DatabaseAccessException e) {
			throw new DatabaseAccessException("Error al intentar eliminar una cochera en la base de datos", e);
		}
	}

	@SuppressWarnings("unused")
	public static void insertOne(Cochera c) {
		try {
			Integer capacidad = c.getCapacidad();
			if (capacidad == null ) {
				throw new CapacidadNullException("La capacidad de la cochera no puede ser nula");
			}else if (capacidad < 1) {
				throw new CapacidadInvalidaException("La capacidad de la cochera no puede ser menor a 1");
			}
			else if (capacidad > 999) {
				throw new CapacidadInvalidaException("La capacidad de la cochera no puede ser mayor a 999");
			}

			Integer id = new CocheraData().insertOne(c);
			c.setIdCochera(id);

			for (int i = 1; i <= capacidad; i++) {
				Lugar l = new Lugar();
				l.setNroLugar(i);
				l.setOcupado(false);
				l.setCochera(c);
				LugarController.insertOne(l);
			}

		} catch (DatabaseAccessException e) {
			throw new DatabaseAccessException("Error al intentar actualizar el lugar en la cochera en la base de datos", e);
		}
	}

	public static void updateOne(Cochera c) {
		try {
			new CocheraData().updateOne(c);
		} catch (DatabaseAccessException e) {
			throw new DatabaseAccessException("Error al intentar actualizar la cochera en la base de datos", e);
		}
	}
}
