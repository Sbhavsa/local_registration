<%@page import="model.user"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%user u =(user) request.getAttribute("user"); %>
<form action="usercontroller" method="post">
	<table>
	
	
	<tr><td>Id : </td><td><input type="text" name="id" value="<%=u.getId()%>"></td></tr>
	<tr><td>name: </td><td><input type="text" name="name" value="<%=u.getName()%>"></td></tr>
	<tr><td>contact:</td><td><input type="text" name="contact" value="<%=u.getContact()%>"></td></tr>
	<tr><td>address:</td><td><input type="text" name="address" value="<%=u.getAddress()%>"></td></tr>
	<tr><td>email:</td><td><input type="email" name="email" value="<%=u.getEmail()%>"></td></tr>
	<tr><td>password:</td><td><input type="text" name="password" value="<%=u.getPassword()%>"></td></tr>
	<tr><td><input type="submit" name="action" value="update"></td></tr>
	
	
	
	
</table>
</form>
</body>
</html>
