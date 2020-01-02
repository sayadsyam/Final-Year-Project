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
      <div class="card-header">Register Company</div>
      <div class="card-body">
        <form method="post" action="CompanyHandler">
          <div class="form-group">
             <div class="form-label-group">
                Company Name
                <input type="text" name="comname" class="form-control" placeholder="Company Name" required="required" autofocus="autofocus">
                 <input type="hidden" name="usertype" value="company">
             </div>
          </div>
          <div class="form-group">
             <div class="form-label-group">
                Company Email
                <input type="email" name="comemail" class="form-control" placeholder="Company Name" required="required">
                 
             </div>
          </div>
         <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <div class="form-group">
                    <div class="form-label-group">
                    	Password
                      <input type="password" name="compass" class="form-control" placeholder="Password" required="required">
                      
                    </div>
                </div>
              </div>
             
           
          
              <div class="col-md-6">
                <div class="form-group">
                    <div class="form-label-group">
                    	Confirm Password
                      <input type="password" name="compass2" class="form-control" placeholder="Confirm Password" required="required">
                     
                    </div>
                </div>
              </div>
            </div>
          </div>
           
          <div class="form-group">
             <div class="form-label-group">
                Company Phone Number
                <input type="text" name="comphone" class="form-control" placeholder="Company Phone" required="required">
             </div>
          </div>
           <div class="form-group">
             <div class="form-label-group">
                Company Fax Number
                <input type="text" name="comfax" class="form-control" placeholder="Company Phone" required="required">
             </div>
          </div>
          <div class="form-group">
            <div class="form-label-group">
            Company Description
              <textarea class="form-control" name="comdesc" placeholder="Your company description" required="required"></textarea>                    
            </div>
          </div>
           <div class="form-group">
            <div class="form-label-group">
            Address 
              <textarea class="form-control" name="comaddress" placeholder="Your company address" required="required"></textarea>                    
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
