package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.MultiplicadorEstadiaController;
import business.PrecioPorHoraController;
import business.TipoVehiculoController;
import domain.MultiplicadorEstadia;
import domain.PrecioPorHora;
import domain.TipoVehiculo;
import util.WebAlertViewer;

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
		else if(path.equals("/editPH")) {
			this.editPH(request,response);
		}
		else {
			this.error(request,response);
		}
	}

	private void config(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		double precioPorHora = PrecioPorHoraController.getPrecioPorHora().getPrecio();
		request.setAttribute("precioPorHora", precioPorHora);
		
    	ArrayList<MultiplicadorEstadia> multiplicadoresEstadia = MultiplicadorEstadiaController.getAll();
    	request.setAttribute("listaMultiplicadoresEstadia", multiplicadoresEstadia);
    	
    	ArrayList<TipoVehiculo> tiposVehiculos = TipoVehiculoController.getAll();
    	request.setAttribute("listaTiposVehiculos", tiposVehiculos);
    	
		request.getRequestDispatcher("/WEB-INF/configurations.jsp").forward(request,response);
	}

	// ------------------------------------------------------------------------------------------
	// Precio Por Hora --------------------------------------------------------------------
	
	private void editPH(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double precio = Double.parseDouble(request.getParameter("precioBase"));
		PrecioPorHora ph = new PrecioPorHora(precio);
		PrecioPorHoraController.updatePrecioPorHora(ph);
		WebAlertViewer.showAlertMessage(request, "El Precio por hora se ha modificado correctamente.");
		this.config(request, response);
	}
	
	// ------------------------------------------------------------------------------------------
	// Multiplicador Estadía --------------------------------------------------------------------
	
	private void createME(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/multiplicadorEstadia-create.jsp").forward(request,response);
	}
	
	private void deleteME(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		int multiplicadorDesde = Integer.parseInt(path.replace("/deleteME/", ""));
		MultiplicadorEstadiaController.deleteOne(multiplicadorDesde);
		WebAlertViewer.showAlertMessage(request, "El descuento por estadía se ha eliminado correctamente.");
		this.config(request, response);
	}
	
	private void addME(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int multiplicadorDesde = Integer.parseInt(request.getParameter("multiplicadorDesde"));
		double porcentajeMultiplicador = Double.parseDouble(request.getParameter("porcentajeMultiplicador"));
		MultiplicadorEstadia me = new MultiplicadorEstadia(multiplicadorDesde, porcentajeMultiplicador);
		MultiplicadorEstadiaController.insertOne(me);
		WebAlertViewer.showAlertMessage(request, "El descuento por estadía se ha añadido correctamente.");
		this.config(request, response);
	}
	
	// ------------------------------------------------------------------------------------------
	// Tipo de Vehículo -------------------------------------------------------------------------
	
	private void createTV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/tipoVehiculo-create.jsp").forward(request,response);
	}
	
	private void deleteTV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		int idTipo = Integer.parseInt(path.replace("/deleteTV/", ""));
		TipoVehiculoController.deleteOne(idTipo);
		WebAlertViewer.showAlertMessage(request, "El tipo de vehículo se ha eliminado correctamente.");
		this.config(request, response);
	}
	
	private void detailsTV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		int idTipo = Integer.parseInt(path.replace("/detailsTV/", ""));
		TipoVehiculo tv = TipoVehiculoController.getOne(idTipo);
    	request.setAttribute("TipoVehiculo", tv);
    	request.getRequestDispatcher("/WEB-INF/tipoVehiculo-details.jsp").forward(request,response);
	}
	
	private void addTV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String descripcion = request.getParameter("descripcion");
		double porcentajeMultiplicador = Double.parseDouble(request.getParameter("porcentajeMultiplicador"));
		TipoVehiculo tv = new TipoVehiculo(descripcion, porcentajeMultiplicador);
		TipoVehiculoController.insertOne(tv);
		WebAlertViewer.showAlertMessage(request, "El tipo de vehículo se ha añadido correctamente.");
		this.config(request, response);
	}
	
	private void editTV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		int idTipo = Integer.parseInt(path.replace("/editTV/", ""));
		String descripcion = request.getParameter("descripcion");
		double porcentajeMultiplicador = Double.parseDouble(request.getParameter("porcentajeMultiplicador"));
		TipoVehiculo tv = new TipoVehiculo(idTipo, descripcion, porcentajeMultiplicador);
		TipoVehiculoController.updateOne(tv);
		WebAlertViewer.showAlertMessage(request, "El tipo de vehículo se ha modificado correctamente.");
		this.config(request, response);
	}
	
	// ------------------------------------------------------------------------------------------

	
	private void error(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/errors/404-error.jsp").forward(request,response);
	}
	
}