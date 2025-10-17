<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.table-container {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

table {
	border-collapse: collapse;
	width: 50%;
}

th, td {
	border: 1px solid black;
	padding: 8px;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}

.vertical-center {
	margin: 40%;
	position: absolute;
	bottom: 10%;
	-ms-transform: translateY(-50%);
	transform: translateY(-50%);
}
</style>
</head>
<body>

	<div class="table-container">
		<table>
			<ul>
				<%@ page import="java.util.ArrayList"%>
				<% ArrayList<String> list = (ArrayList<String>) request.getAttribute("userList");
    %>

				<tr>
					<th>Employee</th>
					<th>Details</th>

				</tr>
				<tr>
					<td>Name</td>
					<td><%= list.get(0) %></td>
				</tr>
				<tr>
					<td>Emp_ID</td>
					<td><%=  list.get(1) %></td>
				</tr>
				<tr>
					<td>Designation</td>
					<td><%= list.get(2) %></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><%= list.get(3)%></td>
				</tr>
			</ul>
		</table>
	</div>

	<div class="container" id="butt">
		<div class="vertical-center">
			<a href="http://localhost:8080/first/updateDetails.jsp?id=<%= list.get(1) %>"><button>Update</button></a>
			<form action="Deactivate" method="post">
				<input type="hidden" name="id" value="<%= list.get(1) %>">
				<button>Delete</button>
			</form>
			<a href="http://localhost:8080/first/image.jsp?id=<%= list.get(1) %>"><button>Upload</button></a>
			<a href="http://localhost:8080/first/showImage.jsp?id=<%= list.get(1) %>"> <button>Display</button>
			</a>
			<form action="bye" method="get">
				<input type="submit" value="Sign Out" />
			</form>
		</div>
	</div>

</body>
</html>