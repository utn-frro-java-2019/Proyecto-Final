package business;

import java.util.ArrayList;
import data.LugarData;
import domain.*;

public class LugarController {
	public static ArrayList<Lugar> getAllFromCochera(int idCochera) {
		return new LugarData().getAllFromCochera(idCochera);
	}

	public static void updateOne(Lugar l) {
		new LugarData().updateOne(l);
	}
	
	public static void insertOne(Lugar l) {
		new LugarData().insertOne(l);
	}

	public static Lugar getOne(int nroLugar, int idCochera) {
		return new LugarData().getOne(nroLugar, idCochera);
	}

	public static Lugar getOneFree(int idCochera) {
		return new LugarData().getOneFree(idCochera);
	}
}
