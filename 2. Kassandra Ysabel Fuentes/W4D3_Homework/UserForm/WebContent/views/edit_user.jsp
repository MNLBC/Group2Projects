<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1" import="com.oocl.mnlbc.model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
  <h1>Edit User Information</h1>
  <%
     User usr = (User) request.getAttribute("usr");
  %>
  <form method="POST" action="EditUser">
    <div class="box">
      <table>
        <tr>
          <td>User ID</td>
          <td><input type="text" name="usr_id" readonly="readonly"
            value="<%=usr.getId()%>"></td>
        </tr>
        <tr>
          <td>First Name</td>
          <td><input type="text" name="first_name"
            value="<%=usr.getFirstName()%>"></td>
        </tr>
        <tr>
          <td>Last Name</td>
          <td><input type="text" name="last_name"
            value="<%=usr.getLastName()%>"></td>
        </tr>
        <tr>
          <td>Address</td>
          <td><input type="text" name="address"
            value="<%=usr.getAddress()%>"></td>
        </tr>
        <tr>
          <td>Email</td>
          <td><input type="email" name="email"
            value="<%=usr.getEmail()%>"></td>
        </tr>
        <tr>
          <td>Username</td>
          <td><input type="text" name="username"
            value="<%=usr.getUserName()%>"></td>
        </tr>
        <tr>
          <td>Password</td>
          <td><input type="password" name="password"
            value="<%=usr.getPassword()%>"></td>
        </tr>
      </table>
      <input type="submit" value="Update"> <input type="button"
        value="Cancel" onclick="window.location.href='ShowUser'">
  </form>
  </div>
</body>
</html>