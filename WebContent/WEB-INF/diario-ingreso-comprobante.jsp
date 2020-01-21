<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:set var="bodyContent">
  <div class="row justify-content-md-center">
    <div class="col-lg-11" style="max-width: 600px">
      <h5 class="h5 text-gray-800">Estacionamiento Diario</h5>
      <h1 class="h3 mb-4 text-gray-800">Comprobante de Ingreso</h1>

      <div id="toPrint" style="display: none">
        <div style="border: 3px solid; padding: 20px; display: inline-block; font-family: monospace">
          <p style="font-size:25px">Fecha: <b>xx/xx/xxxx</b></p>
          <p style="font-size:25px">Hora: <b>xx:xx</b></p>
          <p style="font-size:25px">Patente: <b>xxx111</b></p>
          <p style="font-size:25px">Lugar: <b>12</b></p>
          <p style="font-size:25px">Identificador: <b>123456</b></p>
          <div style="display:flex; justify-content: center">
            <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" xml:space="preserve" width="202" height="60" viewBox="0 0 202 60">
            <desc/>
            <rect x="0" y="0" width="202" height="60" style="fill:#ffffff;"/>
            <line fill="none" style="stroke:#000000; stroke-width:4;" x1="2" y1="0" x2="2" y2="60"/>
            <line fill="none" style="stroke:#000000; stroke-width:2;" x1="7" y1="0" x2="7" y2="60"/>
            <line fill="none" style="stroke:#000000; stroke-width:2;" x1="17" y1="0" x2="17" y2="60"/>
            <line fill="none" style="stroke:#000000; stroke-width:2;" x1="23" y1="0" x2="23" y2="60"/>
            <line fill="none" style="stroke:#000000; stroke-width:6;" x1="31" y1="0" x2="31" y2="60"/>
            <line fill="none" style="stroke:#000000; stroke-width:4;" x1="40" y1="0" x2="40" y2="60"/>
            <line fill="none" style="stroke:#000000; stroke-width:4;" x1="46" y1="0" x2="46" y2="60"/>
            <line fill="none" style="stroke:#000000; stroke-width:6;" x1="55" y1="0" x2="55" y2="60"/>
            <line fill="none" style="stroke:#000000; stroke-width:2;" x1="63" y1="0" x2="63" y2="60"/>
            <line fill="none" style="stroke:#000000; stroke-width:4;" x1="68" y1="0" x2="68" y2="60"/>
            <line fill="none" style="stroke:#000000; stroke-width:2;" x1="75" y1="0" x2="75" y2="60"/>
            <line fill="none" style="stroke:#000000; stroke-width:6;" x1="81" y1="0" x2="81" y2="60"/>
            <line fill="none" style="stroke:#000000; stroke-width:4;" x1="90" y1="0" x2="90" y2="60"/>
            <line fill="none" style="stroke:#000000; stroke-width:2;" x1="97" y1="0" x2="97" y2="60"/>
            <line fill="none" style="stroke:#000000; stroke-width:6;" x1="105" y1="0" x2="105" y2="60"/>
            <line fill="none" style="stroke:#000000; stroke-width:4;" x1="112" y1="0" x2="112" y2="60"/>
            <line fill="none" style="stroke:#000000; stroke-width:6;" x1="119" y1="0" x2="119" y2="60"/>
            <line fill="none" style="stroke:#000000; stroke-width:2;" x1="127" y1="0" x2="127" y2="60"/>
            <line fill="none" style="stroke:#000000; stroke-width:4;" x1="134" y1="0" x2="134" y2="60"/>
            <line fill="none" style="stroke:#000000; stroke-width:6;" x1="143" y1="0" x2="143" y2="60"/>
            <line fill="none" style="stroke:#000000; stroke-width:2;" x1="149" y1="0" x2="149" y2="60"/>
            <line fill="none" style="stroke:#000000; stroke-width:2;" x1="155" y1="0" x2="155" y2="60"/>
            <line fill="none" style="stroke:#000000; stroke-width:6;" x1="161" y1="0" x2="161" y2="60"/>
            <line fill="none" style="stroke:#000000; stroke-width:4;" x1="170" y1="0" x2="170" y2="60"/>
            <line fill="none" style="stroke:#000000; stroke-width:4;" x1="178" y1="0" x2="178" y2="60"/>
            <line fill="none" style="stroke:#000000; stroke-width:6;" x1="189" y1="0" x2="189" y2="60"/>
            <line fill="none" style="stroke:#000000; stroke-width:2;" x1="195" y1="0" x2="195" y2="60"/>
            <line fill="none" style="stroke:#000000; stroke-width:4;" x1="200" y1="0" x2="200" y2="60"/>
          </div>
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
            <div class="col-sm-6 mb-3 mb-sm-0">
              <label class="mb-0 ml-1" for="fechaI">Fecha</label>
              <input class="form-control form-control-user" type="text" name="fechaI" value="">
            </div>
            <div class="col-sm-6">
              <label class="mb-0 ml-1" for="horaI">Hora</label>
              <input class="form-control form-control-user" type="text" name="horaI" value="">
            </div>
          </div>
          <div class="form-group row">
            <div class="col-sm-4 mb-3 mb-sm-0">
              <label class="mb-0 ml-1" for="patente">Patente</label>
              <input class="form-control form-control-user" type="text" name="patente" value="">
            </div>
            <div class="col-sm-3 mb-3 mb-sm-0">
              <label class="mb-0 ml-1" for="lugar">Lugar</label>
              <input class="form-control form-control-user" type="text" name="lugar" value="">
            </div>
            <div class="col-sm-5">
              <label class="mb-0 ml-1" for="id">Id de Ingreso</label>
              <input class="form-control form-control-user" type="text" name="id" value="">
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
        <a href="http://localhost:8080/Cocheras/diarios/ingreso" class="btn btn-primary">
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
