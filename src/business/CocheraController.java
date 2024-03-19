package business;

import java.util.ArrayList;
import data.CocheraData;
import domain.*;

public class CocheraController {
	public static ArrayList<Cochera> getAll() {
		return new CocheraData().getAll();
	}

	public static Cochera getOne(int idCochera) {
		try {
			return new CocheraData().getOne(idCochera);
		} catch (Exception e) {
			throw e;
		}
	}

	public static void deleteOne(int idCochera) {
		try {
			new CocheraData().deleteOne(idCochera);
		} catch (Exception e) {
			throw e;
		}
	}

	public static void insertOne(Cochera c) {
		try {
			Integer capacidad = c.getCapacidad();
			if (capacidad == null || capacidad < 1) {
				throw new RuntimeException("La capacidad de la cochera no puede ser nula o menor a 1");
			} else if (capacidad > 999) {
				throw new RuntimeException("La capacidad de la cochera no puede ser mayor a 999");
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

		} catch (Exception e) {
			throw e;
		}
	}

	public static void updateOne(Cochera c) {
		try {
			new CocheraData().updateOne(c);
		} catch (Exception e) {
			throw e;
		}
	}
}
