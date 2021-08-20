package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ConnectionProvider;
import com.mysql.jdbc.Statement;

public class AddStaff extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddStaff() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.println("adding staff");
		
		
		Random rand = new Random(); 
		int rand_int1 = rand.nextInt(100); 
		String staffid =String.valueOf(rand_int1);
		System.out.println("staff if-----"+staffid);
		
		
		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("rrt");
		String education = request.getParameter("education");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String designation = request.getParameter("designation");
		String department = request.getParameter("department");
		String status = "waiting";
		
	
		int status1 = 0 ;
		 try { 
			 Connection cons= ConnectionProvider.getCon();  
			 PreparedStatement ps1=cons.prepareStatement("select * from staff where email =? "); 
			 ps1.setString(1, email);
				ResultSet rs = ps1.executeQuery();
			
				if(rs.next())
				{
					status1 = 0 ;
					System.out.println(status1);
					 System.out.println("Email already ther");
				}
			 else
			 {
				 Connection con= ConnectionProvider.getCon(); 
				  PreparedStatement ps=con.prepareStatement("insert into staff values (?,?,?,?,?,?,?,?,?,?)");		  
			       ps.setString(1,staffid );
			       ps.setString(2,name ); 
			       ps.setString(3, dob); 
			       ps.setString(4, gender);
			       ps.setString(5, education);
			       ps.setString(6, email); 
			       ps.setString(7, password); 
			       ps.setString(8, designation);
			       ps.setString(9, department);
			       ps.setString(10, status);
			       status1=ps.executeUpdate();
			            
			       System.out.println("Added succes");
			 }
			  
				

		        
		       
		       
		       if(status1 >0)
		       {
		    	   request.setAttribute("success", "Register Sucess !!");
		    	   RequestDispatcher rd = request
					.getRequestDispatcher("addstaff.jsp");
			rd.forward(request, response);; 
		       }
		       else
		       {
		    	   request.setAttribute("fail", "Email Already Exits Enter New Email!");
		    	   RequestDispatcher rd = request
					.getRequestDispatcher("addstaff.jsp");
			rd.forward(request, response);;  
		       }
		  
		  
			
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
