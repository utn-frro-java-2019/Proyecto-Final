package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.AccountHasPermissions;

@WebServlet("/home")

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean hasPermissions = AccountHasPermissions.authenticated(request, response);
		if (!hasPermissions) {
			return;
		}

		request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
	}
}
