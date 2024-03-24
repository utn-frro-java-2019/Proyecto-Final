package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Empleado;

import business.EmpleadoController;

import util.SessionManager;
import util.WebAlertViewer;

@WebServlet("/login-empleado")

public class LoginEmpleadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginEmpleadosServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/login-employee.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		try {
			if (EmpleadoController.authenticate(email, password)) {
				Empleado empleado = EmpleadoController.getOneByEmail(email);
				SessionManager.SetAccountSession(request, empleado.getEmail(), empleado.getNombre(),
						empleado.getApellido(), "empleado");
				SessionManager.SetExtraData(request, "cochera", empleado.getCochera().getNombre());
				SessionManager.SetExtraData(request, "idCochera", String.valueOf(empleado.getCochera().getIdCochera()));
				SessionManager.SetExtraData(request, "turno", empleado.getTurno().getDescripcion());
				SessionManager.SetExtraData(request, "idTurno", String.valueOf(empleado.getTurno().getIdTurno()));
				response.sendRedirect(request.getContextPath() + "/home");
			} else {
				WebAlertViewer.showAlertMessage(request, "Email o contraseña incorrectos", "danger");
				request.getRequestDispatcher("/WEB-INF/login-employee.jsp").forward(request, response);
			}
		} catch (Exception e) {
			WebAlertViewer.showError(request, e);
			request.getRequestDispatcher("/WEB-INF/login-employee.jsp").forward(request, response);
		}
	}
}
