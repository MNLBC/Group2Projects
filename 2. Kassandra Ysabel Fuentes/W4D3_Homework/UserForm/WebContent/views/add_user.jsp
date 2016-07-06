<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register User</title>
<link href='https://fonts.googleapis.com/css?family=Cairo:400,200' rel='stylesheet' type='text/css'>
</head>
<body>
<h1>User Registration</h1>
<div class="box1">
<form method="POST" action="AddUser">
<table>
	<tr>
		<td>User ID</td>
		<td><input type="text" name="usr_id"></td>
	</tr>
	<tr>
		<td>First Name</td>
		<td><input type="text" name="first_name" required></td>
	</tr>
  <tr>
    <td>Last Name</td>
    <td><input type="text" name="last_name" required></td>
  </tr>
	<tr>
		<td>Address</td>
		<td><input type="text" name="address" size="45"></td>
	</tr>
	<tr>
		<td>Email</td>
		<td><input type="email" name="email" required></td>
	</tr>
	<tr>
		<td>Username</td>
		<td><input type="text" name="username" required></td>
	</tr>
  <tr>
    <td>Password</td>
    <td><input type="password" name="password" required></td>
  </tr>
</table>
<input type="submit" value="Add"> <input type="button" value="Cancel" onclick="window.location.href='ShowUser'">
</form>
</div>
</body>
</html>