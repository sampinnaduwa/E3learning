<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Submitted Course Information</h2>
   <table>
    <tr>
        <td>Course Name</td>
        <td>${title}</td>
    </tr>
</table> 
<a href="${pageContext.request.contextPath}/index.html">Home page</a><br/> 
</body>
</html>