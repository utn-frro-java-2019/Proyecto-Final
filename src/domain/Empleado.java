package domain;

public class Empleado {
	private String usuario;
	private String password;
	private String email;
	private String dni;
	private String nombre;
	private String apellido;
	private String telefono1;
	private String telefono2;
	private Cochera cochera;
	private Turno turno;

	public Empleado() {
	};

	public Empleado(String u, String pass, String dni, String em, String n, String a, String tel1, String tel2,
			Cochera co, Turno tu) {
		this.usuario = u;
		this.password = pass;
		this.email = em;
		this.dni = dni;
		this.nombre = n;
		this.apellido = a;
		this.telefono1 = tel1;
		this.telefono2 = tel2;
		this.cochera = co;
		this.turno = tu;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
