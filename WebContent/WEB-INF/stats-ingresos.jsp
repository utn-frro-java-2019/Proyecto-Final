<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%String webAlertMessage = (String)request.getAttribute("webAlertMessage");%>
<%String webAlertType = (String)request.getAttribute("webAlertType");%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DateFormat"%>
<%@page import="domain.Ingreso"%>
<%@page import="domain.Cochera"%>

<%ArrayList<Ingreso> ingresos = (ArrayList<Ingreso>)request.getAttribute("ingresos");%>
<%ArrayList<Cochera> cocheras = (ArrayList<Cochera>)request.getAttribute("cocheras");%>
<%String idCochera = request.getParameter("idCochera");%>
<%java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");%>

<c:set var="bodyContent">

  <%if(webAlertMessage != null){%>
  <div class="alert alert-<%=webAlertType%> alert-dismissible fade show webAlert" role="alert">
	<%=webAlertMessage%>
	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
	  <span aria-hidden="true">&times;</span>
	</button>
  </div>
  <%}%>

  <h1 class="h5 text-gray-800">Estadísticas</h1>
  <h1 class="h3 mb-4 text-gray-800">Ingresos diarios por cochera</h1>
  <form action="/Cocheras/stats/ingresos" method="post">
    <div class="form-row">
      <div class="form-group col-md-3 mb-3">
        <label for="idCochera">Cochera</label>
        <select id="idCochera" name="idCochera" class="form-control" value="<%=idCochera%>">
          <%for(Cochera cochera : cocheras){%>
          <option value="<%=cochera.getIdCochera()%>" <%= idCochera != null && cochera.getIdCochera() == Integer.parseInt(idCochera) ? "selected" : ""%>><%=cochera.getNombre()%></option>
          <%}%>
        </select>
      </div>
      <div class="form-group col-md-3 mb-3" style="display: flex; align-items: flex-end;">
        <button type="submit" class="btn btn-primary">Filtrar</button>
      </div>
    </div>
  </form>

  <%if(ingresos != null && ingresos.size() > 0){%>
  <div class="card shadow mb-3">
    <div class="card-body">
      <div class="chart-area">
        <canvas id="myAreaChart"></canvas>
      </div>
     </div>
  </div>
  <%}%>

  <!-- Page level plugins -->
  <script src="/Cocheras/vendor/chart.js/Chart.min.js"></script>
  <!-- Page level custom scripts -->
  <script>
    // Set new default font family and font color to mimic Bootstrap's default styling
  Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
  Chart.defaults.global.defaultFontColor = '#858796';

  function number_format(number, decimals, dec_point, thousands_sep) {
    // *     example: number_format(1234.56, 2, ',', ' ');
    // *     return: '1 234,56'
    number = (number + '').replace(',', '').replace(' ', '');
    var n = !isFinite(+number) ? 0 : +number,
      prec = !isFinite(+decimals) ? 0 : Math.abs(decimals),
      sep = (typeof thousands_sep === 'undefined') ? ',' : thousands_sep,
      dec = (typeof dec_point === 'undefined') ? '.' : dec_point,
      s = '',
      toFixedFix = function(n, prec) {
        var k = Math.pow(10, prec);
        return '' + Math.round(n * k) / k;
      };
    // Fix for IE parseFloat(0.55).toFixed(0) = 0;
    s = (prec ? toFixedFix(n, prec) : '' + Math.round(n)).split('.');
    if (s[0].length > 3) {
      s[0] = s[0].replace(/\B(?=(?:\d{3})+(?!\d))/g, sep);
    }
    if ((s[1] || '').length < prec) {
      s[1] = s[1] || '';
      s[1] += new Array(prec - s[1].length + 1).join('0');
    }
    return s.join(dec);
  }

  <%if(ingresos != null){%>
  var ingresos = [];

  <%for(Ingreso ingreso : ingresos){%>
  ingresos.push({
    fecha: "<%=dateFormat.format(ingreso.getFechaIngreso())%>",
    tipo: "<%=ingreso.getTipo()%>",
  });
  <%}%>

  const calculateDay = (offset) => {
    var dateOffset = (24*60*60*1000) * offset;
    var date = new Date();
    date.setTime(date.getTime() - dateOffset);

    var day = date.getDate()
    var month = date.getMonth() + 1
    var year = date.getFullYear()

    return "" + (day <= 9 ? "0" + day : day) + "/" + (month <= 9 ? "0" + month : month) + "/" + year;
  }

  var labels = []

  for (var i = 60; i >= -60; i--) {
    labels.push(calculateDay(i));
  }
  
  var data = [];

  labels.forEach(function(label) {
    var total = 0;

    ingresos.forEach(function(e) {
      console.log(e.fecha);
      if(e.fecha == label){
        total += 1;
      }
    });

    data.push(total);
  });

  const start = data.findIndex(e => e > 0);
  labels = labels.slice(start);
  data = data.slice(start);

  data.reverse()
  labels.reverse()
  const end = data.findIndex(e => e > 0);
  labels = labels.slice(end);
  data = data.slice(end);
  data.reverse()
  labels.reverse()
  <%}%>

  // Area Chart Example
  var ctx = document.getElementById("myAreaChart");
  var myLineChart = new Chart(ctx, {
    type: 'line',
    data: {
      labels: labels,
      datasets: [{
        label: "Ingresos",
        lineTension: 0.3,
        backgroundColor: "rgba(78, 115, 223, 0.05)",
        borderColor: "rgba(78, 115, 223, 1)",
        pointRadius: 3,
        pointBackgroundColor: "rgba(78, 115, 223, 1)",
        pointBorderColor: "rgba(78, 115, 223, 1)",
        pointHoverRadius: 3,
        pointHoverBackgroundColor: "rgba(78, 115, 223, 1)",
        pointHoverBorderColor: "rgba(78, 115, 223, 1)",
        pointHitRadius: 10,
        pointBorderWidth: 2,
        data: data,
      }],
    },
    options: {
      maintainAspectRatio: false,
      layout: {
        padding: {
          left: 10,
          right: 25,
          top: 25,
          bottom: 0
        }
      },
      scales: {
        xAxes: [{
          time: {
            unit: 'date'
          },
          gridLines: {
            display: false,
            drawBorder: false
          },
          ticks: {
            maxTicksLimit: 7
          }
        }],
        yAxes: [{
          ticks: {
            maxTicksLimit: 5,
            padding: 10,
            // Include a dollar sign in the ticks
            callback: function(value, index, values) {
              return number_format(value);
            }
          },
          gridLines: {
            color: "rgb(234, 236, 244)",
            zeroLineColor: "rgb(234, 236, 244)",
            drawBorder: false,
            borderDash: [2],
            zeroLineBorderDash: [2]
          }
        }],
      },
      legend: {
        display: false
      },
      tooltips: {
        backgroundColor: "rgb(255,255,255)",
        bodyFontColor: "#858796",
        titleMarginBottom: 10,
        titleFontColor: '#6e707e',
        titleFontSize: 14,
        borderColor: '#dddfeb',
        borderWidth: 1,
        xPadding: 15,
        yPadding: 15,
        displayColors: false,
        intersect: false,
        mode: 'index',
        caretPadding: 10,
        callbacks: {
          label: function(tooltipItem, chart) {
            var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
            return datasetLabel + ': ' + number_format(tooltipItem.yLabel);
          }
        }
      }
    }
  });
  
  </script>
</c:set>

<t:template>
    <jsp:body>
        ${bodyContent}
    </jsp:body>
</t:template>
