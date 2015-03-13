<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Enter details of Account
 
<h2>Student Information</h2>
<form:form method="POST" action="${pageContext.request.contextPath}/addAccount">
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
        <td><form:label path="email">Email</form:label></td>
        <td><form:input path="email" /></td>
    </tr>
    <tr>
        <td><form:label path="activeState">Active State</form:label></td>
        <td><form:input path="activeState" /></td>
    </tr>
    <tr>
        <td><form:label path="address.streetName">Street Name</form:label></td>
        <td><form:input path="address.streetName" /></td>
    </tr>
    <tr>
        <td><form:label path="address.suburb">Suburb</form:label></td>
        <td><form:input path="address.suburb" /></td>
    </tr>
    <tr>
        <td><form:label path="address.country">Country</form:label></td>
        <td><form:input path="address.country" /></td>
    </tr>
    <tr>
		<td><form:label path="courseTitle">Course</form:label></td>
		<td><form:select path="courseTitle">
				<form:option value="NONE" label="-- Select --" />
				<c:forEach var="course" items="${courseList}">
					<form:option  itemLabel="${course.title}"  value="${course.title}" />
				</c:forEach>
		    </form:select>
		    <%-- <form:select path="courseTitle">
     			<form:options items="${courseList}"></form:options>                                                                                                       
 			</form:select>  --%>   
        </td>
	</tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>
</form:form>  
</body>
</html>