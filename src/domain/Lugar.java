package domain;

public class Lugar {

	private int nroLugar;
	private Cochera cochera;
	private boolean ocupado;
	
	public int getNroLugar() {
		return nroLugar;
	}
	public void setNroLugar(int nroLugar) {
		this.nroLugar = nroLugar;
	}
	
	public Cochera getCochera() {
		return cochera;
	}
	public void setCochera(Cochera cochera) {
		this.cochera = cochera;
	}
	public boolean isOcupado() {
		return ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	

}
