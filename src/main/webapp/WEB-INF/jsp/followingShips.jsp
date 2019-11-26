<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

body {
	background-image:
		url("https://i0.wp.com/onlyvectorbackgrounds.com/wp-content/uploads/2019/06/Light-Flat-Shapes-Simple-Background-Silver.jpg?fit=1191%2C843&ssl=1");
	background-position: center center;
	background-size: 90% 90%;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}

h2 {
font-size: 5em;
}
.loopx{
font-size: 2em;
border: 15px solid gray;

}
</style>
</head>

<body>

<div class="topnav">
		<a class="active" href="welcome">Home</a> <a class="account"
			href="account">Account</a> 
			<a class="searchHistory" href="searchHistory">Search History</a> 
			<a class="followingShips" href="followingShips">Following Ships</a> 
			<a class="logout" href="logout">Sign Out</a>
	
		</div>
	


    <h1 align="center">Following Ships</h1>
</body>
<div align="center" class="loopx">
<c:if test="${not empty followList}">
    <c:forEach items="${followList}" var="followList">
       ${followList} <br />
</c:forEach>
</c:if>
</div>