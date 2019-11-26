<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
* {
	box-sizing: border-box;
}

body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

.topnav {
	overflow: hidden;
	background-color: gray;
}

.topnav a {
	float: left;
	display: block;
	color: black;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.topnav a.active {
	background-color: #2196F3;
	color: white;
	border-style: solid;
	border-width: 1px;
	border-color: black;
}

.topnav a.account {
	background-color: #2196F3;
	color: white;
	border-style: solid;
	border-width: 1px;
	border-color: black;
}

.topnav a.logout {
	background-color: #2196F3;
	color: white;
	border-style: solid;
	border-width: 1px;
	border-color: black;
}

.topnav a.searchHistory {
	background-color: #2196F3;
	color: white;
	border-style: solid;
	border-width: 1px;
	border-color: black;
}

.topnav a.followingShips {
	background-color: #2196F3;
	color: white;
	border-style: solid;
	border-width: 1px;
	border-color: black;
}

.topnav .search-container {
	float: right;
}

.topnav input[type=text] {
	padding: 6px;
	margin-top: 8px;
	font-size: 17px;
	border: none;
}

.topnav .search-container button {
	float: right;
	padding: 6px 10px;
	margin-top: 8px;
	margin-right: 16px;
	background: #ddd;
	font-size: 17px;
	border: none;
	cursor: pointer;
}

.topnav .search-container button:hover {
	background: #ccc;
}

@media screen and (max-width: 600px) {
	.topnav .search-container {
		float: none;
	}
	.topnav a, .topnav input[type=text], .topnav .search-container button {
		float: none;
		display: block;
		text-align: left;
		width: 100%;
		margin: 0;
		padding: 14px;
	}
	.topnav input[type=text] {
		border: 1px solid #ccc;
	}
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

td {
	font-size: 35px;
}
img {
  border-radius: 50%;
    display: block;
  margin-left: auto;
  margin-right: auto;
}
h2 {
font-size: 3em;
} 
p {
font-size: 2em;
}
</style>
</head>
<body>

	<div class="topnav">
		<a class="active" href="#home">Home</a> <a class="account"
			href="account">Account</a> 
			<a class="searchHistory" href="searchHistory">Search History</a> 
			<a class="followingShips" href="followingShips">Following Ships</a> 
			<a class="logout" href="logout">Sign Out</a>
		<div class="search-container">
			<form:form modelAttribute="searchKey" action="/searchShip" >
			
				<!-- <input type="text" placeholder="Search.." name="search"> -->
				
				<form:input required="required" path="key" name="key" id="key" type="text" placeholder="Search.." />
				<button type="submit">
					<i class="fa fa-search"></i>
				</button>
			</form:form>
		</div>
	</div>

	<table>
		<tr>
			<td>Welcome ${firstname}</td>
		</tr>
	</table>
	<h2 align="center" >Welcome to Vessel Tracking</h2>
	<img src="https://ak7.picdn.net/shutterstock/videos/24964697/thumb/1.jpg" width="800" height="400">
	<p align="center">It is our job to collect vessel position data and make it available for you </p>
	<p align="center"> We live and breathe shipping and data</p>
	
</body>
</html>