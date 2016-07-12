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
	height: 350px;
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
		<h2>Self-Profile</h2>
		<form:form method="POST" commandName="userForm">
			<form:errors path="*" cssClass="errorblock" element="div" />
			<table>
				<tr>
					<td>Profile:</td>
					<td><form:input path="remark" /></td>
					<td><form:errors path="remark" cssClass="error" /></td>
				</tr>
				<tr>
				<tr>
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