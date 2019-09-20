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
				<li><a href="JobList" class="scrollto ">Joblist</a></li>
				<li><a href="jobPost.jsp" class="scrollto active">Post-Job</a></li>
				<li><a href="addEmployee.jsp" class="scrollto">Add-Employee</a></li>
				<li><a href="Logout" class="scrollto">Logout</a></li>
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
<form action="JobPost" method="post">
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-8" style="margin-left:10%; margin-top:1%;">
	<div class="row">
	<div class="col-xs-3">
		 <div class="form-group">
				<label>Job Title </label>
				<input type="text" name="Title" placeholder="Job Title" class="form-control" required/>
			</div>

	</div>
	<div class="col-xs-3" >
			<div class="form-group">
				<label>Description</label>
					 <input type="text" name="Description" rows="15" placeholder="Description" class="form-control" required/>

			</div>
	</div>
	<div class="col-xs-3" >
			<div class="form-group">
				<label>Eligibility</label>
					 <input type="text" name="Eligibility" rows="15" placeholder="Eligibility" class="form-control" required/>

			</div>
	</div>
	</div> <!---------------row1------------->
	
	<div class="row" style="margin-top:4%;">
	<div class="col-xs-3">
		 <div class="form-group">
				<label>Technology Required </label>
				<input type="text" name="TechReq" placeholder="Technology Required" class="form-control" required/>
			</div>

	</div>
	<div class="col-xs-3" >
			<div class="form-group">
				<label>Location</label>
					 <input type="text" name="Location" rows="15" placeholder="Location" class="form-control" required/>

			</div>
	</div>
	<div class="col-xs-3" >
			<div class="form-group">
				<label>Experience Required</label>
					 <input type="text" name="ExpRequired" rows="15" placeholder="Experience Required" class="form-control" required/>

			</div>
	</div>
	</div><!------------------------------row3--------------------->
	<div class="row"  style="margin-top:4%;">
	<div class="col-xs-3">
		 <div class="form-group">
				<label>Package </label>
				<input type="text" name="Package" placeholder="Package" class="form-control" required/>
			</div>

	</div>
	<div class="col-xs-3" >
			<div class="form-group">
				<label>Expire Date of Job</label>
					 <input type="Date" name="ExpireDate"  class="form-control" style="padding:8px 10px;" required/>
				
			</div>
	</div>
	
	<div class="col-xs-3">
		<label for="gap">Gap</label>
			<div class="form-group">
				
					</br>
					
					 <input name="gap" type="radio" value="Yes" required />Yes 
					
					
					 <input name="gap" type="radio" value="No"  checked="checked" required align="right" />No

			</div>
	</div>
	</div>
	
	<!------------------------row2--------------------->
	<div class="row" >
	<div class="col-xs-3">
			<button type="submit" class="btn btn-blue" >Post-Job</button>
	</div>
	</div>
	</div>

</form>


</body>
</html>
