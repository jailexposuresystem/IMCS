<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>  
<%@ page import="java.io.PrintWriter"%>
    
    
    
    
    
    <%
 
    
    %>
    
    
    <%
 	  String classid=request.getParameter("id");
 	 	System.out.println(classid); 
 	  
 	 	
 	 	PreparedStatement ps=null;
 		PreparedStatement ps1=null;
 		ResultSet rs=null;
 	 	
 	 	try{
 	 		System.out.println(classid);
 	 		
 			Class.forName("com.mysql.jdbc.Driver");
 		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jes","root","1234");
 			
 		    
 		   ps1=con.prepareStatement("select * from classes where classid=?");
 			
 			ps1.setString(1, classid);
 			rs=ps1.executeQuery();
 				
 			if (rs.next()){
 				String bclassid = rs.getString("classid");
 				String bclassname = rs.getString("classname");
 				String bminjail = rs.getString("minjail");
 				String bmaxjail = rs.getString("maxjail");
 				String bminfine = rs.getString("minfine");
 				String bmaxfine = rs.getString("maxfine");
 				String bstatus="Deleted";
 				
 				System.out.println(bclassname);
 			
 					
 		
 		    ps= con.prepareStatement("insert into user_backup (classid,classname,minjail,maxjail,minfine,maxfine,status,datestamp) values(?,?,?,?,?,?,?,now()) ");
 		    

 		    	ps.setString(1,bclassid);
 		    	ps.setString(2,bclassname);
 				ps.setString(3,bminjail);
 				ps.setString(4,bmaxjail);
 				ps.setString(5,bminfine);
 				ps.setString(6,bmaxfine);
 				ps.setString(7,bstatus);
 				
 				int n=ps.executeUpdate();
 				System.out.println("inserted");

 			}
 			


 		/*
 		String firstname=request.getParameter("firstname"); 
 		String lastname=request.getParameter("lastname");
 		String contactnumber=request.getParameter("contactnumber");
 		String street=request.getParameter("street"); 
 		String city=request.getParameter("city"); 
 		String state=request.getParameter("state"); 
 		String zipcode=request.getParameter("zipcode");
 		String status="Changed";*/
 		
 		
 	PreparedStatement ps2= con.prepareStatement("delete from classes where classid=?");
 	    
 				
 			ps2.setString(1,classid);
 			int n=ps2.executeUpdate();
 			
 			if(n!=0)
 			{
 				System.out.print("deleted");
 				   
 					   System.out.println(n +"deleted");
 						request.setAttribute("changesuccess", " Successfully Deleted");
 						RequestDispatcher rd=request.getRequestDispatcher("/Updatedb.jsp");
 						rd.forward(request, response);		  
 			}
 			else
 			{	
 				request.setAttribute("changefailure", " Failed , please Try Again");
 				RequestDispatcher rd=request.getRequestDispatcher("/Updatedb.jsp");
 				rd.forward(request, response);	
 				
 			}

 			
 	}
 	catch(Exception e){
 			e.printStackTrace();
 					
 		}
 	 	
 	 	
 	  %>
  