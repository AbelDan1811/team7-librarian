<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	
	<title>Join Us</title>
</head>
<body>
	<div class = "container">
		<form:form method="POST"  modelAttribute="userForm" class="form-signin">
			<h2 class="form-signin-heading">Create your account!</h2>
			<div>${userExistedMessage}</div>
			<hr>
			<spring:bind path="email">
				<label >Email</label>
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type = "text" path="email" class="form-control"/>
					<form:errors path="email"></form:errors>
				</div>
			</spring:bind>
			<spring:bind path="password">
				<label>Password</label>
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type ="password" path="password" class="form-control"/>
					<form:errors path="password"></form:errors>
				</div>
			</spring:bind>
			<spring:bind path="firstName">
				<label>First Name</label>
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type ="text" path="firstName" class="form-control"/>
					<form:errors path="firstName"></form:errors>
				</div>
			</spring:bind>
			<spring:bind path="lastName">
				<label>Password</label>
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type ="text" path="lastName" class="form-control"/>
					<form:errors path="lastName"></form:errors>
				</div>
			</spring:bind>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<button class= "btn btn-lg btn-primary col-sm-6"type = "submit" style = "text-align:center">Sign Up</button>
			<a class = "btn btn-lg btn-danger col-sm-6" href = "/login"style = "text-align:center">Login</a>
		</form:form>
		<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</div>
	
</body>
</html>