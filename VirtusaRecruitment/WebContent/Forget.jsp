<%@page import="java.sql.Types"%>
<%@page import="java.sql.CallableStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
String id,ques,ans;
int c;
id=request.getParameter("jsid");
ques=request.getParameter("security");
ans=request.getParameter("answer");
Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
CallableStatement cs = con.prepareCall("call  prcForget(?,?,?,?)");//USED PROCEDURES
out.println(id);
out.println(ques);
out.println(ans);
cs.setString(1,id);
cs.setString(2,ans);
cs.setString(3,ques);
cs.registerOutParameter(4,Types.INTEGER);
cs.execute();

int res=cs.getInt(4);
out.println(res);
if(res!=0)
{
	out.println(res);
	out.println("incorrect");
}
else
{
	%>
	<a href="ChangePass.jsp?jsid=<%=id%>">Change Password</a>
	<%
}

%>
</body>
</html>
