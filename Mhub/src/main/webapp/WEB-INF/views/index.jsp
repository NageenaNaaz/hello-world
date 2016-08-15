<!DOCTYPE html>

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
					<li><a href="signup">REGISTER</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="carousel-inner" role="listbox">
		<div class="item active">

			<br>
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
					<li data-target="#myCarousel" data-slide-to="3"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img src="resources/images/1.jpg" alt="resources/images/1.jpg"
							width="600" height="145" />
					</div>

					<div class="item">
						<img src="resources/images/2.jpg" alt="resources/images/2.jpg"
							width="600" height="145">
					</div>

					<div class="item">
						<img src="resources/images/3.jpg" alt="resources/images/3.jpg"
							width="600" height="145">
					</div>

				</div>

				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel" role="button"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#myCarousel" role="button"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>
	</div>
	<div class="container">

		<div class="row">
			<div class="col-sm-4">
				<p class="text-center">
					<strong>Name</strong>
				</p>
				<br> <a href="#demo" data-toggle="collapse"> <img
					src="resources/images/4.jpg" class="img-circle person"
					alt="Random Name" width="255" height="255">
				</a>
				<div id="demo" class="collapse">
					<p>Abayas</p>
				</div>
			</div>
			<div class="col-sm-4">
				<p class="text-center">
					<strong>Name</strong>
				</p>
				<br> <a href="#demo2" data-toggle="collapse"> <img
					src="resources/images/9.jpg" class="img-circle person"
					alt="Random Name" width="255" height="255">
				</a>
				<div id="demo2" class="collapse">
					<p>Abayas</p>
				</div>
			</div>
			<div class="col-sm-4">
				<p class="text-center">
					<strong>Name</strong>
				</p>
				<br> <a href="#demo3" data-toggle="collapse"> <img
					src="resources/images/111.jpg" class="img-circle person"
					alt="Random Name" width="255" height="255">
				</a>
				<div id="demo3" class="collapse">
					<p>Abayas di tutti i giorni</p>
				</div>
			</div>
			<div class="col-sm-4">
				<p class="text-center">
					<strong>Name</strong>
				</p>
				<br> <a href="#demo2" data-toggle="collapse"> <img
					src="resources/images/10.jpg" class="img-circle person"
					alt="Random Name" width="255" height="255">
				</a>
				<div id="demo2" class="collapse">
					<p>Abayas</p>
				</div>
			</div>
			<div class="col-sm-4">
				<p class="text-center">
					<strong>Name</strong>
				</p>
				<br> <a href="#demo" data-toggle="collapse"> <img
					src="resources/images/12.jpg" class="img-circle person"
					alt="Random Name" width="255" height="255">
				</a>
				<div id="demo" class="collapse">
					<p>Abayas</p>
				</div>

			</div>
			<div class="col-sm-4">
				<p class="text-center">
					<strong>Name</strong>
				</p>
				<br> <a href="#demo6" data-toggle="collapse"> <img
					src="resources/images/11.jpg" class="img-circle person"
					alt="Random Name" width="255" height="255">
				</a>
				<div id="demo3" class="collapse">
					<p>Abayas</p>
				</div>
			</div>
		</div>


		<%@ include file="/WEB-INF/views/footer.jsp"%>