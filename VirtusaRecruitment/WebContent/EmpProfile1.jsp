<%@page import="com.virtusa.vrps.model.Employee"%>
<%@page import="com.virtusa.vrps.dao.EmpData"%>
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
				<li><a href="Home1.jsp" class="scrollto" >Jobseeker</a></li>
				<li><a href="ShowTrSelect" class="scrollto " >Application</a></li>
				<li><a href="EmpProfile.jsp" class="scrollto active">Profile</a></li>
				<li><a href="EmpLogout" class="scrollto">Logout</a></li>
			</ul>
		</div><!-- /.navbar-collapse -->
	</div><!-- /.container-fluid -->
</nav>

<body class="bg">
<%
		
		HttpSession hs = request.getSession();
		String s=(String)hs.getAttribute("empid");
		Employee ep=new EmpData().getData(s);
	%>
	<%
	    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);

		if (session == null || session.getAttribute("empid") == null) {

			response.sendRedirect("loginPage1.jsp");
		}
		
	%>
<section id="author">
	<div class="container" style="margin-top: -5%;">
	<div class="item">
		
			<div class="col-md-6">
				<div class="row author">
					<div class="col-sm-4">
						<img src="img/employee.png" alt="" class="pic">
					</div>
					<div class="col-sm-8 author-name">
						<h2 class="heading wow animated fadeInUp"><%=ep.getEmpFirstName()%> <%=ep.getEmpLastName() %> </h2>
						<p class="small muted-light wow animated fadeInUp"><%=ep.getEmpDesignation() %> - <%=ep.getEmpDepartment() %></h4>
						<p class="small muted-light wow animated fadeInUp"><%=ep.getEmpEmail() %></h4>
						<p class="small muted-light wow animated fadeInUp"><%=ep.getEmpPhone() %></h4>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						
					</div>
				</div>
			</div> <!-- col-md-6 author -->
		
			<div class="col-md-6 text-right wow animated fadeInUp text-center-mobile">
				<a href="ChangePassword.jsp" class="btn btn-blue">Change Password</a>
			</div>
		</div>
		
	</div>
</section>


</body>
</html> 