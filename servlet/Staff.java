package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ConnectionProvider;

public class Staff extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Staff() {
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

		System.out.println("staff login");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try{
			 Connection cons= ConnectionProvider.getCon();  
				
				String sql="SELECT * FROM staff where email='"+email+"' and password='"+password+"' and status='Authorized'";
				Statement stmt = cons.createStatement();
				ResultSet rs =stmt.executeQuery(sql);
				if(rs.next())
				{
					System.out.println("login sucess");
				response.sendRedirect("staffhome.jsp");
				}
				else
				{
				String sql1="SELECT * FROM staff where email='"+email+"' and password='"+password+"'  and status='waiting'";
				Statement stmt1 = cons.createStatement();
				ResultSet rs1 =stmt1.executeQuery(sql1);
				
				if(rs1.next())
				{
			System.out.println("sorry your not authorized");
			request.setAttribute("fail", "Your Not Authourized !");
			  RequestDispatcher rd=request.getRequestDispatcher("stafflog.jsp");  
		        rd.forward(request, response);  
				}
			
				}
		}
	    catch(Exception e)
	    {
	        System.out.println("Error in emplogact"+e.getMessage());
	    }
		
	    
	    String e = request.getParameter("email");
	    String p = request.getParameter("password");
	    	System.out.println("-------------------------"+e);
	    	System.out.println("-------------------------"+p);
	    
	    
	    try{
			
			
			Connection con= ConnectionProvider.getCon();  
			Statement stmt=(Statement) con.createStatement();
			String sql="SELECT * FROM staff where email='"+e+"' and password='"+p+"' ";
			ResultSet rs =stmt.executeQuery(sql);
			if(rs.next())
			{

				 String staffid = rs.getString(1);
				 String name = rs.getString(2);
				 String dob = rs.getString(3);
				 String gender = rs.getString(4);
				 String education = rs.getString(5);
				 String emails = rs.getString(6);
				 String passwords = rs.getString(7);
			
				
				 String designation = rs.getString(8);
				 String department = rs.getString(9);

			
				 
			
				
				 
				 System.out.println("indatat-----"+staffid);
				 HttpSession session=request.getSession(); 
				 
			     session.setAttribute("staffid",staffid);  
			     
			     
			     session.setAttribute("designation",designation); 
			     session.setAttribute("department",department); 
			     session.setAttribute("education",education); 
			 
			     session.setAttribute("dob",dob);  
			     session.setAttribute("emails",emails);  
			     session.setAttribute("passwords",passwords);  
			  
			  
			     
			     session.setAttribute("gender",gender);  
			     session.setAttribute("name", name);
				
				
				   RequestDispatcher rd = request
					.getRequestDispatcher("staffhome.jsp");
			rd.forward(request, response);; 

			}
			else 
			{
				
				request.setAttribute("email", " Email Password Wrong !");
				  RequestDispatcher rd = request
					.getRequestDispatcher("stafflog.jsp");
			rd.forward(request, response);
			}
	}
		
			
	catch(Exception e1)
	{
		e1.printStackTrace();
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
