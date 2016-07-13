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
		<h2>User Information</h2>

		<form:form method="POST" commandName="userForm">
			<form:errors path="*" cssClass="errorblock" element="div" />
			<table border="1">
				<tr>
					<td>First Name</td>
					<td><form:input path="firstName" /></td>
					<td><form:errors path="firstName" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Middle Name</td>
					<td><form:input path="middleName" /></td>
					<td><form:errors path="middleName" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><form:input path="lastName" /></td>
					<td><form:errors path="lastName" cssClass="error" /></td>
				</tr>
				<tr>
				<tr>
					<td colspan="3"><input type="submit" value="Previous"
						name="_target0" /> <input type="submit" value="Next"
						name="_target2" /> <input type="submit" value="Cancel"
						name="_cancel" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>