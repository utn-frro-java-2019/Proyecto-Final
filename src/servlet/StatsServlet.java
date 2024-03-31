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

@WebServlet("/stats/*")
public class StatsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StatsServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getPathInfo();

		boolean hasPermissions = AccountHasPermissions.boss(request, response);
		if (!hasPermissions) {
			return;
		}
		if (path.startsWith("/ingresos")) {
			this.ingresos(request, response);
		} else {
			this.error(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean hasPermissions = AccountHasPermissions.boss(request, response);
		if (!hasPermissions) {
			return;
		}

		String path = request.getPathInfo();
		if (path.startsWith("/ingresos")) {
			this.ingresosPorCochera(request, response);
		} else {
			this.error(request, response);
		}

	}

	private void ingresos(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		ArrayList<Cochera> cocheras = CocheraController.getAll();
		request.setAttribute("cocheras", cocheras);

		request.getRequestDispatcher("/WEB-INF/stats-ingresos.jsp").forward(request, response);
	}

	private void ingresosPorCochera(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String idcochera = request.getParameter("idCochera");

		ArrayList<Cochera> cocheras = CocheraController.getAll();
		request.setAttribute("cocheras", cocheras);

		if (idcochera == null || idcochera.equals("")) {
			WebAlertViewer.showAlertMessage(request, "Debe seleccionar una cochera.");
		} else {
			try {
				ArrayList<Ingreso> ingresos = IngresoController.getAllByCochera(Integer.parseInt(idcochera));
				request.setAttribute("ingresos", ingresos);
				request.setAttribute("idCochera", idcochera);
			} catch (Exception e) {
				WebAlertViewer.showAlertMessage(request, "No se encontraron ingresos para la cochera seleccionada.");
			}
		}

		request.getRequestDispatcher("/WEB-INF/stats-ingresos.jsp").forward(request, response);
	}

	private void error(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/errors/404-error.jsp").forward(request, response);
	}
}
