package servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Cochera;
import business.CocheraController;

@WebServlet("/hi")
public class CocheraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public CocheraServlet() {
        super();
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("service at: ").append(request.getContextPath()).append("<br>");
        doGet(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("<i>doGet</i> at: ").append(request.getRequestURL()).append("<br>");
        doPost(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().append("<b>doPost</b> at: ").append(request.getRequestURI());
    }

}
