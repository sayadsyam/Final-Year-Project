<!DOCTYPE html>
<html lang="en">

<head>
  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="internsys.model.CompanyBean"
    import="internsys.model.JobBean"
    %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <%

      CompanyBean currentUser = (CompanyBean) session.getAttribute("currentSessionUser");
    %>

    <script>
//Function to check Whether both passwords 
// is same or not. 
function checkPassword(form) { 
    password1 = form.compass.value; 
    password2 = form.compass2.value; 

    // If password not entered 
    if (password1 == '') 
        alert ("Please enter Password"); 
          
    // If confirm password not entered 
    if (password2 == '') 
        alert ("Please confirm password"); 
          
    // If Not same return False.     
    if (password1 != password2) { 
        alert ("\nPlease enter the same value again") 
        return false; 
    } 

   
} 
</script>

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

    <a class="navbar-brand mr-1" href="companyHome.jsp">Jasin eIntern</a>

    <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
      <i class="fas fa-bars"></i>
    </button>

    <!-- Navbar Search -->
    <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
      <div class="input-group">
        <font color="white">Hi  <%=currentUser.getComname()%>! </font>
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
        <a class="nav-link" href="/InternSys/CompanyHandler?action=getCom&id=<%=currentUser.getComid()%>">
          <i class="fas fa-fw fa-user"></i>
          <span>Company Profile</span>
        </a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-fw fa-briefcase"></i>
          <span>Job</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
           <a class="dropdown-item" href="company/jobCreate.jsp">Add Job</a>
          <a class="dropdown-item" href="/InternSys/JobHandler?action=listJob&id=<%=currentUser.getComid()%>">View Job</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/InternSys/InternInfoHandler?action=listStdApp&id=<%=currentUser.getComid()%>">
          <i class="fas fa-fw fa-address-card"></i>
          <span>Application</span></a>
      </li>
      
    </ul>

    <div id="content-wrapper">

      <div class="container-fluid">

        <!-- Breadcrumbs-->
        <ol class="breadcrumb">
          <li class="breadcrumb-item">
            <a href="#">Company</a>
          </li>
          <li class="breadcrumb-item active">Update Company Info</li>
        </ol>

               <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Update Company Info</div>
      <div class="card-body">
        <form method="post" action="CompanyHandler">
          <div class="form-group">
             <div class="form-label-group">
             Company Name
                 <input type="hidden" name="comid" value="<c:out value="${com.comid}" />">
                 <input type="text" name="comname" class="form-control" value="<c:out value="${com.comname}" />" required="required" autofocus="autofocus">
                 
             </div>
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <div class="form-group">
                    <div class="form-label-group">
                      Password
                      <input type="password" name="compass" class="form-control" value="<c:out value="${com.compass}" />" required="required">
                      
                    </div>
                </div>
              </div>
           
          
              <div class="col-md-6">
                <div class="form-group">
                    <div class="form-label-group">
                      Confirm Password
                      <input type="password" name="compass2" class="form-control" value="<c:out value="${com.compass}" />" required="required">
                      
                    </div>
                </div>
              </div>
            </div>
          </div>
          <div class="form-group">
             <div class="form-label-group">
                Company Phone Number
                <input type="text" name="comphone" class="form-control" value="<c:out value="${com.comphone}" />" required="required">
             </div>
          </div>
           <div class="form-group">
             <div class="form-label-group">
                Company Fax Number
                <input type="text" name="comfax" class="form-control" value="<c:out value="${com.comfax}" />" required="required">
             </div>
          </div>
           <div class="form-group">
            <div class="form-label-group">
            Company Description
              <textarea class="form-control" name="comdesc" ><c:out value="${com.comdesc}" /></textarea>                    
            </div>
          </div>
           <div class="form-group">
            <div class="form-label-group">
            Company Address
              <textarea class="form-control" name="comaddress" ><c:out value="${com.comaddress}" /></textarea>                    
            </div>
          </div>
         <div class="form-group">
             <div class="form-label-group">
                State
                <select class="form-control" name="comstate">
                	<option value="Melaka">Melaka</option>
                	<option value="Sabah">Sabah</option>
                	<option value="Sarawak">Sarawak</option>
                	<option value="Johor">Johor</option>
                	<option value="Negeri Sembilan">Negeri Sembilan</option>
                	<option value="Selangor">Selangor</option>
                	<option value="Selangor">Perak</option>
                	<option value="Kedah">Kedah</option>
                	<option value="Perlis">Perlis</option>
                	<option value="Pulau Pinang">Pulau Pinang</option>
                	<option value="Kelantan">Kelantan</option>
                	<option value="Terengganu">Terengganu</option>
                	<option value="Pahang">Pahang</option>
                	<option value="Putrajaya">Putrajaya</option>
                	<option value="Kuala Lumpur">Kuala Lumpur</option>
                	<option value="Labuan">Labuan</option>
                </select>
                 
             </div>
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
            <span>Copyright © Your Website 2019</span>
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
            <span aria-hidden="true">×</span>
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
