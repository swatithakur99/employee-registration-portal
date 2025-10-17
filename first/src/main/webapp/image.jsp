<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <form method="post" action="fileuploadservlet" enctype="multipart/form-data">
     <input type="hidden" name="id" value="<%=request.getParameter("id")%>">
     Select Self Image 
    <input type="file" name="file" accept="image/png, image/jpeg"/><br><br>
    Upload Resume
    <input type="file" name="file2"  accept=".doc,.docx,.pdf,.xml,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document"/> <br><br>
    <input type="submit" value="Upload" />
  </form>
</body>
</html>