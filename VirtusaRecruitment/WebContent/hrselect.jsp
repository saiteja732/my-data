<%@page import="com.virtusa.vrps.model.JobListInfo"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.virtusa.vrps.model.JobApplicationInfo"%>
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
				<li><a href="Home1.jsp" class="scrollto" >Jobseeker</a></li>
				<li><a href="ShowTrSelect" class="scrollto active" >Application</a></li>
				<li><a href="EmpProfile.jsp" class="scrollto">Profile</a></li>
				<li><a href="EmpLogout" class="scrollto">Logout</a></li>
			</ul>
		</div><!-- /.navbar-collapse -->
	</div><!-- /.container-fluid -->
</nav>
<body class="bg">

<%
	    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);

		if (session == null || session.getAttribute("empid") == null) {

			response.sendRedirect("loginPage1.jsp");
		}
		
	%>


<div class="container-fluid rowback">  <!--/ mujhe iske nichai se looping krni hai-->
	<%
			
				try {
					@SuppressWarnings("unchecked")
					List<JobApplicationInfo> js = (List<JobApplicationInfo>) request.getAttribute("jListInfo");
					if(js.isEmpty()){
						%>
						<div class="item">
						<div class="review text-center wow animated fadeInUp">
						
						<h4 class="subheading reviewer-name">Nothing To Show</h4>
						
					</div>
					
					</div>
						<%
					}else{ %>
					<form method="get" action="FinalSelection">
					<table>
 						 <tr>
							<th>ApplicationId</th>
							<th>JobId</th>
							<th>Jobseeke Id </th>
							<th>Apply Date</th>
							<th>TR Status </th>
							<th>HR Status </th>
							<th>Application Status </th>
							<th>Forward </th>
						</tr>
						<%
							Iterator<JobApplicationInfo> it = js.iterator();
							while (it.hasNext()) {
							JobApplicationInfo ji = (JobApplicationInfo) it.next();
						%>
	
  
  						<tr>
  							 <td><%=ji.getApplicationId()%></td>
								<td><%=ji.getJbId()%></td>
								<td><%=ji.getJsId()%></td>
								<td><%=ji.getApplyDate()%></td>
								<td><%=ji.getTrStatus()%></td>
								<td><%=ji.getHrStatus()%></td>
								<td><%=ji.getAppStatus()%></td>
				
								<td><select name="selection">
								<option>select option-</option>
 								 <option value="s<%=ji.getJsId()%>">Select</option>
 								 <option value="r<%=ji.getJsId()%>">Reject</option>
								</select></td>
  						</tr>
  						<%} %>
  						</table>
  						<input type='submit' class="btn btn-blue" value='Select' >
  						</form>
					
 				<%
				}
				} catch (Exception e) {
				}
			%>
			
</div>
		


</body>
</html>
