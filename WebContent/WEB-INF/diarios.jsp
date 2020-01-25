<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

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

  <h1 class="h5 text-gray-800">Estacionamiento Diario</h1>
  <h1 class="h3 mb-4 text-gray-800">Listado de Ingresos y Salidas</h1>
  <div class="row"></div>
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
              <th class="nw">Monto</th>
              <th class="nw">Estado</th>
            </tr>
          </tfoot>
          <tbody>
            <tr>
              <td class="nw">1221</td>
              <td class="nw">18</td>
              <td class="nw">xxx111</td>
              <td class="nw">xx/xx/xxxx xx:xxx</td>
              <td class="nw">yy/yy/yyyy yy:yy</td>
              <td class="nw">$150</td>
              <td class="nw"><span class="badge badge-pill badge-dark">Finalizado</span></td>
            </tr>
            <tr>
              <td class="nw">1225</td>
              <td class="nw">12</td>
              <td class="nw">xxx111</td>
              <td class="nw">ee/ee/eeee ee:ee</td>
              <td class="nw">---</td>
              <td class="nw">---</td>
              <td class="nw"><span class="badge badge-pill badge-info">En curso</span></td>
            </tr>
            <tr>
              <td class="nw">1231</td>
              <td class="nw">13</td>
              <td class="nw">xxx111</td>
              <td class="nw">xx/xx/xxxx xx:xxx</td>
              <td class="nw">yy/yy/yyyy yy:yy</td>
              <td class="nw">$220</td>
              <td class="nw"><span class="badge badge-pill badge-dark">Finalizado</span></td>
            </tr>
            <tr>
              <td class="nw">1232</td>
              <td class="nw">2</td>
              <td class="nw">xxx111</td>
              <td class="nw">uu/uu/uuuu uu:uuu</td>
              <td class="nw">pp/pp/pppp pp:pp/td>
              <td class="nw">$80</td>
              <td class="nw"><span class="badge badge-pill badge-dark">Finalizado</span></td>
            </tr>
            <tr>
              <td class="nw">1236</td>
              <td class="nw">52</td>
              <td class="nw">xxx111</td>
              <td class="nw">ss/ss/ssss ss:sss</td>
              <td class="nw">hh/hh/hhhh hh:hh</td>
              <td class="nw">$110</td>
              <td class="nw"><span class="badge badge-pill badge-dark">Finalizado</span></td>
            </tr>
            <tr>
              <td class="nw">1242</td>
              <td class="nw">8</td>
              <td class="nw">xxx111</td>
              <td class="nw">hh/hh/hhhh hh:hh</td>
              <td class="nw">---</td>
              <td class="nw">---</td>
              <td class="nw"><span class="badge badge-pill badge-info">En curso</span></td>
            </tr>
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
