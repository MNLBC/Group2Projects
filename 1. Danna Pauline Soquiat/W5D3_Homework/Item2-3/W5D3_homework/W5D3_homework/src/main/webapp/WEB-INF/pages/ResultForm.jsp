<html>


<div align="center">
	<h2>Account Successfuly Registered!</h2>

	<table border="1">
		<tr>
			<td colspan="2">Account Information</td>
		</tr>
		<tr>
			<td>UserName :</td>
			<td>${user.userName}</td>
		</tr>
		<tr>
			<td>Password :</td>
			<td>${user.password}</td>
		</tr>
		<tr>
			<td>Full Name :</td>
			<td>${user.firstName}${user.middleName}${user.lastName}</td>
		</tr>
		<tr>
			<td>Contact Number: :</td>
			<td>${user.contactNumber}</td>
		</tr>
		<tr>
			<td>Email Address :</td>
			<td>${user.email}</td>
		</tr>
	</table>
</div>
</body>
</html>