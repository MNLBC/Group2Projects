<!DOCTYPE HTML>
<html>
<head>
<title>Watches an E-Commerce online Shopping Category Flat
	Bootstrap Responsive Website Template| Checkout :: w3layouts</title>
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
<script src="js/angular.min.js">
	
</script>

<script src="js/checkOutController.js">
	
</script>
</head>
<body ng-app="myApp" ng-controller="checkOutController">
	<div class="men_banner">
		<div class="container">
			<div class="header-top">
			<%@ page import="com.oocl.mnlbc.bean.User"  %>
		<%
			
			User user = (User)session.getAttribute("user");
			
			if(user == null){
		%>
				<form class="form-inline" action="login" method="post">

					<div class="col-md-6 col-md-offset-6">
						<input type="email" placeholder="Email Address"
							aria-describedby="basic-addon1" id="email" name="userEmail">
						<input type="password" placeholder="Password"
							aria-describedby="basic-addon1" id="pword" name="userPass">
						<button type="submit" class="btn btn-primary" id="btnlogin">Login</button>
						<a href="modalregister.html" class="btn btn-primary" data-toggle="modal"
							data-target="#modalregister" id="btnregister">Register</a>
					</div>
				</form>
				<%
			}else{
		%>
				<div class="col-md-5 col-md-offset-7">
					<ul class="header_user_info">
						<a class="login" href="login.html"> <i class="user"> </i>My
							Account
						</a>
					</ul>
					<ul class="header_user_info">
						<a class="login" href="#">Cart <span class="badge"><%=session.getAttribute("cartItems") == null ? 0 : session.getAttribute("cartItems")%></span></a>
					</ul>
					<ul class="header_user_info">
						<a class="login" href="#">Users <span class="badge"><%=application.getAttribute("ctr")%></span></a>
					</ul>
					<ul class="header_user_info">
						<a class="login" href="login.html">Logout </a>
					</ul>
				</div>
				<% }%>
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
						<li><a class="color2" href="index.jsp">Home</a></li>
						<li><a class="color4" href="products.jsp">Products</a></li>
						<li><a class="color3" href="about.jsp">About</a></li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<div class="account-in">
		<div class="container">
			<div class="check_box">
				<div class="col-md-9 cart-items">
					<h1>My Shopping Bag (2)</h1>
					<script>
						$(document).ready(function(c) {
							$('.close1').on('click', function(c) {
								$('.cart-header').fadeOut('slow', function(c) {
									$('.cart-header').remove();
								});
							});
						});
					</script>
					<div class="cart-header">
						<div class="close1"></div>
						<div class="cart-sec simpleCart_shelfItem">
							<div class="cart-item cyc">
								<img src="images/m3.jpg" class="img-responsive" alt="" />
							</div>
							<div class="cart-item-info">
								<h3>
									<a href="#">Mountain Hopper(XS R034)</a><span>Model No:
										3578</span>
								</h3>
								<ul class="qty">
									<li><p>Size : 5</p></li>
									<li><p>Qty : 1</p></li>
								</ul>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
					<script>
						$(document).ready(function(c) {
							$('.close2').on('click', function(c) {
								$('.cart-header2').fadeOut('slow', function(c) {
									$('.cart-header2').remove();
								});
							});
						});
					</script>
					<div class="cart-header2">
						<div class="close2"></div>
						<div class="cart-sec simpleCart_shelfItem">
							<div class="cart-item cyc">
								<img src="images/m4.jpg" class="img-responsive" alt="" />
							</div>
							<div class="cart-item-info">
								<h3>
									<a href="#">Mountain Hopper(XS R034)</a><span>Model No:
										3578</span>
								</h3>
								<ul class="qty">
									<li><p>Size : 5</p></li>
									<li><p>Qty : 1</p></li>
								</ul>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<div class="col-md-3 cart-total">

					<div class="price-details">
						<h3>Price Details</h3>
						<span>Total</span> <span class="total1">6200.00</span>
						<div class="clearfix"></div>
					</div>
					<ul class="total_price">
						<li class="last_price">
							<h4>TOTAL</h4>
						</li>
						<li class="last_price"><span>6350.00</span></li>
						<div class="clearfix"></div>
					</ul>
					<div class="clearfix"></div>
					<a href="pay.jsp" class="order" data-toggle="modal"
						data-target="#modalpay">Pay</a>
				</div>
				<div class="modal fade" id="modalpay" tabindex="-1" role="dialog"
					aria-labelledby="modal-register-label" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content"></div>
					</div>

				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>

	<div class="footer">
		<div class="container">
			<div class="clearfix"></div>
			<div class="copy">
				<p>
					&copy; Design by <a href="#" target="_blank">ITA 2016 GROUP 2</a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>
