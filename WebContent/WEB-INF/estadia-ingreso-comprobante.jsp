<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="domain.Estadia"%>
<%Estadia estadia = (Estadia) request.getAttribute("estadia");%>
<%@page import="java.text.DateFormat"%>
<%java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");%>

<c:set var="bodyContent">
  <div class="row justify-content-md-center">
    <div class="col-lg-11" style="max-width: 600px">
      <h5 class="h5 text-gray-800">Estadías</h5>
      <h1 class="h3 mb-4 text-gray-800">Comprobante de Ingreso</h1>
      <div class="card shadow mb-4">
        <div class="card-header py-3">
          <h6 class="m-0 font-weight-bold text-primary">Datos del comprobante</h6>
        </div>
        <div class="card-body">
          <div class="alert alert-info" role="alert">
            El ingreso se ha registrado de forma exitosa.
          </div>
          <div class="form-group row">
            <div class="col-sm-12 mb-3 mb-sm-0">
              <label class="mb-0 ml-1" for="fechaI">Fecha de ingreso</label>
              <input class="form-control form-control-user" type="text" name="fechaI" value="<%=dateFormat.format(estadia.getFechaIngreso())%>" readonly>
            </div>
          </div>
          <div class="form-group row">
            <div class="col-sm-12 mb-3 mb-sm-0">
              <label class="mb-0 ml-1" for="fechaS">Fecha de salida</label>
              <input class="form-control form-control-user" type="text" name="fechaS" value="<%=dateFormat.format(estadia.getFechaRetiro())%>" readonly>
            </div>
          </div>
          <div class="form-group row">
            <div class="col-sm-4 mb-3 mb-sm-0">
              <label class="mb-0 ml-1" for="patente">Patente</label>
              <input class="form-control form-control-user" type="text" name="patente" value="<%=estadia.getVehiculo().getPatente()%>" readonly>
            </div>
            <div class="col-sm-3 mb-3 mb-sm-0">
              <label class="mb-0 ml-1" for="lugar">Lugar</label>
              <input class="form-control form-control-user" type="text" name="lugar" value="<%=estadia.getLugar().getNroLugar()%>" readonly>
            </div>
             <div class="col-sm-5">
              <label class="mb-0 ml-1" for=precio">Precio</label>
              <input class="form-control form-control-user" type="text" name="precio" value="$<%=estadia.getPrecioFinal()%>" readonly>
            </div>
          </div>
        </div>
      </div>
      <div class="row justify-content-center">
        <a href="/Cocheras/estadias/add" class="btn btn-primary">
          <i class="fas fa-arrow-circle-left m-1"></i>
          Registrar otra estadía
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
