package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Empleado;
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
		else if(path.equals("/edit")) {
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
		this.all(request, response);
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// Crear nueva instancia.
		// POST
	}
		
	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// Editar instancia.
		// POST
	}
	
	private void error(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/errors/404-error.jsp").forward(request,response);
	} 
    
}
