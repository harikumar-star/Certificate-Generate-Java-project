package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ConnectionProvider;

public class BorRequest extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public BorRequest() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
System.out.println("Bor request coming");

String stuid = request.getParameter("stuid");
System.out.println("=="+stuid);
String regno = request.getParameter("regno");
String dob = request.getParameter("dob");
String email = request.getParameter("emails");
String password = request.getParameter("passwords");
String course = request.getParameter("course");
String category = request.getParameter("category");
String jyear = request.getParameter("jyear");
String eyear = request.getParameter("eyear");
String gender = request.getParameter("gender");
String reasonbof = request.getParameter("reasonbof");
String name = request.getParameter("name");
String stat = "waiting";


System.out.println(stuid+"--"+regno+"--"+dob+"--"+email+"--"+password+"--"+course+"--"+category+"--"+jyear+"-"+eyear+"--"+gender+"--"+reasonbof);

//duplicate entry check 






try{
	Connection conssss= ConnectionProvider.getCon();  
	Statement statement=conssss.createStatement();
	String sql ="select * from bonafide_request_copy where regno ='"+regno+"'";
	ResultSet resultSet = statement.executeQuery(sql);
	if(resultSet.next()){
		
System.out.println("duplicate entry-------");
request.setAttribute("dup", "Previous Boncertificate Request is Pending");
RequestDispatcher rd = request
.getRequestDispatcher("studenthome.jsp");
rd.forward(request, response);; 
	}

}
catch (SQLIntegrityConstraintViolationException e) {
  System.out.println("duplicate entry----"+e);
	
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	request.setAttribute("dup", "No entry");
	 RequestDispatcher rd = request
		.getRequestDispatcher("studenthome.jsp");
	rd.forward(request, response);; 
	e.printStackTrace();
} 


try{
	Connection conssss= ConnectionProvider.getCon();  
	Statement statement=conssss.createStatement();
	String sql ="select * from bonafide_request where regno ='"+regno+"'";
	ResultSet resultSet = statement.executeQuery(sql);
	if(resultSet.next()){
		
		request.setAttribute("dup", "Previous Boncertificate Request is Pending");
		RequestDispatcher rd = request
		.getRequestDispatcher("studenthome.jsp");
		rd.forward(request, response);;
		
	}

}
catch (SQLIntegrityConstraintViolationException e) {
    // Duplicate entry
	 System.out.println("duplicate entry----"+e);
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	request.setAttribute("dup", "No entry");
	 RequestDispatcher rd = request
		.getRequestDispatcher("studenthome.jsp");
	rd.forward(request, response);; 
	e.printStackTrace();
} 




//random number
Random rands = new Random(); 

//Generate random integers in range 0 to 999 
int r = rands.nextInt(1000); 
System.out.println("unique id ----"+r);










try{
	int status = 0;
	Connection con= ConnectionProvider.getCon(); 
	String tb1 = "insert into bonafide_request values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	  PreparedStatement ps=con.prepareStatement(tb1);		  
     ps.setString(1,stuid );
     ps.setString(2,regno ); 
     ps.setString(3, dob); 
     ps.setString(4, email);
     ps.setString(5, password);
     ps.setString(6, course); 
     ps.setString(7, category); 
     ps.setString(8, jyear);
     ps.setString(9, eyear);
     ps.setString(10, gender);
     ps.setString(11, reasonbof);
     ps.setString(12, name);
     ps.setString(13, stat);
     ps.setInt(14, r);
   
     status=ps.executeUpdate();
          
     System.out.println(" Bor 1  request succes");
     
     
     
     
  
     
     String tb2 = "insert into bonafide_request_copy values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	  PreparedStatement ps1=con.prepareStatement(tb2);		  
    ps1.setString(1,stuid );
    ps1.setString(2,regno ); 
    ps1.setString(3, dob); 
    ps1.setString(4, email);
    ps1.setString(5, password);
    ps1.setString(6, course); 
    ps1.setString(7, category); 
    ps1.setString(8, jyear);
    ps1.setString(9, eyear);
    ps1.setString(10, gender);
    ps1.setString(11, reasonbof);
    ps1.setString(12, name);
    ps1.setString(13, stat);
    ps1.setInt(14, r);
    status=ps1.executeUpdate();
     
     System.out.println("zz");
  
     
     
    System.out.println(" Bor 2  request succes");
    
    System.out.println("bor 3 request");
    
    //third table
    String tb22 = "insert into bonafide_request_copy1 values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	  PreparedStatement ps12=con.prepareStatement(tb22);		  
  ps12.setString(1,stuid );
  ps12.setString(2,regno ); 
  ps12.setString(3, dob); 
  ps12.setString(4, email);
  ps12.setString(5, password);
  ps12.setString(6, course); 
  ps12.setString(7, category); 
  ps12.setString(8, jyear);
  ps12.setString(9, eyear);
  ps12.setString(10, gender);
  ps12.setString(11, reasonbof);
  ps12.setString(12, name);
  ps12.setString(13, stat);
  ps12.setInt(14, r);
  status=ps12.executeUpdate();
     
    request.setAttribute("success", "BonaFide Certificate Request Submitted !!");
    RequestDispatcher rd = request
	.getRequestDispatcher("studenthome.jsp");
rd.forward(request, response);; 
     
     
     
     
}
catch(Exception e)
{
	e.printStackTrace();
}



	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
