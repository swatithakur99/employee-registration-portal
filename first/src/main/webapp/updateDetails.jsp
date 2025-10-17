<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="change">
	    <h1>Update your credentials</h1>
		<input type="hidden" name="id" value="<%=request.getParameter("id")%>">
		Name <input type="text" name="name"> <br><br>
		Designation <input type="text" name="desg"> <br><br>
		Email <input type="text" name="email"> <br><br>
		Password <input type="text" name="pass"> <br><br>
		<input type="Submit" value="Update">
	</form>
</body>
</html>