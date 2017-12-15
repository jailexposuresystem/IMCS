package logic;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateClassesServlet")
public class UpdateClassesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	Connection con=null;
	PreparedStatement ps=null;
	PreparedStatement ps1=null;
	ResultSet rs=null;
       
   
    public UpdateClassesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		try{
			String classid = request.getParameter("classid"); 
		    System.out.print(classid);
		    
			Class.forName("com.mysql.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jes","root","1234");
			
		    
		   ps1=con.prepareStatement("select * from classes where classid=?");
			
			ps1.setString(1, classid);
			rs=ps1.executeQuery();
				
			if (rs.next()){
				
				String bclassname = rs.getString("classname");
				String bminjail = rs.getString("minjail");
				String bmaxjail = rs.getString("maxjail");
				String bminfine = rs.getString("minfine");
				String bmaxfine = rs.getString("maxfine");
				String bstatus="Changed";
				
				System.out.println(bclassname);
			
					
		
		    PreparedStatement ps= con.prepareStatement("insert into user_backup (classid,classname,minjail,maxjail,minfine,maxfine,status,datestamp) values(?,?,?,?,?,?,?,now()) ");
		    
		    
		    	ps.setString(1,classid);
 		    	ps.setString(2,bclassname);
 				ps.setString(3,bminjail);
 				ps.setString(4,bmaxjail);
 				ps.setString(5,bminfine);
 				ps.setString(6,bmaxfine);
 				ps.setString(7,bstatus);
				
				int n=ps.executeUpdate();
			}
		
		
		String classname=request.getParameter("classname"); 
		String minjail=request.getParameter("minjail");
		String maxjail=request.getParameter("maxjail");
		String minfine=request.getParameter("minfine"); 
		String maxfine=request.getParameter("maxfine"); 
		String status="Changed";
		
		System.out.print(classname);
		
PreparedStatement ps= con.prepareStatement("Update classes set classname=?,minjail=?,maxjail=?,minfine=?,maxfine=?,status=?,datestamp=now() where classid=?");
	    
	    
		
			ps.setString(1,classname);
			ps.setString(2,minjail);
			ps.setString(3,maxjail);
			ps.setString(4,minfine);
			ps.setString(5,maxfine);
			ps.setString(6,status);
			ps.setString(7,classid);
			
			int n=ps.executeUpdate();
		
	
		if(n!=0)
		{
				System.out.println(n +"updated");
				request.setAttribute("changesuccess", " Successfully Changed");
				RequestDispatcher rd=request.getRequestDispatcher("/Updatedb.jsp");
				rd.forward(request, response);
			  
		}
		else
		{	
			request.setAttribute("changefailure", " Failed , please Try Again");
			RequestDispatcher rd=request.getRequestDispatcher("/Updateclasses.jsp");
			rd.forward(request, response);	
			
		}
			
	}
	catch(Exception e){
			e.printStackTrace();
			request.setAttribute("changefailure", " Failed , please Try Again");
			RequestDispatcher rd=request.getRequestDispatcher("/Updateclasses.jsp");
			rd.forward(request, response);			
		}
		
		
		
		
	}


}
