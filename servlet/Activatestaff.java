package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ConnectionProvider;

public class Activatestaff extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Activatestaff() {
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

		try {
			   
			Connection con= ConnectionProvider.getCon();  
			Statement st=con.createStatement();
			String staffid=request.getParameter("staffid");
			String str = "Authorized";
       		
       		String query1 ="update staff set status='"+str+"' where staffid="+staffid+" ";
	   		st.executeUpdate (query1);
		
			response.sendRedirect("lor.jsp");  
			
			
	   		
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
