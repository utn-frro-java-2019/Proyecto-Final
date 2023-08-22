package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.JefeController;
import util.WebAlertViewer;

@WebServlet("/login-jefe")

public class LoginJefeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginJefeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/login-boss.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (JefeController.authenticate(email, password)) {
			request.getSession().setAttribute("email", email);
			request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
		} else {
			WebAlertViewer.showAlertMessage(request, "Email o contraseña incorrectos", "danger");
			request.getRequestDispatcher("/WEB-INF/login-boss.jsp").forward(request, response);
		}
	}
}
