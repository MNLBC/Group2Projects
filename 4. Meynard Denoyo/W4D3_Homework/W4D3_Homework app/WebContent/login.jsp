<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
<%
String type = (String)request.getAttribute("type");
String user = (String)request.getAttribute("user");
if(type == null){
   out.print("");
}else if(type == "userexist"){
   out.print("alert('User " + user + " already exists!')");
}
%>
</script>
</head>

<body id="body">
		<center>
		<form action='register' method='post'>
		<div id="form" style="border-width: thin; border-style:solid; border-radius: 5px; border-color: gray; width:28%; margin-top:30px; margin-bottom:30px">
		<h1 style="font-weight: bold;font-family: Arial; text-align:left; margin-left: 20px; font-weight: 400;
		font-size: 28px;">Create account</h1>
		
		<p style="font-weight: bold;font-family: Arial;text-align:left; margin-left: 20px; margin-bottom:-15px">Your first name</p><br>
		<input style="border-radius: 4px;width:90%; margin-top:0px; height: 35px" type="text" name='fname'>
		
		<p style="font-weight: bold;font-family: Arial;text-align:left; margin-left: 20px; margin-bottom:-15px">Your last name</p><br>
		<input style="border-radius: 4px;width:90%; margin-top:0px; height: 35px" type="text" name='lname'>
		
		<p style="font-weight: bold;font-family: Arial;text-align:left; margin-left: 20px; margin-bottom:0px;margin-bottom:-15px">Email</p><br>
		<input style="border-radius: 4px;width:90%; margin-top:0px; height: 35px" type="email" name='email'>
		
		<p style="font-weight: bold;font-family: Arial;text-align:left; margin-left: 20px; margin-bottom:0px;margin-bottom:-15px">Username</p><br>
		<input style="border-radius: 4px;width:90%; margin-top:0px; height: 35px" type="text" name='uname'>
		
		<p style="font-weight: bold;font-family: Arial;text-align:left; margin-left: 20px; margin-bottom:0px;margin-bottom:-15px">Password</p><br>
		<input style="border-radius: 4px;width:90%; margin-top:0px; height: 35px" type="password" placeholder="at least 6 characters" name='pword'>
		
		<p style="font-weight: bold;font-family: Arial;text-align:left; margin-left: 20px; margin-bottom:0px;margin-bottom:-15px">Password Again</p><br>
		<input style="border-radius: 4px;width:90%; margin-top:0px; height: 35px" type="password"><br>
		
		<%
		if(type == null){
		   out.print("");
		}else if(type == "fieldsempty"){
		   out.print("<span style='color:red'>Please input all fields</span>");
		}
		%>
		
		<input type='submit' name='Create your User account' style="border-style: solid; border-width: 1px; font-size: 11pt;font-family: Arial;border-radius:5px; width:90%; height:35px; margin-top:20px; margin-bottom:20px;">
		</form>
		
		</center>
	</body>
</html>