<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
  <form method="post" action="LoginUser">

    <div class="box">
      <p style="margin-top: 70px; margin-left: 100px;">
        Username: &nbsp<input type="text" name="username" value=""
          required>
      </p>
      <p style="margin-left: 100px;">
        Password: &nbsp<input type="password" name="password" value=""
          style="margin-left: 4px;" required>
      </p>
      <button id="login" type=submit>LOGIN</button>
  </form>
  <i><a href="AddUser">Register account</a></i>
  </div>
</body>
</html>