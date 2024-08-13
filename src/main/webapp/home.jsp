<%@page import="dao.userdao"%>
<%@page import="java.util.List"%>
<%@page import="model.user"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>


<title>Bootstrap Example</title>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<%
	user u = null;
	if (session.getAttribute("data") != null) {
		u = (user) session.getAttribute("data");
	} else {
		response.sendRedirect("login.jsp");
	}
	%>
	<h1>
		Welcome,<%=u.getName()%></h1>

	<h1><%=u.getEmail()%></h1>
	<a href="logout.jsp">Logout</a>
	<div class="container mt-3">
		<h2>Basic table</h2>
		<table class="table">
			<thead>

				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Contact</th>
					<th>Address</th>
					<th>Email</th>
					<th>Password</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>

				<%
				List<user> list = userdao.getAlluser();
				%>
				<%
				for (user u1 : list) {
				%>
				<tr>
					<td><%=u1.getId()%></td>
					<td><%=u1.getName()%></td>
					<td><%=u1.getContact()%></td>
					<td><%=u1.getAddress()%></td>
					<td><%=u1.getEmail()%></td>
					<td><%=u1.getPassword()%></td>


					<td>
						<form action="usercontroller" method="post">
							<input type="hidden" name="id" value="<%=u1.getId()%>"> <input
								type="submit" name="action" value="edit">

						</form>
					</td>
					
					<td>
						<form action="usercontroller" method="post">
							<input type="hidden" name="id" value="<%=u1.getId()%>"> <input
								type="submit" name="action" value="delete">

						</form>
					</td>
					
				</tr>

				<%
				}
				%>
			</tbody>
		</table>


	</div>

</body>
</html>