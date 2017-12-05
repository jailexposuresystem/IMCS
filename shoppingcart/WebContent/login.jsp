<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="loginstyle.css" />
</head>
<body bgcolor="#58D68D">
<center><h1 style="color:#0B5345  ">SHOPWORLD.COM</h1>
<div class="imgcontainer">
    <img src="cartlogo.png" alt="Avatar" height="92" width="92" >
 </div>
 </center>

<center><span style="color:red"><h3>${invalid}</h3></span></center>
 
<center>
		<form action="LoginServlet" name="loginForm" method="post">
  <div class="container">
    <label><b>Username:</b></label>
    <input type="text" placeholder="Enter Username" name="username" required>
<br>
    <label><b>Password:</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
  </div>

  <div class="container" style="background-color:#0B5345  ">
    <button type="submit" name="login">Login</button>
    <button type="reset">Reset</button>
  </div>
  <input type="hidden" name="page" value="login" >
</form>
</center>
</body>
</html>