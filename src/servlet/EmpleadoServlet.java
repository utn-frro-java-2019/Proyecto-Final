package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Empleado;
import util.WebAlertViewer;
import business.EmpleadoController;

@WebServlet("/empleados/*")
public class EmpleadoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public EmpleadoServlet() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		if(path.equals("/all")) {
		 	this.all(request,response);
		}
		else if(path.equals("/create")) {
			this.create(request,response);
		}
		else if(path.startsWith("/details")) {
			this.details(request,response);
		}
		else if(path.startsWith("/delete")) {
			this.delete(request,response);
		}
		else {
			this.error(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		if(path.equals("/add")) {
		 	this.add(request,response);
		}
		else if(path.startsWith("/edit")) {
			this.edit(request,response);
		}
		else {
			this.error(request,response);
		}
	}

	private void all(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	ArrayList<Empleado> empleados = EmpleadoController.getAll();
    	request.setAttribute("listaEmpleado", empleados);
    	request.getRequestDispatcher("/WEB-INF/empleados.jsp").forward(request,response);
	}

	private void details(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String path = request.getPathInfo();
		int dni = Integer.parseInt(path.replace("/details/", ""));
    	Empleado empleado = EmpleadoController.getOne(dni);
    	request.setAttribute("empleado", empleado);
    	request.getRequestDispatcher("/WEB-INF/empleado-details.jsp").forward(request,response);
	}
	
	private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	request.getRequestDispatcher("/WEB-INF/empleado-create.jsp").forward(request,response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String path = request.getPathInfo();
		int dni = Integer.parseInt(path.replace("/delete/", ""));
		EmpleadoController.deleteOne(dni);
		WebAlertViewer.showAlertMessage(request, "El Empleado se ha eliminado correctamente");
		this.all(request, response);
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		/*
		String dni = request.getParameter("Dni");
		String nombre = request.getParameter("Nombre");
		String apellido = request.getParameter("Apellido");
		String email = request.getParameter("Email");
		String telefono1 = request.getParameter("Tel1");
		String telefono2 = request.getParameter("Tel2");
		String usuario = request.getParameter("Usuario");
		String contraseña = request.getParameter("Contraseña");
		Empleado e = new Empleado(usuario,contraseña,dni,email,nombre,apellido,telefono1,telefono2,null,null);
		//Falta agregar controles para la cochera y el turno (por eso los nulls)
		EmpleadoController.insertOne(e);
		this.all(request, response);
		*/
		//TODO
	}
		
	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		/*
		String path = request.getPathInfo();
		String id = path.replace("/edit/", "");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String telefono1 = request.getParameter("tel1");
		String telefono2 = request.getParameter("tel2");
		String usuario = request.getParameter("usuario");
		String contraseña = request.getParameter("contraseña");
		Empleado e = new Empleado(usuario,contraseña,email,id,nombre,apellido,telefono1,telefono2,null,null);
		EmpleadoController.updateOne(e);
		this.all(request, response);
		*/
		//TODO
	}
	
	private void error(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/errors/404-error.jsp").forward(request,response);
	} 
    
}
