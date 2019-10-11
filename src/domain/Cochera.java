package domain;

import java.util.ArrayList;

public class Cochera {

	private int idCochera;
	private String ubicacion;
	private String descripcion;
	private ArrayList<Empleado> empleados;
	
	public int getIdCochera() {
		return idCochera;
	}
	public void setIdCochera(int idCochera) {
		this.idCochera = idCochera;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	
}
