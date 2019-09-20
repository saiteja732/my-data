<%@page import="java.util.List"%>
<%@page import="com.virtusa.vrps.model.JSComment"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.virtusa.vrps.dao.JobseekerData"%>
<%@page import="com.virtusa.vrps.dao.JobseekerList"%>
<%@page import="com.virtusa.vrps.model.JobSeeker"%>
<%@page import="javax.swing.JButton"%>
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
				<li><a href="JSHome.jsp" class="scrollto " >JobList</a></li>
				<li><a href="JobSeekerProfile.jsp" class="scrollto active">Profile</a></li>
				<li><a href="Logout" class="scrollto">Logout</a></li>
			</ul>
		</div><!-- /.navbar-collapse -->
	</div><!-- /.container-fluid -->
</nav>

<body class="bg">
<%	HttpSession hs=request.getSession();
				String str=(String)hs.getAttribute("email");
			JobSeeker js=new JobseekerData().getDataProfile(str);
			String jsid=js.getJsid();
		%>
<section id="author">
<%
	    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);

		if (session == null || session.getAttribute("email") == null) {

			response.sendRedirect("JobSeekerLogin.jsp");
		}
		
	%>
	<div class="container" style="margin-top: -5%;">
		<div class="row">
			<div class="col-md-6">
				<div class="row author">
					<div class="col-sm-4">
						<img src="img/p1.png" alt="" class="pic">
					</div>
					<div class="col-sm-8 author-name">
						<h2 class="heading wow animated fadeInUp"><%=js.getJsid() %></h2>
						<h2 class="heading wow animated fadeInUp"><%=js.getFisrtName() %> <%=js.getLastName() %></h2>
					</div>
				</div>
				<%
						List<JSComment> ljs=new JobseekerData().getComments(str);
						if(ljs.isEmpty()){ %>
						<div class="item">
						<div class="review text-center wow animated fadeInUp">
						
						<h4 class="subheading reviewer-name">Nothing To Show</h4>
						
					</div>
					
					</div>
						<%	}else {
						
						Iterator<JSComment> isc=ljs.iterator();
						%><h4 class="subheading gray wow animated fadeInUp">Comments</h4><%
						while(isc.hasNext()){
						JSComment jc=(JSComment)isc.next();
						%>
				<div class="row">
					<div class="col-md-6">
						<div class="item">
						<p class="small muted-light wow animated fadeInUp">Employee: <%=jc.getEmpid() %></p>
						<p class="small muted-light wow animated fadeInUp">commented: <%=jc.getComment() %></p>
						</div>
					</div>
					
					</div>
					<%}} %>
				
				</div>
			 <!-- col-md-6 author -->
			<div class="col-md-6 text-right wow animated fadeInUp text-center-mobile">
				<h4 class="subheading gray wow animated fadeInUp">Rating: <%=js.getRateAVG() %></h4>
				<h4 class="subheading gray wow animated fadeInUp">No. of Comments: <%=js.getCommentNo() %></h4>
			</div>
			</div>
	</div>
</section>


</body>
</html>