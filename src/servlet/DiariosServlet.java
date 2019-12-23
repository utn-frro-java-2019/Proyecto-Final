package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/diarios/*")
public class DiariosServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public DiariosServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		if(path.equals("/all")) {
		 	this.all(request,response);
		}
		else if(path.equals("/ingreso")) {
			this.ingreso(request,response);
		}
		else if(path.startsWith("/comprobante-ingreso")) {
			this.comprobanteI(request,response);
		}
		else if(path.startsWith("/salida")) {
			this.salida(request,response);
		}
		else if(path.startsWith("/comprobante-salida")) {
			this.comprobanteS(request,response);
		}
		else if(path.startsWith("/salida")) {
			this.salida(request,response);
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
		if(path.equals("/ingreso")) {
		 	this.diarioNew(request,response);
		}
		else if(path.equals("/salida")) {
		 	this.diarioFinish(request,response);
		}
		else if(path.equals("/edit")) {
			this.edit(request,response);
		}
		else {
			this.error(request,response);
		}
	}

	private void all(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//TODO	
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//TODO	
	}
		
	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//TODO	
	}
	
	private void ingreso(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	request.getRequestDispatcher("/WEB-INF/diario-ingreso.jsp").forward(request,response);
		//TODO
	}
	
	private void salida(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	request.getRequestDispatcher("/WEB-INF/diario-salida.jsp").forward(request,response);
		//TODO
	}
	
	private void diarioNew(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	request.getRequestDispatcher("/WEB-INF/diario-ingreso-comprobante.jsp").forward(request,response);
		//TODO
	}
	
	private void diarioFinish(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	request.getRequestDispatcher("/WEB-INF/diario-salida-comprobante.jsp").forward(request,response);
		//TODO
	}
	
	private void comprobanteI(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//TODO
	}
	
	private void comprobanteS(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//TODO
	}
	
	private void error(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/errors/404-error.jsp").forward(request,response);
	}
	
}