<%@tag description="Template" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Cocheras</title>

  <link href="http://localhost:8080/Cocheras/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
  <link href="http://localhost:8080/Cocheras/css/sb-admin-2-custom.min.css" rel="stylesheet">
  <link href="http://localhost:8080/Cocheras/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
  <style media="screen">
    .nw {
      white-space: nowrap;
    }
    .nw:empty:before{
		content: "-";
    }
  </style>
</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="#">
        <div class="sidebar-brand-icon">
          <i class="fas fa-car"></i>
        </div>
        <div class="sidebar-brand-text mx-3">Cocheras</div>
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider my-0">

      <!-- Nav Item - Dashboard -->
      <li class="nav-item">
        <a class="nav-link" href="http://localhost:8080/Cocheras/home">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Tablero</span></a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        Dueño de cochera
      </div>

      <!-- Nav Item - Cocheras -->
      <li class="nav-item">
        <a class="nav-link" href="http://localhost:8080/Cocheras/cocheras/all">
          <i class="fas fa-flag-checkered"></i>
          <span>Administrar cocheras</span></a>
      </li>

      <!-- Nav Item - Empleados -->
      <li class="nav-item">
        <a class="nav-link" href="http://localhost:8080/Cocheras/empleados/all">
          <i class="fas fa-user-edit"></i>
          <span>Administrar empleados</span></a>
      </li>
      
      <!-- Nav Item - Configuraciones -->
      <li class="nav-item">
        <a class="nav-link" href="http://localhost:8080/Cocheras/configuration/config">
          <i class="fas fa-sliders-h"></i>
          <span>Editar precios y otros</span></a>
      </li>

      <!-- Nav Item - Estadísticas Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseStats" aria-expanded="true" aria-controls="collapseStats">
          <i class="fas fa-chart-area"></i>
          <span>Estadísticas</span>
        </a>
        <div id="collapseStats" class="collapse" aria-labelledby="headingStats" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Estadísticas de tipo X</h6>
            <a class="collapse-item" href="#">Estadística 1</a>
            <a class="collapse-item" href="#">Estadística 2</a>
            <a class="collapse-item" href="#">Estadística 3</a>
            <div class="collapse-divider"></div>
            <h6 class="collapse-header">Estadísticas de tipo Y</h6>
            <a class="collapse-item" href="#">Estadística 1</a>
            <a class="collapse-item" href="#">Estadística 2</a>
            <a class="collapse-item" href="#">Estadística 3</a>
        </div>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        Empleado
      </div>

      <!-- Nav Item - Diario Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseDiario" aria-expanded="true" aria-controls="collapseDiario">
          <i class="fas fa-clipboard-list"></i>
          <span>Estacionamiento diario</span>
        </a>
        <div id="collapseDiario" class="collapse" aria-labelledby="headingDiario" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <a class="collapse-item" href="http://localhost:8080/Cocheras/diarios/ingreso"><i class="fas fa-arrow-circle-right"></i> Registrar ingreso</a>
            <a class="collapse-item" href="http://localhost:8080/Cocheras/diarios/salida"><i class="fas fa-arrow-circle-left"></i> Registrar salida y cobro</a>
            <a class="collapse-item" href="#"><i class="far fa-list-alt"></i> Listar ingresos y salidas</a>
          </div>
        </div>
      </li>

      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseEstadia" aria-expanded="true" aria-controls="collapseEstadia">
          <i class="fas fa-clipboard-list"></i>
          <span>Estadías</span>
        </a>
        <div id="collapseEstadia" class="collapse" aria-labelledby="headingEstadia" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <a class="collapse-item" href="#"><i class="far fa-calendar-check"></i> Registrar estadía</a>
            <a class="collapse-item" href="#"><i class="far fa-list-alt"></i> Listar estadías</a>
          </div>
        </div>
      </li>


      <!-- Divider -->
      <hr class="sidebar-divider my-0">
      
      <!-- Nav Item - Cocheras -->
      <li class="nav-item">
        <a class="nav-link" href="http://localhost:8080/Cocheras/vehiculos/all">
          <i class="fas fa-car-alt"></i>
          <span>Listado de Vehículos</span></a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Sidebar Toggler (Sidebar) -->
      <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
      </div>

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

          <!-- Sidebar Toggle (Topbar) -->
          <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
            <i class="fa fa-bars"></i>
          </button>


          <!-- Topbar Navbar -->
          <ul class="navbar-nav ml-auto">


            <!-- Nav Item - User Information -->
            <li class="nav-item dropdown no-arrow">
              <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span class="mr-2 d-none d-inline text-gray-600 small">Franco Giannassi</span>
                <img class="img-profile rounded-circle" src="https://source.unsplash.com/1R63taCoSnM/60x60">
              </a>
              <!-- Dropdown - User Information -->
              <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                <a class="dropdown-item" href="http://localhost:8080/Cocheras/user/profile">
                  <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                  Mi perfil
                </a>
                <a class="dropdown-item" href="#">
                  <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                  Configuraciones
                </a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#">
                  <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                  Salir
                </a>
              </div>
            </li>

          </ul>

        </nav>
        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Body -->
            <jsp:doBody/>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

      <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright &copy; Cocheras Co 2019</span>
          </div>
        </div>
      </footer>
      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <script src="http://localhost:8080/Cocheras/vendor/jquery/jquery.min.js"></script>
  <script src="http://localhost:8080/Cocheras/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="http://localhost:8080/Cocheras/vendor/jquery-easing/jquery.easing.min.js"></script>
  <script src="http://localhost:8080/Cocheras/js/sb-admin-2.min.js"></script>
  <script src="http://localhost:8080/Cocheras/vendor/datatables/jquery.dataTables.min.js"></script>
  <script src="http://localhost:8080/Cocheras/vendor/datatables/dataTables.bootstrap4.min.js"></script>
  <script type="text/javascript">
  	$(document).ready(function() {
		$('.dataTable').DataTable({
			"bFilter": false,
			"lengthChange": false
		});
	});
  </script>
  
  <script type="text/javascript">
    $(".webAlert").fadeTo(3500, 500).slideUp(500, function(){
        $(".webAlert").slideUp(500);
    });
  </script>
  
</body>

</html>
