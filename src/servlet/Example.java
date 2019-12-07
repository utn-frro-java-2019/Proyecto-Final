package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/example/*")
public class Example extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public Example() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch (request.getPathInfo()) {
		case "/all":
			this.all(request,response);
			break;
			
		case "/details":
			this.details(request,response);
			break;

		case "/create":
			this.create(request,response);
			break;
			
		case "/delete":
			this.delete(request,response);
			break;

		default:
			this.error(request,response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch (request.getPathInfo()) {
		case "/add":
			this.add(request,response);
			break;
			
		case "/edit":
			this.edit(request,response);
			break;

		default:
			this.error(request,response);
			break;
		}
	}

	private void all(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// Redirigir a la vista de "All" (Get All).
		// GET
	}

	private void details(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// Redirigir a la vista de "Detalles" (Get By Id).
		// GET
	}
	
	private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// Redirigir a la vista de "Create".
		// GET
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// Eliminar instancia.
		// GET
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
		// Redirigir a la vista de "Error".
	}
	
}