<%@page import="javax.swing.JButton"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
				<li><a href="JSHome.as" class="scrollto active" >JobList</a></li>
				<li><a href="JobSeekerProfile.as" class="scrollto">Profile</a></li>
				<li><a href="viewStatus.as" class="scrollto">My Application</a></li>
				<li><a href="#" class="scrollto">Logout</a></li>
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
						<h2 class="heading wow animated fadeInUp">${jobseeker.firstName} ${jobseeker.firstName} </h2>
						<h2 class="heading wow animated fadeInUp">${jobseeker.jsid}</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<h4 class="subheading gray wow animated fadeInUp">Personal Detail</h4>
						<p class="small muted-light wow animated fadeInUp">Email: ${jobseeker.email}</p>
						<p class="small muted-light wow animated fadeInUp">Phone: ${jobseeker.phone}</p>
						<p class="small muted-light wow animated fadeInUp">Date Of Birth:${jobseeker.dob} </p>
						<p class="small muted-light wow animated fadeInUp">Gender:${jobseeker.gender} </p>
						<p class="small muted-light wow animated fadeInUp">Address: ${jobseeker.address}</p>
						<p class="small muted-light wow animated fadeInUp">City:${jobseeker.city} </p>
						<p class="small muted-light wow animated fadeInUp">State:${jobseeker.state} </p>
						<p class="small muted-light wow animated fadeInUp">Country:${jobseeker.country} </p>
						<p class="small muted-light wow animated fadeInUp">Pincode: ${jobseeker.pincode}</p>
					</div>
					
					<div class="col-md-6">
						<h4 class="subheading gray wow animated fadeInUp">Higher Qualification Detail</h4>
						<p class="small muted-light wow animated fadeInUp">Stream:${jobseeker.stream}</p>
						<p class="small muted-light wow animated fadeInUp">Degree:${jobseeker.degree}</p>
						<p class="small muted-light wow animated fadeInUp">CGPA:${jobseeker.cgpa}</p>
						<p class="small muted-light wow animated fadeInUp">Institute: ${jobseeker.institute}</p>
						<p class="small muted-light wow animated fadeInUp">University: ${jobseeker.university} </p>
						<p class="small muted-light wow animated fadeInUp">Passout: ${jobseeker.passout}</p>
						<p class="small muted-light wow animated fadeInUp">GAP:${jobseeker.gap}</p>
		
					</div>
					</div>
					<div class="row">
					<div class="col-md-6">
						<h4 class="subheading gray wow animated fadeInUp">Secondary Education Detail</h4>
						<p class="small muted-light wow animated fadeInUp">12th Board:${jobseeker.hBoard} </p>
						<p class="small muted-light wow animated fadeInUp">12th Percentage: ${jobseeker.hMarks}</p>
						<p class="small muted-light wow animated fadeInUp">10th Board: ${jobseeker.sBoard}</p>
						<p class="small muted-light wow animated fadeInUp">10th Percentage: ${jobseeker.sMarks}</p>
					</div>
					<div class="col-md-6">
						<h4 class="subheading gray wow animated fadeInUp">Experience Detail</h4>
						<p class="small muted-light wow animated fadeInUp">Year Of Experience: ${jobseeker.experience}</p>
						<p class="small muted-light wow animated fadeInUp">Company: ${jobseeker.company}</p>
						<p class="small muted-light wow animated fadeInUp">Location: ${jobseeker.location}</p>
						
					</div>
				</div>
			</div> <!-- col-md-6 author -->
			<div class="col-md-6 text-right wow animated fadeInUp text-center-mobile">
				<h4 class="subheading gray wow animated fadeInUp">Rating: </h4>
				<h4 class="subheading gray wow animated fadeInUp"><a href="JobSeekerComment.jsp">No. of Comments: </a></h4>
				<a href="page.as" class="btn btn-blue">Edit Profile</a>
				<a href="pass.as" class="btn btn-blue">Change Password</a>
				
			
			</div>
			
		</div>
	</div>
</section>


</body>
</html>