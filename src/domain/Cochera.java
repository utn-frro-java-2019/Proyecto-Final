package domain;

public class Cochera {
	private int idCochera;
	private String nombre;
	private String ubicacion;
	private String descripcion;
	private int capacidad;

	public Cochera() {
	}

	public Cochera(int id, String nombre, String ubicacion, String descripcion, int capacidad) {
		this.setIdCochera(id);
		this.setNombre(nombre);
		this.setUbicacion(ubicacion);
		this.setDescripcion(descripcion);
		this.setCapacidad(capacidad);
	}

	public Cochera(String nombre, String ubicacion, String descripcion, int capacidad) {
		this.setNombre(nombre);
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
