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
		<h2>Contact Information</h2>

		<form:form method="POST" commandName="userForm">
			<form:errors path="*" cssClass="errorblock" element="div" />
			<table border="1">
				<tr>
					<td>Contact Number</td>
					<td><form:input path="contactNumber" /></td>
					<td><form:errors path="contactNumber" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><form:input path="email" /></td>
					<td><form:errors path="email" cssClass="error" /></td>
				</tr>
				<tr>
				<tr align="right">
					<td colspan="3"><input type="submit" value="Previous"
						name="_target1" /> <input type="submit" value="Finish"
						name="_finish" /> <input type="submit" value="Cancel"
						name="_cancel" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>