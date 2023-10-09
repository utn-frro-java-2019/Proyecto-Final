package util;

import javax.servlet.http.HttpServletRequest;

public final class SetSession {
  public static void SetAccountSession(HttpServletRequest request, String email, String nombre, String apellido,
      String accountType) {
    request.getSession().setAttribute("email", email);
    request.getSession().setAttribute("name", nombre);
    request.getSession().setAttribute("surname", apellido);
    request.getSession().setAttribute("accountType", accountType);
  }
}
