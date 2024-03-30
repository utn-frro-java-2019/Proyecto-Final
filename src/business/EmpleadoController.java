package business;

import java.util.ArrayList;
import data.EmpleadoData;
import domain.*;
import util.CustomExceptions.*;

public class EmpleadoController {
	public static ArrayList<Empleado> getAll() {
		try {
			return new EmpleadoData().getAll();
		} catch (DatabaseAccessException e) {
			throw new DatabaseAccessException("Error al intentar obtener los empleados en la base de datos", e);
		}
	}

	public static Empleado getOne(String dni) {
		try {
			return new EmpleadoData().getOne(dni);
		} catch (DatabaseAccessException e) {
			throw new DatabaseAccessException("Error al intentar obtener un empleado por dni en la base de datos", e);
		}
	}

	public static Empleado getOneByEmail(String email) {
		try {
			return new EmpleadoData().getOneByEmail(email);
		} catch (DatabaseAccessException e) {
			throw new DatabaseAccessException("Error al intentar obtener un empleado por mail en la base de datos", e);
		}
	}

	public static void deleteOne(String dni) {
		try {
			new EmpleadoData().deleteOne(dni);
		} catch (DatabaseAccessException e) {
			throw new DatabaseAccessException("Error al intentar eliminar un empleado en la base de datos", e);
		}
	}

	public static void insertOne(Empleado emp) {
		try {
			new EmpleadoData().insertOne(emp);
		} catch (DatabaseAccessException e) {
			throw new DatabaseAccessException("Error al intentar insertar un empleado en la base de datos", e);
		}
	}

	public static void updateOne(Empleado emp) {
		try {
			new EmpleadoData().updateOne(emp);
		} catch (DatabaseAccessException e) {
			throw new DatabaseAccessException("Error al intentar modificar un empleado en la base de datos", e);
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
		} catch (DatabaseAccessException e) {
			throw new DatabaseAccessException("Error al autenticar al empleado", e);
		}
	}
}
