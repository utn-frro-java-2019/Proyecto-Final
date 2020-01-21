<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:set var="bodyContent">
  <div class="row justify-content-md-center">
    <div class="col-lg-11">
      <h1 class="h3 mb-4 text-gray-800">Registrar Nueva Cochera</h1>
      <form name="cochera-add" method="post" action="http://localhost:8080/Cocheras/cocheras/add">
        <div class="card shadow mb-4">
          <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Datos de la Cochera</h6>
          </div>
          <div class="card-body">
            <div class="form-group row">
              <div class="col-sm-12 mb-3 mb-sm-0">
                <label class="mb-0 ml-1" for="descripcion">Descripción</label>
                <input class="form-control form-control-user" type="text" name="descripcion" value="" required>
              </div>
            </div>
            <div class="form-group row">
              <div class="col-sm-8 mb-3 mb-sm-0">
                <label class="mb-0 ml-1" for="ubicacion">Ubicación</label>
                <input class="form-control form-control-user" type="text" name="ubicacion" value="" required>
              </div>
              <div class="col-sm-4">
                <label class="mb-0 ml-1" for="capacidad">Capacidad</label>
                <input class="form-control form-control-user" type="number" name="capacidad" value="0" required>
              </div>
            </div>
          </div>
        </div>
        <div class="row justify-content-end">
          <button type="submit" name="submit" class="btn btn-danger mr-3 mb-4">Registrar Cochera</button>
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
