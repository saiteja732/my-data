<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
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
				<li><a href="JSHome.jsp" class="scrollto active" >JobList</a></li>
				<li><a href="JobSeekerProfile.jsp" class="scrollto">Profile</a></li>
				<li><a href="viewStatus.jsp" class="scrollto">My Application</a></li>
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

			response.sendRedirect("JobSeekerLogin.jsp");
		}
		
	%>
<form action="DetailedJob.jsp" method="post">
<div class="row">
<div class="col-sm-3"></div>
<div class="col-sm-8">
	<div class="row">
	<div class="col-xs-8">
		 <div class="form-group">
				<input type="text" name="Title" placeholder="Job Title" class="form-control">
			</div>
	</div>
	
	
	<div class="col-xs-3">
			<button type="submit" class="btn btn-blue">Search</button>
	</div></div></div>
<div class="col-sm-2"></div>
</div>
</form>


<div class="container-fluid rowback">  <!--/ mujhe iske nichai se looping krni hai-->
	<%
 if(request.getParameter("Title") != null) {
	 Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection(
"jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
	
	
	String tit=request.getParameter("Title");
	String cmd="Select * from Joblist where Title LIKE '%"+tit+"%'";
	Statement stmt = null;
	stmt = con.createStatement();
	//PreparedStatement pst=con.prepareStatement(cmd);
	//pst.setString(1,tit);
	ResultSet rs=stmt.executeQuery(cmd);
%>	
	<table>
	<tr>
	<th>JbId </th>
	<th>Title </th>
	<th>Description </th>
	<th>Eligibility </th>
	<th>TechReq </th>
	<th>Location </th>
	<th>ExpRequired</th>
	<th>CTC</th>
	<th>PostDate</th>
	<th>ExpireDate</th>
	<th>Gap</th>
	<th>Apply</th>
</tr>
<tr>
<%	
	
	while(rs.next()){
		

	%>
		<tr>
		<td>
			<%=rs.getString("Jbid") %>
		</td>
		<td>
			<%=rs.getString("Title") %>
		</td>
		<td>
			<%=rs.getString("Description") %>
		</td>
		<td>
			<%=rs.getString("Eligibility") %>
		</td>
		
		<td>
			<%=rs.getString("TechReq") %>
		</td>
		<td>
			<%=rs.getString("Location") %>
		</td>
		<td>
			<%=rs.getInt("ExpRequired") %>
		</td>
		<td>
			<%=rs.getInt("package") %>
		</td>
		<td>
			<%=rs.getDate("PostDate") %>
		</td>
		<td>
			<%=rs.getDate("ExpireDate") %>
		</td>
		<td>
			<%=rs.getString("Gap") %>
		</td>
		<td>
			<a href="JobApplication?Jid=<%=rs.getString("jbid") %>">Apply</a>
		</td>
		</tr>
		
	<%
} 
 
		
	}
%>
</table>
</div>
<div class="container-fluid rowback">  <!--/ mujhe iske nichai se looping krni hai-->
	<%
 if(request.getParameter("jbid") != null) {
	 Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection(
"jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
	
	
	String id=request.getParameter("jbid");
	String cmd="Select * from Joblist where jbid LIKE '%"+id+"%'";
	Statement stmt = null;
	stmt = con.createStatement();
	//PreparedStatement pst=con.prepareStatement(cmd);
	//pst.setString(1,tit);
	ResultSet rs=stmt.executeQuery(cmd);
%>	
	<table>
	<tr>
	<th>JbId </th>
	<th>Title </th>
	<th>Description </th>
	<th>Eligibility </th>
	<th>TechReq </th>
	<th>Location </th>
	<th>ExpRequired</th>
	<th>CTC</th>
	<th>PostDate</th>
	<th>ExpireDate</th>
	<th>Gap</th>
	<th>Apply</th>
</tr>
<tr>
<%	
	
	while(rs.next()){
		

	%>
		<tr>
		<td>
			<%=rs.getString("Jbid") %>
		</td>
		<td>
			<%=rs.getString("Title") %>
		</td>
		<td>
			<%=rs.getString("Description") %>
		</td>
		<td>
			<%=rs.getString("Eligibility") %>
		</td>
		
		<td>
			<%=rs.getString("TechReq") %>
		</td>
		<td>
			<%=rs.getString("Location") %>
		</td>
		<td>
			<%=rs.getInt("ExpRequired") %>
		</td>
		<td>
			<%=rs.getInt("package") %>
		</td>
		<td>
			<%=rs.getDate("PostDate") %>
		</td>
		<td>
			<%=rs.getDate("ExpireDate") %>
		</td>
		<td>
			<%=rs.getString("Gap") %>
		</td>
		<td>
			<a href="JobApplication?Jid=<%=rs.getString("jbid") %>">Apply</a>
		</td>
		</tr>
		
	<%
} 
 
		
	}
%>
</table>
</div>
</body>
</html>    