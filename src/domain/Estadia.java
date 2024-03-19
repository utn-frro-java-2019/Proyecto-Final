package domain;

import java.util.Date;

public class Estadia {
	private Integer idEstadia;
	private String estado;
	private Cochera cochera;
	private Lugar lugar;
	private Vehiculo vehiculo;
	private Date fechaIngreso;
	private Date fechaRetiro;
	private Double precioFinal;
	private Boolean autoEnCochera;

	public Cochera getCochera() {
		return cochera;
	}

	public void setCochera(Cochera cochera) {
		this.cochera = cochera;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaRetiro() {
		return fechaRetiro;
	}

	public void setFechaRetiro(Date fechaRetiro) {
		this.fechaRetiro = fechaRetiro;
	}

	public Double getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(Double precioFinal) {
		this.precioFinal = precioFinal;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getIdEstadia() {
		return idEstadia;
	}

	public void setIdEstadia(Integer idEstadia) {
		this.idEstadia = idEstadia;
	}

	public Boolean getAutoEnCochera() {
		return autoEnCochera;
	}

	public void setAutoEnCochera(Boolean autoEnCochera) {
		this.autoEnCochera = autoEnCochera;
	}
	
}
