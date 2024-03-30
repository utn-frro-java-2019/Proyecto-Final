<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@page import="domain.Vehiculo"%>
<%@page import="domain.TipoVehiculo"%>
<%@page import="java.util.ArrayList"%>
<%Vehiculo v = (Vehiculo)request.getAttribute("vehiculo");%>
<%ArrayList<TipoVehiculo> tv = (ArrayList<TipoVehiculo>)request.getAttribute("tipos");%>

<c:set var="bodyContent">
  <div class="row justify-content-md-center">
    <div class="col-lg-11">
      <h1 class="h3 mb-4 text-gray-800">Editar Vehículo</h1>
      <form name="vehiculo-edit" method="post" action="/Cocheras/vehiculos/edit/<%=v.getPatente()%>">
        <div class="card shadow mb-4">
          <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Datos del Vehículo</h6>
          </div>
          <div class="card-body">
            <div class="form-group row">
              <div class="col-sm-4 mb-3 mb-sm-0">
                <label class="mb-0 ml-1" for="Patente">Patente</label>
                <input class="form-control form-control-user" type="text" name="patente" value="<%=v.getPatente()%>" required readonly>
              </div>
              <div class="col-sm-8">
                <label class="mb-0 ml-1" for="Propietario">Propietario</label>
                <input class="form-control form-control-user" type="text" name="propietario" value="<%=v.getPropietario()%>">
              </div>
            </div>
            <div class="form-group row">
              <div class="col-sm-4 mb-3 mb-sm-0">
                <label class="mb-0 ml-1" for="tipo">Tipo</label>
                <select name="tipo" class="form-control form-control-user" required>
                <%for(TipoVehiculo t: tv){%>
                  <option <%=t.getIdTipo() == v.getTipo().getIdTipo() ? "selected" : ""%> value="<%=t.getIdTipo()%>"><%=t.getDescripcion()%></option>
                <%}%>
                </select>
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
          <button type="submit" name="submit" class="btn btn-danger mr-3 mb-4">Actualizar Vehículo</button>
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
