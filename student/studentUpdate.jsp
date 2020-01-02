   
<!DOCTYPE html>
<html lang="en">

<head>
  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="internsys.model.StudentBean"
    %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <%
      StudentBean currentUser = (StudentBean) session.getAttribute("currentSessionUser");
    %>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SB Admin - Dashboard</title>

   <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Page level plugin CSS-->
  <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">

</head>

<body id="page-top">

  <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

    <a class="navbar-brand mr-1" href="student/studentHome.jsp">Jasin eIntern</a>

    <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
      <i class="fas fa-bars"></i>
    </button>

    <!-- Navbar Search -->
     <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0" method="post" action="StudentHandler">
      <div class="input-group">
        <font color="white">Hi  <%=currentUser.getStdfname()%>! </font>
        </div>
      </div>
    </form>
    <!-- Navbar -->
    <ul class="navbar-nav ml-auto ml-md-0">
      <li class="nav-item dropdown no-arrow mx-1">
        <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-bell fa-fw"></i>
          <span class="badge badge-danger">9+</span>
        </a>
        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="alertsDropdown">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
      <li class="nav-item dropdown no-arrow mx-1">
        <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-envelope fa-fw"></i>
          <span class="badge badge-danger">7</span>
        </a>
        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="messagesDropdown">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
      <li class="nav-item dropdown no-arrow">
        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-user-circle fa-fw"></i>
        </a>
        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
          <a class="dropdown-item" href="#">Settings</a>
          <a class="dropdown-item" href="#">Activity Log</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="../logout.jsp" data-toggle="modal" data-target="#logoutModal">Logout</a>
        </div>
      </li>
    </ul>

  </nav>

  <div id="wrapper">

    <!-- Sidebar -->
    <ul class="sidebar navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="/InternSys/StudentHandler?action=getStd&id=<%=currentUser.getStdid()%>">
          <i class="fas fa-fw fa-user-graduate"></i>
          <span>My Profile</span>
        </a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link" href="/InternSys/InternInfoHandler?action=listIntern">
          <i class="fas fa-fw fa-briefcase"></i>
          <span>Jobs</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/InternSys/InternInfoHandler?action=viewApply&id=<%=currentUser.getStdid()%>">
          <i class="fas fa-fw fa-address-card"></i>
          <span>Application</span></a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-fw fa-folder"></i>
          <span>Pages</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
          <h6 class="dropdown-header">Login Screens:</h6>
          <a class="dropdown-item" href="login.html">Login</a>
          <a class="dropdown-item" href="register.html">Register</a>
          <a class="dropdown-item" href="forgot-password.html">Forgot Password</a>
          <div class="dropdown-divider"></div>
          <h6 class="dropdown-header">Other Pages:</h6>
          <a class="dropdown-item" href="404.html">404 Page</a>
          <a class="dropdown-item" href="blank.html">Blank Page</a>
        </div>
      </li>
    </ul>

    <div id="content-wrapper">

      <div class="container-fluid">

        <!-- Breadcrumbs-->
        <ol class="breadcrumb">
          <li class="breadcrumb-item">
            <a href="#">My Profile</a>
          </li>
          <li class="breadcrumb-item active">Update Profile</li>
        </ol>

        <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Update Profile</div>
      <div class="card-body">
        <form method="post" action="StudentHandler">
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <div class="form-label-group">
                First Name
                  <input type="hidden" name="stdid" value="<c:out value="${std.stdid}" />">
                  <input type="text" name="stdfname" class="form-control" value="<c:out value="${std.stdfname}" />" required="required" autofocus="autofocus">
                  
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-label-group">
                Last Name
                  <input type="text" name="stdlname" class="form-control" value="<c:out value="${std.stdlname}" />" placeholder="Last name" required="required">
                  
                </div>
              </div>
            </div>
          </div>
          <div class="form-group">
            <div class="form-label-group">
            Student ID
              <input type="text" name="stdmatric" class="form-control" value="<c:out value="${std.stdmatric}" />" required="required">
                        </div>
          </div>
          <div class="form-group">
            <div class="form-label-group">
            Email Address
              <input type="email" name="stdemail" class="form-control" value="<c:out value="${std.stdemail}" />" required="required">
              
            </div>
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <div class="form-label-group">
                Password
                  <input type="password" name="stdpass" class="form-control" value="<c:out value="${std.stdpass}" />" required="required">
                  
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-label-group">
                Confirm Password
                  <input type="password" name="stdpass" class="form-control" value="<c:out value="${std.stdpass}" />" required="required">
                  
                </div>
              </div>
            </div>
          </div>
          <div class="form-group">
            <div class="form-label-group">
              Program
              <select name="stdprogram" class="form-control">
              	<c:if test="${std.stdprogram == 'Diploma in Computer Science (CS110)'}">
                    <option value="Diploma in Computer Science (CS110)" selected>Diploma in Computer Science(CS110)</option>
                </c:if>
                <c:if test="${std.stdprogram == 'Bachelor of Computer Science (Hons.) Data Communication and Networking (CS245)'}">
                    <option value="Bachelor of Computer Science (Hons.) Data Communication and Networking (CS245)" selected>Bachelor of Computer Science (Hons.) Data Communication and Networking (CS245)</option>
                </c:if>
                <c:if test="${std.stdprogram == 'Bachelor of Information Technology (Hons.) Information System Engineering (CS246)'}">
                    <option value="Bachelor of Information Technology (Hons.) Information System Engineering (CS246)" selected>Bachelor of Information Technology (Hons.) Information System Engineering (CS246)</option>
              	</c:if>
              	<c:if test="${std.stdprogram == 'Bachelor of Computer Science (Hons.) (CS230)'}">
                    <option value="Bachelor of Computer Science (Hons.) (CS230)" selected>Bachelor of Computer Science (Hons.) (CS230)</option>
              	</c:if>
              	<c:if test="${std.stdprogram == 'Bachelor of Computer Science (Hons.) Netsentric Computing (CS251)'}">
                    <option value="Bachelor of Computer Science (Hons.) Netsentric Computing (CS251)" selected>Bachelor of Computer Science (Hons.) Netsentric Computing (CS251)</option>
              	</c:if>
              	<c:if test="${std.stdprogram == 'Bachelor of Computer Science (Hons.) Multimedia Computing (CS253)'}">
                    <option value="Bachelor of Computer Science (Hons.) Multimedia Computing (CS253)" selected>Bachelor of Computer Science (Hons.) Multimedia Computing (CS253)</option>
              	</c:if>
              	<c:if test="${std.stdprogram == 'Diploma in Planting Industry Management (AT110)'}">
                    <option value="Diploma in Planting Industry Management (AT110)" selected>Diploma in Planting Industry Management (AT110)</option>
              	</c:if>
              	<c:if test="${std.stdprogram == 'Bachelor of Science (Hons.) in Plantation Technology and Management (AT220)'}">
                    <option value="Bachelor of Science (Hons.) in Plantation Technology and Management (AT220)" selected>Bachelor of Science (Hons.) in Plantation Technology and Management (AT220)</option>
              	</c:if>
              	<c:if test="${std.stdprogram == 'Bachelor of Science in Agrotechnology (Hons.) Agronomy (AT222)'}">
                    <option value="Bachelor of Science in Agrotechnology (Hons.) Agronomy (AT222)" selected>Bachelor of Science in Agrotechnology (Hons.) Agronomy (AT222)</option>
              	</c:if>
              	<c:if test="${std.stdprogram == 'Bachelor of Science (Hons.) Agribusiness (AT223)'}">
                    <option value="Bachelor of Science (Hons.) Agribusiness (AT223)" selected>Bachelor of Science (Hons.) Agribusiness (AT223)</option>
              	</c:if>
              	<c:if test="${std.stdprogram == 'Bachelor of Science (Hons.) in Agrotechnology (Plant Biotechnology) (AT226)'}">
                    <option value="Bachelor of Science (Hons.) in Agrotechnology (Plant Biotechnology) (AT226)" selected>Bachelor of Science (Hons.) in Agrotechnology (Plant Biotechnology) (AT226)</option>
              </c:if>
              	<option value="Diploma in Computer Science (CS110)">Diploma in Computer Science(CS110)</option>
              	<option value="Bachelor of Computer Science (Hons.) Data Communication and Networking (CS245)">Bachelor of Computer Science (Hons.) Data Communication and Networking (CS245)</option>
              	<option value="Bachelor of Information Technology (Hons.) Information System Engineering (CS246)">Bachelor of Information Technology (Hons.) Information System Engineering (CS246)</option>
              	<option value="Bachelor of Computer Science (Hons.) (CS230)">Bachelor of Computer Science (Hons.) (CS230)</option>
              	<option value="Bachelor of Computer Science (Hons.) Netsentric Computing (CS251)">Bachelor of Computer Science (Hons.) Netsentric Computing (CS251)</option>
              	<option value="Bachelor of Computer Science (Hons.) Multimedia Computing (CS253)">Bachelor of Computer Science (Hons.) Multimedia Computing (CS253)</option>
              	<option value="Diploma in Planting Industry Management (AT110)">Diploma in Planting Industry Management (AT110)</option>
              	<option value="Bachelor of Science (Hons.) in Plantation Technology and Management (AT220)">Bachelor of Science (Hons.) in Plantation Technology and Management (AT220)</option>
              	<option value="Bachelor of Science in Agrotechnology (Hons.) Agronomy (AT222)">Bachelor of Science in Agrotechnology (Hons.) Agronomy (AT222)</option>
              	<option value="Bachelor of Science (Hons.) Agribusiness (AT223)">Bachelor of Science (Hons.) Agribusiness (AT223)</option>
              	<option value="Bachelor of Science (Hons.) in Agrotechnology (Plant Biotechnology) (AT226)">Bachelor of Science (Hons.) in Agrotechnology (Plant Biotechnology) (AT226)</option>
              </select>
            </div>
          </div>
          <div class="form-group">
            <div class="form-label-group">
            Phone Number
              <input type="text" name="stdphone" class="form-control" value="<c:out value="${std.stdphone}" />" required="required">
            </div>
          </div>
          <div class="form-group">
            <div class="form-label-group">
              Home Address
              <textarea class="form-control" name="stdaddress" required="required"><c:out value="${std.stdaddress}" /></textarea>
              
            </div>
          </div>
          <div class="form-group">
            <div class="form-label-group">
            CGPA
              <input type="number" name="stdcgpa" class="form-control" value="<c:out value="${std.stdcgpa}" />" required="required">
              
            </div>
          </div>
          <div class="form-group">
          Gender
            <div class="form-row">
                <c:if test="${std.stdgender == 'Female'}">
                <div class="col-md-6">
                		Female &nbsp&nbsp&nbsp<input type="radio" name="stdgender" required="required" value="Female" checked>
               	</div>
            	<div class="col-md-6">
            		Male &nbsp&nbsp&nbsp	
            		<input type="radio" name="stdgender" required="required" value="Male" >
               	</div>
            	</c:if>
            	<c:if test="${std.stdgender == 'Male'}">
                <div class="col-md-6">
                		Female &nbsp&nbsp&nbsp<input type="radio" name="stdgender" required="required" value="Female">
               	</div>
            	<div class="col-md-6">
            		Male &nbsp&nbsp&nbsp	
            		<input type="radio" name="stdgender" required="required" value="Male" checked>
               	</div>
            	</c:if>
            </div>
          </div>
          
          <button class="btn btn-primary btn-block" type="submit">Update</button>
        </form>
        
      </div>
    </div>
  </div>


      </div>
      <!-- /.container-fluid -->

      <!-- Sticky Footer -->
      <footer class="sticky-footer">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright � Your Website 2019</span>
          </div>
        </div>
      </footer>

    </div>
    <!-- /.content-wrapper -->

  </div>
  <!-- /#wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">�</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="login.html">Logout</a>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Page level plugin JavaScript-->
  <script src="vendor/chart.js/Chart.min.js"></script>
  <script src="vendor/datatables/jquery.dataTables.js"></script>
  <script src="vendor/datatables/dataTables.bootstrap4.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin.min.js"></script>

  <!-- Demo scripts for this page-->
  <script src="js/demo/datatables-demo.js"></script>
  <script src="js/demo/chart-area-demo.js"></script>

</body>

</html>
