<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:set var="bodyContent">
  <div class="row justify-content-md-center">
    <div class="col-lg-11">
      <h1 class="h3 mb-4 text-gray-800">Registrar Nuevo Precio por Tiempo de Estadía</h1>
      <form name="cochera-add" method="post" action="/Cocheras/configuration/addME">
        <div class="card shadow mb-4">
          <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Datos del Descuento</h6>
          </div>
          <div class="card-body">
            <div class="form-group row">
              <div class="col-sm-12 mb-3 mb-sm-0">
                <label class="mb-0 ml-1" for="multiplicadorDesde">A partir de ... días</label>
                <input class="form-control form-control-user" type="number" min="1" max="365" step="1" name="multiplicadorDesde" placeholder="Días" required>
              </div>
            </div>
            <div class="form-group row">
              <div class="col-sm-12 mb-3 mb-sm-0">
                <label class="mb-0 ml-1" for="porcentajeMultiplicador">Porcentaje Multiplicador</label>
                <input class="form-control form-control-user" type="number" min="0.001" max="0.999" step="any" name="porcentajeMultiplicador" placeholder="Ej: 0.2" required>
              </div>
            </div>
          </div>
        </div>
        <div class="row justify-content-end">
          <button type="submit" name="submit" class="btn btn-danger mr-3 mb-4">Registrar Descuento</button>
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
