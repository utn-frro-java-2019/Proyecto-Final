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
              <label class="mb-0 ml-1" for="fechaI">Fecha de Ingreso</label>
              <input class="form-control form-control-user" type="text" name="fechaI" value="">
            </div>
            <div class="col-sm-6">
              <label class="mb-0 ml-1" for="horaI">Hora de Ingreso</label>
              <input class="form-control form-control-user" type="text" name="horaI" value="">
            </div>
          </div>
          <div class="form-group row">
            <div class="col-sm-6 mb-3 mb-sm-0">
              <label class="mb-0 ml-1" for="FechaS">Fecha de Salida</label>
              <input class="form-control form-control-user" type="text" name="fechaS" value="">
            </div>
            <div class="col-sm-6">
              <label class="mb-0 ml-1" for="HoraS">Hora de Salida</label>
              <input class="form-control form-control-user" type="text" name="HoraS" value="">
            </div>
          </div>
          <div class="form-group row">
            <div class="col-sm-4 mb-3 mb-sm-0">
              <label class="mb-0 ml-1" for="patente">Patente</label>
              <input class="form-control form-control-user" type="text" name="patente" value="">
            </div>
            <div class="col-sm-4  mb-3 mb-sm-0">
              <label class="mb-0 ml-1" for="id">Id de Ingreso</label>
              <input class="form-control form-control-user" type="text" name="id" value="">
            </div>
            <div class="col-sm-2  mb-3 mb-sm-0">
              <label class="mb-0 ml-1" for="lugar">Lugar</label>
              <input class="form-control form-control-user" type="text" name="lugar" value="">
            </div>
            <div class="col-sm-2">
              <label class="mb-0 ml-1" for="monto">Monto</label>
              <input class="form-control form-control-user" type="text" name="monto" value="">
            </div>
          </div>
        </div>
      </div>
      <div class="row justify-content-center">
        <a href="http://localhost:8080/Cocheras/diarios/ingreso" class="btn btn-primary">
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
