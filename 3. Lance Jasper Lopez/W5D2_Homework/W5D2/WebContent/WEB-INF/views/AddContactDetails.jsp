<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/css/errors.css"
	rel="stylesheet" type="text/css">
<title>Add Contact</title>
</head>
<body>
	<form:form method="post" action="AddUser.html" name="user"
		commandName="user">
		<table>
			<tr>
				<td><form:label path="mobile">Mobile No:</form:label></td>
				<td><form:input path="mobile" /></td>
				<td><form:errors path="mobile" cssClass="errors" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email:</form:label></td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="errors" /></td>
			</tr>
			<tr>
				<td><input type="hidden" name="_page2" value="true" /></td>
				<td><input type="hidden" name="_finish" value="true" />
				<td>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" value="Store" /></td>
			</tr>
		</table>

	</form:form>
</body>
</html>