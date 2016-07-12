
<!DOCTYPE HTML>
<html>
<head>
<title>Watch Me Whip</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/component.css" rel='stylesheet' type='text/css' />
<link href='//fonts.googleapis.com/css?family=PT+Sans+Narrow:400,700' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Dorsa' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<script src="js/jquery.easydropdown.js"></script>
<script src="js/simpleCart.min.js"> </script>
<script src="js/angular.min.js"></script>

<script>
	var myApp = angular.module('myApp', []);

	myApp.controller('MyController',function  MyController($scope, $http) {

		$scope.getDataFromServer = function() {
			$http({
				method : 'GET',
				url : 'getProducts'
			}).success(function(data, status, headers, config) {
				$scope.products = data;
				console.log($scope.products);
			}).error(function(data, status, headers, config) {
				// called asynchronously if an error occurs
				// or server returns response with an error status.
			});

		};
		
		$scope.getDataFromServer();
	});
</script> 
</head>
<body ng-app="myApp" ng-controller="MyController">
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
            </i><%= user.getUserFname()%>
            </a>
          </ul>
          <ul class="header_user_info">
            <a class="login" href="checkout.jsp">Cart <span class="badge"><%=session.getAttribute("cartItems")==null? 0 : session.getAttribute("cartItems")%></span></a>
          </ul>
		  <ul class="header_user_info">
            <a class="login" href="#">Users <span class="badge"><%=application.getAttribute("ctr")==null? 0 : application.getAttribute("ctr")%></span></a>
          </ul>
          <ul class="header_user_info">
            <a class="login" href="/W4D4_Project/logout">Logout </a>
          </ul>
        </div>
        
        <% }%>
		<div class="modal fade" id="modalregister" tabindex="-1" role="dialog" aria-labelledby="modal-register-label" aria-hidden="true">
        	<div class="modal-dialog">
        		<div class="modal-content">
        			
        			
        			
        		</div>
        	</div>

		</div>
		
	  </div>
	  <div class="header_bottom">
	   <div class="logo">
		  <h1>
            <a href="index.jsp" id="title"><span class="m_1"></span></a>
          </h1>
	   </div>
   	   <div class="menu">
	     <ul class="megamenu skyblue">
			<li><a class="color2" href="index.jsp">Home</a></li>
			<li><a class="color4" href="products.jsp">Products</a></li>
			<li><a class="color3" href="about.html">About</a></li>
			</ul>
			</div>
	        <div class="clearfix"> </div>
	        </div>
	    </div>
   </div>
   <br>
   <br>
   <div class="main">
		<div class="container" id="aboutus">
			<div class="row">
			<div class="col-md-2 col-md-offset-3">
				<img src="images/danna.jpg" class="img-responsive img-circle img-thumbnail"/>
			</div>
			<div class="col-md-2">
				<img src="images/kass.jpg" class="img-responsive img-circle img-thumbnail"/>
			</div>
			<div class="col-md-2">
				<img src="images/lance.jpg" class="img-responsive img-circle img-thumbnail"/>
			</div>
			</div>
			<div class="row">
			<div class="col-md-2 col-md-offset-3">
				<h2>Danna Pauline Soquiat</h2>
			</div>
			<div class="col-md-2">
				<h2>Kassandra Ysabel Fuentes</h2>
			</div>
			<div class="col-md-2">
				<h2>Lance Jasper Lopez</h2>
			</div>
			</div>
			<br>
			<br>
			<div class="row">
			<div class="col-md-2 col-md-offset-3">
				<img src="images/nard.png" class="img-responsive img-circle img-thumbnail"/>
			</div>
			<div class="col-md-2">
				<img src="images/william.jpg" class="img-responsive img-circle img-thumbnail"/>
			</div>
			<div class="col-md-2">
				<img src="images/ziggy.jpg" class="img-responsive img-circle img-thumbnail"/>
			</div>
			</div>
			<div class="row">
			<div class="col-md-2 col-md-offset-3">
				<h2>Meynard Denoyo</h2>
			</div>
			<div class="col-md-2">
				<h2>William Kalingasan</h2>
			</div>
			<div class="col-md-2">
				<h2>Ziegfried Morissey Flameno</h2>
			</div>
		</div>
   </div>
	 
   <div class="footer">
   	 <div class="container">
	    <div class="copy">
            <p> &copy; Design by <a href="#" target="_blank">ITA 2016 GROUP 2</a></p>
	    </div>
   	</div>
   </div>
</body>
</html>		