package business;

import java.util.ArrayList;
import data.LugarData;
import domain.*;
import util.CustomExceptions.DatabaseAccessException;

public class LugarController {
	public static ArrayList<Lugar> getAllFromCochera(int idCochera) {
		try {
		return new LugarData().getAllFromCochera(idCochera);
		}
		catch(DatabaseAccessException e) {
			throw new DatabaseAccessException("Error al intentar obtener los lugares en la cochera en la base de datos", e);
		}
	}

	public static void updateOne(Lugar l) {
		try {
		new LugarData().updateOne(l);
		}
		catch(DatabaseAccessException e){
			throw new DatabaseAccessException("Error al intentar modificar el lugar en la cochera en la base de datos", e);
		}
	}
	
	public static void insertOne(Lugar l) {
		try {
		new LugarData().insertOne(l);
		}
		catch(DatabaseAccessException e){
			throw new DatabaseAccessException("Error al intentar insertar el lugar en la cochera en la base de datos", e);
		}
	}

	public static Lugar getOne(int nroLugar, int idCochera) {
		try {
		return new LugarData().getOne(nroLugar, idCochera);
		}
		catch(DatabaseAccessException e){
			throw new DatabaseAccessException("Error al intentar obtener un lugar en la cochera en la base de datos", e);
		}
	}

	public static Lugar getOneFree(int idCochera) {
		try {
		return new LugarData().getOneFree(idCochera);
		}
		catch(DatabaseAccessException e){
			throw new DatabaseAccessException("Error al intentar obtener un lugar libre en la cochera en la base de datos", e);
		}
	}
}
