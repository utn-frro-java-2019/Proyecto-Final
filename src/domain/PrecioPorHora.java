package domain;

public class PrecioPorHora {

	private double precio;
	private int idPrecio;

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public int getIdPrecio() {
		return idPrecio;
	}

	public void setIdPrecio(int idPrecio) {
		this.idPrecio = idPrecio;
	}

	public PrecioPorHora(double precio, int idPrecio) {
		super();
		this.precio = precio;
		this.idPrecio = idPrecio;
	}

	public PrecioPorHora() {
		super();
	}
	
}
