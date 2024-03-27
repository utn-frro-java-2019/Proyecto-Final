<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@page import="domain.Cochera"%>
<%@page import="domain.Ingreso"%>
<%@page import="java.util.ArrayList"%>
<%Cochera c = (Cochera)request.getAttribute("cochera");%>
<%ArrayList<Ingreso> ingresos = (ArrayList<Ingreso>)request.getAttribute("ingresos");%>

<c:set var="bodyContent">
    <%Integer ocupados = 0;%>
    <%for(int i = 0; i < c.getCapacidad(); i++){

      for(Ingreso ingreso : ingresos){
        if(ingreso.getCochera().getIdCochera() == c.getIdCochera() && ingreso.getLugar().getNroLugar() == (i+1)){
          ocupados++;
        }
      }
    }%>


  <h1 class="h5 text-gray-800">Cochera: <b><%=c.getNombre()%></b></h1>
  <h1 class="h3 mb-4 text-gray-800">Lugares disponibles: <b><%=c.getCapacidad()-ocupados%>/<%=c.getCapacidad()%></b></h1>
  <div class="row mb-4" style="justify-content: center;">
    <%for(int i = 0; i < c.getCapacidad(); i++){%>
    <%boolean ocupado = false;%>
    <%String patente = "";%>
    <%String tipo = "";%>
    <%
      for(Ingreso ingreso : ingresos){
        if(ingreso.getCochera().getIdCochera() == c.getIdCochera() && ingreso.getLugar().getNroLugar() == (i+1)){
          ocupado = true;
          patente = ingreso.getVehiculo().getPatente();
          tipo = ingreso.getTipo().toUpperCase();
        }
      }
    %>
    <div style="width:9rem; height:9rem;"class="card bg-<%=ocupado ? "danger" : "success"%> text-white shadow">
      <div class="card-body"><%=i+1%>
      <div class="text-white-50 small"><%=ocupado ? "Ocupado" : "Libre"%></div>
      <%if(ocupado){%>
      <div class="text-white-50 small"><%=patente%></div>
      <div class="text-white-50 small">Tipo: <span class="badge badge-pill badge-warning"><%=tipo%></span></div>
      <%}%>
      </div>
    </div>
    <%}%>
  </div>
</c:set>

<t:template>
    <jsp:body>
        ${bodyContent}
    </jsp:body>
</t:template>
