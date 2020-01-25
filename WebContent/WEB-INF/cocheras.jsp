<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@page import="domain.Cochera"%>
<%@page import="java.util.ArrayList"%>
<%ArrayList<Cochera> lc = (ArrayList<Cochera>)request.getAttribute("listaCochera");%>

<%String webAlertMessage = (String)request.getAttribute("webAlertMessage");%>
<%String webAlertType = (String)request.getAttribute("webAlertType");%>

<c:set var="bodyContent">

  <%if(webAlertMessage != null){%>
  <div class="alert alert-<%=webAlertType%> alert-dismissible fade show webAlert" role="alert">
	<%=webAlertMessage%>
	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
	  <span aria-hidden="true">&times;</span>
	</button>
  </div>
  <%}%>

  <h1 class="h3 mb-4 text-gray-800">Administrar Cocheras</h1>
  <div class="row  mb-3">
    <div class="col col-auto d-flex">
      <a class="d-flex align-items-center btn btn-primary" href="http://localhost:8080/Cocheras/cocheras/create">Añadir Cochera</a>
    </div>
    <form class="col">
      <div class="input-group">
        <input type="text" class="form-control bg-light border border-primary p-4" placeholder="Buscar cochera" aria-label="Search" aria-describedby="basic-addon2">
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
          <table class="table table-bordered dataTable" width="100%" cellspacing="0">
            <thead>
              <tr>
                <th class="nw">Id</th>
                <th class="nw">Descripción</th>
                <th class="nw">Ubicación</th>
                <th class="nw">Capacidad</th>
                <th class="nw">Opciones</th>
              </tr>
            </thead>
            <tfoot>
              <tr>
                <th class="nw">Id</th>
                <th class="nw">Descripción</th>
                <th class="nw">Ubicación</th>
                <th class="nw">Capacidad</th>
                <th class="nw">Opciones</th>
              </tr>
            </tfoot>
            <tbody>
              <%for(Cochera c: lc){%>
              <tr>
                <td class="nw"><%=c.getIdCochera()%></td>
                <td class="nw"><%=c.getDescripcion()%></td>
                <td class="nw"><%=c.getUbicacion()%></td>
                <td class="nw"><%=c.getCapacidad()%></td>
                <td class="d-flex align-items-center p-0">
                  <a href="http://localhost:8080/Cocheras/cocheras/details/<%=c.getIdCochera()%>" class="d-flex align-items-center btn btn-warning m-1">
                    <i class="fas fa-edit fa-xs m-1"></i>Editar
                  </a>
                  <a href="http://localhost:8080/Cocheras/cocheras/delete/<%=c.getIdCochera()%>" class="d-flex align-items-center btn btn-danger m-1">
                    <i class="fas fa-trash-alt fa-xs m-1"></i>Eliminar
                  </a>
                  <button type="button" class="d-flex align-items-center btn btn-primary m-1">
                    <i class="fas fa-map-marker-alt fa-xs m-1"></i>
                    <p class="d-none d-md-block m-0" style="white-space: nowrap">Estado actual de los lugares</p>
                  </button>
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
