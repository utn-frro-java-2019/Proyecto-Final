package business;

import java.util.ArrayList;
import data.DiarioData;
import domain.*;

public class DiarioController extends IngresoController {
	public static Diario getOne(int idIngreso) {
		return new DiarioData().getOne(idIngreso);
	}

	public static ArrayList<Diario> getAll() {
		return new DiarioData().getAll();
	}
}
