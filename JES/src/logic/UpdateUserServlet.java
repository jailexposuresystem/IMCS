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


@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	Connection con=null;
	PreparedStatement ps=null;
	PreparedStatement ps1=null;
	ResultSet rs=null;
   
       
    
    public UpdateUserServlet() {
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
			String emil = request.getParameter("email"); 
		    System.out.print(emil);
		    
			Class.forName("com.mysql.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jes","root","1234");
			
		    
		   ps1=con.prepareStatement("select * from user_registration where email=?");
			
			ps1.setString(1, emil);
			rs=ps1.executeQuery();
				
			if (rs.next()){
				
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
				String bstatus=rs.getString("status");;
				
				System.out.println(bfirstname);
			
					
		
		    PreparedStatement ps= con.prepareStatement("insert into user_backup (email,firstname,lastname,contactnumber,street,city,state,zipcode,status,datestamp,password,security1,answer1,type) values(?,?,?,?,?,?,?,?,?,now(),?,?,?,?) ");
		    
		    
			//String str="insert into user_reg values(?,?,?,?,?,?,?,?,?,?,?,?,?) ";
			
				//ps=con.prepareStatement(str);
		    	ps.setString(1,emil);
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
			}
			
		
		String firstname=request.getParameter("firstname"); 
		String lastname=request.getParameter("lastname");
		String contactnumber=request.getParameter("contactnumber");
		String street=request.getParameter("street"); 
		String city=request.getParameter("city"); 
		String state=request.getParameter("state"); 
		String zipcode=request.getParameter("zipcode");
		String status="Changed";
		
		
PreparedStatement ps= con.prepareStatement("Update user_registration set FirstName=?,LastName=?,contactnumber=?,street=?,city=?,state=?,zipcode=?,status=?,datestamp=now() where email=?");
	    
	    
		
			ps.setString(1,firstname);
			ps.setString(2,lastname);
			ps.setString(3,contactnumber);
			ps.setString(4,street);
			ps.setString(5,city);
			ps.setString(6,state);
			ps.setString(7,zipcode);
			ps.setString(8,status);
			ps.setString(9,emil);
			
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
			RequestDispatcher rd=request.getRequestDispatcher("/Updateuser.jsp");
			rd.forward(request, response);	
			
		}
			
	}
	catch(Exception e){
			e.printStackTrace();
			request.setAttribute("changefailure", " Failed , please Try Again");
			RequestDispatcher rd=request.getRequestDispatcher("/Updateuser.jsp");
			rd.forward(request, response);			
		}
		
		
		
		
	}


}