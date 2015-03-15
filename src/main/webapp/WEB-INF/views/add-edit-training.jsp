<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Add Edit Training Records
<form:form method="POST" action="${pageContext.request.contextPath}/addTraining">
   <table>
    <tr>
        <td><form:label path="grade">Grade</form:label></td>
        <td><form:input path="grade" /></td>
    </tr>
    <form:hidden path="accountId" />
    <form:hidden path="courseId" />
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>
</form:form> 
<a href="${pageContext.request.contextPath}/index.html">Home page</a><br/> 
</body>
</html>