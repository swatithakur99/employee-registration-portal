<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:red" align="center">Display Image
</h1>
<div align="center">
<form action="DisplayImage" method="get">
<input type="hidden" name="id" value="<%=request.getParameter("id")%>">
<input type="submit" value="Show">
</form>
</div>
<%
    String imgId = (String)request.getParameter("id");
    String imgfilename=(String)request.getAttribute("img");
    String docfile=(String)request.getAttribute("docs");
    System.out.println(imgfilename);
%>
<div align="center">
<table border="5px" style="width:600px">
<tr>
<th>Image id</th>
<th>Image</th>
<th>Resume</th>
</tr>
<%
    if(imgfilename!="" && imgId!="" && docfile!="")
    {
%>
<tr>
<td><%=imgId %></td>
<td><img src="image/img/<%=imgfilename%>"></td>
<td><a href="image/doc/<%=docfile%>">Click</a></td>
<%
    }
%>
</table>
</div>
</body>
</html>