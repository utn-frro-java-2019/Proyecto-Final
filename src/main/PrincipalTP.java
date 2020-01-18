package main;

import java.util.ArrayList;

import business.*;
import domain.*;

public class PrincipalTP {

	public static void main(String[] args) {
		ArrayList<Cochera> cocheras = CocheraController.getAll();
		for(Cochera c: cocheras) {
			System.out.println("Cochera: "+c.getIdCochera()+" - "+c.getUbicacion()+" - "+c.getDescripcion());		
		}
		ArrayList<Jefe> jefes = JefeController.getAll();
		for(Jefe j: jefes) {
			System.out.println("Jefe: "+j.getDni()+" - "+j.getNombre()+" - "+j.getApellido());		
		}
		ArrayList<Empleado> empleados = EmpleadoController.getAll();
		for(Empleado e: empleados) {
			System.out.println("Empleado: "+e.getDni()+" - "+e.getNombre()+" - "+e.getApellido()+" - "+e.getCochera().getIdCochera()+" - "+e.getTurno().getDescripcion());		
		}
		ArrayList<Vehiculo> vehiculos = VehiculoController.getAll();
		for(Vehiculo v: vehiculos) {
			System.out.println("Vehiculo: "+v.getPatente()+" - "+v.getMarca()+" - "+v.getModelo());		
		}
		ArrayList<Turno> turnos = TurnoController.getAll();
		for(Turno t: turnos) {
			System.out.println("Turno: "+t.getIdTurno()+" - "+t.getDescripcion()+" - "+t.getHoraInicio()+" - "+t.getHoraFin());		
		}
		ArrayList<Estadia> estadias = EstadiaController.getAll();
		for(Estadia es: estadias) {
			System.out.println("Estadia: "+es.getCochera().getIdCochera()+" - "+es.getVehiculo().getPatente()+" - "+es.getLugar().getNroLugar()+" - "+es.getFechaIngreso()+" - "+es.getEstado());		
		}
		ArrayList<Lugar> lugares = LugarController.getAll();
		for(Lugar l: lugares) {
			System.out.println("Lugar: "+l.getNroLugar()+" - "+l.getCochera().getIdCochera());		
		}
		ArrayList<TipoVehiculo> tiposVehiculos = TipoVehiculoController.getAll();
		for(TipoVehiculo tv: tiposVehiculos) {
			System.out.println("TipoVehiculo: "+tv.getIdTipo()+" - "+tv.getDescripcion()+" - "+tv.getPorcentajeMultiplicador());		
		}
		ArrayList<MultiplicadorEstadia> multiplicadoresEstadias = MultiplicadorEstadiaController.getAll();
		for(MultiplicadorEstadia me: multiplicadoresEstadias) {
			System.out.println("MultiplicadorEstadia: "+me.getMultiplicadorDesde()+" - "+me.getPorcentajeMultiplicador());
		}
		PrecioPorHora p = PrecioPorHoraController.getPrecioPorHora();
		System.out.println("PrecioPorHora: "+p.getPrecio());
		
	}

}
