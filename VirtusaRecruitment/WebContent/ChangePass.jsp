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
String h=request.getParameter("jsid");

%>
<%
	    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);

		if (session == null || session.getAttribute("empid") == null) {

			response.sendRedirect("loginPage1.jsp");
		}
		
	%>
<form method="get" action="UpdatePass.jsp">
<input type="text" name="jsid" value=<%=h%> readonly="readonly"/>
New password<input type="text" name="new" /><br/>
<!--  Confirm password
<input type="text" name="Confirm" />
-->
<input type="submit" value="Change" />
</form>
</body>
</html>