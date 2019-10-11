package main;

import java.util.ArrayList;

import data.*;
import domain.*;

public class Main {

	public static void main(String[] args) {
		ArrayList<Cochera> cocheras = cocheraData.getAll();
		for(Cochera c: cocheras) {
			System.out.println(c.getIdCochera()+" - "+c.getUbicacion()+" - "+c.getDescripcion());		
		}
		ArrayList<Empleado> empleados = empleadoData.getAll();
		for(Empleado e: empleados) {
			System.out.println(e.getDni()+" - "+e.getNombre()+" - "+e.getApellido());		
		}
		ArrayList<Vehiculo> vehiculos = vehiculoData.getAll();
		for(Vehiculo v: vehiculos) {
			System.out.println(v.getPatente()+" - "+v.getMarca()+" - "+v.getModelo());		
		}
	}

}
