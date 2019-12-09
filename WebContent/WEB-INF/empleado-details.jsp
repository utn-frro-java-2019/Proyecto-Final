<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@page import="domain.Empleado"%>
<%Empleado e = (Empleado)request.getAttribute("empleado");%>

<c:set var="bodyContent">
  <div class="row justify-content-md-center">
    <div class="col-lg-11">
      <h1 class="h3 mb-4 text-gray-800">Editar Empleado</h1>
      <form>
        <div class="card shadow mb-4">
          <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Datos del Empleado</h6>
          </div>
          <div class="card-body">
            <div class="form-group row">
              <div class="col-sm-6 mb-3 mb-sm-0">
                <label class="mb-0 ml-1" for="Nombre">Nombre</label>
                <input class="form-control form-control-user" type="text" name="Nombre" value="<%=e.getNombre()%>">
              </div>
              <div class="col-sm-6">
                <label class="mb-0 ml-1" for="Apellido">Apellido</label>
                <input class="form-control form-control-user" type="text" name="Apellido" value="<%=e.getApellido()%>">
              </div>
            </div>
            <div class="form-group row">
              <div class="col-sm-3 mb-3 mb-sm-0">
                <label class="mb-0 ml-1" for="Dni">Dni</label>
                <input class="form-control form-control-user" type="text" name="Dni" value="<%=e.getDni()%>">
              </div>
              <div class="col-sm-4 mb-3 mb-sm-0">
                <label class="mb-0 ml-1" for="Usuario">Usuario</label>
                <input class="form-control form-control-user" type="text" name="Usuario" value="<%=e.getUsuario()%>">
              </div>
              <div class="col-sm-5">
                <label class="mb-0 ml-1" for="Email">Email</label>
                <input class="form-control form-control-user" type="text" name="Email" value="<%=e.getEmail()%>">
              </div>
            </div>
            <div class="form-group row">
              <div class="col-sm-6 mb-3 mb-sm-0">
                <label class="mb-0 ml-1" for="Tel1">Teléfono 1</label>
                <input class="form-control form-control-user" type="text" name="Tel1" value="<%=e.getTelefono1()%>">
              </div>
              <div class="col-sm-6">
                <label class="mb-0 ml-1" for="Tel2">Teléfono 2</label>
                <input class="form-control form-control-user" type="text" name="Tel2" value="<%=e.getTelefono2()%>">
              </div>
            </div>
          </div>
        </div>
        <div class="row justify-content-end">
          <button type="submit" name="submit" class="btn btn-danger mr-3 mb-4">Actualizar Empleado</button>
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
