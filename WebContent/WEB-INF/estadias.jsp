<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%String webAlertMessage = (String)request.getAttribute("webAlertMessage");%>
<%String webAlertType = (String)request.getAttribute("webAlertType");%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DateFormat"%>
<%@page import="domain.Estadia"%>

<%ArrayList<Estadia> estadias = (ArrayList<Estadia>)request.getAttribute("estadias");%>
<%java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");%>

<c:set var="bodyContent">

  <%if(webAlertMessage != null){%>
  <div class="alert alert-<%=webAlertType%> alert-dismissible fade show webAlert" role="alert">
	<%=webAlertMessage%>
	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
	  <span aria-hidden="true">&times;</span>
	</button>
  </div>
  <%}%>

  <h1 class="h5 text-gray-800">Estadías</h1>
  <h1 class="h3 mb-4 text-gray-800">Listado de Estadías</h1>
  <div class="card shadow mb-4">
    <div class="card-body">
      <div class="table-responsive">
        <table class="table table-bordered dataTable" width="100%" cellspacing="0">
          <thead>
            <tr>
              <th class="nw">Lugar</th>
              <th class="nw">Patente</th>
              <th class="nw">Ingreso</th>
              <th class="nw">Salida</th>
              <th class="nw">Monto</th>
              <th class="nw">Estado</th>
              <th class="nw">Auto en Cochera</th>
              <th class="nw">Acciones</th>
            </tr>
          </thead>
          <tfoot>
            <tr>
              <th class="nw">Lugar</th>
              <th class="nw">Patente</th>
              <th class="nw">Ingreso</th>
              <th class="nw">Salida</th>
              <th class="nw">Monto</th>
              <th class="nw">Estado</th>
              <th class="nw">Auto en Cochera</th>
              <th class="nw">Acciones</th>
            </tr>
          </tfoot>
          <tbody>
          <%for(Estadia estadia : estadias){%>
            <tr>
              <td class="nw"><%=estadia.getLugar().getNroLugar()%></td>
              <td class="nw"><%=estadia.getVehiculo().getPatente()%></td>
              <td class="nw"><%=dateFormat.format(estadia.getFechaIngreso())%></td>
              <td class="nw"><%=dateFormat.format(estadia.getFechaRetiro())%></td>
              <td class="nw">$<%=estadia.getPrecioFinal()%></td> 
              <td class="nw"><span class="badge badge-pill badge-<%=estadia.getEstado().equals("activo") ? "info" : "dark"%>"><%=estadia.getEstado()%></span></td>
              <td class="nw"><div class="badge badge-pill badge-<%=estadia.getAutoEnCochera() ? "success" : "warning"%>"><%=estadia.getAutoEnCochera() ? "Sí" : "No"%></div></td>
                <td class="d-flex align-items-center p-0">
                  <%if(estadia.getAutoEnCochera()){%>
                  <a style="white-space: nowrap" href="/Cocheras/estadias/salida-v/<%=estadia.getComprobante()%>" class="d-flex align-items-center btn btn-info m-1">Retirar Vehículo</a>
                  <%} else {%>
                  <a style="white-space: nowrap" href="/Cocheras/estadias/ingreso-v/<%=estadia.getComprobante()%>" class="d-flex align-items-center btn btn-info m-1">Ingresar Vehículo</a>
                  <%}%>
                  <a style="white-space: nowrap" href="/Cocheras/estadias/finalizar/<%=estadia.getComprobante()%>" class="d-flex align-items-center btn btn-success m-1 <%=estadia.getEstado().equals("activo") ? "" : "disabled"%>">Finalizar Estadía</a>
                  <a style="white-space: nowrap" target="_Blank" href="https://api.whatsapp.com/send?phone=<%=estadia.getVehiculo().getTelefonoContacto()%>" class="d-flex align-items-center btn btn-primary m-1">
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
