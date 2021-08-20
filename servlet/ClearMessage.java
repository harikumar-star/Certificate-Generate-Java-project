package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ConnectionProvider;

public class ClearMessage extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ClearMessage() {
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

		
		String a = "clear";
		String b = "allclear";
		
		
		
		String ui = request.getParameter("unique_id");
		String a2 = request.getParameter("aclear");
		
	System.out.println("clear message ----"+ui+a2);
		
		try{
			
			
				Connection con2= ConnectionProvider.getCon();  
				Statement st1=con2.createStatement();

					System.out.println("Deleting");

				 String sq1 = "delete from approvedlofcertificate_copy where u_id='"+ui+"'";
				st1.executeUpdate(sq1);
				request.setAttribute("clear", "Message Deleted");
			      RequestDispatcher rd=request.getRequestDispatcher("viewlofcerti.jsp");  
			        rd.forward(request, response);
			
		
		
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try{
			String regnos = request.getParameter("aclear");
			System.out.println("post============"+regnos);
			Connection con2= ConnectionProvider.getCon();  
			Statement st1=con2.createStatement();

				System.out.println("Deleting");

			 String sq1 = "delete  from approvedlofcertificate_copy where regno='"+regnos+"' ";
			st1.executeUpdate(sq1);
			request.setAttribute("aclear", " All Messages Deleted");
		      RequestDispatcher rd=request.getRequestDispatcher("viewlofcerti.jsp");  
		        rd.forward(request, response);
		
	
	
		
		
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
