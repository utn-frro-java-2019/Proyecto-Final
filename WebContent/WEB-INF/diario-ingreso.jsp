<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@page import="domain.Vehiculo"%>
<%@page import="domain.TipoVehiculo"%>
<%Vehiculo v = (Vehiculo)request.getAttribute("vehiculo");%>
<%
  if (v == null) {
	TipoVehiculo t = new TipoVehiculo(0, "", 0);
	v = new Vehiculo("", "", "", "", t, "","");
  }
%>

<%String webAlertMessage = (String)request.getAttribute("webAlertMessage");%>
<%String webAlertType = (String)request.getAttribute("webAlertType");%>

<c:set var="bodyContent">

  <div class="row justify-content-md-center">
    <div class="col-lg-11">
    
  <%if(webAlertMessage != null){%>
  <div class="alert alert-<%=webAlertType%> alert-dismissible fade show webAlert" role="alert">
	<%=webAlertMessage%>
	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
	  <span aria-hidden="true">&times;</span>
	</button>
  </div>
  <%}%>
    
      <h5 class="h5 text-gray-800">Estacionamiento Diario</h5>
      <h1 class="h3 mb-4 text-gray-800">Registrar Ingreso de Vehículo</h1>
      <div class="row  mb-4">
        <form class="col" name="ingresoSearch" method="post" action="http://localhost:8080/Cocheras/diarios/ingresoSearch">
          <div class="input-group">
            <input type="text" class="form-control bg-light border border-primary p-4" placeholder="Buscar vehículo por patente" aria-label="Search" aria-describedby="basic-addon2" name="patente" required>
            <div class="input-group-append">
              <button type="submit" class="btn btn-primary" type="button">
                <i class="fas fa-search"></i>
              </button>
            </div>
          </div>
        </form>
        <div class="col col-auto d-flex">
          <a class="d-flex justify-content-center align-items-center btn btn-primary" href="http://localhost:8080/Cocheras/vehiculos/create">Registrar nuevo vehículo</a>
        </div>
      </div>
      <form name="diario-ingreso" method="post" action="http://localhost:8080/Cocheras/diarios/ingreso">
      <div class="card shadow mb-4">
        <div class="card-header py-3">
          <h6 class="m-0 font-weight-bold text-primary">Datos del vehículo</h6>
        </div>
        <div class="card-body">
          <div class="form-group row">
            <div class="col-sm-4 mb-3 mb-sm-0">
              <label class="mb-0 ml-1" for="patente">Patente</label>
              <input class="form-control form-control-user" type="text" name="patente" value="<%=v.getPatente()%>">
            </div>
            <div class="col-sm-8">
              <label class="mb-0 ml-1" for="propietario">Propietario</label>
              <input class="form-control form-control-user" type="text" name="propietario" value="<%=v.getPropietario()%>">
            </div>
          </div>
          <div class="form-group row">
            <div class="col-sm-4 mb-3 mb-sm-0">
              <label class="mb-0 ml-1" for="tipo">Tipo</label>
              <input class="form-control form-control-user" type="text" name="tipo" value="<%=v.getTipo().getDescripcion()%>">
            </div>
            <div class="col-sm-4 mb-3 mb-sm-0">
              <label class="mb-0 ml-1" for="marca">Marca</label>
              <input class="form-control form-control-user" type="text" name="marca" value="<%=v.getMarca()%>">
            </div>
            <div class="col-sm-4">
              <label class="mb-0 ml-1" for="modelo">Modelo</label>
              <input class="form-control form-control-user" type="text" name="modelo" value="<%=v.getModelo()%>">
            </div>
          </div>
          <div class="form-group row">
            <div class="col-sm-7 mb-3 mb-sm-0">
              <label class="mb-0 ml-1" for="desc">Descripción</label>
              <input class="form-control form-control-user" type="text" name="desc" value="<%=v.getDescripcion()%>">
            </div>
            <div class="col-sm-5">
              <label class="mb-0 ml-1" for="tel">Teléfono de contacto</label>
              <input class="form-control form-control-user" type="text" name="tel" value="<%=v.getTelefonoContacto()%>">
            </div>
          </div>
        </div>
      </div>
      <div class="row justify-content-end">
      	<button class="btn btn-success mr-3 mb-4" type="submit" <%if(v.getPatente().equals("")){%>disabled<%}%>>Generar ingreso</button>
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
