package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class SessionManager {
  public static void SetAccountSession(HttpServletRequest request, String email, String nombre, String apellido,
      String accountType) {
    request.getSession().setAttribute("email", email);
    request.getSession().setAttribute("name", nombre);
    request.getSession().setAttribute("surname", apellido);
    request.getSession().setAttribute("accountType", accountType);
  }

  public static void DestroySession(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String accountType = (String) request.getSession().getAttribute("accountType");

    request.getSession().invalidate();

    if (accountType.equals("jefe"))
      response.sendRedirect(request.getContextPath() + "/login-jefe");
    else {
      response.sendRedirect(request.getContextPath() + "/login-empleado");
    }
  }
}
