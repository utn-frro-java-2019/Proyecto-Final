package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.EmpleadoController;
import domain.Empleado;


@WebServlet("/user/*")
public class UsuarioServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       

    public UsuarioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		if(path.equals("/profile")) {
		 	this.profile(request,response);
		}
		else {
			this.error(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		if(path.startsWith("/editProfile")) {
			this.editProfile(request,response);
		}
		else if(path.startsWith("/editPassword")) {
			this.editPassword(request,response);
		}
		else {
			this.error(request,response);
		}
	}
	
	private void profile(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	Empleado usuario = EmpleadoController.getOne(11111111);
    	// TODO
    	request.setAttribute("usuario", usuario);
    	request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request,response);
	}
	
	private void editProfile(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	}
		
	private void editPassword(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	}
	
	private void error(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/errors/404-error.jsp").forward(request,response);
	}

}
