<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- jQuery library -->
	
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://localhost:8443/css/list.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>New Cart</title>
</head>
<body>
	<div class = col-sm-4></div>
	<div class = "container-fluid col-sm-4">
		<form id = "addCart" action = "/api/carts" method="post"  class="form-signin">
			<h2 class="form-signin-heading">New Cart </h2>
			<hr>
			<div id = "notification" style = "display:none;" class = "alert alert-success"></div>
			<div class="form-group">
				<label >Email :</label>
				<input type = "text" name="email" class="form-control" required/>
			</div>
			<div class="form-group">
				<label >Name :</label>
				<input type = "text" name="fullname" class="form-control" required/>
			</div>
			<div class="form-group">
				<label >Number :</label>
				<input type = "text" name="contactNumber" class="form-control" required/>
			</div>
			<div class="form-group">
				<label >Organization :</label>
				<input type = "text" name="organization" class="form-control" required/>
			</div>
			
			<div class = "form-group" style = "margin-bottom:40px;width:100%">
				<label style = "width : 100%"> Books :</label>
				<div id = "chosenItems"></div>
				<div class="dropdown">
				    <button class="btn btn-lg btn-primary dropdown-toggle" type="button"   data-toggle="dropdown">Add Books To Cart
				   		<span class="caret"></span>
				    </button>
				    <ul class="dropdown-menu" id = "bookList">
						<input class="form-control" id="myInput" type="text" placeholder="Search..">
				    </ul>
	  			</div>
  			</div>
  			<br>
  			<br>
  			<div style = "width:100%">
				<input type = "submit" class = "btn btn-lg btn-danger col-sm-6" value = "Submit" />
				<a href = "/home" class = "btn btn-lg btn-primary col-sm-6">Home</a>
			</div>
		</form>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src = "https://localhost:8443/js/add_cart.js">	</script>
</body>
</html>