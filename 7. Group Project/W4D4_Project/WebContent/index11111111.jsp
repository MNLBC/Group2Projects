<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ page
  import="com.oocl.mnlbc.bean.User, com.oocl.mnlbc.listener.UserListener, java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
<link rel="stylesheet" href="style2222222222.css">
</head>
<body>
  <%

  			Integer counter = (Integer) session.getAttribute("userCounter");
  %>
  <form method="post" action="login">
    <div class="box">
      <p style="margin-top: 50px; margin-left: 100px;">
        Username: &nbsp<input type="text" name="userEmail" value=""
          >
      </p>
      <p style="margin-left: 100px;">
        Password: &nbsp<input type="password" name="userPass" value=""
          style="margin-left: 4px;" >
      </p>
      <br>
        <button id="login" type=submit>LOGIN</button>
  </form>
  <i><a href="AddUser">Register account</a></i>

  </div>
</body>
</html>