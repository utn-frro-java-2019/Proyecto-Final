<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@page import="domain.Empleado"%>
<%@page import="java.util.ArrayList"%>
<%ArrayList<Empleado> le = (ArrayList<Empleado>)request.getAttribute("listaEmpleado");%>

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

  <h1 class="h3 mb-4 text-gray-800">Administrar Empleados</h1>
  <div class="row  mb-3">
    <div class="col col-auto d-flex">
      <a class="d-flex align-items-center btn btn-primary" href="/Cocheras/empleados/create">Añadir Empleado</a>
    </div>
</div>
    <div class="card shadow mb-4">
      <div class="card-body">
        <div class="table-responsive">
          <table class="table table-bordered dataTable" width="100%" cellspacing="0">
            <thead>
              <tr>
                <th class="nw">Dni</th>
                <th class="nw">Usuario</th>
                <th class="nw">Nombre</th>
                <th class="nw">Apellido</th>
                <th class="nw">Email</th>
                <th class="nw">Teléfono 1</th>
                <th class="nw">Teléfono 2</th>
                <th class="nw">Opciones</th>
              </tr>
            </thead>
            <tfoot>
              <tr>
                <th class="nw">Dni</th>
                <th class="nw">Usuario</th>
                <th class="nw">Nombre</th>
                <th class="nw">Apellido</th>
                <th class="nw">Email</th>
                <th class="nw">Teléfono 1</th>
                <th class="nw">Teléfono 2</th>
                <th class="nw">Opciones</th>
              </tr>
            </tfoot>
            <tbody>
              <%for(Empleado e:le){%>
              <tr>
                <td class="nw"><%=e.getDni()%></td>
                <td class="nw"><%=e.getUsuario()%></td>
                <td class="nw"><%=e.getNombre()%></td>
                <td class="nw"><%=e.getApellido()%></td>
                <td class="nw"><%=e.getEmail()%></td>
                <td class="nw"><%=e.getTelefono1()%></td>
                <td class="nw"><%=e.getTelefono2()%></td>
                <td class="d-flex align-items-center p-0">
                  <a href="/Cocheras/empleados/details/<%=e.getDni()%>" class="d-flex align-items-center btn btn-warning m-1">
                    <i class="fas fa-edit fa-xs m-1"></i>Editar
                  </a>
                  <a href="/Cocheras/empleados/delete/<%=e.getDni()%>" class="d-flex align-items-center btn btn-danger m-1">
                    <i class="fas fa-trash-alt fa-xs m-1"></i>Eliminar
                  </a>
                  <a href="mailto:<%=e.getEmail()%>" style="white-space: nowrap" class="d-flex align-items-center btn btn-primary m-1">
                    <i class="fas fa-envelope fa-xs m-1"></i>Enviar Correo
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
