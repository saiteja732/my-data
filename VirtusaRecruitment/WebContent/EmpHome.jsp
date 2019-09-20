<%@page import="java.util.Iterator"%>
<%@page import="com.virtusa.vrps.dao.JobseekerList"%>
<%@page import="com.virtusa.vrps.model.JobSeeker"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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

	<form action="EmpHomeServlet " method="post">
		 <input type="text" name="loc" placeholder="Location">
		 <input type="text" name="qual" placeholder="Qualification">
		  <input type="text" name="exp" placeholder="Experience(year)">
		  <input type="submit" value="Seach">
	</form>
	
	<%
		List<JobSeeker> ljs=new JobseekerList().getJSList(); 
	if(ljs.isEmpty()){ %>
	<p>****** No Such Data Available *****</p>
<%	}else {
	Iterator<JobSeeker> itr=ljs.iterator();
	while(itr.hasNext()){
		JobSeeker jb=(JobSeeker)itr.next();
		
%>
<br/><a href="JobseekerInfo.jsp?info=<%=jb.getJsid()%>"><%=jb.getJsid() %></a><br/>
<%=jb.getFisrtName()%>
		<%=jb.getLastName() %><br/>
		<%=jb.getState() %>
		<%=jb.getCountry() %><br/>
		<%=jb.getDegree() %>
		<%=jb.getStream() %><br/>
		<%=jb.getExperience() %><br/>
		<%
		if( jb.getRateAVG()>0 || jb.getCommentNo()>0 ) { %>
			<%=jb.getRateAVG() %>
			<p>(----------)</p>
			<%=jb.getCommentNo()%>
		<% } else { %>
			no rate and comment
		<% }%>
		<br/><hr/>
<%}} %>
	
	

</body>
</html>