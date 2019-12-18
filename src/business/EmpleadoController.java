package business;
import java.util.ArrayList;

import data.EmpleadoData;
import domain.*;

public class EmpleadoController {
	
	public static ArrayList<Empleado> getAll() {
		return new EmpleadoData().getAll();
	}

	public static Empleado getOne(int dni) {
		return new EmpleadoData().getOne(dni);
	}
	
	public static void deleteOne(int dni){
		new EmpleadoData().deleteOne(dni);
	}
	
	public static void insertOne(Empleado e){
		new EmpleadoData().insertOne(e);
	}
	
	public static void updateOne(Empleado e){
		new EmpleadoData().updateOne(e);
	}
}
