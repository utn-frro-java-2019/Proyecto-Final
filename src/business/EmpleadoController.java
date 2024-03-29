package business;

import java.util.ArrayList;
import data.EmpleadoData;
import domain.*;

public class EmpleadoController {
	public static ArrayList<Empleado> getAll() {
		try {
			return new EmpleadoData().getAll();
		} catch (Exception e) {
			throw e;
		}
	}

	public static Empleado getOne(String dni) {
		try {
			return new EmpleadoData().getOne(dni);
		} catch (Exception e) {
			throw e;
		}
	}

	public static Empleado getOneByEmail(String email) {
		try {
			return new EmpleadoData().getOneByEmail(email);
		} catch (Exception e) {
			throw e;
		}
	}

	public static void deleteOne(String dni) {
		try {
			new EmpleadoData().deleteOne(dni);
		} catch (Exception e) {
			throw e;
		}
	}

	public static void insertOne(Empleado e) {
		try {
			new EmpleadoData().insertOne(e);
		} catch (Exception e1) {
			throw e1;
		}
	}

	public static void updateOne(Empleado e) {
		try {
			new EmpleadoData().updateOne(e);
		} catch (Exception e1) {
			throw e1;
		}
	}

	public static boolean authenticate(String email, String password) {
		try {
			Empleado e = getOneByEmail(email);
			if (e != null) {
				return e.getEmail().equals(email) && e.getPassword().equals(password);
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
}
