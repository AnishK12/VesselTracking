<!DOCTYPE html>
<html>
   <head>
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
      <style>
         * {box-sizing: border-box;}
         body {
         margin: 0;
         font-family: Arial, Helvetica, sans-serif;
         background-image:
         url("https://i0.wp.com/onlyvectorbackgrounds.com/wp-content/uploads/2019/06/Light-Flat-Shapes-Simple-Background-Silver.jpg?fit=1191%2C843&ssl=1");
         background-position: center center;
         background-size: 100% 100%;
         background-position: center;
         background-repeat: no-repeat;
         background-size: cover;
         }
         .topnav {
         overflow: hidden;
         background-color: #e9e9e9;
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
         .topnav a:hover {
         background-color: #ddd;
         color: black;
         }
         .topnav a.active {
         background-color: #2196F3;
         color: white;
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
      </style>
   </head>
   <body>
      <div class="topnav">
         <a class="active" href="/welcome">Home</a>
         <a href="/account">Account</a>
         <div class="search-container">
            <form action="/ships/China" method=get>
               <input type="text" placeholder="Search.." name="search" id="input">
               <button type="submit" onClick="storeHistory"><i class="fa fa-search"></i></button>
            </form>
         </div>
      </div>
      <p style="text-align: center;"><strong><span style="font-size: 30px;"><u>Vessel Tracking</u></span></strong></p>
      <p>&nbsp; &nbsp; Options:</p>
      <p>&nbsp; &nbsp; - Home button to navigate back to the welcome page throughout the website.</p>
      <p>&nbsp; &nbsp; - Account button to access your account information after signing in.</p>
      <p>&nbsp; &nbsp; - Search for ships using the search bar in the top left corner. </p>
      <p>
         <br>
      </p>
      <p>
         <br>
      </p>
   </body>
</html>