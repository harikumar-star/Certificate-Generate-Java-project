package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ConnectionProvider;

import com.mysql.jdbc.Statement;

public class StudentLog extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public StudentLog() {
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

	System.out.println("Studentlog");
	try{
		
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		System.out.println("emial--"+email+"---"+"pas--"+pass);
		Connection con= ConnectionProvider.getCon();  
		Statement stmt=(Statement) con.createStatement();
		String sql="SELECT * FROM student where email='"+email+"' and password='"+pass+"' and status='Authorized'";
		ResultSet rs =stmt.executeQuery(sql);
		if(rs.next())
		{
			String stuid = rs.getString(1);
			 String regno = rs.getString(2);
			 String dob = rs.getString(3);

			 String emails = rs.getString(4);
			 String passwords = rs.getString(5);
			 String course = rs.getString(6);
			 

			 String category = rs.getString(7);
			 String jyear = rs.getString(8);
			 String eyear = rs.getString(9);
			 
			 String gender = rs.getString(10);
			 String name = rs.getString(12);
			 
			 
			 String address = rs.getString(13);
			 String pincode = rs.getString(14);
			 String location = rs.getString(15);
			 
			 
			 System.out.println("Pincode----"+pincode+"-----"+regno);
			 System.out.println("indatat-----"+stuid);
			 HttpSession session=request.getSession();  
		     session.setAttribute("stuid",stuid);  
		     session.setAttribute("regno",regno);  
		     session.setAttribute("dob",dob);  
		     session.setAttribute("emails",emails);  
		     session.setAttribute("passwords",passwords);  
		     session.setAttribute("course",course);  
		     session.setAttribute("category",category);  
		     session.setAttribute("jyear",jyear);  
		     session.setAttribute("eyear",eyear);  
		     session.setAttribute("gender",gender);  
		     session.setAttribute("name", name);
		     session.setAttribute("address", address);
		     session.setAttribute("plncode", pincode);
		     session.setAttribute("location", location);
			
			
			   RequestDispatcher rd = request
				.getRequestDispatcher("studenthome.jsp");
		rd.forward(request, response);; 

		}
		
		String sql1="SELECT * FROM student where email='"+email+"' and password='"+pass+"' and status='waiting'";
		Statement stmt1 = (Statement) con.createStatement();
		ResultSet rs1 =stmt1.executeQuery(sql1);
		if(rs1.next())
		{
			request.setAttribute("no", "Your Not Authorized!");
			  RequestDispatcher rd = request
				.getRequestDispatcher("student.jsp");
		rd.forward(request, response);; 
			
		}
		

		}		
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	String e = request.getParameter("email");
	String p = request.getParameter("pass");
		System.out.println("-------------------------"+e);
		System.out.println("-------------------------"+p);
		
		
		

	try{
			
			
			Connection con= ConnectionProvider.getCon();  
			Statement stmt=(Statement) con.createStatement();
			String sql="SELECT * FROM student where email='"+e+"' and password='"+p+"' ";
			ResultSet rs =stmt.executeQuery(sql);
			if(rs.next())
			{

				String stuid = rs.getString(1);
				 String regno = rs.getString(2);
				 String dob = rs.getString(3);
				 String emails = rs.getString(4);
				 String passwords = rs.getString(5);
				 String course = rs.getString(6);
				 

				 String category = rs.getString(7);
				 String jyear = rs.getString(8);
				 String eyear = rs.getString(9);
				 
				 String gender = rs.getString(10);
				 String name = rs.getString(12);
				 
				 System.out.println("indatat-----"+stuid);
				 HttpSession session=request.getSession();  
			     session.setAttribute("stuid",stuid);  
			     session.setAttribute("regno",regno);  
			     session.setAttribute("dob",dob);  
			     session.setAttribute("emails",emails);  
			     session.setAttribute("passwords",passwords);  
			     session.setAttribute("course",course);  
			     session.setAttribute("category",category);  
			     session.setAttribute("jyear",jyear);  
			     session.setAttribute("eyear",eyear);  
			     session.setAttribute("gender",gender);  
			     session.setAttribute("name", name);
				
				
				   RequestDispatcher rd = request
					.getRequestDispatcher("studenthome.jsp");
			rd.forward(request, response);; 

			}
			else 
			{
				
				request.setAttribute("email", " Email Password Wrong !");
				  RequestDispatcher rd = request
					.getRequestDispatcher("student.jsp");
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
