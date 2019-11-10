package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.EmpleadoController;
import domain.Empleado;

@WebServlet("/Empleados")
public class EmpleadoServlet extends HttpServlet {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmpleadoServlet() {
        super();
        
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ArrayList<Empleado> empleados = EmpleadoController.getAll();
    	
    	request.setAttribute("listaEmpleado", empleados);
    	request.getRequestDispatcher("WEB-INF/empleados.jsp").forward(request,response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Post");
    }

    
    
}
