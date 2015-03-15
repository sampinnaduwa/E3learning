<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.error {
    color: #ff0000;
    font-style: italic;
    font-weight: bold;
}
</style>
</head>
<body>
<h2>Course Information</h2>
<form:form method="POST" modelAttribute="course" action="${pageContext.request.contextPath}/addCourse" commandName="course">
   <table>
    <tr>
        <td><form:label path="title">Course Name</form:label></td>
        <td><form:input path="title" /></td>
        <td><form:errors path="title" cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="code">Course Code</form:label></td>
        <td><form:input path="code" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Create Course"/>
        </td>
    </tr>
</table>
</form:form>  
<a href="${pageContext.request.contextPath}/index.html">Home page</a><br/>
</body>
</html>