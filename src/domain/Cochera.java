package domain;

public class Cochera {

	private int idCochera;
	private String ubicacion;
	private String descripcion;
	private int capacidad;
	
	public Cochera() {

	}
	
	public Cochera(int id, String ubicacion, String descripcion, int capacidad) {
		this.setIdCochera(id);
		this.setUbicacion(ubicacion);
		this.setDescripcion(descripcion);
		this.setCapacidad(capacidad);
	}
	
	public Cochera(String ubicacion, String descripcion, int capacidad) {
		this.setUbicacion(ubicacion);
		this.setDescripcion(descripcion);
		this.setCapacidad(capacidad);
	}
	
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
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
	
}
