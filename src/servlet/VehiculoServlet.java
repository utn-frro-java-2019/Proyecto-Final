package servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/vehiculos/*")
public class VehiculoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public VehiculoServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		if(path.equals("/all")) {
		 	this.all(request,response);
		}
		else if(path.equals("/create")) {
			this.create(request,response);
		}
		else if(path.startsWith("/details")) {
			this.details(request,response);
		}
		else if(path.startsWith("/delete")) {
			this.delete(request,response);
		}
		else {
			this.error(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		if(path.equals("/add")) {
		 	this.add(request,response);
		}
		else if(path.startsWith("/edit")) {
			this.edit(request,response);
		}
		else {
			this.error(request,response);
		}
	}

	private void all(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	}

	private void details(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	}
	
	private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	request.getRequestDispatcher("/WEB-INF/vehiculo-create.jsp").forward(request,response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	request.getRequestDispatcher("/WEB-INF/diario-ingreso.jsp").forward(request,response);
	}
		
	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	}
	
	private void error(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	} 
    
}
