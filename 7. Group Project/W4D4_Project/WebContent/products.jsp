<!DOCTYPE HTML>
<html>
<head>
<title>Watch Me Whip</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript">
	
	
	
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 







</script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/component.css" rel='stylesheet' type='text/css' />
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
<script src="js/angular.min.js"></script>

<script src="js/productsController.js">
	
</script>
</head>
<body ng-app="myApp" ng-controller="productsController">
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
              aria-describedby="basic-addon1" id="email"
              name="userEmail"> <input type="password"
              placeholder="Password" aria-describedby="basic-addon1"
              id="pword" name="userPass">
            <button type="submit" class="btn btn-primary" id="btnlogin">Login</button>
            <a href="modalregister.html" class="btn btn-primary"
              data-toggle="modal" data-target="#modalregister"
              id="btnregister">Register</a>


          </div>
        </form>
		<%
			}else{
		%>
          <div class="col-md-5 col-md-offset-7">
          <ul class="header_user_info">
            <a class="login" href="login.html"> <i class="user">
            </i>My Account
            </a>
          </ul>
          <ul class="header_user_info">
            <a class="login" href="checkout.jsp">Cart <span class="badge"><%=session.getAttribute("cartItems")==null? 0 : session.getAttribute("cartItems")%></span></a>
          </ul>
		  <ul class="header_user_info">
            <a class="login" href="#">Users <span class="badge"><%=application.getAttribute("ctr")==null? 0 : application.getAttribute("ctr")%></span></a>
          </ul>
          <ul class="header_user_info">
            <a class="login" href="index.jsp">Logout </a>
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
				<div class="logo"></div>
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

	<div class="men">
		<div class="container">
			<div class="col-md-4 sidebar_men">
				<h3>Categories</h3>
				<ul class="product-categories color">
					<li class="cat-item cat-item-60"><a href="#"
						ng-click="getDataFromServer()">ALL</a> <span class="count">({{catCount.All}})</span></li>
					<li class="cat-item cat-item-60"><a href="#"
						ng-click="getDataFromServerByCat('Luxury')">LUXURY</a> <span
						class="count">({{catCount.Luxury}})</span></li>
					<li class="cat-item cat-item-63"><a href="#"
						ng-click="getDataFromServerByCat('Dress')">DRESS</a> <span
						class="count">({{catCount.Dress}})</span></li>
					<li class="cat-item cat-item-55"><a href="#"
						ng-click="getDataFromServerByCat('Casual')">CASUAL</a> <span
						class="count">({{catCount.Casual}})</span></li>
					<li class="cat-item cat-item-64"><a href="#"
						ng-click="getDataFromServerByCat('Digital')">DIGITAL</a> <span
						class="count">({{catCount.Digital}})</span></li>
			</div>
			<div class="col-md-8 mens_right">
				<div class="dreamcrub">

					<ul class="previous">
						<li><a href="index.html">Back to Previous Page</a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="mens-toolbar">


					<div class="clearfix"></div>
				</div>
				<div id="cbp-vm" class="cbp-vm-switcher cbp-vm-view-grid">

					<div class="clearfix"></div>
					<ul id="listcategories">

						<li ng-repeat="product in products" class="simpleCart_shelfItem"><a
							class="cbp-vm-image" href="single.html">
								<div class="view view-first">
									<div class="inner_content clearfix">
										<div class="product_image">
											<div class="mask1">
												<img
													src="images/{{product.prodCat}}/{{product.prodImg}}"
													alt="image" class="img-responsive zoom-img">
											</div>
											<div class="mask">
												<div class="info" ng-if="product.prodSale != null">{{product.prodSale}}%
													Off</div>
											</div>
											<div class="product_container">
												<h4>{{product.prodName}}</h4>
												<p>{{product.prodCat}}</p>
												<p class="desc">{{product.prodDesc}}</p>
												<div class="price mount item_price">¥{{product.prodPrice}}</div>
												<a class="button item_add cbp-vm-icon cbp-vm-add"
													ng-click="addToCart(product.prodId)">Add to cart</a>
											</div>
										</div>
									</div>
								</div>
						</a></li>

					</ul>

				</div>
				<div class="row">
					<div class="col-md-6">
						<a href="#" ng-click="checkOut()" class="btn btn-primary"
							 id="btnregister">Pay</a>
					</div>

				</div>
				<div class="modal fade" id="modalpay" tabindex="-1"
					role="dialog" aria-labelledby="modal-register-label"
					aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content"></div>
					</div>

				</div>
				<script src="js/cbpViewModeSwitch.js" type="text/javascript"></script>
				<script src="js/classie.js" type="text/javascript"></script>
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
