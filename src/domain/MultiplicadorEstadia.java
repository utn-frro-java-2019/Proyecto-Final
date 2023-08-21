package domain;

public class MultiplicadorEstadia {
	private int multiplicadorDesde;
	private double porcentajeMultiplicador;

	public MultiplicadorEstadia() {
	}

	public MultiplicadorEstadia(int md, double pm) {
		this.setMultiplicadorDesde(md);
		this.setPorcentajeMultiplicador(pm);
	}

	public int getMultiplicadorDesde() {
		return multiplicadorDesde;
	}

	public void setMultiplicadorDesde(int multiplicadorDesde) {
		this.multiplicadorDesde = multiplicadorDesde;
	}

	public Double getPorcentajeMultiplicador() {
		return porcentajeMultiplicador;
	}

	public void setPorcentajeMultiplicador(double porcentajeMultiplicador) {
		this.porcentajeMultiplicador = porcentajeMultiplicador;
	}
}
