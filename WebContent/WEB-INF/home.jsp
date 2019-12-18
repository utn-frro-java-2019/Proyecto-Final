<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:set var="bodyContent">
	WELCOME
</c:set>

<t:template>
    <jsp:body>
        ${bodyContent}
    </jsp:body>
</t:template>
