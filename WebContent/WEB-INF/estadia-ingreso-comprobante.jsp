<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="domain.Estadia"%>
<%Estadia estadia = (Estadia) request.getAttribute("estadia");%>


<c:set var="bodyContent">
  <div class="row justify-content-md-center">
    <div class="col-lg-11" style="max-width: 600px">
      <h5 class="h5 text-gray-800">Estacionamiento estadia</h5>
      <h1 class="h3 mb-4 text-gray-800">Comprobante de Ingreso</h1>

      <div id="toPrint" style="display: none">
        <div style="border: 3px solid; padding: 20px; display: inline-block; font-family: monospace">
          <p style="font-size:25px">Fecha: <b><%=estadia.getFechaIngreso()%></b></p>
          <p style="font-size:25px">Patente: <b><%=estadia.getVehiculo().getPatente()%></b></p>
          <p style="font-size:25px">Lugar: <b><%=estadia.getLugar().getNroLugar()%></b></p>
          <p style="font-size:25px">Cochera: <b><%=estadia.getLugar().getCochera().getNombre()%></b></p>
          <hr>
          <p style="font-size:25px"><b><%=estadia.getComprobante()%></b></p>
          <p style="font-size:10p; text-align:center"><b>Cocheras</b></p>
        </div>
      </div>

      <div class="card shadow mb-4">
        <div class="card-header py-3">
          <h6 class="m-0 font-weight-bold text-primary">Datos del comprobante</h6>
        </div>
        <div class="card-body">
          <div class="alert alert-info" role="alert">
            El ingreso se ha registrado de forma exitosa.
          </div>
          <div class="form-group row">
            <div class="col-sm-12 mb-3 mb-sm-0">
             <label class="mb-0 ml-1" for="id">Id de Ingreso</label>
              <input class="form-control form-control-user" type="text" name="id" value="<%=estadia.getComprobante()%>" readonly>
            </div>
          </div>
          <div class="form-group row">
            <div class="col-sm-5">
              <label class="mb-0 ml-1" for="fechaI">Fecha</label>
              <input class="form-control form-control-user" type="text" name="fechaI" value="<%=estadia.getFechaIngreso()%>" readonly>
            </div>
            <div class="col-sm-4 mb-3 mb-sm-0">
              <label class="mb-0 ml-1" for="patente">Patente</label>
              <input class="form-control form-control-user" type="text" name="patente" value="<%=estadia.getVehiculo().getPatente()%>" readonly>
            </div>
            <div class="col-sm-3 mb-3 mb-sm-0">
              <label class="mb-0 ml-1" for="lugar">Lugar</label>
              <input class="form-control form-control-user" type="text" name="lugar" value="<%=estadia.getLugar().getNroLugar()%>" readonly>
            </div>

          </div>
        </div>
      </div>
      <div class="row justify-content-center mb-4">
        <button class="btn btn-success" type="button" onclick="javascript:printComprobante()">
          <i class="fas fa-print mr-1"></i> Imprimir
        </button>
      </div>
      <div class="row justify-content-center">
        <a href="/Cocheras/estadias/ingreso" class="btn btn-primary">
          <i class="fas fa-arrow-circle-left m-1"></i>
          Registrar otro ingreso
        </a>
      </div>
    </div>
  </div>
  <script type="text/javascript">
    function printComprobante() {
      let printContents = document.getElementById('toPrint').innerHTML;
      w = window.open();
      w.document.write(printContents);
      w.document.close(); // necessary for IE >= 10
      w.focus(); // necessary for IE >= 10
      w.print();
      //w.close();
      return true;
    }
  </script>
</c:set>

<t:template>
    <jsp:body>
        ${bodyContent}
    </jsp:body>
</t:template>
