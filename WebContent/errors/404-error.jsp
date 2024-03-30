<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:set var="bodyContent">
<!-- 404 Error -->
<div class="jumbotron bg-transparent">
    <div class="text-center">
        <div class="error mx-auto" data-text="404">404</div>
        <p class="lead text-gray-800 mb-2">Página no encontrada</p>
        <p class="text-gray-500 mb-4">Error al procesar la solicitud.</p>
        <a href="/Cocheras/">&larr; Regresar al Inicio</a>
    </div>
</div>
</c:set>

<t:template>
    <jsp:body>
        ${bodyContent}
    </jsp:body>
</t:template>
