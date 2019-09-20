<%@page import="com.virtusa.vrps.model.JobSeeker"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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
	</style>
</head>
<% 
	String str=request.getParameter("d");
	//response.getWriter().println(str);
	 if(str.equalsIgnoreCase("HR")) {
		
		 %>
		
<nav class="navbar navbar-default">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			
			<a class="navbar-brand" href="#"><img src=" " alt=""></a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right main-nav">
				<li><a href="Home1.jsp" class="scrollto active" >Jobseeker</a></li>
				<li><a href="ShowTrSelect" class="scrollto" >Application</a></li>
				<li><a href="EmpProfile.jsp" class="scrollto">Profile</a></li>
				<li><a href="EmpLogout" class="scrollto">Logout</a></li>
			</ul>
		</div><!-- /.navbar-collapse -->
	</div><!-- /.container-fluid -->
</nav>
<%} %>
<% 
	 if(str.equalsIgnoreCase("Technical")) {
		 %>
<nav class="navbar navbar-default">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			
			<a class="navbar-brand" href="#"><img src=" " alt=""></a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right main-nav">
				<li><a href="Home.jsp" class="scrollto active" >Jobseeker</a></li>
				<li><a href="ShowAdminSelect" class="scrollto" >Application</a></li>
				<li><a href="EmpProfile.jsp" class="scrollto">Profile</a></li>
				<li><a href="EmpLogout" class="scrollto">Logout</a></li>
			</ul>
		</div><!-- /.navbar-collapse -->
	</div><!-- /.container-fluid -->
</nav>
<%} %>

<body class="bg">
<form action="EmpHomeServlet" method="post">
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-8">
	<div class="row">
	<div class="col-xs-3">
		 <div class="form-group">
				<input type="text" name="loc" placeholder="Location" class="form-control">
			</div>
	</div>
	<div class="col-xs-3">
			<div class="form-group">
				
					 <input type="text" name="qual" placeholder="Qualification" class="form-control">

			</div>
	</div>
	<div class="col-xs-3">
			<div class="form-group">
				
					 <input type="text" name="exp" placeholder="Experience(year)" class="form-control">

			</div>
	</div>
	
	<div class="col-xs-3">
			<button type="submit" class="btn btn-blue">Search</button>
	</div></div></div>
<div class="col-sm-2"></div>
</div>
</form>


<div class="container-fluid rowback"> 
<%
		List<JobSeeker> ljs=(List<JobSeeker>)request.getAttribute("listAttr");
	
		if(ljs.isEmpty()){ %>
			<div class="item">
						<div class="review text-center wow animated fadeInUp">
						
						<h4 class="subheading reviewer-name">Nothing To Show</h4>
						
					</div>
					
					</div>
	<%	}else {
			Iterator<JobSeeker> itr=ljs.iterator();
			while(itr.hasNext()){
				JobSeeker jb=(JobSeeker)itr.next();
				
		%>
	
	
	<div class="item">
					<div class="review text-center wow animated fadeInUp">
						
						<img src="img/hpn.jpg" class="reviewer-pic" alt="">
						<h4 class="subheading reviewer-name"><a href="JobseekerInfo.jsp?info=<%=jb.getJsid()%>"><%=jb.getJsid() %></a></h4>
					
						<h4 class="subheading reviewer-name"><%=jb.getFisrtName()%>  <%=jb.getLastName() %></h4>
						<h6 class="subheading muted reviewer-city" ><%=jb.getEmail() %></h6>
						
						<p class="small"><%=jb.getPhone() %></p>
						<%
						if( jb.getRateAVG()>0 || jb.getCommentNo()>0 ) { %>
						<p class="small">Rating :<%=jb.getRateAVG() %></p>
						<p class="small">Comments:<%=jb.getCommentNo()%></p>
						<% } else { %>
						
						<p class="small">no rate and comment</p>
						<% }%>
					</div>
					<%}} %>
					
		</div>
		
</div>
</body>
</html>