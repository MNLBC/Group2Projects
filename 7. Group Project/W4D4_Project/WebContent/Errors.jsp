<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/sweetalert.css">
<script type="text/javascript" src="js/sweetalert.min.js"></script>
<title>Error</title>
</head>
<body>
<script type=text/javascript>
swal({
	  title: "Error!",
	  text: "Contact Support: Meynard Denoyo (09123456789).",
	  type: "error",
	  timer: 3000,
	  showConfirmButton: false
	}, function(){
	      window.location.href = "index.jsp";
	});
</script>
</body>
</html>