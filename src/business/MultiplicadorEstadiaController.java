package business;

import java.util.ArrayList;
import data.MultiplicadorEstadiaData;
import domain.*;

public class MultiplicadorEstadiaController {
	public static ArrayList<MultiplicadorEstadia> getAll() {
		return new MultiplicadorEstadiaData().getAll();
	}

	public static MultiplicadorEstadia getOne(int multiplicadorDesde) {
		return new MultiplicadorEstadiaData().getOne(multiplicadorDesde);
	}

	public static void deleteOne(int multiplicadorDesde) {
		new MultiplicadorEstadiaData().deleteOne(multiplicadorDesde);
	}

	public static void insertOne(MultiplicadorEstadia me) {
		new MultiplicadorEstadiaData().insertOne(me);
	}

	// public static void updateOne(MultiplicadorEstadia me){
	// new MultiplicadorEstadiaData().updateOne(me);
	// }
}
