<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/css/errors.css"
	rel="stylesheet" type="text/css">
<title>Add User Credential</title>
</head>
<body>
	<form:form method="post" action="AddUser.html" name="user"
		commandName="user">
		<table>
			<tr>
				<td><form:label path="password">Password:</form:label></td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" cssClass="errors" /></td>
			</tr>
			<tr>
				<td><form:label path="rpassword">Confirm Password:</form:label></td>
				<td><form:password path="rpassword" /></td>
				<td><form:errors path="rpassword" cssClass="errors" /></td>
			</tr>
			<tr>
				<td><form:label path="dob">Date of Birth(DD/MM/YY):</form:label></td>
				<td><form:input path="dob" /></td>
				<td><form:errors path="dob" cssClass="errors" /></td>
			</tr>
			<tr>
				<td><input type="hidden" name="_page1" value="true" /></td>
				<td><input type="hidden" name="_target2" value="true" />
				<td>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" value="Next" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>