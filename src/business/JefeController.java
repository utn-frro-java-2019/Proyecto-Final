package business;

import data.JefeData;
import domain.*;
import util.CustomExceptions.DatabaseAccessException;

public class JefeController {
	public static Jefe get() {
		try {
			return new JefeData().get();
		} catch (DatabaseAccessException e) {
			throw new DatabaseAccessException("Error al obtener al jefe", e);
		}
	}

	public static boolean authenticate(String email, String password) {
		try {
			Jefe j = new JefeData().get();
			if (j != null) {
				return j.getEmail().equals(email) && j.getPassword().equals(password);
			} else {
				return false;
			}
		} catch (DatabaseAccessException e) {
			throw new DatabaseAccessException("Error al autenticar al jefe", e);
		}
	}
}
