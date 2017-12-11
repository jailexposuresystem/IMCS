<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>


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
    <body>
    <center>
        <div style="color:red">
        	${invalid}
        	<html:errors/>
        </div>
        
        
        <html:form action="/loginaction" method="post">
        
        <div class="container">
			Username: <html:text name="loginform" property="username"></html:text>
			<html:errors  property="username_e" />
			<br/>
			Password: <html:password name="loginform" property="password"></html:password>
			<html:errors property="password_e" />
			<br/>
		</div>
		<div class="container" style="background-color:#0B5345  ">
			<html:hidden property="page" value="login"/>
			<html:submit value="Login"/>&nbsp;&nbsp;&nbsp;<html:reset/>
		</div>

		</html:form>

    </center>
    </body>
</html>
