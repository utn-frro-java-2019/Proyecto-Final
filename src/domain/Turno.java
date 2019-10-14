package domain;

public class Turno {
	private Cochera cochera;
	private Empleado empleado;
	private TipoTurno tipoTurno;
	
	public Cochera getCochera() {
		return cochera;
	}
	public void setCochera(Cochera cochera) {
		this.cochera = cochera;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public TipoTurno getTipoTurno() {
		return tipoTurno;
	}
	public void setTipoTurno(TipoTurno tipoTurno) {
		this.tipoTurno = tipoTurno;
	}
	
	
}
