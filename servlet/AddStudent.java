package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ConnectionProvider;

public class AddStudent extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddStudent() {
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

	
		
		


		String sname = request.getParameter("sname");
	
		String dob = request.getParameter("dob");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String course = request.getParameter("course");
		String category = request.getParameter("category");
		String jyear = request.getParameter("jyear");
		
		String address = request.getParameter("address");
		String pincode = request.getParameter("pincode");
		String location = request.getParameter("location");
		
		
		System.out.println("Join year ----"+jyear);
		 
		
		System.out.println("Date before Addition: "+jyear);
		//Specifying date format that matches the given date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		try{
		   //Setting the date to the given date
		   c.setTime(sdf.parse(jyear));
		}catch(ParseException e){
			e.printStackTrace();
		 }
		   
		//Number of Days to add
		c.add(Calendar.DAY_OF_MONTH, 1460);  
		//Date after adding the days to the given date
		String newDate = sdf.format(c.getTime());  
		//Displaying the new Date after addition of Days
		System.out.println("Date after Addition: "+newDate);
		
		
		
		
		
		String eyear = newDate;
		String gender = request.getParameter("rrt");
        
		String status1 = "waiting";
		
		Random rand = new Random(); 
		int rand_int1 = rand.nextInt(100); 
		String stuid =String.valueOf(rand_int1);
		System.out.println("stuid-----"+stuid);

		Random rands = new Random(); 

		//Generate random integers in range 0 to 999 
		int rand_int12 = rand.nextInt(10000); 
		String regno =String.valueOf(rand_int12);
		System.out.println("regno-----"+regno);
		
		
		double min = 5;  
		double  max = 9.9;   
		//Generate random int value from 200 to 400   
		System.out.println("Random value of type int between "+min+" to "+max+ ":");  
		double b = (double)(Math.random()*(max-min+1)+min);  
		System.out.println(b);

		    String x_str = Double.toString(b);
		    System.out.println("-----------"+x_str);

		    System.out.println(x_str.substring(0,3));
		
		String cgpa = x_str.substring(0,3);
		
		
		
		
		
		
		
		
	
		int status = 0 ;
		 try { 
			 Connection cons= ConnectionProvider.getCon();  
			 PreparedStatement ps1=cons.prepareStatement("select * from student where email =?  "); 
			 ps1.setString(1, email);
			
				ResultSet rs = ps1.executeQuery();
			
				if(rs.next())
				{
					status = 0 ;
					System.out.println(status);
					 System.out.println("Email already ther");
				}
			 else
			 {
				 Connection con= ConnectionProvider.getCon(); 
				  PreparedStatement ps=con.prepareStatement("insert into student values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");		  
			       ps.setString(1,stuid );
			       ps.setString(2,regno ); 
			       ps.setString(3, dob); 
			       ps.setString(4, email);
			       ps.setString(5, password);
			       ps.setString(6, course); 
			       ps.setString(7, category); 
			       ps.setString(8, jyear);
			       ps.setString(9, newDate);
			       ps.setString(10, gender);
			       ps.setString(11, status1);
			       ps.setString(12, sname);
			       ps.setString(13,address);
			       ps.setString(14, pincode);
			       ps.setString(15, location);
			       ps.setString(16, cgpa);
			       status=ps.executeUpdate();
			            
			       System.out.println(" Student Added succes");
			 }
			  
				
			
		        
		       
		       
		       if(status >0)
		       {
		    	   request.setAttribute("success", "Regiter Sucess !!");
		    	   RequestDispatcher rd = request
					.getRequestDispatcher("addstudent.jsp");
			rd.forward(request, response);; 
		       }
		       else
		       {
		    	   request.setAttribute("fail", " Email Already Exits Enter New Email!!");
		    	   RequestDispatcher rd = request
					.getRequestDispatcher("addstudent.jsp");
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
