<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@page import="domain.MultiplicadorEstadia"%>
<%@page import="domain.TipoVehiculo"%>
<%@page import="java.util.ArrayList"%>

<%double precioPorHora = (double)request.getAttribute("precioPorHora");%>
<%ArrayList<MultiplicadorEstadia> me = (ArrayList<MultiplicadorEstadia>)request.getAttribute("listaMultiplicadoresEstadia");%>
<%ArrayList<TipoVehiculo> tv = (ArrayList<TipoVehiculo>)request.getAttribute("listaTiposVehiculos");%>

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

  <div class="row mb-3">
            <div class="col-lg-12">
      		  <h5 class="h5 mb-3 ml-2 text-gray-800">Configuraciones</h5>
      		  
              <!-- Collapsable Card Example -->
              <div class="card shadow mb-4">
                <!-- Card Header - Accordion -->
                <a href="#precioHora" class="d-block card-header py-3" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="precioHora">
                  <h6 class="m-0 font-weight-bold text-primary">Precio por hora</h6>
                </a>
                <!-- Card Content - Collapse -->
                <div class="collapse show" id="precioHora">
                  <div class="card-body">
                    <form name="precioPorHora-edit" method="post" action="/Cocheras/configuration/editPH">
                      <div class="form-group row">
                        <div class="col-sm-12 mb-3 mb-sm-0">
                          <input type="number" min="0.001" step="any" class="form-control form-control-user" name="precioBase" value="<%=precioPorHora%>">
                        </div>
                      </div>
					            <button type="submit" class="btn btn-danger">Actualizar</button>
                    </form>
                  </div>
                </div>
              </div>

			  <hr>

              <!-- Collapsable Card Example -->
              <div class="card shadow mb-4">
                <!-- Card Header - Accordion -->
                <a href="#preciosEstadias" class="d-block card-header py-3" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="preciosEstadias">
                  <h6 class="m-0 font-weight-bold text-primary">Precios por tiempo de estadía</h6>
                </a>
                <!-- Card Content - Collapse -->
                <div class="collapse show" id="preciosEstadias">
                  <div class="card-body">
                    <div class="row  mb-3">
					    <div class="col col-auto d-flex">
					    	<a class="d-flex align-items-center btn btn-primary" href="/Cocheras/configuration/createME">Añadir descuento</a>
					    </div>
				    </div>
                    <div class="table-responsive">
                      <table class="table table-bordered dataTable" width="100%" cellspacing="0">
                        <thead>
                          <tr>
                            <th class="nw">A partir de</th>
                            <th class="nw">Porcentaje sobre el precio base</th>
                            <th class="nw">Opciones</th>
                          </tr>
                        </thead>
                        <tfoot>
                          <tr>
                            <th class="nw">A partir de</th>
                            <th class="nw">Porcentaje sobre el precio base</th>
                            <th class="nw">Opciones</th>
                          </tr>
                        </tfoot>
                        <tbody>
                        <%for(MultiplicadorEstadia m: me){%>
                          <tr>
                            <td class="nw"><%=m.getMultiplicadorDesde()%> días</td>
                            <td class="nw"><%=m.getPorcentajeMultiplicador()*100%>%</td>
			                <td class="d-flex align-items-center p-0">
			                  <a href="/Cocheras/configuration/deleteME/<%=m.getMultiplicadorDesde()%>" class="d-flex align-items-center btn btn-danger m-1">
			                    <i class="fas fa-trash-alt fa-xs m-1"></i>Eliminar
			                  </a>
			                </td>
                          </tr>
                          <%}%>
                        </tbody>
                      </table>
                    </div>
                  </div>
                </div>
              </div>

			  <hr>

              <!-- Collapsable Card Example -->
              <div class="card shadow mb-4">
                <!-- Card Header - Accordion -->
                <a href="#categoriasDeVehiculos" class="d-block card-header py-3" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="categoriasDeVehiculos">
                  <h6 class="m-0 font-weight-bold text-primary">Categorías de vehículos</h6>
                </a>
                <!-- Card Content - Collapse -->
                <div class="collapse show" id="categoriasDeVehiculos">
                  <div class="card-body">
                    <div class="row  mb-3">
				   		<div class="col col-auto d-flex">
				    		<a class="d-flex align-items-center btn btn-primary" href="/Cocheras/configuration/createTV">Añadir tipo de vehículo</a>
						</div>
				    </div>
                    <div class="table-responsive">
                      <table class="table table-bordered dataTable" width="100%" cellspacing="0">
                        <thead>
                          <tr>
                            <th class="nw">Descripción</th>
                            <th class="nw">Porcentaje sobre el precio base</th>
                            <th class="nw">Opciones</th>
                          </tr>
                        </thead>
                        <tfoot>
                          <tr>
                            <th class="nw">Descripción</th>
                            <th class="nw">Porcentaje sobre el precio base</th>
                            <th class="nw">Opciones</th>
                          </tr>
                        </tfoot>
                        <tbody>
                        <%for(TipoVehiculo t: tv){%>                        
                          <tr>
                            <td class="nw"><%=t.getDescripcion()%></td>
                            <td class="nw"><%=t.getPorcentajeMultiplicador()*100%>%</td>
			                <td class="d-flex align-items-center p-0">
			                  <a href="/Cocheras/configuration/detailsTV/<%=t.getIdTipo()%>" class="d-flex align-items-center btn btn-warning m-1">
			                    <i class="fas fa-edit fa-xs m-1"></i>Editar
			                  </a>
			                  <a href="/Cocheras/configuration/deleteTV/<%=t.getIdTipo()%>" class="d-flex align-items-center btn btn-danger m-1">
			                    <i class="fas fa-trash-alt fa-xs m-1"></i>Eliminar
			                  </a>
			                </td>
                          </tr>
                          <%}%>                          
                        </tbody>
                      </table>
                    </div>
                  </div>
                </div>
              </div>
              
              <hr>
			
              <!-- Collapsable Card Example -->
              <div class="card shadow mb-4">
                <!-- Card Header - Accordion -->
                <a href="#datosEmpresa" class="d-block card-header py-3" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="datosEmpresa">
                  <h6 class="m-0 font-weight-bold text-primary">Datos de la empresa</h6>
                </a>
                <!-- Card Content - Collapse -->
                <div class="collapse show" id="datosEmpresa">
                  <div class="card-body">
                  </div>
                </div>
              </div>
	
            </div>
  </div>
</c:set>

<t:template>
    <jsp:body>
        ${bodyContent}
    </jsp:body>
</t:template>
