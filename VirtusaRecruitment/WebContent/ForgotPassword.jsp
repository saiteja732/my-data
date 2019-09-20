<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='font.css' rel='stylesheet' type='text/css'><!--web font-->
<script src="css2/jquery.min.js"></script>
<link href="css2/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="css2/bootstrap.min.js"></script>
<style>
body{
}			
.login-form {
    width: 35%;
    margin: 3.5em auto;
    background: rgba(12, 85, 105, 0.51);
    padding-bottom: 2em;
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
			<h2 style="color:white;">Forgot Password</h2> 
			<div class="agileits-top">
				<form action="ForgotPasswordServlet" method="post">
					<div class="styled-input">
						<input type="text" name="id" required=""/>
						<label>Jobseeker ID</label>
						<span></span>
					</div>
					<div class="styled-input">
						<select id="questions" name="que" class="form-control">
						<option>What is your favourite food?</option>
						<option>What is your pet name?</option>
						<option>What is your car's number? </option>
						<option>What is your first school name?</option>
						</select>
						<span></span>
					</div> 
					<div class="styled-input">
						<input type="text" name="answer" required=""> 
						<label>Answer</label>
						<span></span>
					</div> 
				
				
			</div>
			<div class="agileits-bottom">
				
					<input type="submit" value="Submit">
				
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