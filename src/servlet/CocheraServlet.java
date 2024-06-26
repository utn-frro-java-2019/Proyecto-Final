package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.CocheraController;
import business.IngresoController;
import domain.Cochera;
import domain.Ingreso;
import util.AccountHasPermissions;
import util.WebAlertViewer;

@WebServlet("/cocheras/*")
public class CocheraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CocheraServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getPathInfo();

		if (path.startsWith("/estado")) {
			boolean hasPermissions = AccountHasPermissions.authenticated(request, response);
			if (!hasPermissions) {
				return;
			}
			this.estado(request, response);
		} else {
			boolean hasPermissions = AccountHasPermissions.boss(request, response);
			if (!hasPermissions) {
				return;
			}
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
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean hasPermissions = AccountHasPermissions.boss(request, response);
		if (!hasPermissions) {
			return;
		}

		String path = request.getPathInfo();
		if (path.equals("/add")) {
			this.add(request, response);
		} else if (path.startsWith("/edit")) {
			this.edit(request, response);
		} else {
			this.error(request, response);
		}
	}

	private void all(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ArrayList<Cochera> cocheras = CocheraController.getAll();
		request.setAttribute("listaCochera", cocheras);
		request.getRequestDispatcher("/WEB-INF/cocheras.jsp").forward(request, response);
	}

	private void details(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String path = request.getPathInfo();
		int id = Integer.parseInt(path.replace("/details/", ""));
		Cochera cochera = CocheraController.getOne(id);
		request.setAttribute("cochera", cochera);
		request.getRequestDispatcher("/WEB-INF/cochera-details.jsp").forward(request, response);
	}

	private void estado(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String path = request.getPathInfo();
		int id = Integer.parseInt(path.replace("/estado/", ""));
		Cochera cochera = CocheraController.getOne(id);
		ArrayList<Ingreso> ingresos = IngresoController.getActivosByCochera(id);
		request.setAttribute("cochera", cochera);
		request.setAttribute("ingresos", ingresos);
		request.getRequestDispatcher("/WEB-INF/lugares.jsp").forward(request, response);
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/cochera-create.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			String path = request.getPathInfo();
			int id = Integer.parseInt(path.replace("/delete/", ""));
			CocheraController.deleteOne(id);
			WebAlertViewer.showAlertMessage(request, "La cochera se ha eliminado correctamente.");
		} catch (Exception e) {
			WebAlertViewer.showError(request, e);
		}

		this.all(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String nombre = request.getParameter("nombre");
		String ubicacion = request.getParameter("ubicacion");
		String descripcion = request.getParameter("descripcion");
		int capacidad = Integer.parseInt(request.getParameter("capacidad"));
		Cochera c = new Cochera(nombre, ubicacion, descripcion, capacidad);
		CocheraController.insertOne(c);
		WebAlertViewer.showAlertMessage(request, "La cochera se ha añadido correctamente.");
		this.all(request, response);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String path = request.getPathInfo();
		int id = Integer.parseInt(path.replace("/edit/", ""));
		String nombre = request.getParameter("nombre");
		String ubicacion = request.getParameter("ubicacion");
		String descripcion = request.getParameter("descripcion");
		int capacidad = 1;
		Cochera c = new Cochera(id, nombre, ubicacion, descripcion, capacidad);
		CocheraController.updateOne(c);
		WebAlertViewer.showAlertMessage(request, "La cochera se ha modificado correctamente.");
		this.all(request, response);
	}

	private void error(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/errors/404-error.jsp").forward(request, response);
	}
}
