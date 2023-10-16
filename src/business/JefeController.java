package business;

import data.JefeData;
import domain.*;

public class JefeController {
	public static Jefe get() {
		try {
			return new JefeData().get();
		} catch (Exception e) {
			throw e;
		}
	}

	public static boolean authenticate(String email, String password) {
		try {
			Jefe j = new JefeData().get();
			return j.getEmail().equals(email) && j.getPassword().equals(password);
		} catch (Exception e) {
			throw e;
		}
	}
}
