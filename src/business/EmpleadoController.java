package business;

import java.util.ArrayList;
import data.EmpleadoData;
import domain.*;

public class EmpleadoController {
	public static ArrayList<Empleado> getAll() {
		return new EmpleadoData().getAll();
	}

	public static Empleado getOne(String dni) {
		return new EmpleadoData().getOne(dni);
	}

	public static void deleteOne(String dni) {
		new EmpleadoData().deleteOne(dni);
	}

	public static void insertOne(Empleado e) {
		try {
			new EmpleadoData().insertOne(e);
		} catch (Exception e1) {
			throw e1;
		}
	}

	public static void updateOne(Empleado e) {
		new EmpleadoData().updateOne(e);
	}
}
