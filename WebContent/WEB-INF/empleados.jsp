<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@page import="domain.Empleado"%>
<%@page import="java.util.ArrayList"%>
<%ArrayList<Empleado> le = (ArrayList<Empleado>)request.getAttribute("listaEmpleado");%>

<c:set var="bodyContent">
  <h1 class="h3 mb-4 text-gray-800">Administrar Empleados</h1>
  <div class="row  mb-3">
    <div class="col col-auto d-flex">
      <a class="d-flex align-items-center btn btn-primary" href="http://localhost:8080/Cocheras/empleados/create">Añadir Empleado</a>
    </div>
    <form class="col">
      <div class="input-group">
        <input type="text" class="form-control bg-light border border-primary p-4" placeholder="Buscar empleado" aria-label="Search" aria-describedby="basic-addon2">
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
                  <a href="http://localhost:8080/Cocheras/empleados/details/<%=e.getDni()%>" class="d-flex align-items-center btn btn-warning m-1">
                    <i class="fas fa-edit fa-xs m-1"></i>Editar
                  </a>
                  <a href="http://localhost:8080/Cocheras/empleados/delete/<%=e.getDni()%>" class="d-flex align-items-center btn btn-danger m-1">
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
