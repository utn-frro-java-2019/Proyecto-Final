<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:set var="bodyContent">
  <div class="row justify-content-md-center">
    <div class="col-lg-11" style="max-width: 800px">
      <h1 class="h5 text-gray-800">Estacionamiento Diario</h1>
      <h1 class="h3 mb-4 text-gray-800">Comprobante de Salida</h1>
      <div class="card shadow mb-4">
        <div class="card-header py-3">
          <h6 class="m-0 font-weight-bold text-primary">Datos del comprobante</h6>
        </div>
        <div class="card-body">
          <div class="alert alert-info" role="alert">
            La salida se ha registrado de forma exitosa.
          </div>
          <div class="form-group row">
            <div class="col-sm-6 mb-3 mb-sm-0">
              <label class="mb-0 ml-1" for="Fecha">Fecha de Ingreso</label>
              <input class="form-control form-control-user" type="text" name="Fecha" value="">
            </div>
            <div class="col-sm-6">
              <label class="mb-0 ml-1" for="Hora">Hora de Ingreso</label>
              <input class="form-control form-control-user" type="text" name="Hora" value="">
            </div>
          </div>
          <div class="form-group row">
            <div class="col-sm-6 mb-3 mb-sm-0">
              <label class="mb-0 ml-1" for="Fecha">Fecha de Salida</label>
              <input class="form-control form-control-user" type="text" name="Fecha" value="">
            </div>
            <div class="col-sm-6">
              <label class="mb-0 ml-1" for="Hora">Hora de Salida</label>
              <input class="form-control form-control-user" type="text" name="Hora" value="">
            </div>
          </div>
          <div class="form-group row">
            <div class="col-sm-4 mb-3 mb-sm-0">
              <label class="mb-0 ml-1" for="Patente">Patente</label>
              <input class="form-control form-control-user" type="text" name="Patente" value="">
            </div>
            <div class="col-sm-4  mb-3 mb-sm-0">
              <label class="mb-0 ml-1" for="Id">Id de Ingreso</label>
              <input class="form-control form-control-user" type="text" name="Id" value="">
            </div>
            <div class="col-sm-2  mb-3 mb-sm-0">
              <label class="mb-0 ml-1" for="Lugar">Lugar</label>
              <input class="form-control form-control-user" type="text" name="Lugar" value="">
            </div>
            <div class="col-sm-2">
              <label class="mb-0 ml-1" for="Monto a cobrar">Monto</label>
              <input class="form-control form-control-user" type="text" name="Monto a cobrar" value="">
            </div>
          </div>
        </div>
      </div>
      <div class="row justify-content-center">
        <a href="#" class="btn btn-primary">
          <i class="fas fa-arrow-circle-left m-1"></i>
          Registrar otro ingreso
        </a>
      </div>
    </div>
  </div>
</c:set>

<t:template>
    <jsp:body>
        ${bodyContent}
    </jsp:body>
</t:template>
