<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>  
<%@ page import="java.io.PrintWriter"%>


<%
	if(request.getSession().getAttribute("adminemail") == null) {
		response.sendRedirect(request.getContextPath() + "/Adminlogin.jsp");
		return;
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <meta charset="UTF-8">
        <title>Update DB</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="main.css" />
   
   
   
   
   
   
   
    <script>   
    function goBack() 
	{
    	window.history.back();
	}
    function logout() 
	{
	}

</script>


<script>

function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}


function myFunction1() {
    document.getElementById("myDropdown1").classList.toggle("show1");
}
function myFunction2() {
    document.getElementById("myDropdown2").classList.toggle("show2");
}

function myFunction3() {
    document.getElementById("myDropdown3").classList.toggle("show3");
}

window.onclick = function(event) {
if (!event.target.matches('.dropbtn')) {

    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');


      }
    }
  }
  if (!event.target.matches('.dropbtn1')) {

    var dropdowns1 = document.getElementsByClassName("dropdown-content1");
    var j;
    for (j = 0; j < dropdowns1.length; j++) {
      var openDropdown1 = dropdowns1[j];
      if (openDropdown1.classList.contains('show1')) {
        openDropdown1.classList.remove('show1');

      }
    }
  }

if (!event.target.matches('.dropbtn2')) {

    var dropdowns2 = document.getElementsByClassName("dropdown-content2");
    var k;
    for (k = 0; k < dropdowns2.length; k++) {
      var openDropdown2 = dropdowns2[k];
      if (openDropdown2.classList.contains('show2')) {
        openDropdown2.classList.remove('show2');

      }
    }
  }

if (!event.target.matches('.dropbtn3')) {

    var dropdowns3 = document.getElementsByClassName("dropdown-content3");
    var n;
    for (n = 0; n < dropdowns3.length; n++) {
      var openDropdown3 = dropdowns3[n];
      if (openDropdown3.classList.contains('show3')) {
        openDropdown3.classList.remove('show3');

      }
    }
  }

}
</script>
</head>
<body>

<p><img src="logo.jpg" alt="Smiley face" height="80" width="120" align="left"/>
<pre><h1 align="left">        
  JAIL EXPOSURE SYSTEM </h1></pre>
</p>

<h2>	
<div>
 
  				<a class="active" href="Adminhome.jsp"> Home </a></li>
       			
<ul>
<div class="dropdown">
<button onclick="myFunction()" class="dropbtn">Login&#9207</button>
  <div id="myDropdown" class="dropdown-content">
    <a >Admin</a>
    <a >Any walkin</a>
    
  </div>
</div>
<div class="dropdown1">
<button onclick="myFunction1()" class="dropbtn1">Registration&#9207</button>
  <div id="myDropdown1" class="dropdown-content1">
    <a >Admin</a>
    <a >Any walkin</a>
    
  </div>
</div>

<li style="margin-left:600px";>
<div class="dropdown">
<button onclick="myFunction2()" class="dropbtn2">Reports&#9207</button>
  <div id="myDropdown2" class="dropdown-content2">
    <a href="AdminEditmyaccount.jsp">My Account</a>
    <a href="Updatedb.jsp">DB Update</a>
    <a href="Adminviewhistory.jsp">Output history</a>
    
    
  </div>
</div>

      <a href="AdminAboutus.jsp" >About Us</a>
      <a href="AdminContactus.jsp">Contact Us</a>
 </li>
  </ul>
  
  <script>
	function focus1() {
	    document.getElementById('myInput').focus();
	    }
	function focus2() {
	    document.getElementById('myInput1').focus();
	    }
	
function myFunction() {
  var input, filter, table, tr, td, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[2];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}
function myFunction1() {
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myInput1");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable1");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[2];
	    if (td) {
	      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    }       
	  }
	}
</script>
 	
  <br/><br/><br/><br/>
  <center style="font-size:75%"><p style="color:red;">${changefailure}</p><p style="color:blue;">${changesuccess} </p></center><br />
  <center style="font-size:40%">
  <!--  <form name="Login" action="http://localhost:8081/JES/UpdateDBServlet" onsubmit="return loginValidation()" method="post">  -->
  <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search.." title="Type in a name" style="font-size: 14pt; height: 30px; width:240px; ">
		 	
		 	<table id="myTable" border="2" >
		 	
			<tr>
			    <th>Date Stamp</th>
				<th>Status</th>
				<th>Email Id</th>
				<th>Type</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Contact Number</th>
				<th>Street</th>
				<th>City</th>
				<th>State</th>
				<th>Zip code</th>
				<th>Password</th>
				<th>Security Question</th>
				<th>Security Answer</th>
				<th>Action</th>
				
			</tr>
			
		<%
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jes","root","1234");
			
			PreparedStatement ps3=con.prepareStatement("select * from user_registration");
			//ps.setString(1, emil);
			ResultSet rs1=ps3.executeQuery();
			
		while(rs1.next())
		{
		
		%>
		
		<% String email=rs1.getString("email");
		%>	
		
    		<tr>
    	<td><%=rs1.getString("datestamp")%></td>
        <td><%=rs1.getString("status")%></td>
        <td><%=rs1.getString("email")%></td>
        <td><%=rs1.getString("type")%></td>
    	<td><%=rs1.getString("FirstName")%></td>
    	<td><%=rs1.getString("LastName")%></td>
    	<td><%=rs1.getString("contactnumber")%></td>
    	<td><%=rs1.getString("street")%></td>
    	<td><%=rs1.getString("city")%></td>
    	<td><%=rs1.getString("state")%></td>
    	<td><%=rs1.getString("zipcode")%></td>
    	<td><%=rs1.getString("password")%></td>
    	<td><%=rs1.getString("security1")%></td>
    	<td><%=rs1.getString("answer1")%></td> 
    	
    	<td style="padding-bottom:80px">
    	<select   	onchange="if(this.selectedIndex < 3 && this.selectedIndex > 0){location = this.options[this.selectedIndex].value} else if (this.selectedIndex = 3){focus1();}">
    	<option>Action</option>
    	<option value="Updateuser.jsp?id=<%=rs1.getString("email")%>" >Change</option>
    	<option value="Updatedb2.jsp?id=<%=rs1.getString("email")%>">Delete</option>
    	<option value="" >Query</option>
		</select>​
    	</td>
        
    		</tr>
    	
    	
        <%

		}
	%>
	<% 
	Class.forName("com.mysql.jdbc.Driver");
		Connection con3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/jes","root","1234");
		PreparedStatement ps5=con3.prepareStatement("select * from user_backup");
		//ps.setString(1, emil);
		ResultSet rs3=ps5.executeQuery();
		
	while(rs3.next())
	{
    	%>
    	<tr>
    	<td><%=rs3.getString("datestamp")%></td>
        <td><%=rs3.getString("status")%></td>
        <td><%=rs3.getString("email")%></td>
        <td><%=rs3.getString("type")%></td>
    	<td><%=rs3.getString("FirstName")%></td>
    	<td><%=rs3.getString("LastName")%></td>
    	<td><%=rs3.getString("contactnumber")%></td>
    	<td><%=rs3.getString("street")%></td>
    	<td><%=rs3.getString("city")%></td>
    	<td><%=rs3.getString("state")%></td>
    	<td><%=rs3.getString("zipcode")%></td>
    	<td><%=rs3.getString("password")%></td>
    	<td><%=rs3.getString("security1")%></td>
    	<td><%=rs3.getString("answer1")%></td> 
    	<td style="padding-bottom:30px">No Action<img src="d.png" alt="Smiley face" height="50" width="50" valign="center"/></td> 
        
    		</tr>
    		
    		<%} %>
    		
	</table>
	<br>
	<center style="font-size:200%">
	<input type="text" id="myInput1" onkeyup="myFunction1()" placeholder="Search for names.." title="Type in a name" style="font-size: 14pt; height: 30px; width:240px; ">
		 	<table  id="myTable1" border="2" >
		 	<thead>
			<tr style="font-weight:bold" style="font-size:75%">
				<th>Date Stamp</th>
				<th>Class Id</th>
				<th>Class Name</th>
				<th>Minimum Jail</th>
				<th>Maximum Jail</th>
				<th>Minimum Fine</th>
				<th>Maximum Fine</th>
				<th>Action</th>	
			</tr>
			</thead>
	<%
			Class.forName("com.mysql.jdbc.Driver");
			Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/jes","root","1234");
			
			PreparedStatement ps4=con2.prepareStatement("select * from classes");
			//ps.setString(1, emil);
			ResultSet rs2=ps4.executeQuery();
			
		while(rs2.next())
		{

		%>
		
    		<tr>
    	<td><%=rs2.getString("datestamp")%></td>
        <td><%=rs2.getString("classid")%></td>
    	<td><%=rs2.getString("classname")%></td>
    	<td><%=rs2.getString("minjail")%></td>
    	<td><%=rs2.getString("maxjail")%></td>
    	<td><%=rs2.getString("minfine")%></td>
    	<td><%=rs2.getString("maxfine")%></td>
    	<td style="padding-bottom:80px">
    	<select onchange="if(this.selectedIndex < 3 && this.selectedIndex > 0){location = this.options[this.selectedIndex].value} else if (this.selectedIndex = 3){focus2();}">
    	<option>Action</option>
    	<option value="Updateclasses.jsp?id=<%=rs2.getString("classid")%>" >Change</option>
    	<option value="Deleteclasses.jsp?id=<%=rs2.getString("classid")%>">Delete</option>
    	<option >Query</option>
		</select>​
    	</td>
    	
    		</tr>
    	</tbody>
    	   <%

		}
	%>
    </table>
    
    <%
    ps3.close();
    ps4.close();
	rs2.close();
    rs1.close();
    }
catch(Exception e)
{
    e.printStackTrace();
    }
	%>
 <button onclick="goBack()">Go Back</button><a href="Logout.jsp"><button>Exit</button></a>

</center>
    
        
    </body>
</html>
