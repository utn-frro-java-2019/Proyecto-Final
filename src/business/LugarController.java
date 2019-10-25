package business;

import java.util.ArrayList;

import data.LugarData;
import domain.*;

public class LugarController {
	public static Lugar getOne(int idEstadia) {
		return new LugarData().getOne(idEstadia);
	}

	public static ArrayList<Lugar> getAll() {
		return new LugarData().getAll();
	}
}
