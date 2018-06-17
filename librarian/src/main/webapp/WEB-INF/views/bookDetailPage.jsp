<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src = "https://code.highcharts.com/highcharts.js"></script>  
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://localhost:8443/css/homepage.css">
	<link rel="stylesheet" href="https://localhost:8443/css/sidebar.css">
	<link rel="stylesheet" href="https://localhost:8443/css/table1.css">
<!-- Latest compiled JavaScript -->

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Books</title>
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
		<h2>Detail</h2>
		<hr>
		<div id="slug" style ="display:none">${slug}</div>
		<div id = "image" class= 'col-sm-7 well' style = "height:800px;">
			<img src="https://source.unsplash.com/random/1000x1000" class="img-thumbnail" alt="Cinque Terre" height="700px" width="700px" style="margin-left:80px;margin-top:30px">
		</div>
		<div id = "info" class= "col-sm-5" style = "height:800px; padding-left:70px">
			<h2 id = "title"></h2>
			<hr>
			<table>
				<tbody style = "font-size:20px">
					<tr>
						<td><b>Author&nbsp</b></td>
						<td id = "author"></td>
					</tr>
					<tr>
						<td><b>Publisher&nbsp</b></td>
						<td id = "publisher"></td>
					</tr>
					<tr>
						<td><b>Genre&nbsp</b></td>
						<td id = "genre"></td>
					</tr>
					<tr>
						<td><b>Available&nbsp</b></td>
						<td id = "available"></td>
					</tr>
					<tr>
						<td><b>Total&nbsp</b></td>
						<td id = "number"></td>
					</tr>
				</tbody>
			</table>
			<hr>
		</div>
	</div>
	<script src="https://localhost:8443/js/book_detail.js"></script>
</body>
</html>