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

import org.apache.commons.fileupload.FileUploadException;

import com.dao.ConnectionProvider;

public class DeclineBonCertificate extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DeclineBonCertificate() {
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

	
		
		
		System.out.println("Doget Decline Bonafide Certificate");
		
		String regno = request.getParameter("regno");
		String s = request.getParameter("stuid");
		String stat = request.getParameter("stat");
		String staffreason = request.getParameter("staffreason");
		System.out.println("Regno ---"+regno);
		
		
		//getting location
	

			
			  try { 
				  
				String sname ="none";
				String joinyear = "none";
				String endyear = "none";
				String course = "none";
				String regno2 = "none";
				String b = "";
				String cdate = "";
				
				String  x ="vv";
				
				String detial = "decline";
				String crea = "";
			int count =1;
			
				  Connection con= ConnectionProvider.getCon(); 
				  PreparedStatement ps=con.prepareStatement("insert into approvedboncertificate values (?,?,?,?,?,?,?,?,?,?,?)");		  
				  ps.setString(1,sname);
				  ps.setString(2,joinyear);
				  ps.setString(3,endyear);
				  ps.setString(4,course);
				  ps.setString(5,regno2);
				  ps.setString(6,b);
				  ps.setString(7,cdate);
				  ps.setString(8,x);
			     ps.setInt(9, count);
			     ps.setString(10, detial);
			     ps.setString(11, crea);
			
			       int   status=ps.executeUpdate();
			      System.out.println("Inserting Data==="+status);
			     
			  
			      
			      
			      Connection con1= ConnectionProvider.getCon(); 
				  PreparedStatement ps1=con1.prepareStatement("insert into approvedboncertificate_copy values (?,?,?,?,?,?,?,?,?.?,?)");		  
				  ps1.setString(1,sname);
				  ps1.setString(2,joinyear);
				  ps1.setString(3,endyear);
				  ps1.setString(4,course);
				  ps1.setString(5,regno2);
				  ps1.setString(6,b);
				  ps1.setString(7,cdate);
				  ps1.setString(8,x);
			     ps1.setInt(9, count);
			     ps1.setString(10, detial);
			     ps1.setString(11, crea);
			
			       int   status1=ps1.executeUpdate();
			      System.out.println("Inserting Data==="+status1);
		
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

		
		System.out.println("Coming Post");
		
		String reason = request.getParameter("reason");
		String staffreason = request.getParameter("staffreason");
		String regnos = request.getParameter("regnos");
		int unique = Integer.parseInt(request.getParameter("u"));
		
		System.out.println("reason---"+reason+"---"+staffreason+"regnos----"+regnos);
		
		
		
		String stuid = "";
		String regno ="";
		String stureason = "";
		String stuname = "";
		String stuemail = "";
		
		
		try{
			Connection conssss= ConnectionProvider.getCon();  
			Statement statement=conssss.createStatement();
			String sql ="select * from bonafide_request_copy where regno ='"+regnos+"'";
			ResultSet resultSet = statement.executeQuery(sql);
			if(resultSet.next()){
				System.out.println("regno---dup"+regnos+"unique key----"+unique);

				//
		
				
				  try { 
					  
					String sname ="none";
					String joinyear = "none";
					String endyear = "none";
					String course = "none";
					String regno2 = "none";
					String b = "";
					String cdate = "";
					
					String  x ="vv";
					
					String detial = "decline";
					String crea = "";
				int count =1;
				
					  Connection con= ConnectionProvider.getCon(); 
					  PreparedStatement ps=con.prepareStatement("insert into approvedboncertificate values (?,?,?,?,?,?,?,?,?,?,?)");		  
					  ps.setString(1,sname);
					  ps.setString(2,joinyear);
					  ps.setString(3,endyear);
					  ps.setString(4,course);
					  ps.setString(5,regnos);
					  ps.setString(6,b);
					  ps.setString(7,cdate);
					  ps.setString(8,x);
				     ps.setInt(9, count);
				     ps.setString(10, detial);
				     ps.setString(11, staffreason);
				
				       int   status=ps.executeUpdate();
				      System.out.println("Inserting Data==="+status);
				     
				  
				      
				      
				      
				      
				      Connection con1= ConnectionProvider.getCon(); 
					  PreparedStatement ps1=con.prepareStatement("insert into approvedboncertificate_copy values (?,?,?,?,?,?,?,?,?,?,?)");		  
					  ps1.setString(1,sname);
					  ps1.setString(2,joinyear);
					  ps1.setString(3,endyear);
					  ps1.setString(4,course);
					  ps1.setString(5,regnos);
					  ps1.setString(6,b);
					  ps1.setString(7,cdate);
					  ps1.setString(8,x);
				     ps1.setInt(9, count);
				     ps1.setString(10, detial);
				     ps1.setString(11, staffreason);
				
				       int   status1=ps1.executeUpdate();
				      System.out.println("Inserting Data==="+status);
				     
				   
				   		System.out.println("regno-------"+regno);
				   		//delete bonreq and bon req copy
				   		Connection con2= ConnectionProvider.getCon();  
						Statement st1=con2.createStatement();
						
				   		System.out.println("Deleting");
				   	
				   	 String sq1 = "delete  from bonafide_request where unique_no='"+unique+"' ";
		st1.executeUpdate(sq1);
				   		
				   		
				   		

		Connection con21= ConnectionProvider.getCon();  
		Statement st11=con21.createStatement();

			System.out.println("Deleting");

		String sq11 = "delete  from bonafide_request_copy where unique_no='"+unique+"' ";
		st11.executeUpdate(sq11);
			
		
	  	Connection con211= ConnectionProvider.getCon();  
		Statement st111=con211.createStatement();
		
			System.out.println("Deleting");
		
		 String sq11221 = "delete from bonafide_request_copy1 where regno='"+regnos+"'";
	st11.executeUpdate(sq11221);
		


		//try request dispatcher her 



		                request.setAttribute("decline", "Certificate Declined");
		                RequestDispatcher rd = request
		        		.getRequestDispatcher("hodrecreq.jsp");
		        		rd.forward(request, response);; 
				
				      
				      
				      
				  }
				  
				  
				  catch(Exception e) { e.printStackTrace();
				  
				  }
				
				
				
				
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// inseritn two 

		 /* try { 
			  
			String sname ="none";
			String joinyear = "none";
			String endyear = "none";
			String course = "none";
			String regno2 = "none";
			String b = "";
			String cdate = "";
			
			String  x ="vv";
			
			String detial = "decline";
			String crea = "";
		int count =1;
		
			  Connection con= ConnectionProvider.getCon(); 
			  PreparedStatement ps=con.prepareStatement("insert into approvedboncertificate values (?,?,?,?,?,?,?,?,?,?,?)");		  
			  ps.setString(1,sname);
			  ps.setString(2,joinyear);
			  ps.setString(3,endyear);
			  ps.setString(4,course);
			  ps.setString(5,regno);
			  ps.setString(6,b);
			  ps.setString(7,cdate);
			  ps.setString(8,x);
		     ps.setInt(9, count);
		     ps.setString(10, detial);
		     ps.setString(11, staffreason);
		
		       int   status=ps.executeUpdate();
		      System.out.println("Inserting Data==="+status);
		     
		  
		      
		      
		      
		      
		      Connection con1= ConnectionProvider.getCon(); 
			  PreparedStatement ps1=con.prepareStatement("insert into approvedboncertificate_copy values (?,?,?,?,?,?,?,?,?,?,?)");		  
			  ps1.setString(1,sname);
			  ps1.setString(2,joinyear);
			  ps1.setString(3,endyear);
			  ps1.setString(4,course);
			  ps1.setString(5,regno);
			  ps1.setString(6,b);
			  ps1.setString(7,cdate);
			  ps1.setString(8,x);
		     ps1.setInt(9, count);
		     ps1.setString(10, detial);
		     ps1.setString(11, staffreason);
		
		       int   status1=ps1.executeUpdate();
		      System.out.println("Inserting Data==="+status);
		     
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		     
	
		    
		   		
		   		
		   		//delete bonreq and bon req copy
		   		Connection con2= ConnectionProvider.getCon();  
				Statement st1=con2.createStatement();
				
		   		System.out.println("Deleting");
		   	
		   	 String sq1 = "delete  from bonafide_request where regno='"+regno+"' ";
st1.executeUpdate(sq1);
		   		
		   		
		   		

Connection con21= ConnectionProvider.getCon();  
Statement st11=con21.createStatement();

	System.out.println("Deleting");

String sq11 = "delete  from bonafide_request_copy where regno='"+regno+"' ";
st11.executeUpdate(sq11);
	


//try request dispatcher her 



                request.setAttribute("decline", "Certificate Declined");
                RequestDispatcher rd = request
        		.getRequestDispatcher("hodrecreq.jsp");
        		rd.forward(request, response);; 
		
		      
		      
		      
		  }
		  
		  
		  catch(Exception e) { e.printStackTrace();
		  
		  }
		*/
		
		
	
		
		
		
		
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
