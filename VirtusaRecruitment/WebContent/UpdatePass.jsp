<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
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
String new1=request.getParameter("new");
//String confirm=request.getParameter("Confirm");
String id=request.getParameter("jsid");
//out.println(new1+" "+confirm+" "+id);
//if(new1.equals(confirm)){
	//out.println("correct");
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:orcl","scott","tiger");
	//String cmd="Update jsregistration set JSPASSWORD='" + new1 + "' where jsid='" + new1 + "'";
	String cmd = "update jsregistration set jspassword=? where jsid=?";
	PreparedStatement pst=con.prepareStatement(cmd);
	pst.setString(1,new1);
	pst.setString(2,id);
	pst.executeUpdate();
	String cmd2 = "commit";
	PreparedStatement pst2 = con.prepareStatement(cmd2);
	
	pst2.executeUpdate(cmd2);
	
	out.println("Updated");
	con.close();
//}
//else
//{
//	out.println("Incorrect");
//}
%>
</body>
</html>