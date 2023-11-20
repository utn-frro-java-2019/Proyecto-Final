<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@page import="domain.Empleado"%>
<%Empleado u = (Empleado)request.getAttribute("usuario");%>

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
                <input class="form-control form-control-user" type="text" name="nombre" value="<%=u.getNombre()%>">
              </div>
              <div class="col-sm-6">
                <label class="mb-0 ml-1" for="apellido">Apellido</label>
                <input class="form-control form-control-user" type="text" name="apellido" value="<%=u.getApellido()%>">
              </div>
            </div>
            <div class="form-group row">
              <div class="col-sm-3 mb-3 mb-sm-0">
                <label class="mb-0 ml-1" for="dni">Dni</label>
                <input class="form-control form-control-user" type="text" name="dni" value="<%=u.getDni()%>">
              </div>
              <div class="col-sm-4 mb-3 mb-sm-0">
                <label class="mb-0 ml-1" for="usuario">Usuario</label>
                <input class="form-control form-control-user" type="text" name="usuario" value="<%=u.getUsuario()%>">
              </div>
              <div class="col-sm-5">
                <label class="mb-0 ml-1" for="email">Email</label>
                <input class="form-control form-control-user" type="text" name="email" value="<%=u.getEmail()%>">
              </div>
            </div>
            <div class="form-group row">
              <div class="col-sm-6 mb-3 mb-sm-0">
                <label class="mb-0 ml-1" for="tel1">Teléfono 1</label>
                <input class="form-control form-control-user" type="text" name="tel1" value="<%=u.getTelefono1()%>">
              </div>
              <div class="col-sm-6">
                <label class="mb-0 ml-1" for="tel2">Teléfono 2</label>
                <input class="form-control form-control-user" type="text" name="tel2" value="<%=u.getTelefono2()%>">
              </div>
            </div>
            <a href="#" class="btn btn-success">
              Guardar Cambios
            </a>
          </form>
        </div>
      </div>
      <!-- Collapsable Card Example -->
      <div class="card shadow mb-4">
        <!-- Card Header - Accordion -->
        <a href="#editPasswordCollapse" class="d-block card-header py-3" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="editPasswordCollapse">
          <h6 class="m-0 font-weight-bold text-primary">Editar Contraseña</h6>
        </a>
        <!-- Card Content - Collapse -->
        <div class="collapse show" id="editPasswordCollapse">
          <div class="card-body">
            <form>
              <div class="form-group row">
                <div class="col-sm-12 mb-3 mb-sm-0">
                  <input type="password" class="form-control form-control-user" id="actual-pass" placeholder="Contraseña actual">
                </div>
              </div>
              <div class="form-group row">
                <div class="col-sm-6 mb-3 mb-sm-0">
                  <input type="password" class="form-control form-control-user" id="new-pass1" placeholder="Nueva Contraseña">
                </div>
                <div class="col-sm-6">
                  <input type="password" class="form-control form-control-user" id="new-pass2" placeholder="Repetir Nueva Contraseña">
                </div>
              </div>
              <a href="#" class="btn btn-success">
                Cambiar
              </a>
            </form>
          </div>
        </div>
      </div>
</c:set>

<t:template>
    <jsp:body>
        ${bodyContent}
    </jsp:body>
</t:template>
