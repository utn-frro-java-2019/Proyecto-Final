package business;

import java.util.ArrayList;
import data.EstadiaData;
import domain.*;

public class EstadiaController extends IngresoController {
	public static Estadia getOne(int idIngreso) {
		return new EstadiaData().getOne(idIngreso);
	}

	public static ArrayList<Estadia> getAll() {
		return new EstadiaData().getAll();
	}
}
