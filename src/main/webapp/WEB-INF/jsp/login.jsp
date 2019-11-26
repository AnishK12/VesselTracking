<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Login</title>
            
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
img {
  position: absolute;
  left: 50px;
  top: 90px;
}
</style>

        </head>
        <body>
            <form:form id="loginForm" modelAttribute="login" action="loginProcess" method="post"> 
       <h1><font color="black">Log in Page</font></h1>
       <img src="https://www.rolls-royce.com/~/media/Images/R/Rolls-Royce/content-images/country-site/pr-15-10-2018.jpg?h=300&la=en&w=480" width="300" height="150">
                <table align="center">
                    <tr>
                        <td>
                            <form:label path="username">Username: </form:label>
                        </td>
                        <td>
                            <form:input required="required" path="username" name="username" id="username" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="password">Password:</form:label>
                        </td>
                        <td>
                            <form:password required="required" path="password" name="password" id="password" />
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td align="left">
                            <form:button id="login" name="login">Login</form:button>
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td></td>
                        <td><a href="home">Cancel</a>
                        </td>
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