<html>
<head>
<style>
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
	<div class="box"></div>
	<h2>Registration Form</h2>

	<table>
		<tr>
			<td>UserName :</td>
			<td>${user.userName}</td>
		</tr>
		<tr>
			<td>Password :</td>
			<td>${user.password}</td>
		</tr>
		<tr>
			<td>Remark :</td>
			<td>${user.remark}</td>
		</tr>
	</table>
	</div>
</body>
</html>