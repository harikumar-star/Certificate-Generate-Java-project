package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ConnectionProvider;

public class DeclineLofCertificate extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DeclineLofCertificate() {
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

		System.out.println("Doget Decline lof Certificate");
		String uid = request.getParameter("unique_id");
		System.out.println("uid----------"+uid);
		String regno= "";
		
		
		
		String cdate ="";
		String sname = "";
		String sadd ="";
		String place = "";
		String pincode ="";
		String staffname ="";
		String dep = "";
		String univer = "";
		String p = "";
		String w3review = "";
	
		String filename = "";
		
		
		
		String stuid ="";
	
		String staffid ="";
		String im ="";
		String unique_id ="";
		
		
		
		
		
		
		 try{
				Connection conssss= ConnectionProvider.getCon();  
				Statement statement=conssss.createStatement();
				String sql ="select * from lofrequest_copy where unique_id="+uid+"";
				ResultSet resultSet = statement.executeQuery(sql);
				while(resultSet.next()){
					regno = resultSet.getString(14);
				
					staffname = resultSet.getString(2);
					dep = resultSet.getString(3);
					
				
				}
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
		

		
		 try { 
				
				
			
				
				
			String zz = "decline";
			String d = "";
		int count =1;
		
			  Connection con= ConnectionProvider.getCon(); 
			  PreparedStatement ps=con.prepareStatement("insert into approvedlofcertificate values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");		  
			  ps.setString(1,d);
			  ps.setString(2,sname);
			  ps.setString(3,sadd);
			  ps.setString(4,place);
			  ps.setString(5,pincode);
			  ps.setString(6,staffname);
			  ps.setString(7,dep);
			  ps.setString(8,univer);
		     ps.setString(9, p);
		     ps.setString(10, filename);
		     ps.setString(11, w3review);
		     ps.setString(12, stuid);
		     ps.setString(13, regno);
		     ps.setString(14, staffid);
		     ps.setString(15, im);
		     ps.setInt(16, count);
		     ps.setString(17,zz);
		     ps.setString(18, uid);
		     
		
		       int   status=ps.executeUpdate();
		      System.out.println("Inserting Data==="+status);
		     
		  
		      
		      
		      Connection con1= ConnectionProvider.getCon(); 
			  PreparedStatement ps1=con1.prepareStatement("insert into approvedlofcertificate_copy values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");		  
			  ps1.setString(1,d);
			  ps1.setString(2,sname);
			  ps1.setString(3,sadd);
			  ps1.setString(4,place);
			  ps1.setString(5,pincode);
			  ps1.setString(6,staffname);
			  ps1.setString(7,dep);
			  ps1.setString(8,univer);
		     ps1.setString(9, p);
		     ps1.setString(10, filename);
		     ps1.setString(11, w3review);
		     ps1.setString(12, stuid);
		     ps1.setString(13, regno);
		     ps1.setString(14, staffid);
		     ps1.setString(15, im);
		     ps1.setInt(16, count);
		     ps1.setString(17,zz);
		     ps1.setString(18, uid);
		       int   status1=ps1.executeUpdate();
		      System.out.println("Inserting Data==="+status1);
		      
		      
		      
		      //delete lof request and lof request_copy
		      
		      
		  	Connection con2= ConnectionProvider.getCon();  
			Statement st1=con2.createStatement();
			
				System.out.println("Deleting lofreq");
			
			 String sq1 = "delete from lofrequest where unique_id='"+uid+"'";
		st1.executeUpdate(sq1);


		Connection con21= ConnectionProvider.getCon();  
		Statement st11=con21.createStatement();

			System.out.println("Deleting lof req_copy");

		 String sq11 = "delete from lofrequest_copy where unique_id='"+uid+"'";
		st11.executeUpdate(sq11);

		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		    //  response.sendRedirect("viewreqlistlor.jsp");  
		      request.setAttribute("success", "LOF Declined !");
		      RequestDispatcher rd=request.getRequestDispatcher("viewreqlistlor.jsp");  
		        rd.forward(request, response);  
		 }
		
		

	  
	  catch(Exception e) 
	  { 
	
		  e.printStackTrace();
		  System.out.println("Filenotfound 1---"+e);
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
