
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>

<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box
}

input[type=text], input[type=password] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: gray;
}

input[type=text]:focus, input[type=password]:focus {
	background-color: lightgreen;
	outline: none;
}

button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
	font-size: 15px;
}

a:link, a:visited {
	background-color: #f44336;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	text-align: center;
	text-decoration: none;
	width: 100%;
	opacity: 0.9;
	display: inline-block;
	font-size: 15px;
}

a:hover, a:active {
	background-color: red;
}

body {
	background-image:
		url("https://i0.wp.com/onlyvectorbackgrounds.com/wp-content/uploads/2019/06/Light-Flat-Shapes-Simple-Background-Silver.jpg?fit=1191%2C843&ssl=1");
	background-position: center center;
	background-size: 90% 90%;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}

h1 {
  position: absolute;
  left: 100px;
  top: 10px;
}
p {
  position: absolute;
  left: 100px;
  top: 60px;
}
</style>

</head>
<body>
	<form:form id="regForm" modelAttribute="user" action="registerProcess"
		method="post">
		<h1><font color="black">Sign Up Page</font></h1>
		<p><font color="black">Please fill in this form to create an account.</font></p>
		<table align="center">
			<tr>
				<td><form:label path="username">Username</form:label></td>
				<td><form:input placeholder="Enter username"
						required="required" path="username" name="username" id="username" />
				</td>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:password placeholder="Enter Password"
						required="required" path="password" name="password" id="password" /></td>
			</tr>
			<tr>
				<td><form:label path="firstname">FirstName</form:label></td>
				<td><form:input placeholder="Enter firstname"
						required="required" path="firstname" name="firstname"
						id="firstname" /></td>
			</tr>
			<tr>
				<td><form:label path="lastname">LastName</form:label></td>
				<td><form:input placeholder="Enter Lastname"
						required="required" path="lastname" name="lastname" id="lastname" />
				</td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input placeholder="Enter Email Address"
						required="required" path="email" name="email" id="email" /></td>
			</tr>
			<tr>
				<td><form:label path="address">Address</form:label></td>
				<td><form:input placeholder="Enter your address" path="address" name="address" id="address" />
				</td>
			</tr>
			<tr>
				<td><form:label path="phone">Phone</form:label></td>
				<td><form:input placeholder="Enter Phone Number" path="phone"
						name="phone" id="phone" /></td>
			</tr>
			<tr>
				<td></td>
				<td><form:button id="register" name="register">Register</form:button>
				</td>
			</tr>
			<tr></tr>
			<tr>
				<td></td>
				<td><a href="home">Cancel</a></td>
			</tr>
		</table>
	</form:form>
	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${message}</td>
		</tr>
	</table>
</body>
</html>
