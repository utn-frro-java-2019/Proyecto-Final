package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.EstadiaController;
import domain.Estadia;
import util.AccountHasPermissions;
import util.WebAlertViewer;

@WebServlet("/estadias/*")
public class EstadiaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EstadiaServlet() {
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
		} else if (path.equals("/add")) {
			this.add(request, response);
		} else if (path.startsWith("/comprobante-ingreso")) {
			this.comprobanteI(request, response);
		} else if (path.startsWith("/salida")) {
			this.salida(request, response);
		} else if (path.startsWith("/comprobante-salida")) {
			this.comprobanteS(request, response);
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
		ArrayList<Estadia> estadias = EstadiaController.getAll();
		request.setAttribute("listaEstadias", estadias);
		request.getRequestDispatcher("/WEB-INF/estadias.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/estadia-create.jsp").forward(request, response);
		// TODO
	}

	private void salida(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/diario-salida.jsp").forward(request, response);
		// TODO
	}

	private void ingresoSearch(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String idEstadia = request.getParameter("idEstadia");
		Estadia estadia = EstadiaController.getOne(Integer.parseInt(idEstadia));
		if (estadia == null) {
			WebAlertViewer.showAlertMessage(request,
					"La patente solicitada no se corresponde con ningún vehículo en nuestra base de datos.", "danger");
		} else {
			request.setAttribute("vehiculo", estadia);
		}
		this.add(request, response);
	}

	private void diarioNew(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/diario-ingreso-comprobante.jsp").forward(request, response);
		// TODO
	}

	private void salidaSearch(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		this.salida(request, response);
		// TODO
	}

	private void diarioFinish(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/diario-salida-comprobante.jsp").forward(request, response);
		// TODO
	}

	private void comprobanteI(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO
	}

	private void comprobanteS(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO
	}

	private void error(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/errors/404-error.jsp").forward(request, response);
	}
}