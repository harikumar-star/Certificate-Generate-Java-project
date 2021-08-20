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

public class CheckingBon extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CheckingBon() {
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

	String reg = request.getParameter("reg");
	System.out.println("reg---------"+reg);
	
	
	    
	 HttpSession sessions=request.getSession();  
	 String regno1 = (String)sessions.getAttribute("regno");
	 System.out.println("regno1---------"+regno1);
	 
	 
	 String dreg = "";
	 String stat = "";
	 try{
			Connection conssss= ConnectionProvider.getCon();  
			Statement statement=conssss.createStatement();
			String sql ="select * from approvedboncertificate where regno="+regno1+"";
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
				
			stat = resultSet.getString(10);
		dreg = resultSet.getString(5);
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	 
	 
	 System.out.println("stat------"+stat);
	 
	 if(stat.equals("accept"))
	 {
		 HttpSession sessions12=request.getSession();  
		 sessions12.setAttribute("r", dreg);
		
		 System.out.println("dgre---------"+dreg);
		 RequestDispatcher rd=request.getRequestDispatcher("viewboncer.jsp");  
	        rd.forward(request, response);  
	 }
	 else if(stat.equals("decline"))
	 { 
		 HttpSession sessions13=request.getSession();  
		 sessions13.setAttribute("r", dreg);
	 System.out.println("regno1---------"+regno1);
		 RequestDispatcher rd=request.getRequestDispatcher("viewdeclinebon.jsp");  
	        rd.forward(request, response);  
	 }
	 else
	 {
		 RequestDispatcher rd=request.getRequestDispatcher("stuinbox.jsp");  
	        rd.forward(request, response);  
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
