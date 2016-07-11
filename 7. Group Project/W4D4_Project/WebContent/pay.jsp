<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Watches an E-Commerce online Shopping Category Flat
  Bootstrap Responsive Website Template| Home :: w3layouts</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
  content="Watches Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="css/form-elements.css" type='text/css' />
<link href='//fonts.googleapis.com/css?family=PT+Sans+Narrow:400,700'
  rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Dorsa' rel='stylesheet'
  type='text/css'>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<link href="css/megamenu.css" rel="stylesheet" type="text/css"
  media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>
	$(document).ready(function() {
		$(".megamenu").megamenu();
	});
</script>
<script src="js/jquery.easydropdown.js"></script>
<script src="js/simpleCart.min.js">
	
</script>
<script>
	$(document).ready(function() {
		$("#sample").load("modal.html #myModal");
	});
</script>
</head>
<body>
<div class="men_banner">
    <div class="container">
      <div class="header-top">
        <form class="form-inline" action="login" method="post">

          <div class="col-md-6 col-md-offset-6">
            <input type="email" placeholder="Email Address"
              aria-describedby="basic-addon1" id="email"
              name="userEmail"> <input type="password"
              placeholder="Password" aria-describedby="basic-addon1"
              id="pword" name="userPass">
            <button type="submit" class="btn btn-primary" id="btnlogin">Login</button>
            <a href="modal.html" class="btn btn-primary"
              data-toggle="modal" data-target="#modalregister"
              id="btnregister">Register</a>
          </div>
        </form>
        <div class="col-md-5 col-md-offset-7" hidden="true">
          <ul class="header_user_info">
            <a class="login" href="login.html"> <i class="user">
            </i>My Account
            </a>
          </ul>
          <ul class="header_user_info">
            <a class="login" href="#">Cart <span class="badge"><%=session.getAttribute("cartItems")==null? 0 : session.getAttribute("cartItems")%></span></a>
          </ul>
		  <ul class="header_user_info">
            <a class="login" href="#">Users <span class="badge"><%=application.getAttribute("ctr")==null? 0 : application.getAttribute("ctr")%></span></a>
          </ul>
          <ul class="header_user_info">
            <a class="login" href="http://localhost:8080/W4D4_Project/logout">Logout </a>
          </ul>
        </div>
        <div class="modal fade" id="modalregister" tabindex="-1"
          role="dialog" aria-labelledby="modal-register-label"
          aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content"></div>
          </div>

        </div>

      </div>
      <div class="header_bottom">

        <div class="menu">
          <ul class="megamenu skyblue">
            <li><a class="color2" href="../index.jsp">Home</a></li>
			<li><a class="color4" href="products.html">Products</a></li>
			<li><a class="color3" href="about.html">About</a></li>
          </ul>
        </div>
        <div class="clearfix"></div>
      </div>
    </div>
  </div>
<div class="modal-header" id="modalheader">
  <button type="button" class="close" data-dismiss="modal" id="close">
    <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
  </button>
  <h3 class="modal-title" id="myModalLabel">Checkout</h3>
</div>
<div class="modal-body" id="modalheader">
	
  <div class="container">
	<div class="row">
		<div class="col-md-12" style="text-align:left;">
			Meynard Denoyo
		</div>
	</div>
	<div class="row">
		<div class="col-md-12" style="text-align:left; color: #BBB">
			<h3>Sample Address</h3>
		</div>
	</div>
  </div>
  <div class="container">
	<div class="row">
		<div class="col-md-2 col-md-offset-2">
			<h3 id="payheader">Item</h3>
		</div>
		<div class="col-md-2">
			<h3 id="payheader">Price</h3>
		</div>
		<div class="col-md-2">
			<h3 id="payheader">Quantity</h3>
		</div>
		<div class="col-md-2">
			<h3 id="payheader">Subtotal</h3>
		</div>
	</div>
	<div class="row">
		<div class="col-md-2 col-md-offset-2">
			Item 1
		</div>
		<div class="col-md-2">
			Price
		</div>
		<div class="col-md-2">
			Quantity
		</div>
		<div class="col-md-2">
			Subtotal
		</div>
	</div>
  </div>
  <h1>Total: 400.00</h1>
  <div class="form-group">
      <button type="submit" class="btn btn-primary" id="btnsignup">Pay</button>
  </div>
</div>

</body>
</html>