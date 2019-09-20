<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>VRPS</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="css/animate.css">
	<link id="main" rel="stylesheet" type="text/css" href="css/publisher.css">
	<style>
	.active{
	color: white !important;}
	.btn{
	padding: 10px 30px;
    margin: 14px 10px;}
	.bg{
	background-color: #f5f5f5;
	width: 100vw;
	height: 100vh;}
	.rowback{
	margin: 1%;
	}
	.bottommarg{
	height: 434px;
	}
	.navbar-default {
    background-color: #02a299;
    border-color: transparent;
}
	.btn {
	display:inline-block;
	font-family:'Proxima Bold';
	font-size:18px;
	font-weight: bold;
	padding:10px 20px;
	border-radius:3px;
	transition: all 0.3s ease;
}
.btn.btn-blue {
	background: #02a299;
    border: 3px solid #02a299;
    color: white;
}

.btn.btn-white {
	border:3px solid white;
	background: transparent;
	color:white;
}

.btn.btn-white:hover {
	background:white;
	color:#4249A3;
}
	</style>
</head>
	
<nav class="navbar navbar-default">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			
			<a class="navbar-brand" href="#"><img src=" " alt=""></a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right main-nav">
				<li><a href="Required" class="scrollto "  >Selection</a></li>
				<li><a href="ApplicantData" class="scrollto " >Application</a></li>
				<li><a href="JobList" class="scrollto">Joblist</a></li>
				<li><a href="jobPost.jsp" class="scrollto">Post-Job</a></li>
				<li><a href="addEmployee.jsp" class="scrollto active">Add-Employee</a></li>
				<li><a href="index.jsp" class="scrollto">Logout</a></li>
			</ul>
		</div><!-- /.navbar-collapse -->
	</div><!-- /.container-fluid -->
</nav>

<body class="bg">
<%
	    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);

		if (session == null || session.getAttribute("email") == null) {

			response.sendRedirect("loginPage.jsp");
		}
		
	%>
<form action="AddEmployee" method="post" autocomplete="off">
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-8" style="margin-left:10%; margin-top:1%;">
	<div class="row">
	<div class="col-xs-3">
		 <div class="form-group">
				<label>Employee ID </label>
				<input type="text" name="empid"" placeholder="Employee ID" class="form-control" required>
			</div>

	</div>
	<div class="col-xs-3" >
			<div class="form-group">
				<label>First Name</label>
					 <input type="text" name="empFirstName"" rows="15" placeholder="First Name"  class="form-control" required>

			</div>
	</div>
	<div class="col-xs-3" >
			<div class="form-group">
				<label>Last Name</label>
					 <input type="text" name="empLastName" rows="15" placeholder="Last Name" class="form-control" required>

			</div>
	</div>
	</div> <!---------------row1------------->
	
	<div class="row" style="margin-top:4%;">
	<div class="col-xs-3">
		 <div class="form-group">
				<label>Email </label>
				<input type="text" name="empEmail" placeholder="Email" class="form-control" required>
			</div>

	</div>
	<div class="col-xs-3" >
			<div class="form-group">
				<label>Phone</label>
					 <input type="text" name="empPhone" rows="15" placeholder="Phone" class="form-control" required>

			</div>
	</div>
	<div class="col-xs-3" >
			<div class="form-group">
				<label>Password</label>
					 <input type="password" name="empPassword" rows="15" placeholder="Password" class="form-control" required>

			</div>
	</div>
	
	</div><!------------------------------row3--------------------->
	<div class="row"  style="margin-top:4%;">
	<div class="col-xs-3">
		 <div class="form-group">
				<label>Designation </label>
				<select name="empDesignation" class="form-control" required>
<option>Technical</option>
<option>HR</option>
</select>
				
				
			</div>

	</div>
	<div class="col-xs-3" >
			<div class="form-group">
				<label>Department</label>
					<input type="text" name="empDepartment"" placeholder="Department" class="form-control" required>
				
			</div>
	</div>
	
	<div class="col-xs-3">
		<div class="form-group">
				<label>Role</label>
					<input type="text" name="empRole" placeholder="Role" class="form-control" required>
				
			</div>
			</div>
	</div>
	
	
	<!------------------------row2--------------------->
	<div class="row" style="margin-left:30%;">
	
			<input type="submit" class="btn btn-blue" name="Add Employee"/>
	
	</div>
	</div>
</form>
</body>
</html>
	
