package business;

import java.util.ArrayList;

import data.JefeData;
import domain.*;

public class JefeController {
	public static Jefe getOne(int dni) {
		return new JefeData().getOne(dni);
	}

	public static ArrayList<Jefe> getAll() {
		return new JefeData().getAll();
	}
}
