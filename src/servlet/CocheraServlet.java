package servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import domain.Cochera;
import business.CocheraController;

@WebServlet("/Cocheras")
public class CocheraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public CocheraServlet() {
        super();
        
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ArrayList<Cochera> cocheras = CocheraController.getAll();
    	
    	request.setAttribute("listaCochera", cocheras);
    	request.getRequestDispatcher("WEB-INF/cocheras.jsp").forward(request,response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Post");
    }

    
    
}
