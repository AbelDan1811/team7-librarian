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
	<link rel="stylesheet" href="https://localhost:8443/css/table.css">
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
		<h2>Books</h2>
		<hr>
		<div class= "container-fluid" style = "font-size:20px">
			<div class = col-sm-2></div>
			<div class= "col-sm-2">
				<label>Filter :</label> 
				<input type = "text" class = "form-control" id="filter" placeholder="Search.."></input>
			</div>
			<div class= "col-sm-2">
				<label>By :</label> 
				<select class = "form-control" id="filterBy">
					<option value ='title'>Title </option>
					<option value ='author'>Author</option>
					<option value ='publisher'>Publisher</option>
					<option value ='genre'>Genre</option>
				</select>
			</div>
			<div class= "col-sm-2">
				<label>Sort by :</label> 
				<select class = "form-control" id="sortBy">
					<option value ='1'>Title </option>
					<option value ='2'>Number </option>
					<option value ='3'>Available </option>
				</select>
			</div>
			<div class ="col-sm-2">
				<label>Order :</label> 
				<select class = "form-control" id ="order">
					<option value ='1'>Ascending</option>
					<option value ='2'>Descending</option>
				</select>
			</div>
			<div class = "col-sm-2"></div>
		</div>
		<div class = col-sm-1></div>
		<table class="table table-hover table-bordered col-sm-8" style = "top:40px;width:84%;border:1px solid black;">
		    <thead>
		      <tr class = "info">
		        <th>ID</th>
		        <th>Title</th>
		        <th>Author</th>
		        <th>Publisher</th>
		        <th>Genre</th>
		        <th>Available</th>
		        <th>Total</th>
		      </tr>
		    </thead>
		    <tbody id="table-body">
		      
		    </tbody>
  		</table>
	</div>
	<script src="https://localhost:8443/js/book_page.js"></script>
</body>
</html>