<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/css/errors.css"
	rel="stylesheet" type="text/css">
<title>Add User</title>
</head>
<body>
<h2>User Registration</h2>
	<form:form method="post" action="AddUser.html" name="user"
		commandName="user">
		<table>
			<tr>
				<td><form:label path="name">Name:</form:label></td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="errors" /></td>
			</tr>
			<tr>
				<td><form:label path="username">Username:</form:label></td>
				<td><form:input path="username" /></td>
				<td><form:errors path="username" cssClass="errors" /></td>
			</tr>
			<tr>
				<td><input type="hidden" name="_page0" value="true" /></td>
				<td><input type="hidden" name="_target1" value="true" />
				<td>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" value="Next" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>