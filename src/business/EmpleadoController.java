package business;

import java.util.ArrayList;

import data.EmpleadoData;
import domain.*;

public class EmpleadoController {

	public static Empleado getOne(int dni) {
		return new EmpleadoData().getOne(dni);
	}

	public static ArrayList<Empleado> getAll() {
		return new EmpleadoData().getAll();
	}
}
