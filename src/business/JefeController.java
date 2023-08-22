package business;

import data.JefeData;
import domain.*;

public class JefeController {
	public static Jefe get() {
		return new JefeData().get();
	}

	public static boolean authenticate(String email, String password) {
		Jefe j = new JefeData().get();
		return j.getEmail().equals(email) && j.getPassword().equals(password);
	}
}
