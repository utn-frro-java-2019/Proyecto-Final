package business;

import java.util.ArrayList;

import data.MultiplicadorEstadiaData;
import domain.*;

public class MultiplicadorEstadiaController {
	public static MultiplicadorEstadia getOne(int idEstadia) {
		return new MultiplicadorEstadiaData().getOne(idEstadia);
	}

	public static ArrayList<MultiplicadorEstadia> getAll() {
		return new MultiplicadorEstadiaData().getAll();
	}
}
