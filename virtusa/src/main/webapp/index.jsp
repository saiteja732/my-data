<!DOCTYPE html>
<html lang="en">
<head>

<script src="${pageContext.request.contextPath}/resources/css2/jquery.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css2/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="${pageContext.request.contextPath}/resources/css2/bootstrap.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<style>
body{ 
	margin: 0;
	padding: 0;
	font-family: 'Josefin Sans', sans-serif;
}			
section {
	position: absolute;
	width: 100%;
	height: 100vh;
	background: #000;
	overflow: hidden;
	animation: bgColor 20s linear infinite;
}
.bgPulse {
z-index: -1 !important;
	width: 100%;
	height: 100%;
}
.bgPulse span {
z-index: 0 !important;
	position: absolute;
	width: 80px;
	height: 80px;
	background: #fff;
}
.bgPulse span:nth-child(3n+1) {
	background: transparent;
	border: 5px solid #fff;
}
.bgPulse span:nth-child(1) {
	top: 50%;
	left: 20%;
	animation: animate 10s linear infinite;
}
.bgPulse span:nth-child(2) {
	top: 80%;
	left: 40%;
	animation: animate 12s linear infinite;
}
.bgPulse span:nth-child(3) {
	top: 10%;
	left: 65%;
	animation: animate 15s linear infinite;
}
.bgPulse span:nth-child(4) {
	top: 50%;
	left: 70%;
	animation: animate 6s linear infinite;
}
.bgPulse span:nth-child(5) {
	top: 10%;
	left: 30%;
	animation: animate 9s linear infinite;
}
.bgPulse span:nth-child(6) {
	top: 90%;
	left: 95%;
	animation: animate 8s linear infinite;
}
.bgPulse span:nth-child(7) {
	top: 80%;
	left: 5%;
	animation: animate 5s linear infinite;
}
.bgPulse span:nth-child(8) {
	top: 35%;
	left: 50%;
	animation: animate 14s linear infinite;
}
.bgPulse span:nth-child(9) {
	top: 5%;
	left: 5%;
	animation: animate 11s linear infinite;
}
.bgPulse span:nth-child(10) {
	top: 25%;
	left: 90%;
	animation: animate 10s linear infinite;
}
.bgPulse span:nth-child(10) {
	top: 25%;
	left: 90%;
}

@keyframes animate {
	0% {
		transform: scale(0) translateY(0) rotate(0deg);
		opacity: 1;
	}
	100% {
		transform: scale(1) translateY(-100px) rotate(360deg);
		opacity: 0;
	}
}

@keyframes bgColor {
	
	0% {
		background: #03a9f4;
	}
	100% {
		background: #03a9f4;
	}
}
header .heading {
	font-family:'Proxima Bold';
	color: white ;
	font-size:40px;
	margin:10px 0;
}

header .subheading {
	color:white;
	opacity: .5;
	font-size:24px;
	margin:10px 0px 30px;
}

header p {
	margin:20px 0;
	font-size:20px;
	color:white;
	line-height: 34px;
}
.btn {
	display:inline-block;
	font-family:'Proxima Bold';
	font-size:18px;
	font-weight: bold;
	padding:15px 30px;
	margin:20px 10px;
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
h2 {
    font-size: 1.1em;
    text-align: center;
    padding: 10px;
    background: #02a299;
    color: #fff;
    letter-spacing: 10px;
}
</style>
<!------ Include the above in your HEAD tag ---------->

<title>VRPS</title>
</head>
<body>
<%
	    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);

		
		
	%>
<section>
	<div class="bgPulse">
		<span></span>
		<span></span>
		<span></span>
		<span></span>
		<span></span>
		<span></span>
		<span></span>
		<span></span>
		<span></span>
		<span></span>
		
	</div>
	<header>
	<div class="container" style="margin-top: -46%; display: none;">
			<div class="row">
			<div class="col-md-6">
				<div class="intro-book">
					<img src="${pageContext.request.contextPath}/resources/img/virtusa.png" style="width: 95%;" alt="">
				</div>
			</div>
			
			<div class="col-md-6 login-form" >
				
				<h2 class="heading">Virtusa Recruitment Process</h2>
	
				<p>PASSION - To inspire our global teams to deliver extraordinary results</p>
				<p>INNOVATION - Apply intellectual curiosity to reimagine better business outcomes for our clients</p>
				<p>RESPECT - Protect our environment, honor our diversity and treat everyone with dignity</p>
				<p>LEADERSHIP - Take personal responsibility when things go awry and always ascribe success to the team</p>
				<a href="jobseeker.as" class="scrollto btn btn-white">Jobseeker</a>
				<a href="loginPage.as" class="btn btn-blue">Employee</a>
				<a href="addEmployee.as" class="btn btn-blue">Admin</a>
			</div>
			</div>
	</div>
	</header>
</section>
<script>
$(".container").fadeIn(2000);
</script>
</body>
</html>