<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>  
<%@ page import="java.io.PrintWriter"%>
    




  <%
  String emil=request.getParameter("id");
 	System.out.println(emil); 
  
 	
 	PreparedStatement ps=null;
	PreparedStatement ps1=null;
	ResultSet rs=null;
 	
 	try{
 		System.out.println(emil);
		Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jes","root","1234");
		
	    
	   ps1=con.prepareStatement("select * from user_registration where email=?");
		
		ps1.setString(1, emil);
		rs=ps1.executeQuery();
			
		if (rs.next()){
			String bemail = rs.getString("email");
			String bfirstname = rs.getString("firstname");
			String blastname = rs.getString("lastname");
			String bcontactnumber = rs.getString("contactnumber");
			String bstreet = rs.getString("street");
			String bcity = rs.getString("city");
			String bstate = rs.getString("state");
			String bzipcode = rs.getString("zipcode");
			String bpassword = rs.getString("password");
			String bsecurity1 = rs.getString("security1");
			String banswer1 = rs.getString("answer1");
			String btype = rs.getString("type");
			String bstatus="Deleted";
			System.out.println(bfirstname);
		
				
	
	    ps= con.prepareStatement("insert into user_backup (email,firstname,lastname,contactnumber,street,city,state,zipcode,status,datestamp,password,security1,answer1,type) values(?,?,?,?,?,?,?,?,?,now(),?,?,?,?) ");
	    

	    	ps.setString(1,bemail);
	    	ps.setString(2,bfirstname);
			ps.setString(3,blastname);
			ps.setString(4,bcontactnumber);
			ps.setString(5,bstreet);
			ps.setString(6,bcity);
			ps.setString(7,bstate);
			ps.setString(8,bzipcode);
			ps.setString(9,bstatus);
			ps.setString(10,bpassword);
			ps.setString(11,bsecurity1);
			ps.setString(12,banswer1);
			ps.setString(13,btype);
			
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
	
	
PreparedStatement ps2= con.prepareStatement("delete from user_registration where email=?");
    
			
		ps2.setString(1,emil);
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
  
  