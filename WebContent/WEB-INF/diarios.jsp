<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%String webAlertMessage = (String)request.getAttribute("webAlertMessage");%>
<%String webAlertType = (String)request.getAttribute("webAlertType");%>

<%@page import="java.util.ArrayList"%>
<%@page import="domain.Diario"%>

<%ArrayList<Diario> diarios = (ArrayList<Diario>)request.getAttribute("diarios");%>

<c:set var="bodyContent">

  <%if(webAlertMessage != null){%>
  <div class="alert alert-<%=webAlertType%> alert-dismissible fade show webAlert" role="alert">
	<%=webAlertMessage%>
	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
	  <span aria-hidden="true">&times;</span>
	</button>
  </div>
  <%}%>

  <h1 class="h5 text-gray-800">Estacionamiento Diario</h1>
  <h1 class="h3 mb-4 text-gray-800">Listado de Ingresos y Salidas</h1>
  <div class="card shadow mb-4">
    <div class="card-body">
      <div class="table-responsive">
        <table class="table table-bordered dataTable" width="100%" cellspacing="0">
          <thead>
            <tr>
              <th class="nw">Identificador</th>
              <th class="nw">Lugar</th>
              <th class="nw">Patente</th>
              <th class="nw">Fecha y Hora de Ingreso</th>
              <th class="nw">Fecha y Hora de Salida</th>
              <th class="nw">Tiempo Transcurrido</th>
              <th class="nw">Monto</th>
              <th class="nw">Estado</th>
            </tr>
          </thead>
          <tfoot>
            <tr>
              <th class="nw">Identificador</th>
              <th class="nw">Lugar</th>
              <th class="nw">Patente</th>
              <th class="nw">Fecha y Hora de Ingreso</th>
              <th class="nw">Fecha y Hora de Salida</th>
              <th class="nw">Tiempo Transcurrido</th>
              <th class="nw">Monto</th>
              <th class="nw">Estado</th>
            </tr>
          </tfoot>
          <tbody>
          <%for(Diario diario : diarios){%>
            <tr>
              <td class="nw"><%=diario.getComprobante()%></td>
              <td class="nw"><%=diario.getLugar().getNroLugar()%></td>
              <td class="nw"><%=diario.getVehiculo().getPatente()%></td>
              <td class="nw"><%=diario.getFechaIngreso()%></td>
              <td class="nw"><%=diario.getFechaRetiro() == null ? "Sin retiro" : diario.getFechaRetiro()%></td>
              <%if(diario.getFechaRetiro() != null){%>
              <td class="nw"><%=(diario.getFechaRetiro().getTime() - diario.getFechaIngreso().getTime())/(60 * 60 * 1000)%> horas, <%=(diario.getFechaRetiro().getTime() - diario.getFechaIngreso().getTime())/ (60 * 1000) % 60%> minutos</td>
              <%}else{%>
              <td class="nw">Sin retiro</td>
              <%}%>
              <td class="nw">$<%=diario.getPrecioFinal()%></td> 
              <td class="nw"><span class="badge badge-pill badge-<%=diario.getEstado().equals("activo") ? "info" : "dark"%>"><%=diario.getEstado()%></span></td>
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
