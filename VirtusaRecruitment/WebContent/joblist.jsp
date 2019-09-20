<%@page import="com.virtusa.vrps.model.JobListInfo"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
		
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
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td{
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}
 th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
  background-color:#7cc576;
  color:white;
}

tr:nth-child(odd) {
  background-color: #dddddd;
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
				<li><a href="JobList" class="scrollto active">Joblist</a></li>
				<li><a href="jobPost.jsp" class="scrollto">Post-Job</a></li>
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

<div class="container-fluid rowback">  <!--/ mujhe iske nichai se looping krni hai-->
	
	<%
			
				try {
					@SuppressWarnings("unchecked")
					List<JobListInfo> js = (List<JobListInfo>) request.getAttribute("jListInfo");
					if(js.isEmpty()){
						%>
						<div class="item">
						<div class="review text-center wow animated fadeInUp">
						
						<h4 class="subheading reviewer-name">Nothing To Show</h4>
						
					</div>
					
					</div>
						<%
					}else{ %>
					<table>
 						 <tr>
							<th>Job Id</th>
				<th>Job Title</th>
				<th>Job Description </th>
				<th>Job Eligibility</th>
				<th>Technology Required </th>
				<th>Job Location </th>
				<th>Experience Required </th>
				<th>Job Post Date </th>
				<th>Job Expiry Date </th>
				<th>Gap </th>
						</tr>
						<%
						Iterator<JobListInfo> it = js.iterator();
						while (it.hasNext()) {
							JobListInfo ji = (JobListInfo) it.next();
						%>
	
  
  						<tr>
  							 
								<td><%=ji.getJbId()%></td>
				<td><%=ji.getJbTitle()%></td>
				<td><%=ji.getJbDesc()%></td>
				<td><%=ji.getJbEligibility()%></td>
				<td><%=ji.getJbTechReq()%></td>
				<td><%=ji.getJbLoc()%></td>
				<td><%=ji.getJbExpReq()%></td>
				<td><%=ji.getJbPostDate()%></td>
				<td><%=ji.getJbExpireDate()%></td>
				<td><%=ji.getGap()%></td>
								</tr>
  						<%} %>
  						</table>
 				<%
				}
				} catch (Exception e) {
				}
			%>
			
</div>

</body>
</html>
	





















