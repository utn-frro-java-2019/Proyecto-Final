<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@page import="domain.Estadia"%>
<%@page import="java.util.ArrayList"%>
<%ArrayList<Estadia> le = (ArrayList<Estadia>)request.getAttribute("listaEstadias");%>

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
  
  <h1 class="h3 mb-4 text-gray-800">Listado de Estadias Registradas</h1>
  <div class="row  mb-3">
    <div class="col col-auto d-flex">
      <a class="d-flex align-items-center btn btn-primary" href="#">Añadir Estadia</a>
    </div>
    <form class="col">
      <div class="input-group">
        <input type="text" class="form-control bg-light border border-primary p-4" placeholder="Buscar estadia" aria-label="Search" aria-describedby="basic-addon2">
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
                <th class="nw">Estado</th>
                <th class="nw">Cochera</th>
                <th class="nw">Fecha Ingreso</th>
                <th class="nw">Fecha Retiro</th>
                <th class="nw">Patente</th>
                <th class="nw">Auto en Cochera</th>
              </tr>
            </thead>
            <tfoot>
              <tr>
                <th class="nw">Estado</th>
                <th class="nw">Cochera</th>
                <th class="nw">Fecha Ingreso</th>
                <th class="nw">Fecha Retiro</th>
                <th class="nw">Patente</th>
                <th class="nw">Auto en Cochera</th>
              </tr>
            </tfoot>
            <tbody>
              <%for(Estadia e: le){%>
              <tr>
                <td class="nw"><%=e.getEstado()%></td>
                <td class="nw"><%=e.getCochera().getDescripcion()%></td>
                <td class="nw"><%=e.getFechaIngreso()%></td>
                <td class="nw"><%=e.getFechaRetiro()%></td>
                <td class="nw"><%=e.getVehiculo().getPatente()%></td>
                <td class="nw"><%=e.getAutoEnCochera()%></td>
                <td class="d-flex align-items-center p-0">
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
