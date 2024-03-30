<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%String webAlertMessage = (String)request.getAttribute("webAlertMessage");%>
<%String webAlertType = (String)request.getAttribute("webAlertType");%>

<!DOCTYPE html>
<html lang="en" class="h-100">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />

    <title>Cocheras - Login</title>

    <!-- Custom fonts for this template-->
    <link
      href="vendor/fontawesome-free/css/all.min.css"
      rel="stylesheet"
      type="text/css"
    />
    <link
      href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
      rel="stylesheet"
    />

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2-custom.min.css" rel="stylesheet" />
  </head>

  <body
    class="bg-gradient-success h-100 d-flex flex-column justify-content-center align-items-center"
  >
    <div class="container">
      <!-- Outer Row -->
      <div class="row justify-content-center">
        <div class="col-xl-5 col-lg-6 col-md-8">
          <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
              <!-- Nested Row within Card Body -->
              <div class="row">
                <div class="col">
                  <div class="p-5">
                    <div class="text-center">
                      <h1 class="h4 text-gray-900 mb-1">Cocheras</h1>
                      <p class="mb-4">
                        Usted está accediendo como:
                        <span class="badge badge-secondary"
                          >Jefe de cocheras</span
                        >
                      </p>
                    </div>
                    <%if(webAlertMessage != null){%>
                    <div class="alert alert-<%=webAlertType%> alert-dismissible fade show webAlert" role="alert">
                    <%=webAlertMessage%>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                    </div>
                    <%}%>
                    <form
                      class="user"
                      method="post"
                      action="/Cocheras/login-jefe"
                      name="login-boss"
                    >
                      <div class="form-group">
                        <input
                          name="email"
                          type="email"
                          placeholder="Ingrese su email..."
                          class="form-control form-control-user"
                        />
                      </div>
                      <div class="form-group">
                        <input
                          name="password"
                          type="password"
                          placeholder="Contraseña"
                          class="form-control form-control-user"
                        />
                      </div>
                      <button
                        class="btn btn-success btn-user btn-block"
                        type="submit"
                      >
                        Ingresar
                      </button>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <a
        href="/Cocheras/login-empleado"
        class="text-white position-absolute mb-3 mr-4"
        style="bottom: 0; right: 0"
        ><i class="fas fa-user"></i> - Acceder como empleado</a
      >
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

  <script type="text/javascript">
    $(".webAlert").fadeTo(3500, 500).slideUp(500, function(){
        $(".webAlert").slideUp(500);
    });
  </script>
  
  </body>
</html>
