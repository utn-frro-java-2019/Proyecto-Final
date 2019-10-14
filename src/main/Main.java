package main;

import java.util.ArrayList;

import data.*;
import domain.*;

public class Main {

	public static void main(String[] args) {
		ArrayList<Cochera> cocheras = CocheraData.getAll();
		for(Cochera c: cocheras) {
			System.out.println("Cochera: "+c.getIdCochera()+" - "+c.getUbicacion()+" - "+c.getDescripcion());		
		}
		ArrayList<Jefe> jefes = JefeData.getAll();
		for(Jefe j: jefes) {
			System.out.println("Jefe: "+j.getDni()+" - "+j.getNombre()+" - "+j.getApellido());		
		}
		ArrayList<Empleado> empleados = EmpleadoData.getAll();
		for(Empleado e: empleados) {
			System.out.println("Empleado: "+e.getDni()+" - "+e.getNombre()+" - "+e.getApellido());		
		}
		ArrayList<Vehiculo> vehiculos = VehiculoData.getAll();
		for(Vehiculo v: vehiculos) {
			System.out.println("Vehiculo: "+v.getPatente()+" - "+v.getMarca()+" - "+v.getModelo());		
		}
		ArrayList<Turno> turnos = TurnoData.getAll();
		for(Turno t: turnos) {
			System.out.println("Turno: "+t.getCochera().getIdCochera()+" - "+t.getEmpleado().getApellido()+", "+t.getEmpleado().getNombre()+" - "+t.getTipoTurno().getIdTurno());		
		}
		ArrayList<Estadia> estadias = EstadiaData.getAll();
		for(Estadia es: estadias) {
			System.out.println("Estadia: "+es.getCochera().getIdCochera()+" - "+es.getVehiculo().getPatente()+" - "+es.getLugar().getNroLugar()+" - "+es.getFechaIngreso()+" - "+es.getEstado());		
		}
		ArrayList<Lugar> lugares = LugarData.getAll();
		for(Lugar l: lugares) {
			System.out.println("Lugar: "+l.getNroLugar()+" - "+l.getCochera().getIdCochera());		
		}
		ArrayList<TipoVehiculo> tiposVehiculos = TipoVehiculoData.getAll();
		for(TipoVehiculo tv: tiposVehiculos) {
			System.out.println("TipoVehiculo: "+tv.getIdTipo()+" - "+tv.getDescripcion());		
		}
		ArrayList<TipoTurno> tiposTurnos = TipoTurnoData.getAll();
		for(TipoTurno tt: tiposTurnos) {
			System.out.println("TipoTurno: "+tt.getIdTurno()+" - "+tt.getDescripcion());	
		}
		ArrayList<MultiplicadorEstadia> multiplicadoresEstadias = MultiplicadorEstadiaData.getAll();
		for(MultiplicadorEstadia me: multiplicadoresEstadias) {
			System.out.println("MultiplicadorEstadia: "+me.getMultiplicadorDesde()+" - "+me.getPorcentajeMultiplicador());
		}
		PrecioPorHora p = PrecioPorHoraData.getPrecio();
		System.out.println("PrecioPorHora: "+p.getPrecio());
	}

}
