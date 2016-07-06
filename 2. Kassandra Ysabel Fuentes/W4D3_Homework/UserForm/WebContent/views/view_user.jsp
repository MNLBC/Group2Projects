<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.oocl.mnlbc.model.User,java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show User</title>
<script>
function confirmDelete(id) {
  var r = confirm("Are you sure you want to delete user account" + id + "?");
  if(r == true) {
    window.location.href="DeleteUser?id=" + id;
  }
}
</script>
<link rel="stylesheet" href="style.css">
</head>
<body>
<h1>Show User</h1>
<% if(request.getParameter("addsuccess") != null) { %>
<p style="color:red">User added successfully.</p>
<% } else if(request.getParameter("editsuccess") != null) { %>
<p style="color:red">User updated successfully.</p>
<% } else if(request.getParameter("delsuccess") != null) {%>
<p style="color:red">User deleted successfully.</p>
<% } %>
<table border="1">
  <tr>
    <td>User ID</td>
    <td>Name</td>
    <td>Address</td>
     <td>Email</td>
    <td>Username</td>
    <td>Password</td>
    <td>&nbsp;</td>
  </tr>
  <% 
  List<User> usr = (List<User>) request.getAttribute("usr");
  
  for(User usrs : usr) {
  %>
  <tr>
    <td><%= usrs.getId() %></td>
    <td><%= usrs.getLastName() + ", " + usrs.getFirstName() %></td>
    <td><%= usrs.getAddress() %></td>
    <td><%= usrs.getEmail() %></td>
    <td><%= usrs.getUserName() %></td>
    <td><%= usrs.getPassword() %></td>
    <td><a href="EditUser?id=<%= usrs.getId() %>">Edit</a>
      <a href="#" onClick="confirmDelete('<%= usrs.getId() %>')">Delete</a>
  </tr>
  <%
  }
  %>
</table>
<a href="AddUser">Add New User</a>
</body>
</html>