<!DOCTYPE html>
<html lang="en">
<%@page import="domain.Empleado"%>
<%@page import="java.util.ArrayList"%>
<%ArrayList<Empleado> le = (ArrayList<Empleado>)request.getAttribute("listaEmpleado");%>

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SB Admin 2 - Blank</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/sb-admin-2.min.css" rel="stylesheet">

  <!-- Custom styles for this page -->
  <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

  <style media="screen">
    .nw {
      white-space: nowrap;
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
        <a class="nav-link" href="#">
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
        <a class="nav-link" href="#">
          <i class="fas fa-flag-checkered"></i>
          <span>Administrar cocheras</span></a>
      </li>

      <!-- Nav Item - Empleados -->
      <li class="nav-item">
        <a class="nav-link" href="#">
          <i class="fas fa-user-edit"></i>
          <span>Administrar Empleados</span></a>
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
            <a class="collapse-item" href="#"><i class="fas fa-arrow-circle-right"></i> Registrar ingreso</a>
            <a class="collapse-item" href="#"><i class="fas fa-arrow-circle-left"></i> Registrar salida y cobro</a>
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
      <hr class="sidebar-divider d-none d-md-block">

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
                <span class="mr-2 d-none d-inline text-gray-600 small">Juan Lopez</span>
                <img class="img-profile rounded-circle" src="https://source.unsplash.com/1R63taCoSnM/60x60">
              </a>
              <!-- Dropdown - User Information -->
              <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                <a class="dropdown-item" href="#">
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
          <h1 class="h3 mb-4 text-gray-800">Administrar Empleados</h1>
          <div class="row  mb-3">
            <div class="col col-auto d-flex">
              <button class="btn btn-primary" type="button" name="button">Añadir Empleado</button>
            </div>
            <form class="col">
              <div class="input-group">
                <input type="text" class="form-control bg-light border border-primary p-4" placeholder="Buscar Empleado" aria-label="Search" aria-describedby="basic-addon2">
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
                      <td class="nw"><%=e.getEmail()%>td>
                      <td class="nw">12566521</td>
                      <td class="nw">55211256</td>
                      <td class="d-flex align-items-center p-0">
                        <button type="button" class="d-flex align-items-center btn btn-warning m-1">
                          <i class="fas fa-edit fa-xs m-1"></i>
                          <p class="d-none d-md-block m-0">Editar</p>
                        </button>
                        <button type="button" class="d-flex align-items-center btn btn-danger m-1">
                          <i class="fas fa-trash-alt fa-xs m-1"></i>
                          <p class="d-none d-md-block m-0">Eliminar</p>
                        </button>
                        <button type="button" class="d-flex align-items-center btn btn-primary m-1">
                          <i class="fas fa-envelope fa-xs m-1"></i>
                          <p class="d-none d-md-block m-0" style="white-space: nowrap">Enviar Correo</p>
                        </button>
                      </td>
                    </tr>
                    <%}%>
                    
                  </tbody>
                </table>
              </div>
            </div>
          </div>

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


  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin-2.min.js"></script>

  <!-- Page level plugins -->
  <script src="vendor/datatables/jquery.dataTables.min.js"></script>
  <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="js/demo/datatables-demo.js"></script>

</body>

</html>
