<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="domain.Diario"%>
<%Diario diario = (Diario) request.getAttribute("diario");%>

<c:set var="bodyContent">
  <div class="row justify-content-md-center">
    <div class="col-lg-11" style="max-width: 800px">
      <h5 class="h5 text-gray-800">Estacionamiento Diario</h5>
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
            <div class="col-sm-12 mb-3 mb-sm-0">
              <label class="mb-0 ml-1" for="comprobante">Id de Ingreso</label>
              <input class="form-control form-control-user" type="text" name="comprobante" value="<%=diario.getComprobante()%>" readonly>
            </div>
          </div>
          <div class="form-group row">
            <div class="col-sm-6 mb-3 mb-sm-0">
              <label class="mb-0 ml-1" for="fechaI">Fecha de Ingreso</label>
              <input class="form-control form-control-user" type="text" name="fechaI" value="<%=diario.getFechaIngreso()%>" readonly>
            </div>
            <div class="col-sm-6">
              <label class="mb-0 ml-1" for="fechaS">Fecha de Salida</label>
              <input class="form-control form-control-user" type="text" name="fechaS" value="<%=diario.getFechaRetiro()%>" readonly>
            </div>
          </div>
          <div class="form-group row">
            <div class="col-sm-4 mb-3 mb-sm-0">
              <label class="mb-0 ml-1" for="patente">Patente</label>
              <input class="form-control form-control-user" type="text" name="patente" value="<%=diario.getVehiculo().getPatente()%>" readonly>
            </div>
            <div class="col-sm-4 mb-3 mb-sm-0">
              <label class="mb-0 ml-1" for="lugar">Lugar</label>
              <input class="form-control form-control-user" type="text" name="lugar" value="<%=diario.getLugar().getNroLugar()%>" readonly>
            </div>
            <div class="col-sm-4">
              <label class="mb-0 ml-1" for="precio">Precio</label>
              <input class="form-control form-control-user" type="text" name="precio" value="$<%=diario.getPrecioFinal()%>" readonly>
            </div>
          </div>
        </div>
      </div>
      <div class="row justify-content-center">
        <a href="/Cocheras/diarios/ingreso" class="btn btn-primary">
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
