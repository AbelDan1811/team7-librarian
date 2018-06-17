<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

	
<title>Login</title>
</head>
<body>
	<div class= "container">
		<div class= "col-sm-3"></div>
		<form action="/login" method = "post" class = "form-signin col-sm-6">
			<h1 class = "form-signin-heading"> Login </h1>	
			<c:if test="${not empty message}">
				<h4 class = "alert alert-danger" style="margin-top:30px">${message}</h4>
			</c:if>
			
			<div class = "form-group">
				<label class = "form-label">Username</label>
				<input type="text" name="email" class= "form-control"/>
			</div>
			<div class = "form-group">
				<label>Password</label>
				<input type="password" name = "password" class = "form-control"/>
			</div>
			<input type="hidden"                     
			name="${ 	_csrf.parameterName}"
			value="${_csrf.token}"/>
			<button class= "btn btn-lg btn-primary col-sm-6"type = "submit" style = "text-align:center">Submit</button>
			<a href="/registration" class = "btn btn-lg btn-danger col-sm-6" style = "text-align:center">Sign Up</a>
		</form>
	</div>
	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>