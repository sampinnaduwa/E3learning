<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Account</title>
</head>
<body>
<form:form method="POST" action="${pageContext.request.contextPath}/searchAccount">
<table>
	<tr>
        <td><form:label path="firstName">First Name</form:label></td>
       	<td><form:input path="firstName" /></td>
    </tr>
    <tr>
        <td><form:label path="lastName">Last Name</form:label></td>
        <td><form:input path="lastName" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Search"/>
        </td>
    </tr>
</table>
</form:form> 
<br>
<h3>Account List</h3>
<c:if test="${!empty listAccounts}">
    <table class="tg">
    <tr>
        <th width="80">Account ID</th>
        <th width="120">First Name</th>
        <th width="120">Last Name</th>
        <th width="80">Email</th>
        <th width="120">Country</th>
        <th width="120">Course</th>
        <th width="60">Training</th>
    </tr>
    <c:forEach items="${listAccounts}" var="account">
        <tr>
            <td width="80">${account.id}</td>
            <td width="120">${account.firstName}</td>
            <td width="120">${account.lastName}</td>
            <td width="80">${account.email}</td>
            <td width="120">${account.address.country}</td>
            <td width="120">${account.course.title}</td>
            <td width="60"><a href="<c:url value='/edit/${account.id}/${account.course.id}' />" >Add/View</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>

<a href="${pageContext.request.contextPath}/index.html">Home page</a><br/>
</body>
</html>