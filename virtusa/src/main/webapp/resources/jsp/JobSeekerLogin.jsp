<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- Custom Theme files -->
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='${pageContext.request.contextPath}/resources/font.css' rel='stylesheet' type='text/css'><!--web font-->
<script src="${pageContext.request.contextPath}/resources/css2/jquery.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css2/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="${pageContext.request.contextPath}/resources/css2/bootstrap.min.js"></script>
<style>
body{
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
</style>
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
	<!-- main -->
	<div class="main"  style="margin-top: -50%; display: none;"> 
			
		<div class="login-form"> 
			<h2 style="color:white;">JobSeeker Login</h2> 
			<div class="agileits-top">
				<form action="JSValidate.as">
					<div class="styled-input">
						<input type="text" name="email" required=""/>
						<label>Email</label>
						<span></span>
					</div>
					<div class="styled-input">
						<input type="password" name="psw" required=""> 
						<label>Password</label>
						<span></span>
					</div> 
					<div class="wthree-text"> 
						<ul> 
							<li> <a href="JobSeekerSignUP.as" >Create Account</a> </li>
							<li> <a href="redirect.as" >Forgot password?</a> </li>
						</ul>
						<div class="clear"> </div>
					</div>  
					
				
			</div>
			<div class="agileits-bottom">
				
					<input type="submit" value="Login">
				
			</div>
			</form>
			
			</div>	
	</div>
	
	</section>
	<script>
	$(".main").fadeIn();
	</script>
</body>
</html>

