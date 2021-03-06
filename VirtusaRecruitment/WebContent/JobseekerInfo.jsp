<%@page import="com.virtusa.vrps.dao.JobseekerData"%>
<%@page import="com.virtusa.vrps.dao.JobseekerList"%>
<%@page import="com.virtusa.vrps.model.JobSeeker"%>
<%@page import="javax.swing.JButton"%>
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
	<!-- ------------------- -->
	
	
	<style>
 
div.stars {

  width: 270px;

  display: inline-block;

}

input.star { display: none; }

label.star {

  float: right;

  padding: 10px;

  font-size: 36px;

  color: #444;

  transition: all .2s;

}

 

input.star:checked ~ label.star:before {

  content: '\f005';

  color: #FD4;

  transition: all .25s;

}

 

input.star-5:checked ~ label.star:before {

  color: #FE7;

  text-shadow: 0 0 20px #952;

}

 

input.star-1:checked ~ label.star:before { color: #F62; }

 

label.star:hover { transform: rotate(-15deg) scale(1.3); }

 

label.star:before {

  content: '\f006';

  font-family: FontAwesome;

}
</style>
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
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
				<li><a href="Home1.jsp" class="scrollto active" >Jobseeker</a></li>
				<li><a href="ShowTrSelect" class="scrollto" >Application</a></li>
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

		
	%>
<% String str=request.getParameter("info");
			JobSeeker js=new JobseekerData().getData(str);
			String jsid=js.getJsid();
		%>
<section id="author">
	<div class="container" style="margin-top: -5%;">
		<div class="row">
			<div class="col-md-6">
				<div class="row author">
					<div class="col-sm-4">
						<img src="img/p1.png" alt="" class="pic">
					</div>
					<div class="col-sm-8 author-name">
						<h2 class="heading wow animated fadeInUp"><%=js.getJsid() %></h2>
						<h2 class="heading wow animated fadeInUp"><%=js.getFisrtName() %> <%=js.getLastName() %></h2>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<h4 class="subheading gray wow animated fadeInUp">Personal Detail</h4>
						<p class="small muted-light wow animated fadeInUp">Email: <%=js.getEmail() %></p>
						<p class="small muted-light wow animated fadeInUp">Phone: <%=js.getPhone() %></p>
						<p class="small muted-light wow animated fadeInUp">Date Of Birth: <%=js.getDob()%></p>
						<p class="small muted-light wow animated fadeInUp">Gender: <%=js.getGender() %></p>
						<p class="small muted-light wow animated fadeInUp">Address: <%=js.getAddress() %></p>
						<p class="small muted-light wow animated fadeInUp">City: <%=js.getCity() %></p>
						<p class="small muted-light wow animated fadeInUp">State: <%=js.getState() %></p>
						<p class="small muted-light wow animated fadeInUp">Country: <%=js.getCountry() %></p>
						<p class="small muted-light wow animated fadeInUp">Pincode: <%=js.getPincode() %></p>
					</div>
					
					<div class="col-md-6">
						<h4 class="subheading gray wow animated fadeInUp">Higher Qualification Detail</h4>
						<p class="small muted-light wow animated fadeInUp">Stream: <%=js.getStream() %></p>
						<p class="small muted-light wow animated fadeInUp">Degree: <%=js.getDegree() %></p>
						<p class="small muted-light wow animated fadeInUp">CGPA: <%=js.getCgpa()%></p>
						<p class="small muted-light wow animated fadeInUp">Institute: <%=js.getInstitute() %></p>
						<p class="small muted-light wow animated fadeInUp">University: <%=js.getUniversity() %></p>
						<p class="small muted-light wow animated fadeInUp">Passout: <%=js.getPassout() %></p>
						<p class="small muted-light wow animated fadeInUp">GAP: <%=js.getGap() %></p>
		
					</div>
					</div>
					<div class="row">
					<div class="col-md-6">
						<h4 class="subheading gray wow animated fadeInUp">Secondary Education Detail</h4>
						<p class="small muted-light wow animated fadeInUp">12th Board: <%=js.gethBoard() %></p>
						<p class="small muted-light wow animated fadeInUp">12th Percentage: <%=js.gethMarks() %></p>
						<p class="small muted-light wow animated fadeInUp">10th Board: <%=js.getsBoard()%></p>
						<p class="small muted-light wow animated fadeInUp">10th Percentage: <%=js.getsMarks() %></p>
					</div>
					<div class="col-md-6">
						<h4 class="subheading gray wow animated fadeInUp">Experience Detail</h4>
						<p class="small muted-light wow animated fadeInUp">Year Of Experience: <%=js.getExperience() %></p>
						<p class="small muted-light wow animated fadeInUp">Company: <%=js.getCompany() %></p>
						<p class="small muted-light wow animated fadeInUp">Location: <%=js.getLocation()%></p>
						
					</div>
				</div>
			</div> <!-- col-md-6 author -->
			<div class="col-md-6 text-right wow animated fadeInUp text-center-mobile">
				<form action="RateCommentServlet?id=<%=jsid %>" method="post">
				 <input class="star star-5" value="5" id="star-5" type="radio" name="star"/>

    			<label class="star star-5" for="star-5"></label>

    			<input class="star star-4" value="4" id="star-4" type="radio" name="star"/>

    			<label class="star star-4" for="star-4"></label>

    			<input class="star star-3" value="3" id="star-3" type="radio" name="star"/>

    			<label class="star star-3" for="star-3"></label>

   				<input class="star star-2" value="2" id="star-2" type="radio" name="star"/>

   				 <label class="star star-2" for="star-2"></label>

    			<input class="star star-1" value="1" id="star-1" type="radio" name="star"/>

    			<label class="star star-1" for="star-1"></label>
				<input name="cmt" class="form-control" rows="5" placeholder="Message. . ." />
				<input type="submit" class="btn btn-blue contact-button" value="comment">
				</form>
			</div>
			
		</div>
	</div>
</section>


</body>
</html>