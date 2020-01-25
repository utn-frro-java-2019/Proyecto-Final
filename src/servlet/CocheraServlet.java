package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Cochera;
import util.WebAlertViewer;
import business.CocheraController;

@WebServlet("/cocheras/*")
public class CocheraServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public CocheraServlet() {
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
    	ArrayList<Cochera> cocheras = CocheraController.getAll();
    	request.setAttribute("listaCochera", cocheras);
    	request.getRequestDispatcher("/WEB-INF/cocheras.jsp").forward(request,response);
	}

	private void details(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String path = request.getPathInfo();
		int id = Integer.parseInt(path.replace("/details/", ""));
    	Cochera cochera = CocheraController.getOne(id);
    	request.setAttribute("cochera", cochera);
    	request.getRequestDispatcher("/WEB-INF/cochera-details.jsp").forward(request,response);
	}
	
	private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	request.getRequestDispatcher("/WEB-INF/cochera-create.jsp").forward(request,response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String path = request.getPathInfo();
		int id = Integer.parseInt(path.replace("/delete/", ""));
		CocheraController.deleteOne(id);
		WebAlertViewer.showAlertMessage(request, "La cochera se ha eliminado correctamente");
		this.all(request, response);
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String ubicacion = request.getParameter("ubicacion");
		String descripcion = request.getParameter("descripcion");
		int capacidad = Integer.parseInt(request.getParameter("capacidad"));
		Cochera c = new Cochera(ubicacion, descripcion, capacidad);
		CocheraController.insertOne(c);
		WebAlertViewer.showAlertMessage(request, "La cochera se ha añadido correctamente");
		this.all(request, response);
	}
		
	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String path = request.getPathInfo();
		int id = Integer.parseInt(path.replace("/edit/", ""));
		String ubicacion = request.getParameter("ubicacion");
		String descripcion = request.getParameter("descripcion");
		int capacidad = Integer.parseInt(request.getParameter("capacidad"));
		Cochera c = new Cochera(id, ubicacion, descripcion, capacidad);
		CocheraController.updateOne(c);
		WebAlertViewer.showAlertMessage(request, "La cochera se ha modificado correctamente");
		this.all(request, response);
	}
	
	private void error(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/errors/404-error.jsp").forward(request,response);
	} 
    
}
