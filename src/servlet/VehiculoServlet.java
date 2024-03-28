package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.TipoVehiculoController;
import business.VehiculoController;
import domain.TipoVehiculo;
import domain.Vehiculo;
import util.AccountHasPermissions;
import util.WebAlertViewer;

@WebServlet("/vehiculos/*")
public class VehiculoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VehiculoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean hasPermissions = AccountHasPermissions.authenticated(request, response);
		if (!hasPermissions) {
			return;
		}

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean hasPermissions = AccountHasPermissions.authenticated(request, response);
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
		try {
			ArrayList<Vehiculo> vehiculos = VehiculoController.getAll();
			request.setAttribute("listaVehiculos", vehiculos);
		} catch (Exception e) {
			WebAlertViewer.showError(request, e);
		}
		request.getRequestDispatcher("/WEB-INF/vehiculos.jsp").forward(request, response);
	}

	private void details(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
			String path = request.getPathInfo();
			String patente = path.replace("/details/", "");
			Vehiculo vehiculo = VehiculoController.getOne(patente);
			request.setAttribute("vehiculo", vehiculo);
			request.setAttribute("tipos", TipoVehiculoController.getAll());

		} catch (Exception e) {
			WebAlertViewer.showError(request, e);
		}
		request.getRequestDispatcher("/WEB-INF/vehiculo-details.jsp").forward(request, response);
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			request.setAttribute("tipos", TipoVehiculoController.getAll());
		} catch (Exception e) {
			WebAlertViewer.showError(request, e);
		}
		request.getRequestDispatcher("/WEB-INF/vehiculo-create.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			String path = request.getPathInfo();
			String patente = path.replace("/delete/", "");
			VehiculoController.deleteOne(patente);
			WebAlertViewer.showAlertMessage(request, "El vehículo se ha eliminado correctamente.");
		} catch (Exception e) {
			WebAlertViewer.showError(request, e);
		}
		this.all(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			String patente = request.getParameter("patente");
			String modelo = request.getParameter("modelo");
			String descripcion = request.getParameter("desc");
			String marca = request.getParameter("marca");
			String propietario = request.getParameter("propietario");
			String telefonoContacto = request.getParameter("tel");
			TipoVehiculo tipo = new TipoVehiculo();
			tipo.setIdTipo(Integer.parseInt(request.getParameter("tipo")));
			Vehiculo v = new Vehiculo(patente, modelo, descripcion, marca, tipo, propietario, telefonoContacto);
			VehiculoController.insertOne(v);
			WebAlertViewer.showAlertMessage(request, "El vehículo se ha añadido correctamente.");
		} catch (Exception e) {
			WebAlertViewer.showError(request, e);
		}
		this.all(request, response);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO
	}

	private void error(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/errors/404-error.jsp").forward(request, response);
	}
}
