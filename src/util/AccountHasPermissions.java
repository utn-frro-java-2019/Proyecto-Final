package util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class AccountHasPermissions {
  public static boolean boss(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    Object accountType = request.getSession().getAttribute("accountType");

    if (accountType == null || !accountType.toString().equals("jefe")) {
      WebAlertViewer.showAlertMessage(request, "Acceso restringido solo para jefes", "danger");
      response.sendRedirect(request.getContextPath() + "/login-jefe");
      return false;
    }
    return true;
  }

  public static boolean employee(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    Object accountType = request.getSession().getAttribute("accountType");

    if (accountType == null || !accountType.toString().equals("empleado")) {
      WebAlertViewer.showAlertMessage(request, "Acceso restringido solo para empleados", "danger");
      response.sendRedirect(request.getContextPath() + "/login-empleado");
      return false;
    }
    return true;
  }

  public static boolean authenticated(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    Object accountType = request.getSession().getAttribute("accountType");

    if (accountType == null) {
      WebAlertViewer.showAlertMessage(request, "Acceso restringido", "danger");
      response.sendRedirect(request.getContextPath() + "/login-empleado");
      return false;
    }
    return true;
  }
}
