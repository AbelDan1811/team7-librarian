<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>New Book</title>
</head>
<body>
	<div class = col-sm-4></div>
	<div class = "container-fluid col-sm-4">
		<form id = "addBook" action = "/api/books" method="post"  class="form-signin">
			<h2 class="form-signin-heading">Add New Book !</h2>
			<hr>
			<div id = "notification" style = "display:none;" class = "alert alert-success"></div>
			<div class="form-group">
				<label >Title</label>
				<input type = "text" name="title" class="form-control" required/>
			</div>
			<div class="form-group">
				<label >Author</label>
				<input type = "text" name="author" class="form-control" required/>
			</div>
			<div class="form-group">
				<label >Publisher</label>
				<input type = "text" name="publisher" class="form-control"required/>
			</div>
			<div class="form-group">
				<label>Genres</label>
				 <select class="form-control" name = "genre" id="sel1" required>
				    <option value = "Comic">Comic</option>
				    <option value = "Novel">Novel</option>
				    <option value = "Romantic">Romantic</option>
				    <option value = "Science">Science</option>
				    <option value = "Other">Others</option>
				 </select>
			</div>
			<div class="form-group">
				<label >Amount</label>
				<input type = "text" name="copies" class="form-control"/ required>
			</div>
			<input type = "submit" class = "btn btn-lg btn-danger col-sm-6" value = "Submit" />
			<a href = "/home" class = "btn btn-lg btn-primary col-sm-6">Home</a>
		</form>
	</div>
	
	<script src = "https://localhost:8443/js/add_book.js">	</script>
	
</body>
</html>