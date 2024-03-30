package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.DiarioController;
import business.EstadiaController;
import business.MultiplicadorEstadiaController;
import business.PrecioPorHoraController;
import business.VehiculoController;
import domain.Diario;
import domain.Estadia;
import domain.Vehiculo;
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
		} else if (path.startsWith("/get-precio-final")) {
			this.getPrecioFinal(request, response);
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
		if (path.equals("/ingresoSearch")) {
			this.ingresoSearch(request, response);
		} else if (path.equals("/ingreso")) {
			this.ingreso(request, response);
		} else {
			this.error(request, response);
		}
	}

	private void all(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			request.setAttribute("estadias",
					EstadiaController.getAllByCochera(request.getSession().getAttribute("idCochera").toString()));
		} catch (Exception e) {
			WebAlertViewer.showError(request, e);
		}
		request.getRequestDispatcher("/WEB-INF/estadias.jsp").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/estadia-create.jsp").forward(request, response);
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
		this.add(request, response);
	}

	private void getPrecioFinal(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String fechaDeIngreso = request.getParameter("fechaDeIngreso");
		String fechaDeEgreso = request.getParameter("fechaDeEgreso");
		request.setAttribute("fechaDeEgreso", fechaDeEgreso);

		String patente = request.getParameter("patente");
		Vehiculo vehiculo = VehiculoController.getOne(patente);

		if (vehiculo == null) {
			WebAlertViewer.showAlertMessage(request,
					"La patente solicitada no se corresponde con ningún vehículo en nuestra base de datos.", "danger");
		} else {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				java.util.Date egreso = sdf.parse(fechaDeEgreso);
				java.util.Date ingreso = sdf.parse(fechaDeIngreso);

				Long diff = egreso.getTime() - ingreso.getTime();
				Integer diffDays = Math.toIntExact((long) (diff / (1000 * 60 * 60 * 24)));
				Double precioPorHora = PrecioPorHoraController.getPrecioPorHora().getPrecio();
				Double porcentajeMultiplicadorTipoVehiculo = vehiculo.getTipo().getPorcentajeMultiplicador();
				Double porcentajeMultiplicadorEstadia = MultiplicadorEstadiaController.getOne(diffDays)
						.getPorcentajeMultiplicador();
				Double precioFinal = diffDays * 24 * precioPorHora * porcentajeMultiplicadorTipoVehiculo
						* porcentajeMultiplicadorEstadia;

				String precioMessage = "En concepto de un total de " + diffDays + " días "
						+ "para un vehículo de tipo "
						+ vehiculo.getTipo().getDescripcion() + " cuyo porcentaje multiplicador es de "
						+ porcentajeMultiplicadorTipoVehiculo + ". El descuento por estadía es de "
						+ porcentajeMultiplicadorEstadia + ".";

				request.setAttribute("precio", precioFinal);
				request.setAttribute("precioMessage", precioMessage);

			} catch (Exception e) {
				System.out.println(e.getMessage());
				WebAlertViewer.showError(request, e);
			}

			request.setAttribute("vehiculo", vehiculo);
		}
		this.add(request, response);
	}

	private void ingreso(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String patente = request.getParameter("patente");
		String fechaDeEgreso = request.getParameter("fechaDeEgreso");
		String precioFinal = request.getParameter("precio");
		Integer idCochera = Integer.parseInt(request.getSession().getAttribute("idCochera").toString());

		try {
			java.util.Date egreso = sdf.parse(fechaDeEgreso);

			Estadia estadia = EstadiaController.generateNew(patente, idCochera, Double.parseDouble(precioFinal),
					egreso);
			request.setAttribute("estadia", estadia);
			request.getRequestDispatcher("/WEB-INF/estadia-ingreso-comprobante.jsp").forward(request, response);

		} catch (Exception e) {
			WebAlertViewer.showError(request, e);
			this.add(request, response);
		}

	}

	private void error(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/errors/404-error.jsp").forward(request, response);
	}
}