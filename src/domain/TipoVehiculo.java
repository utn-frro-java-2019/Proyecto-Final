package domain;

public class TipoVehiculo {

	private int idTipo;
	private String descripcion;
	private Double porcentajeMultiplicador;
	
	public TipoVehiculo() {}
	
	public TipoVehiculo(int id, String d, double pm) {
		this.setIdTipo(id);
		this.setDescripcion(d);
		this.setPorcentajeMultiplicador(pm);
	}
	
	public TipoVehiculo(String d, double pm) {
		this.setDescripcion(d);
		this.setPorcentajeMultiplicador(pm);
	}
	
	public Double getPorcentajeMultiplicador() {
		return porcentajeMultiplicador;
	}
	public void setPorcentajeMultiplicador(Double porcentajeMultiplicador) {
		this.porcentajeMultiplicador = porcentajeMultiplicador;
	}
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
