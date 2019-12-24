package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.MultiplicadorEstadiaController;
import business.TipoVehiculoController;
import domain.MultiplicadorEstadia;
import domain.TipoVehiculo;

@WebServlet("/configuration/*")
public class ConfigurationServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public ConfigurationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		if(path.equals("/config")) {
		 	this.config(request,response);
		}
		else if(path.equals("/createME")) {
			this.createME(request,response);
		}
		else if(path.startsWith("/deleteME")) {
			this.deleteME(request,response);
		}
		else if(path.equals("/createTV")) {
			this.createTV(request,response);
		}
		else if(path.startsWith("/detailsTV")) {
			this.detailsTV(request,response);
		}
		else if(path.startsWith("/deleteTV")) {
			this.deleteTV(request,response);
		}
		else {
			this.error(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		if(path.equals("/addME")) {
		 	this.addME(request,response);
		}
		else if(path.equals("/addTV")) {
		 	this.addTV(request,response);
		}
		else if(path.startsWith("/editTV")) {
			this.editTV(request,response);
		}
		else {
			this.error(request,response);
		}
	}

	private void config(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
    	ArrayList<MultiplicadorEstadia> multiplicadoresEstadia = MultiplicadorEstadiaController.getAll();
    	request.setAttribute("listaMultiplicadoresEstadia", multiplicadoresEstadia);
    	
    	ArrayList<TipoVehiculo> tiposVehiculos = TipoVehiculoController.getAll();
    	request.setAttribute("listaTiposVehiculos", tiposVehiculos);
    	
		request.getRequestDispatcher("/WEB-INF/configurations.jsp").forward(request,response);
	}

	// ------------------------------------------------------------------------------------------
	// Multiplicador Estadía --------------------------------------------------------------------
	
	private void createME(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO
	}
	
	private void deleteME(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO
	}
	
	private void addME(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO
	}
	
	// ------------------------------------------------------------------------------------------
	// Tipo de Vehículo -------------------------------------------------------------------------
	
	private void createTV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO
	}
	
	private void deleteTV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO
	}
	
	private void detailsTV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO
	}
	
	private void addTV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO
	}
	
	private void editTV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO
	}
	
	// ------------------------------------------------------------------------------------------

	
	private void error(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/errors/404-error.jsp").forward(request,response);
	}
	
}