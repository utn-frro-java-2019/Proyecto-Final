<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@page import="domain.Vehiculo"%>
<%@page import="java.util.ArrayList"%>
<%ArrayList<Vehiculo> lv = (ArrayList<Vehiculo>)request.getAttribute("listaVehiculos");%>

<c:set var="bodyContent">
  <h1 class="h3 mb-4 text-gray-800">Listado de Vehículos Registrados</h1>
  <div class="row  mb-3">
    <div class="col col-auto d-flex">
      <a class="d-flex align-items-center btn btn-primary" href="http://localhost:8080/Cocheras/vehiculos/create">Añadir vehículo</a>
    </div>
    <form class="col">
      <div class="input-group">
        <input type="text" class="form-control bg-light border border-primary p-4" placeholder="Buscar vehículo" aria-label="Search" aria-describedby="basic-addon2">
          <div class="input-group-append">
            <button class="btn btn-primary" type="button">
              <i class="fas fa-search"></i>
            </button>
          </div>
        </div>
      </form>
    </div>
    <div class="card shadow mb-4">
      <div class="card-body">
        <div class="table-responsive">
          <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
            <thead>
              <tr>
                <th class="nw">Patente</th>
                <th class="nw">Modelo</th>
                <th class="nw">Marca</th>
                <th class="nw">Tipo</th>
                <th class="nw">Opciones</th>
              </tr>
            </thead>
            <tfoot>
              <tr>
                <th class="nw">Patente</th>
                <th class="nw">Modelo</th>
                <th class="nw">Marca</th>
                <th class="nw">Tipo</th>
                <th class="nw">Opciones</th>
              </tr>
            </tfoot>
            <tbody>
              <%for(Vehiculo v: lv){%>
              <tr>
                <td class="nw"><%=v.getPatente()%></td>
                <td class="nw"><%=v.getModelo()%></td>
                <td class="nw"><%=v.getMarca()%></td>
                <td class="nw"><%=v.getTipo().getDescripcion()%></td>
                <td class="d-flex align-items-center p-0">
                  <a href="http://localhost:8080/Cocheras/vehiculos/details/<%=v.getPatente()%>" style="white-space: nowrap" class="d-flex align-items-center btn btn-warning m-1">
                    <i class="fas fa-edit fa-xs m-1"></i>Detalles / Editar
                  </a>
                  <a href="http://localhost:8080/Cocheras/vehiculos/delete/<%=v.getPatente()%>" class="d-flex align-items-center btn btn-danger m-1">
                    <i class="fas fa-trash-alt fa-xs m-1"></i>Eliminar
                  </a>
                  <a target="_Blank" href="https://api.whatsapp.com/send?phone=<%=v.getTelefonoContacto()%>" style="white-space: nowrap" class="d-flex align-items-center btn btn-primary m-1">
                    <i class="fas fa-phone-alt fa-xs m-1"></i></i>Llamar al propietario
                  </a>
                </td>
              </tr>
              <%}%>
            </tbody>
          </table>
        </div>
      </div>
    </div>
</c:set>

<t:template>
    <jsp:body>
        ${bodyContent}
    </jsp:body>
</t:template>
