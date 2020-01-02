<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SB Admin - Register</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">

</head>

<body class="bg-dark">

  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Register an Account</div>
      <div class="card-body">
        <form method="post" action="StudentHandler" enctype="multipart/form-data">
         <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <div class="form-label-group">
                First Name
                  <input type="text" name="stdfname" class="form-control" placeholder="First Name" required="required" autofocus="autofocus">
                  <input type="hidden" name="usertype" value="student">
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-label-group">
                  Last Name
                  <input type="text" name="stdlname" class="form-control" placeholder="Last Name" placeholder="Last name" required="required">
                </div>
              </div>
            </div>
          </div>
           <div class="form-group">
            <div class="form-label-group">
            Student ID
              <input type="text" name="stdmatric" class="form-control" placeholder="Student ID" required="required">
            </div>
          </div>
           <div class="form-group">
            <div class="form-label-group">
            Email Address
              <input type="email" name="stdemail" class="form-control" placeholder="Email" required="required">
            </div>
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <div class="form-label-group">
                Password
                  <input type="password" name="stdpass" class="form-control" placeholder="Password" required="required">
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-label-group">
                Confirm Password
                  <input type="password" name="stdpass2" class="form-control" placeholder="Confirm Password" required="required">
                </div>
              </div>
            </div>
          </div>
           <div class="form-group">
            <div class="form-label-group">
              Program
              <select name="stdprogram" class="form-control">
              	<option value="Diploma in Computer Science (CS110)">Diploma in Computer Science(CS110)</option>
              	<option value="Bachelor of Computer Science (Hons.) Data Communication and Networking (CS245)">Bachelor of Computer Science (Hons.) Data Communication and Networking (CS245)</option>
              	<option value="Bachelor of Information Technology (Hons.) Information System Engineering (CS246)">Bachelor of Information Technology (Hons.) Information System Engineering (CS246)</option>
              	<option value="Bachelor of Computer Science (Hons.) (CS230)">Bachelor of Computer Science (Hons.) (CS230)</option>
              	<option value="Bachelor of Computer Science (Hons.) Netsentric Computing (CS251)">Bachelor of Computer Science (Hons.) Netsentric Computing (CS251)</option>
              	<option value="Bachelor of Computer Science (Hons.) Multimedia Computing (CS253)">Bachelor of Computer Science (Hons.) Multimedia Computing (CS253)</option>
              	<option value="Diploma in Planting Industry Management (AT110)">Diploma in Planting Industry Management (AT110)</option>
              	<option value="Bachelor od Science (Hons.) in Plantation Technology and Management (AT220)">Bachelor of Science (Hons.) in Plantation Technology and Management (AT220)</option>
              	<option value="Bachelor of Science in Agrotechnology (Hons.) Agronomy (AT222)">Bachelor of Science in Agrotechnology (Hons.) Agronomy (AT222)</option>
              	<option value="Bachelor of Science (Hons.) Agribusiness (AT223)">Bachelor of Science (Hons.) Agribusiness (AT223)</option>
              	<option value="Bachelor of Science (Hons.) in Agrotechnology (Plant Biotechnology) (AT226)">Bachelor of Science (Hons.) in Agrotechnology (Plant Biotechnology) (AT226)</option>
              </select>
            </div>
          </div>
          <div class="form-group">
            <div class="form-label-group">
            Phone Number
              <input type="text" name="stdphone" class="form-control" placeholder="Phone Number" required="required">
            </div>
          </div>
          <div class="form-group">
            <div class="form-label-group">
              Home Address
              <textarea class="form-control" name="stdaddress" required="required" placeholder="Address"></textarea>
            </div>
          </div>
          <div class="form-group">
            <div class="form-label-group">
            	CGPA
              <input type="number" name="stdcgpa" class="form-control" placeholder="CGPA" required="required">
            </div>
          </div>
          <div class="form-group">
          Gender
            <div class="form-row">
                	<div class="col-md-6">
            		Female &nbsp&nbsp&nbsp<input type="radio" name="stdgender" required="required" value="Female">
            	</div>
            	<div class="col-md-6">
            		Male &nbsp&nbsp&nbsp<input type="radio" name="stdgender" required="required" value="Male">
            	</div>
            </div>
          </div>
          <div class="form-group">
            <div class="form-label-group">
            Date Of Birth
              <input type="date" name="stddob" class="form-control" required="required">
            </div>
          </div>
          <div class="form-group">
            <div class="form-label-group">
            Upload Resume
              <input type="file" name="file_uploaded" class="form-control" required="required">
            </div>
          </div>
          <button class="btn btn-primary btn-block" type="submit">Register</button>
        
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="loginpage.jsp">Login Page</a>
          
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

</body>

</html>
