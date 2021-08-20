package com.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Random;

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

public class LofRequest extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LofRequest() {
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

	
		System.out.println("Post Coming");
		
		
		String s = request.getParameter("staffid");
		System.out.println("staffid-------------"+s);
	String staffid ="",name="",dep="",email="",stuid="",stuname="",address="",locations="",content="",filename="";
	int count = 1 ;
		
		
		System.out.println("-"+staffid+""+name+""+dep+email+""+stuid+""+stuname+""+address+""+locations+""+content+""+filename);
		
		
		 boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				String filepath = ""  ;
				List<FileItem> items = upload.parseRequest(request);

				for (FileItem locFileItem : items) {
					if (locFileItem.isFormField()) {
						System.out.println("---" + locFileItem.getFieldName());

						if (locFileItem.getFieldName().equals("staffid")) {
							staffid = locFileItem.getString();
						}
						if (locFileItem.getFieldName().equals("name")) {
							name = locFileItem.getString();
						}
						if (locFileItem.getFieldName().equals("dep")) {
							dep = locFileItem.getString();
						}
						if (locFileItem.getFieldName().equals("email")) {
							email = locFileItem.getString();
						}
						if (locFileItem.getFieldName().equals("stuid")) {
							stuid = locFileItem.getString();
						}
						if (locFileItem.getFieldName().equals("stuname")) {
							stuname = locFileItem.getString();
						}
						if (locFileItem.getFieldName().equals("address")) {
							address = locFileItem.getString();
						}
						
						if (locFileItem.getFieldName().equals("location")) {
							locations = locFileItem.getString();
						}
						if (locFileItem.getFieldName().equals("content")) {
							locations = locFileItem.getString();
						}
						if (locFileItem.getFieldName().equals("subject")) {
							locations = locFileItem.getString();
						}
						

					}
		
					else {
						System.out.println("--------ELSE--------");
						System.out.println("staffid-----: " + staffid);
						System.out.println("name-----"+name);
						System.out.println("dep     --"+dep);
						System.out.println("email----"+email);
						System.out.println("stuid------"+stuid);
						System.out.println("stuname==t--"+stuname);
						
						System.out.println("address--"+address);
					
						
						
						
						
						
						System.out.println("location--location--"+locations);
						System.out.println("content--content--"+content);
						
						
						
						filepath = "webapps/D/student_signature/";
						String path = filepath; 

						File f = new File(path);
						if (!f.exists()) {
							f.mkdirs();
						}
						filename = locFileItem.getName();
						System.out.println("filename concate-----"+filename);
					
						System.out.println("Filename is ====" + filename);
						File tosave = new File(path, filename);
						locFileItem.write(tosave);
					
						
						
						System.out.println("Stuid = === "+stuid);
						String place = "";
						String pincode = "";
						String regno = "";
						
						
						
						//getting location
						try{
							Connection conssss= ConnectionProvider.getCon();  
							Statement statement=conssss.createStatement();
							String sql ="select * from student where stuid ="+stuid+"";
							ResultSet resultSet = statement.executeQuery(sql);
							while(resultSet.next()){
								
								place = resultSet.getString(15);
								pincode = resultSet.getString(14);
								regno = resultSet.getString(2);
								
							}
						
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						
						
						Random rands = new Random(); 

						//Generate random integers in range 0 to 999 
						int r = rands.nextInt(10000); 
						System.out.println("unique id for staff ----"+r);

						
						
						
						  try { 
							  
							  System.out.println("filename---------"+filename);
							String x = filename;
						
	
							  
							Connection con= ConnectionProvider.getCon(); 
							  PreparedStatement ps=con.prepareStatement("insert into lofrequest values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");		  
							  ps.setString(1,staffid);
							  ps.setString(2,name);
							  ps.setString(3,dep);
							  ps.setInt(4,count);
							  ps.setString(5,locations);
							  ps.setString(6,email);
							  ps.setString(7,stuid);
							
						     ps.setString(8, stuname);
						     
						     ps.setString(9, address);
						   
						     ps.setString(10, place);
						     ps.setString(11, filename);
						     
						     ps.setString(12, place);
						     ps.setString(13, pincode);
						     ps.setString(14, regno);
						     ps.setInt(15, r);
						
						       int   status=ps.executeUpdate();
						      System.out.println("Inserting  lor request Data==="+status);
						     
						  
						      
						      
						      Connection con1= ConnectionProvider.getCon(); 
							  PreparedStatement ps1=con1.prepareStatement("insert into lofrequest_copy values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");		  
							  ps1.setString(1,staffid);
							  ps1.setString(2,name);
							  ps1.setString(3,dep);
							  ps1.setInt(4,count);
							  ps1.setString(5,locations);
							  ps1.setString(6,email);
							  ps1.setString(7,stuid);
							   ps1.setString(8, stuname);
							     
							     ps1.setString(9, address);
							   
							     ps1.setString(10, place);
							     ps1.setString(11, filename);
						
							     
							     ps1.setString(12, place);
							     ps1.setString(13, pincode);
							     ps1.setString(14, regno);
							     ps1.setInt(15, r);
						       int   status1=ps1.executeUpdate();
						      System.out.println("Inserting lor request  2 ==="+status1);
						      
						      request.setAttribute("success", " LOF Request Submitted !!");
							    RequestDispatcher rd = request
								.getRequestDispatcher("studenthome.jsp");
							rd.forward(request, response);; 
						  
					}
				
 catch(Exception e) 
 { 
	 e.printStackTrace();
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
					  
					  
					 
					
					
					
					
					     
					
						  
					      
						      
						      
						      
						      
						      
						      
						      
						      
						      
						      
						      
						      
						      
						      
						      
						      
						      
						      
						      
						  
						     
						  
						      
						     
		
						
						
						
						
						
						
						
						
						
						
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	public void init() throws ServletException {
		// Put your code here
	}

}
