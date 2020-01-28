<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:set var="bodyContent">
  <div class="row justify-content-md-center">
    <div class="col-lg-11">
      <h1 class="h3 mb-4 text-gray-800">Registrar Nuevo Empleado</h1>
      <form name="empleado-add" method="post" action="http://localhost:8080/Cocheras/empleados/add">
        <div class="card shadow mb-4">
          <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Datos del Empleado</h6>
          </div>
          <div class="card-body">
            <div class="form-group row">
              <div class="col-sm-4 mb-3 mb-sm-0">
                <label class="mb-0 ml-1" for="nombre">Nombre</label>
                <input class="form-control form-control-user" type="text" name="nombre" value="" required>
              </div>
              <div class="col-sm-4">
                <label class="mb-0 ml-1" for="apellido">Apellido</label>
                <input class="form-control form-control-user" type="text" name="apellido" value="" required>
              </div>
              <div class="col-sm-4">
                <label class="mb-0 ml-1" for="dni">Dni</label>
                <input class="form-control form-control-user" type="text" name="dni" value="" required>
              </div>
            </div>
            <div class="form-group row">
              <div class="col-sm-3 mb-3 mb-sm-0">
                <label class="mb-0 ml-1" for="usuario">Usuario</label>
                <input class="form-control form-control-user" type="text" name="usuario" value="" required>
              </div>
              <div class="col-sm-5">
                <label class="mb-0 ml-1" for="email">Email</label>
                <input class="form-control form-control-user" type="email" name="email" value="" required>
              </div>
              <div class="col-sm-4">
                <label class="mb-0 ml-1" for="password">Contraseña</label>
                <input class="form-control form-control-user" type="password" name="password" value="" required>
              </div>
            </div>
            <div class="form-group row">
              <div class="col-sm-6 mb-3 mb-sm-0">
                <label class="mb-0 ml-1" for="tel1">Teléfono 1</label>
                <input class="form-control form-control-user" type="text" name="tel1" value="" required>
              </div>
              <div class="col-sm-6">
                <label class="mb-0 ml-1" for="tel2">Teléfono 2</label>
                <input class="form-control form-control-user" type="text" name="tel2" value="" required>
              </div>
            </div>
          </div>
        </div>
        <div class="row justify-content-end">
          <button type="submit" name="submit" class="btn btn-danger mr-3 mb-4">Registrar Empleado</button>
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
