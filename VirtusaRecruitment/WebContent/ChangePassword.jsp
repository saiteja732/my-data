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

		if (session == null || session.getAttribute("empid") == null) {

			response.sendRedirect("loginPage1.jsp");
		}
		
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
		
		<div class="login-form"> 
			<h2 style="color:white;">Change Password</h2> 
			<div class="agileits-top">
				<form action="ChangePassword" method="post" name="change" onsubmit="return validate()" autocomplete="off">
					<div class="styled-input">
						<input type="text" name="id" />
						<label>Employee ID</label>
						<span></span>
					</div>
					<div class="styled-input">
						<input type="text" name="email" > 
						<label>Registered Email</label>
						<span></span>
					</div> 
					<div class="styled-input">
						<input type="password" name="pass" > 
						<label>Password</label>
						<span></span>
					</div> 
					<div class="styled-input">
						<input type="password" name="cpass" > 
						<label>Confirm Password</label>
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
	function validate() {
		var empid=document.forms["change"]["id"].value;
	    var email = document.forms["change"]["email"].value;
	    var psw = document.forms["change"]["pass"].value;
	    var psw2 = document.forms["change"]["cpass"].value;
	    var atposition=email.indexOf("@");  
	var dotposition=email.lastIndexOf(".");  
	      
	    if (email === "") {
	        alert("Email must be filled out");
	        return false;
	    }
	    if (empid === "") {
	        alert("Employee Id must be filled out");
	        return false;
	    }
	    
	    if (atposition<1 || dotposition<atposition+2 || dotposition+3 >=email.length){  
	  alert("Please enter a valid e-mail address \n atpostion:"+atposition+"\n dotposition:"+dotposition);  
	  return false;  
	  }  
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
    
    
    
  