<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
	overflow-y:scroll;
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
	<div class="main"  style="margin-top: -52%; display: none;"> 
		<form action="JSForgotPass.as" method="post" name="myform" onsubmit="return validate()" autocomplete="off">
		<div class="login-form"> 
			<h2 style="color:white;">Change Password</h2> 
			<div class="agileits-top">
				
				<div class="styled-input">
						<label>Email</label><br><input type="text" name="email" pattern="[a-z][a-z0-9._%+-]+@gmail.[a-z]{2,}$" title="Must be gmail id starting with letter" required> 
						
						<span></span>
					</div> 
				<div class="row">
					<div class="col-md-6 styled-input">
						
						<select id="questions" name="question" class="form-control">
						<option>What is your favourite food ?</option>
						<option>What is your pet name ?</option>
						<option>What is your car's number ? </option>
						<option>What is your first school name ?</option>
						</select>
						<span></span>
					</div>
				<div class="col-md-6 styled-input">
						<label>Answer</label><br><input type="text" name="answer" required> 
						
						<span></span>
					</div> 
					 
					<div class="col-md-6 styled-input">
						<label>New Password</label><br><input type="password" name="newpass" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number, one uppercase and lowercase letter, and at least 8 or more characters" required> 
						
						<span></span>
					</div> 
					<div class="col-md-6 styled-input">
						<label>Confirm Password</label><br><input type="password" name="cpass" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number, one uppercase and lowercase letter, and at least 8 or more characters" required> 
						
						<span></span>
					</div> 
				
				</div>
			
			</div>
			<div class="agileits-bottom">
				
					<input type="submit" value="Submit">
			</div>	
			</div>
			</form>
		</div>	
	
	</section>
	<script type="text/javascript">
$(".main").fadeIn();
	function validate() {
		
	   
	    var psw = document.forms["myform"]["newpass"].value;
	    var psw2 = document.forms["myform"]["cpass"].value;
	    
	
	    if (psw === "") {
	        alert("Password must be filled out");
	        return false;
	    }
	    
	    if(psw===psw2){  
	return true;  
	}  
	else{  
	alert("password must be same!");  
	return false;  
	}  
	}
	</script>
	
</body>
</html>