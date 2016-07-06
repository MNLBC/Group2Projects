<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Week 4 Day 3 Homework</title>
	</head>
	<style type ="text/css">
		body{
			font-family:Arial;
		}
		span{
			font-size:25px;
		}
		form{
			width: 365px;
		    height: 400px;
			margin:auto;
		}
		input[type=text]{
			width: 325px;
			height:35px;
			border:2px solid gray;
			box-sizing: border-box;
			border-radius: 4px;
		}
		input[type=password]{
			font-size:18px;
			width: 325px;
			height:35px;
			border:2px solid gray;
			box-sizing: border-box;
			border-radius: 4px;
		}
	</style>
	<body>
		<center>
			<h1>Register Now!</h1>
		
		<form action = "registeruser">
			<fieldset>
				<span>Create Account</span><br><br>
				<label for="firstname">First Name</label><br>
				<input type="text" id="firstname" name="firstname"><br><br>
				<label for="lastname">Last Name</label><br>
				<input type="text" id="lastname" name="lastname"><br><br>
				<label for="username">Username</label><br>
				<input type="text" id="username" name="username"><br><br>
				<label for="pword">Password</label><br>
				<input type="password" id="pword" name="pword" placeholder="at least 6 characters"><br><br>
				<label for="confirmpword">Password Again</label><br>
				<input type="password" id="confirmpword" name="confirmpword"><br><br>
				<input type="submit"/>
			</fieldset>
		</form>
		<br><br><br>
		<%= request.getAttribute("req")%>
		</center>
	</body>
</html>