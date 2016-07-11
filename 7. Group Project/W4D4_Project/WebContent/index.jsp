
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
  <div class="banner">
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
            <a class="login" href="#">Cart <span class="badge"><%=session.getAttribute("cartItems")==null? 0 : session.getAttribute("cartItems")%></span></a>
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
        <div class="logo">
          <h1>
            <a href="index.jsp" id="title"><span class="m_1"></span></a>
          </h1>
        </div>
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
  <div class="main">
    <br> <br>
    <div class="middle_content">
      <div class="container">
        <h2>Welcome</h2>
        <p>There are many variations of passages of Lorem Ipsum
          available, but the majority have suffered alteration in some
          form, by injected humour, or randomised words which don't look
          even slightly believable. If you are going to use a passage of
          Lorem Ipsum, you need to be sure there isn't anything
          embarrassing hidden in the middle of text. All the Lorem Ipsum
          generators on the Internet tend to repeat predefined chunks as
          necessary, making this the first true generator on the
          Internet. It uses a dictionary of over 200 Latin words,
          combined with a handful of model sentence structures, to
          generate Lorem Ipsum which looks reasonable. The generated
          Lorem Ipsum is therefore always free from repetition, injected
          humour, or non-characteristic words etc.</p>
      </div>
    </div>
    <div class="container">
      <ul class="content-home" id="listcategories">
        <li class="col-sm-4"><a href="luxury.html"
          class="item-link" title="">
            <div class="bannerBox">
              <img src="images/w1.png" class="item-img" title=""
                alt="" width="100%" height="100%">
              <div class="item-html">
                <h3>Luxury</h3>
                <p>Lorem ipsum dolor sit amet consectetur
                  adipisicing.</p>
                <button>Shop now!</button>
              </div>
            </div>
        </a></li>
        <li class="col-sm-4"><a href="dress.html"
          class="item-link" title="">
            <div class="bannerBox">
              <img src="images/w2.png" class="item-img" title=""
                alt="" width="100%" height="100%">
              <div class="item-html">
                <h3>Dress</h3>
                <p>Lorem ipsum dolor sit amet consectetur
                  adipisicing.</p>
                <button>Shop now!</button>
              </div>
            </div>
        </a></li>
        <li class="col-sm-4"><a href="sports.html"
          class="item-link" title="">
            <div class="bannerBox">
              <img src="images/w3.jpg" class="item-img" title=""
                alt="" width="100%" height="100%">
              <div class="item-html">
                <h3>Sports</h3>
                <p>Lorem ipsum dolor sit amet consectetur
                  adipisicing.</p>
                <button>Shop now!</button>
              </div>
            </div>
        </a></li>
        <li class="col-sm-4 col-sm-offset-2"><a href="casual.html"
          class="item-link" title="">
            <div class="bannerBox">
              <img src="images/w4.png" class="item-img" title=""
                alt="" width="100%" height="100%">
              <div class="item-html">
                <h3>Casual</h3>
                <p>Lorem ipsum dolor sit amet consectetur
                  adipisicing.</p>
                <button>Shop now!</button>
              </div>
            </div>
        </a></li>
        <li class="col-sm-4"><a href="digital.html"
          class="item-link" title="">
            <div class="bannerBox">
              <img src="images/w5.png" class="item-img" title=""
                alt="" width="100%" height="100%">
              <div class="item-html">
                <h3>Digital</h3>
                <p>Lorem ipsum dolor sit amet consectetur
                  adipisicing.</p>
                <button>Shop now!</button>
              </div>
            </div>
        </a></li>
        <div class="clearfix"></div>
      </ul>
    </div>
	<div class="footer">
    <div class="container">
      <div class="copy">
        <p>
          &copy; Design by <a href="about.html" target="_blank">ITA 2016
            GROUP 2</a>
        </p>
      </div>
    </div>
  </div>
  </div>
  <script
    src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
</body>
</html>
