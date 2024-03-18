<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%String nombre = (String)request.getSession().getAttribute("name");%>
<%String apellido = (String)request.getSession().getAttribute("surname");%>
<%String tipoDeCuenta = (String)request.getSession().getAttribute("accountType");%>
<%String cochera = (String)request.getSession().getAttribute("cochera");%>
<%String turno = (String)request.getSession().getAttribute("turno");%>


<c:set var="bodyContent">
<div class="d-flex flex-column align-items-center" style="margin-top: 64px">
    <h1 class="mb-8 text-center"><i class="fas fa-car mr-2"></i>Cocheras</h1>
    <h2 class="text-center">Bienvenido <span class="text-primary"><%=nombre%> <%=apellido%></span></h2> 
    <div style="margin-top: 16px; margin-bottom: 32px">
        <p class="text-center"> Tu rango es: 
            <span class="badge badge-primary <%=tipoDeCuenta == "jefe" ? "bg-success" : "bg-primary"%>">
                <%=tipoDeCuenta == "jefe" ? "Jefe de cochera" : "Empleado"%>
            </span>
        </p>
        <%if(tipoDeCuenta == "empleado"){%>
        <p class="text-center"> Tu cochera asignada es:
            <span class="badge badge-primary bg-info">
                <%=cochera%>
            </span>
        </p>
        <p class="text-center"> Tu turno es:
            <span class="badge badge-primary bg-info">
                <%=turno%>
            </span>
        </p>
        <%}%>
    </div>
    <a class="btn btn-link text-center" href="/Cocheras/logout">Cerrar sesión</a>
</div>
</c:set>

<t:template>
    <jsp:body>
        ${bodyContent}
    </jsp:body>
</t:template>
