package domain;


public class Empleado {

	private String usuario;
	private String contrase�a;
	private String email;
	private String dni;
	private String nombre;
	private String apellido;
	private String telefono1;
	private String telefono2;
	private Cochera cochera;
	private Turno turno;
	
	public Empleado() {};
	
	public Empleado(String usuario, String contrase�a, String email, String dni, String nombre, String apellido,
			String telefono1, String telefono2, Cochera cochera, Turno turno) {
		super();
		this.usuario = usuario;
		this.contrase�a = contrase�a;
		this.email = email;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.cochera = cochera;
		this.turno = turno;
	}
	
	public Empleado(String usuario, String contrase�a, String email, String nombre, String apellido, String telefono1,
			String telefono2, Cochera cochera, Turno turno) {
		super();
		this.usuario = usuario;
		this.contrase�a = contrase�a;
		this.email = email;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.cochera = cochera;
		this.turno = turno;
	}



	public Cochera getCochera() {
		return cochera;
	}
	public void setCochera(Cochera cochera) {
		this.cochera = cochera;
	}
	public Turno getTurno() {
		return turno;
	}
	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono1() {
		return telefono1;
	}
	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}
	public String getTelefono2() {
		return telefono2;
	}
	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}
	
}
