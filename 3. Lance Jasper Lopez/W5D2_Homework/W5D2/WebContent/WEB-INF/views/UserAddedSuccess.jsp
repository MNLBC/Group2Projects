<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Successful adding user</title>
</head>
<body>
	Hello ${user.name}
	<br> Your details are as follows:
	<br>
	<table>
		<tr>
			<td>Name :</td>
			<td>${user.name}</td>
		</tr>
		<tr>
			<td>User Name :</td>
			<td>${user.username}</td>
		</tr>
		<tr>
			<td>Mobile No :</td>
			<td>${user.mobile}</td>
		</tr>
		<tr>
			<td>Date of Birth(DD/MM/YY) :</td>
			<td>${user.dob}</td>
		</tr>
		<tr>
			<td>Email :</td>
			<td>${user.email}</td>
		</tr>
	</table>

	<a href="AddUser.html">Add Another User</a>
</body>
</html>