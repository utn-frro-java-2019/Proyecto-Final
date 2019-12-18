<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:set var="bodyContent">
  <div class="row justify-content-md-center">
    <div class="col-lg-11">
      <h1 class="h5 text-gray-800">Estacionamiento Diario</h1>
      <h1 class="h3 mb-4 text-gray-800">Registrar Ingreso de Vehículo</h1>
      <div class="row  mb-4">
        <form class="col">
          <div class="input-group">
            <input type="text" class="form-control bg-light border border-primary p-4" placeholder="Buscar vehículo por patente" aria-label="Search" aria-describedby="basic-addon2">
            <div class="input-group-append">
              <button class="btn btn-primary" type="button">
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
              <label class="mb-0 ml-1" for="Patente">Patente</label>
              <input class="form-control form-control-user" type="text" name="Patente" value="">
            </div>
            <div class="col-sm-8">
              <label class="mb-0 ml-1" for="Propietario">Propietario</label>
              <input class="form-control form-control-user" type="text" name="Propietario" value="">
            </div>
          </div>
          <div class="form-group row">
            <div class="col-sm-4 mb-3 mb-sm-0">
              <label class="mb-0 ml-1" for="Tipo">Tipo</label>
              <input class="form-control form-control-user" type="text" name="Tipo" value="">
            </div>
            <div class="col-sm-4 mb-3 mb-sm-0">
              <label class="mb-0 ml-1" for="Marca">Marca</label>
              <input class="form-control form-control-user" type="text" name="Marca" value="">
            </div>
            <div class="col-sm-4">
              <label class="mb-0 ml-1" for="Modelo">Modelo</label>
              <input class="form-control form-control-user" type="text" name="Modelo" value="">
            </div>
          </div>
          <div class="form-group row">
            <div class="col-sm-7 mb-3 mb-sm-0">
              <label class="mb-0 ml-1" for="Desc">Descripción</label>
              <input class="form-control form-control-user" type="text" name="Desc" value="">
            </div>
            <div class="col-sm-5">
              <label class="mb-0 ml-1" for="Tel">Teléfono de contacto</label>
              <input class="form-control form-control-user" type="text" name="Tel" value="">
            </div>
          </div>
        </div>
      </div>
      <div class="row justify-content-end">
      	<button class="btn btn-success mr-3 mb-4" type="submit">Generar ingreso</button>
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
