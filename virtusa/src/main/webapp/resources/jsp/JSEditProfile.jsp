<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="javax.swing.JButton"%>
  
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>VRPS</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/animate.css">
	<link id="main" rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/publisher.css">
	<!-- ------------------- -->
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-star-rating/4.0.2/css/star-rating.min.css" />
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-star-rating/4.0.2/js/star-rating.min.js"></script>
	<!-- -------------------------- -->
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
.login-form {
    width: 35%;
    background: rgba(12, 85, 105, 0.51);
    padding-bottom: 1%;
}
	</style>
</head>
	
<nav class="navbar navbar-default">
	<div class="container" >
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			
			<a class="navbar-brand" href="#"><img src=" " alt=""></a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right main-nav">
				<li><a href="JSHome.as" class="scrollto " >JobList</a></li>
				<li><a href="JobSeekerProfile.as" class="scrollto active">Profile</a></li>
				<li><a href="viewStatus.as" class="scrollto">My Application</a></li>
				<li><a href="EmpLogout" class="scrollto">Logout</a></li>
			</ul>
		</div><!-- /.navbar-collapse -->
	</div><!-- /.container-fluid -->
</nav>

<body class="bg">


<section id="author">
	<div class="container" style="margin-top: -5%;">
		<div class="row">
			<div class="col-md-6">
				<div class="row author">
					<div class="col-sm-4">
						<img src="${pageContext.request.contextPath}/resources/img/p1.png" alt="" class="pic">
					</div>
					<div class="col-sm-8 author-name">
						<h2 class="heading wow animated fadeInUp">Id:${jobseeker.jsid}</h2>
						<h2 class="heading wow animated fadeInUp"> Name:${jobseeker.firstName}  ${jobseeker.lastName}</h2>
						<p class="small muted-light wow animated fadeInUp"></p>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	<form action="testg.as" method="post">
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-8" style="margin-left:10%; margin-top:1%;">
	<div class="row">
	<div class="col-xs-3">
	
		 <div class="form-group">
				<label>Date Of Birth</label>
				<input type="Date" name="dob" required  class="form-control">
			</div>
			

	</div>
	<div class="col-xs-3" >
			<div class="form-group">
				<label>Gender</label>
					<select name="gender" class="form-control">
   					 <option value="m">Male</option>
   					 <option value="f">Female</option> 
				</select>

			</div>
	</div>
	</div> <!---------------row1------------->
	
	<div class="row" style="margin-top:4%;">
	<div class="col-xs-3">
	
		 <div class="form-group">
				<label>Address</label>
				<input type="text" name="address" required="" placeholder="Address" class="form-control">
			</div>

	</div>
	<div class="col-xs-3" >
			<div class="form-group">
				<label>City</label>
					 <input type="text" name="city" pattern="([A-Z][a-z]*)" maxlength="20" title="Only First letter should be captial" required="" rows="15" placeholder="City" class="form-control">

			</div>
	</div>
	<div class="col-xs-3" >
			<div class="form-group">
				<label>State</label>
					 <input type="text" name="state"  maxlength="20" required="" rows="15" placeholder="State" class="form-control">

			</div>
	</div>
	</div><!------------------------------row3--------------------->
	<div class="row" style="margin-top:4%;">
	<div class="col-xs-3">
	
		 <div class="form-group">
				<label>Country</label>
				<input type="text" name="country"  maxlength="20"  required="" placeholder="Country" class="form-control">
			</div>

	</div>
	<div class="col-xs-3" >
			<div class="form-group">
				<label>Pincode</label>
					 <input type="number" name="pincode" pattern="[1-9]{1}[0-9]{5}" title="Please enter the valid pincode" required="" rows="15" placeholder="Pinecode" class="form-control">

			</div>
	</div>
	</div><!------------------------------row3--------------------->
	<div class="row"  style="margin-top:4%;">
	<div class="col-xs-3">
		 <div class="form-group">
				<label>Stream </label>
				<input type="text" name="stream" placeholder="Stream" class="form-control">
			</div>

	</div>
	<div class="col-xs-3">
		 <div class="form-group">
				<label>Degree </label>
				<input type="text" name="degree" placeholder="Degree" class="form-control">
			</div>

	</div>
	<div class="col-xs-3">
		 <div class="form-group">
				<label>CGPA </label>
				<input type="number" name="cgpa" pattern="[0-9]{1}[.][0-9]{1}|[0-1]{2}$" placeholder="CGPA" step="0.1" class="form-control">
			</div>

	</div>
	</div>
	
	<!------------------------row2--------------------- backi bchai field--->
	<div class="row"  style="margin-top:4%;">
	<div class="col-xs-3">
		 <div class="form-group">
				<label>Institute </label>
				<input type="text" name="institute" placeholder="Institute"  maxlength="20"  class="form-control">
			</div>

	</div>
	
	<div class="col-xs-3">
		 <div class="form-group">
				<label>University </label>
				<input type="text" name="university" placeholder="University"  maxlength="20"  class="form-control">
			</div>

	</div>
	<div class="col-xs-3">
		 <div class="form-group">
				<label>Passout </label>
				<input type="Date" name="passout" placeholder="Passout Year" class="form-control">
			</div>

	</div>
	</div>
	
	<!------------------------row2--------------------baki bchai field 2---->
	<div class="row"  style="margin-top:4%;">
	
	<div class="col-xs-3">
		 <div class="form-group">
				<label>Gap</label>
						 <select name="gap" class="form-control">
    <option value="yes">Yes</option>
    <option value="no">No</option>
    
  </select>
			</div>

	</div>
	</div>
	<!------------------------row2--------------------- backi bchai field 3--->
	<div class="row"  style="margin-top:4%;">
	<div class="col-xs-3">
		 <div class="form-group">
				<label>12th Board </label>
				<input type="text" name="hBoard" placeholder="12th Board " class="form-control">
			</div>

	</div>
	<div class="col-xs-3">
		 <div class="form-group">
				<label>12th Percentage </label>
				<input type="number" name="hMarks" step="0.01" maxlength="5" pattern="[0-9]{2}[.][0-9]{2}|[0-1]{3}$" title="Please Enter the valid percentage" placeholder="12th Percentage " class="form-control">
			</div>

	</div>
	</div>
	
	<!------------------------row2--------------------baki bchai field 2---->
	<div class="row"  style="margin-top:4%;">
	<div class="col-xs-3">
		 <div class="form-group">
				<label>10th Board </label>
				<input type="text" name="sBoard" placeholder="10th Board " class="form-control">
			</div>

	</div>
	<div class="col-xs-3">
		 <div class="form-group">
				<label>10th Percentage </label>
				<input type="number" name="sMarks" step="0.01" placeholder="10th Percentage " maxlength="5" pattern="[0-9]{2}[.][0-9]{2}|[0-1]{3}$" title="Please Enter the valid percentage" class="form-control">
			</div>

	</div>
	</div>
	<!------------------------row2--------------------->
	<!------------------------row2--------------------- backi bchai field--->
	<div class="row"  style="margin-top:4%;">
	<div class="col-xs-3">
		 <div class="form-group">
				<label>Experience Year </label>
				<input type="number" name="experience" placeholder="Experience Year " step="0.01" class="form-control">
			</div>

	</div>
	<div class="col-xs-3">
		 <div class="form-group">
				<label>Company Name</label>
				<input type="text" name="company"  maxlength="20"  placeholder="Company Name" class="form-control">
			</div>

	</div>
	<div class="col-xs-3">
		 <div class="form-group">
				<label>Work Location </label>
				<input type="text" name="location" maxlength="20"  placeholder="Work Location" class="form-control">
			</div>

	</div>
	</div>
	
	<!------------------------row2--------------------baki bchai field 2---->
	<div class="row" >
	<div class="col-xs-3">
			<button type="submit" class="btn btn-blue" >Update</button>
	</div>
	</div>
	</div>

</form>
</section>
</body>
</html>