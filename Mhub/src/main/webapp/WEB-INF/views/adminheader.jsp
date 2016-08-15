
<%@ include file="/WEB-INF/views/header.jsp"%>
<body background=".jpg">
	<div class="jumbotron">
		<div class="container text-center">
			<h1>ABAYAS ONLINE STORE</h1>
			<p>MISSION, VISION & VALUES</p>
		</div>
	</div>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">ABAYAS</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="index.jsp"> <span
							class="glyphicon glyphicon-home" aria-hidden="true"></span></a></li>

					<li><a href="login">LOGIN</a></li>
					<li><a href="categories">AddCategories</a></li>
					<li><a href="suppliers">AddSuppliers</a></li>
					<li><a href="Products">AddProducts</a></li>
					<li><a href="viewproduct">ViewProduct</a></li>
					<li><a href="viewsupplier">ViewSupplier</a></li>
					<li><a href="viewcategory">ViewCategory</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
				<li><a href="ManageUsers">ManageUsers</a></li>
					<li><a href="#"><span class="glyphicon glyphicon-user"></span>
							Your Account</a></li>
							<font size="3" color="Red"><%=session.getAttribute("UNAME") %></font>
					<li><a href="cart"><span
							class="glyphicon glyphicon-shopping-cart"></span>Cart</a></li>
				</ul>
			</div>
		</div>
	</nav>