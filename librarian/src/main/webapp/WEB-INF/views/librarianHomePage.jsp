<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src = "https://code.highcharts.com/highcharts.js"></script>  
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/homepage.css">
	<link rel="stylesheet" href="css/sidebar.css">
<!-- Latest compiled JavaScript -->

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	
	<div class="sidenav">
	  <a href="/librarian/carts"><span class="glyphicon glyphicon-shopping-cart"></span>&nbsp Carts</a>
	  <a href="/librarian/books"><span class="glyphicon glyphicon-list-alt"></span>&nbsp Books</a>
	  <a href="/librarian/customers"><span class="glyphicon glyphicon-user"></span>&nbsp Customers</a>
	  <a href="/librarian/genre"><span class="glyphicon glyphicon-star"></span>&nbsp Genres</a>
	</div>
	<nav class="navbar navbar-inverse">
		  <div class="container-fluid">
			    <div class="navbar-header">
			      <a class="navbar-brand" href="/home" style = "font-size:25px;color:white">Librarian</a>
			    </div>
		    <ul class="nav navbar-nav navbar-right">
		       <li><a href="/librarian/new-book" style="font-size:16px"><span class="glyphicon glyphicon-plus"></span>&nbsp New Book</a></li>
		       <li><a href="/librarian/new-cart" style="font-size:16px"><span class="glyphicon glyphicon-plus"></span>&nbsp New Cart</a></li>
		       <li><a href="/librarian/resolve-cart" style="font-size:16px"><span class="glyphicon glyphicon-ok"></span>&nbsp Resolve Cart </a></li>
		       <li><a href="/logout" style="font-size:16px"><span class="glyphicon glyphicon-log-out" ></span>&nbsp Logout</a></li>
		    </ul>
		  </div>
	</nav>

	
	<div class= "container-fluid content">
		<h5 class = "alert alert-info alert-sm hello">Hello, ${username} !</h5>
		<hr>
		<div class= "container-fluid col-sm-6"> 
			<h3>Genres Statistic</h3>
			<hr>
			<div id ="genre-chart" style="width:100%;height:20%;margin:0 auto"></div>
		</div>
		<div class ="container-fluid col-sm-6">
			<h3>Trending Books</h3>
			<hr>
			<div id ="trending-book-chart" style="width:550;height:400px;margin:0 auto"></div>
		</div>
		<hr>
		<div>
			<h3>Recent Receipts</h3>
			<hr>
			<div id="receipt_chart">
		</div>
		
	</div>
	<script src="js/genre_chart.js"></script>
</body>
</html>