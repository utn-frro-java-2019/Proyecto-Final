package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/example/*")
public class _Example extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public _Example() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		if (path.equals("/all")) {
			this.all(request, response);
		} else if (path.equals("/create")) {
			this.create(request, response);
		} else if (path.startsWith("/details")) {
			this.details(request, response);
		} else if (path.startsWith("/delete")) {
			this.delete(request, response);
		} else {
			this.error(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		if (path.equals("/add")) {
			this.add(request, response);
		} else if (path.equals("/edit")) {
			this.edit(request, response);
		} else {
			this.error(request, response);
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