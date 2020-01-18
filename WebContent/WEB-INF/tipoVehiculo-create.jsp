<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:set var="bodyContent">
  <div class="row justify-content-md-center">
    <div class="col-lg-11">
      <h1 class="h3 mb-4 text-gray-800">Registrar Nuevo Tipo de Vehículo</h1>
      <form name="cochera-add" method="post" action="http://localhost:8080/Cocheras/configuration/addTV">
        <div class="card shadow mb-4">
          <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Datos del Tipo de Vehículo</h6>
          </div>
          <div class="card-body">
            <div class="form-group row">
              <div class="col-sm-12 mb-3 mb-sm-0">
                <label class="mb-0 ml-1" for="descripcion">Descripcion</label>
                <input class="form-control form-control-user" type="text" name="descripcion" required>
              </div>
            </div>
            <div class="form-group row">
              <div class="col-sm-12 mb-3 mb-sm-0">
                <label class="mb-0 ml-1" for="ubicacion">Porcentaje Multiplicador</label>
                <input class="form-control form-control-user" type="text" name="porcentajeMultiplicador" placeholder="Ej: 0.2" required>
              </div>
            </div>
          </div>
        </div>
        <div class="row justify-content-end">
          <button type="submit" name="submit" class="btn btn-danger mr-3 mb-4">Registrar Tipo de Vehículo</button>
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