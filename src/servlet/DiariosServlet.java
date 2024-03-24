package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.DiarioController;
import business.VehiculoController;
import domain.Diario;
import domain.Vehiculo;
import util.AccountHasPermissions;
import util.WebAlertViewer;

@WebServlet("/diarios/*")
public class DiariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DiariosServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean hasPermissions = AccountHasPermissions.employee(request, response);
		if (!hasPermissions) {
			return;
		}

		String path = request.getPathInfo();
		if (path.equals("/all")) {
			this.all(request, response);
		} else if (path.equals("/ingreso")) {
			this.ingreso(request, response);
		} else if (path.startsWith("/salida")) {
			this.salida(request, response);
		} else if (path.startsWith("/delete")) {
			this.delete(request, response);
		} else {
			this.error(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean hasPermissions = AccountHasPermissions.employee(request, response);
		if (!hasPermissions) {
			return;
		}

		String path = request.getPathInfo();
		if (path.equals("/ingreso")) {
			this.diarioNew(request, response);
		} else if (path.equals("/salida")) {
			this.diarioFinish(request, response);
		} else if (path.equals("/edit")) {
			this.edit(request, response);
		} else if (path.equals("/ingresoSearch")) {
			this.ingresoSearch(request, response);
		} else if (path.equals("/salidaSearch")) {
			this.salidaSearch(request, response);
		} else {
			this.error(request, response);
		}
	}

	private void all(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO
	}

	private void ingreso(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/diario-ingreso.jsp").forward(request, response);
	}

	private void salida(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/diario-salida.jsp").forward(request, response);
	}

	private void ingresoSearch(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String patente = request.getParameter("patente");
		Vehiculo vehiculo = VehiculoController.getOne(patente);
		if (vehiculo == null) {
			WebAlertViewer.showAlertMessage(request,
					"La patente solicitada no se corresponde con ningún vehículo en nuestra base de datos.", "danger");
		} else {
			request.setAttribute("vehiculo", vehiculo);
		}
		this.ingreso(request, response);
	}

	private void diarioNew(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String patente = request.getParameter("patente");
		Integer idCochera = Integer.parseInt(request.getParameter("idCochera"));

		try {
			Diario diario = DiarioController.generateNew(patente, idCochera);
			request.setAttribute("diario", diario);
			request.getRequestDispatcher("/WEB-INF/diario-ingreso-comprobante.jsp").forward(request, response);

		} catch (Exception e) {
			WebAlertViewer.showError(request, e);
			this.ingreso(request, response);
		}
	}

	private void salidaSearch(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String patente = request.getParameter("comprobante");
		Diario diario = DiarioController.getOneActiveByComprobante(patente);
		if (diario == null) {
			WebAlertViewer.showAlertMessage(request,
					"El comprobante solicitado no se corresponde con ningún ingreso activo en nuestra base de datos.",
					"danger");
		} else {
			request.setAttribute("diario", diario);
		}
		this.salida(request, response);

	}

	private void diarioFinish(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
			String comprobante = request.getParameter("comprobante");
			Diario d = DiarioController.getOneActiveByComprobante(comprobante);

			Diario diario = DiarioController.finalizeOne(d);
			request.setAttribute("diario", diario);
			request.getRequestDispatcher("/WEB-INF/diario-salida-comprobante.jsp").forward(request, response);
		} catch (Exception e) {
			WebAlertViewer.showError(request, e);
			this.salida(request, response);
		}
	}

	private void error(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/errors/404-error.jsp").forward(request, response);
	}
}