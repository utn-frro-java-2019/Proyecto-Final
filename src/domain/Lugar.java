package domain;

public class Lugar {

	private int nroLugar;
	private String tipoVehiculoPermitido;
	private boolean ocupado;
	
	public int getNroLugar() {
		return nroLugar;
	}
	public void setNroLugar(int nroLugar) {
		this.nroLugar = nroLugar;
	}
	public String getTipoVehiculoPermitido() {
		return tipoVehiculoPermitido;
	}
	public void setTipoVehiculoPermitido(String tipoVehiculoPermitido) {
		this.tipoVehiculoPermitido = tipoVehiculoPermitido;
	}
	public boolean isOcupado() {
		return ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	

}
