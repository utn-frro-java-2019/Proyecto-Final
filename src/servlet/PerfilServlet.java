package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.EmpleadoController;
import business.JefeController;
import domain.Empleado;
import domain.Jefe;
import util.AccountHasPermissions;

@WebServlet("/perfil")
public class PerfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PerfilServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean hasPermissions = AccountHasPermissions.authenticated(request, response);
		if (!hasPermissions) {
			return;
		}

		String accountType = (String) request.getSession().getAttribute("accountType");

		if (accountType.equals("jefe")) {
			Jefe usuario = JefeController.get();
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher("/WEB-INF/perfil-jefe.jsp").forward(request, response);
		} else if (accountType.equals("empleado")) {
			Empleado usuario = EmpleadoController.getOneByEmail(request.getSession().getAttribute("email").toString());
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher("/WEB-INF/perfil-empleado.jsp").forward(request, response);
		}

	}
}
