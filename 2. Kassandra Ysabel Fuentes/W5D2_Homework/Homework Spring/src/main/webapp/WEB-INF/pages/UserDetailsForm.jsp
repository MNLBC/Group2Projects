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

.box {
	background-color: white;
	top: 50%;
	left: 49%;
	transform: translate(-50%, -45%);
	height: 500px;
	position: fixed;
	width: 500px;
	padding: 10px;
	font-family: 'Palanquin', sans-serif;
	font-size: 20px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.4);
}
</style>
</head>

<body>
	<div class="box">
		<h2>User Details</h2>
		<form:form method="POST" commandName="userForm">
			<form:errors path="*" cssClass="errorblock" element="div" />
			<table>
				<tr>
					<td>First Name :</td>
					<td><form:input path="userFname" /></td>
					<td><form:errors path="userFname" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Last Name :</td>
					<td><form:input path="userLname" /></td>
					<td><form:errors path="userLname" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Email :</td>
					<td><form:input path="userEmail" /></td>
					<td><form:errors path="userEmail" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Address :</td>
					<td><form:textarea path="userAddress" /></td>
					<td><form:errors path="userAddress" cssClass="error" /></td>
				</tr>
				<tr>
				<tr>
					<td colspan="3"><input type="submit" value="Next"
						name="_target1" /> <input type="submit" value="Cancel"
						name="_cancel" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>