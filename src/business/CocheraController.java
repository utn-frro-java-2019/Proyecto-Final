package business;

import java.util.ArrayList;
import data.CocheraData;
import domain.*;

public class CocheraController {
	public static ArrayList<Cochera> getAll() {
		return new CocheraData().getAll();
	}

	public static Cochera getOne(int idCochera) {
		try {
			return new CocheraData().getOne(idCochera);
		} catch (Exception e) {
			throw e;
		}
	}

	public static void deleteOne(int idCochera) {
		try {
			new CocheraData().deleteOne(idCochera);
		} catch (Exception e) {
			throw e;
		}
	}

	public static void insertOne(Cochera c) {
		try {
			new CocheraData().insertOne(c);
		} catch (Exception e) {
			throw e;
		}
	}

	public static void updateOne(Cochera c) {
		try {
			new CocheraData().updateOne(c);
		} catch (Exception e) {
			throw e;
		}
	}
}
