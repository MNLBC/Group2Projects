<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>

<body>
	<div align="center">
		<h3>Account Credentials</h3>

		<form:form method="POST" commandName="userForm">
			<form:errors path="*" cssClass="errorblock" element="div" />
			<table border="1">
				<tr>
					<td>Username</td>
					<td><form:input path="userName" /></td>
					<td><form:errors path="userName" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><form:password path="password" /></td>
					<td><form:errors path="password" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Confirm Password</td>
					<td><form:password path="confirmPassword" /></td>
					<td><form:errors path="confirmPassword" cssClass="error" /></td>
				</tr>
				<tr>
					<td colspan="3" align="right"><input type="submit"
						value="Next" name="_target1" /> <input type="submit"
						value="Cancel" name="_cancel" /></td>
				</tr>

			</table>
		</form:form>
	</div>
</body>
</html>