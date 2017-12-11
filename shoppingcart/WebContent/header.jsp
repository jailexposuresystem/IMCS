 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%if(session.getAttribute("user") == null){
    	RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
    }
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--<html>
   <head>
      <title>HEADER</title>
   </head>
   
   <body bgcolor="#58D68D"> 
      <center>
      <img src="cartlogo.png" alt="Smiley face" height="80" width="80" align="left"/>
         <h2 style="color:white;">Welcome To ShopWorld.com</h2>
         <p></p>
      </center>
      <br/><br/> --%>
      
<html lang="en">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="pragma" content="nocache">
    <title></title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
  </head>
  <body>

    <div class="container-fluid">
	<div class="row">
		 <div class="col-md-12"> 
<center>
      <img src="cartlogo.png" alt="Smiley face" height="80" width="80" align="left"/>
         <h2>Welcome To ShopWorld.com</h2>
         <p></p>
</center>
		</div>
	</div>
	</div>