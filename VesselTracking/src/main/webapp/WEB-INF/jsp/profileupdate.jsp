<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<form:form id="profileupdateform" modelAttribute="user" action="updateProfile"
		method="post">
		<table align="center">
			<tr>
				<td><form:label path="username">Username</form:label></td>
				<td><form:label path="username" name="username" id="username" />
				</td>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:password required="required" path="password" name="password"
						id="password" /></td>
			</tr>
			<tr>
				<td><form:label path="firstname">FirstName</form:label></td>
				<td><form:input required="required" path="firstname" name="firstname"
						id="firstname" /></td>
			</tr>
			<tr>
				<td><form:label path="lastname">LastName</form:label></td>
				<td><form:input required="required" path="lastname" name="lastname" id="lastname" />
				</td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input required="required" path="email" name="email" id="email" /></td>
			</tr>
			<tr>
				<td><form:label path="address">Address</form:label></td>
				<td><form:input path="address" name="address" id="address" />
				</td>
			</tr>
			<tr>
				<td><form:label path="phone">Phone</form:label></td>
				<td><form:input path="phone" name="phone" id="phone" /></td>
			</tr>
			<tr>
				<td></td>
				<td><form:button id="update" name="update">Update</form:button>
				</td>
			</tr>
			<tr></tr>
			<tr>
				<td></td>
				<td><a href="home">Home</a></td>
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
