<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:set var="bodyContent">
  <div class="row justify-content-md-center">
    <div class="col-lg-11">
      <h1 class="h3 mb-4 text-gray-800">Registrar Nuevo Vehículo</h1>
      <form name="vehiculo-add" method="post" action="http://localhost:8080/Cocheras/vehiculos/add">
        <div class="card shadow mb-4">
          <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Datos del Vehículo</h6>
          </div>
          <div class="card-body">
            <div class="form-group row">
              <div class="col-sm-4 mb-3 mb-sm-0">
                <label class="mb-0 ml-1" for="Patente">Patente</label>
                <input class="form-control form-control-user" type="text" name="patente" value="">
              </div>
              <div class="col-sm-8">
                <label class="mb-0 ml-1" for="Propietario">Propietario</label>
                <input class="form-control form-control-user" type="text" name="propietario" value="">
              </div>
            </div>
            <div class="form-group row">
              <div class="col-sm-4 mb-3 mb-sm-0">
                <label class="mb-0 ml-1" for="Tipo">Tipo</label>
                <select name="Tipo" class="form-control form-control-user">
                  <option value="1">Auto</option>
                  <option value="2">Motocicleta</option>
                  <option value="3">Autobus</option>
                  <option value="4">Camión</option>
                </select>
              </div>
              <div class="col-sm-4 mb-3 mb-sm-0">
                <label class="mb-0 ml-1" for="Marca">Marca</label>
                <input class="form-control form-control-user" type="text" name="marca" value="">
              </div>
              <div class="col-sm-4">
                <label class="mb-0 ml-1" for="Modelo">Modelo</label>
                <input class="form-control form-control-user" type="text" name="modelo" value="">
              </div>
            </div>
            <div class="form-group row">
              <div class="col-sm-7 mb-3 mb-sm-0">
                <label class="mb-0 ml-1" for="Desc">Descripción</label>
                <input class="form-control form-control-user" type="text" name="desc" value="">
              </div>
              <div class="col-sm-5">
                <label class="mb-0 ml-1" for="Tel">Teléfono de contacto</label>
                <input class="form-control form-control-user" type="text" name="tel" value="">
              </div>
            </div>
          </div>
        </div>
        <div class="row justify-content-end">
          <button type="submit" name="submit" class="btn btn-danger mr-3 mb-4">Registrar Vehículo</button>
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
