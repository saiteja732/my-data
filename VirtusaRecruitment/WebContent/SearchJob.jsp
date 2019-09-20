<%@page import="com.virtusa.vrps.dao.IdGenerator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="DetailedJob.jsp">
Insert Job Title: <input type='text' name='Title' size='10'>
<br/><br/> 
<input type='submit' value='Search'>
</form>
<jsp:include page="DetailedJob.jsp"></jsp:include>
</body>
</html>