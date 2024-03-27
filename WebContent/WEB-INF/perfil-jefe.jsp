<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@page import="domain.Jefe"%>
<%Jefe u = (Jefe)request.getAttribute("usuario");%>

<%String webAlertMessage = (String)request.getAttribute("webAlertMessage");%>
<%String webAlertType = (String)request.getAttribute("webAlertType");%>

<c:set var="bodyContent">

  <%if(webAlertMessage != null){%>
  <div class="alert alert-<%=webAlertType%> alert-dismissible fade show webAlert" role="alert">
	<%=webAlertMessage%>
	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
	  <span aria-hidden="true">&times;</span>
	</button>
  </div>
  <%}%>

      <!-- Basic Card Example -->
      <div class="card shadow mb-4">
        <div class="card-header py-3">
          <h6 class="m-0 font-weight-bold text-primary">Mi Perfil</h6>
        </div>
        <div class="card-body">
          <form>
            <div class="form-group row">
              <div class="col-sm-6 mb-3 mb-sm-0">
                <label class="mb-0 ml-1" for="nombre">Nombre</label>
                <input class="form-control form-control-user" type="text" name="nombre" value="<%=u.getNombre()%>" disabled>
              </div>
              <div class="col-sm-6">
                <label class="mb-0 ml-1" for="apellido">Apellido</label>
                <input class="form-control form-control-user" type="text" name="apellido" value="<%=u.getApellido()%>" disabled>
              </div>
            </div>
            <div class="form-group row">
              <div class="col-sm-12">
                <label class="mb-0 ml-1" for="email">Email</label>
                <input class="form-control form-control-user" type="text" name="email" value="<%=u.getEmail()%>" disabled>
              </div>
            </div>
          </form>
        </div>
      </div>
</c:set>

<t:template>
    <jsp:body>
        ${bodyContent}
    </jsp:body>
</t:template>
