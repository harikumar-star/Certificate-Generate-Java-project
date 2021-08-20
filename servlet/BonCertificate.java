package com.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dao.ConnectionProvider;

public class BonCertificate extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public BonCertificate() {
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
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Boncertificate servlet coming");
		
		
		 String sname = "";
		 String joinyear ="";
		 String endyear = "";
		 String course = "";
		 String regno = "";
		 String filename="";
		 String bfcno ="";
		 String cdate = "";
		 boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				String filepath = ""  ;
				List<FileItem> items = upload.parseRequest(request);

				for (FileItem locFileItem : items) {
					if (locFileItem.isFormField()) {
						System.out.println("---" + locFileItem.getFieldName());

						if (locFileItem.getFieldName().equals("sname")) {
							sname = locFileItem.getString();
						}
						if (locFileItem.getFieldName().equals("joinyear")) {
							joinyear = locFileItem.getString();
						}
						if (locFileItem.getFieldName().equals("endyear")) {
							endyear = locFileItem.getString();
						}
						if (locFileItem.getFieldName().equals("course")) {
							course = locFileItem.getString();
						}
						if (locFileItem.getFieldName().equals("regno")) {
							regno = locFileItem.getString();
						}
						if (locFileItem.getFieldName().equals("joinyear")) {
							joinyear = locFileItem.getString();
						}
						if (locFileItem.getFieldName().equals("bfcno")) {
							bfcno = locFileItem.getString();
						}
						if (locFileItem.getFieldName().equals("cdate")) {
							cdate = locFileItem.getString();
						}

					}
					else {
						System.out.println("--------ELSE--------");
						System.out.println("name-----: " + sname);
						System.out.println("joinyear-- -----: " + joinyear);
						System.out.println("endyear-- -----: " + endyear);
						System.out.println("course-- -----: " + course);
						System.out.println("regno-- -----: " + regno);
						System.out.println("bfcno-- -----: " + bfcno);
						System.out.println("cdate-- -----: " + cdate);
						
						
						
						
						
						filepath = "webapps/D/boncertificate/";
						String path = filepath;

						File f = new File(path);
						if (!f.exists()) {
							f.mkdirs();
						}
						filename = locFileItem.getName();
					
						System.out.println("Filename is ====" + filename);
						File tosave = new File(path, filename);
						locFileItem.write(tosave);
						
						
						
						
						  try { 
							  
							  System.out.println("filename---------"+filename);
							String x = filename;
							String detial = "accept";
							String res = "lol";
						int count =1;
						
							  Connection con= ConnectionProvider.getCon(); 
							  PreparedStatement ps=con.prepareStatement("insert into approvedboncertificate values (?,?,?,?,?,?,?,?,?,?,?)");		  
							  ps.setString(1,sname);
							  ps.setString(2,joinyear);
							  ps.setString(3,endyear);
							  ps.setString(4,course);
							  ps.setString(5,regno);
							  ps.setString(6,bfcno);
							  ps.setString(7,cdate);
							  ps.setString(8,x);
						     ps.setInt(9, count);
						     ps.setString(10, detial);
						     ps.setString(11, res);
						
						       int   status=ps.executeUpdate();
						      System.out.println("Inserting Data==="+status);
						     
						  
						      
						      
						      Connection con1= ConnectionProvider.getCon(); 
							  PreparedStatement ps1=con1.prepareStatement("insert into approvedboncertificate_copy values (?,?,?,?,?,?,?,?,?,?,?)");		  
							  ps1.setString(1,sname);
							  ps1.setString(2,joinyear);
							  ps1.setString(3,endyear);
							  ps1.setString(4,course);
							  ps1.setString(5,regno);
							  ps1.setString(6,bfcno);
							  ps1.setString(7,cdate);
							  ps1.setString(8,x);
						     ps1.setInt(9, count);
						     ps1.setString(10, detial);
						     ps1.setString(11, res);
						
						       int   status1=ps1.executeUpdate();
						      System.out.println("Inserting Data==="+status1);
						     
						      
						      /*//updating hte status
						      Connection con11= ConnectionProvider.getCon();  
								Statement st=con.createStatement();
							
								String str = "Accepted";
					       		
					       		String query1 ="update bonafide_request_copy set status='"+str+"' where regno='"+regno+"'";
						   		st.executeUpdate (query1);
						   		*/
						   		
						   		//delete notify count
						   		Connection con2= ConnectionProvider.getCon();  
								Statement st122=con2.createStatement();
								
						   		System.out.println("Deleting");
						   	
						   	 String sq122 = "delete from bonafide_request where regno='"+regno+"'";
			      st122.executeUpdate(sq122);
						   		
						   		
						   		
					Connection con21= ConnectionProvider.getCon();  
					Statement st11=con21.createStatement();
					
			   		System.out.println("Deleting");
			   	
			   	 String sq1122 = "delete from bonafide_request_copy where regno='"+regno+"'";
      st11.executeUpdate(sq1122);
			   		
			      
      
  	Connection con211= ConnectionProvider.getCon();  
	Statement st111=con211.createStatement();
	
		System.out.println("Deleting");
	
	 String sq11221 = "delete from bonafide_request_copy1 where regno='"+regno+"'";
st11.executeUpdate(sq11221);
      
      
      
      
      
			      
			      
      request.setAttribute("success", "Request Successfully Processed !");
							
      RequestDispatcher rd = request
		.getRequestDispatcher("hodrecreq.jsp");
		rd.forward(request, response);;  
						    
						      
						      
						      
						  }
						  
						  
						  catch(Exception e) { e.printStackTrace();
						  
						  }
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
					}
				}
			}
				 catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
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
