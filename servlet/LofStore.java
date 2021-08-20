package com.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class LofStore extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LofStore() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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

		
		
		System.out.println("Post coming lofstore");
		
		
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
		String regno ="";
		String staffid ="";
		String im ="";
		String unique_id ="";
		
		
		
		 boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				String filepath = ""  ;
				List<FileItem> items = upload.parseRequest(request);

				for (FileItem locFileItem : items) {
					if (locFileItem.isFormField()) {
						System.out.println("---" + locFileItem.getFieldName());

						if (locFileItem.getFieldName().equals("cdate")) {
							sname = locFileItem.getString();
						}
						if (locFileItem.getFieldName().equals("sname")) {
							sname = locFileItem.getString();
						}
						if (locFileItem.getFieldName().equals("sadd")) {
							sadd = locFileItem.getString();
						}
						if (locFileItem.getFieldName().equals("place")) {
							place = locFileItem.getString();
						}
						if (locFileItem.getFieldName().equals("pincode")) {
							pincode = locFileItem.getString();
						}
						if (locFileItem.getFieldName().equals("staffname")) {
							staffname = locFileItem.getString();
						}
						if (locFileItem.getFieldName().equals("dep")) {
							dep = locFileItem.getString();
						}
						if (locFileItem.getFieldName().equals("univer")) {
							univer = locFileItem.getString();
						}
						if (locFileItem.getFieldName().equals("p")) {
							p = locFileItem.getString();
						}
						if (locFileItem.getFieldName().equals("w3review")) {
							w3review = locFileItem.getString();
						}
					
						if (locFileItem.getFieldName().equals("filename")) {
							filename = locFileItem.getString();
						}
						if (locFileItem.getFieldName().equals("stuid")) {
							stuid = locFileItem.getString();
						}
						if (locFileItem.getFieldName().equals("regno")) {
							regno = locFileItem.getString();
						}
						if (locFileItem.getFieldName().equals("staffid")) {
							staffid = locFileItem.getString();
						}
						if (locFileItem.getFieldName().equals("im")) {
							im = locFileItem.getString();
						}
						
						if (locFileItem.getFieldName().equals("unique_id")) {
							unique_id = locFileItem.getString();
						}

					}
					else {
						System.out.println("--------ELSE--------");
					
						
						System.out.println("cdate"+cdate);
						System.out.println("stuname"+sname);
						System.out.println("cdate"+sadd);
						System.out.println("cdate"+place);
						System.out.println("cdate"+pincode);
						System.out.println("cdate"+staffname);
						System.out.println("cdate"+dep);
						System.out.println("cdate"+univer);
						
						System.out.println("cdate"+p);
						System.out.println("cdate"+w3review);
					
						System.out.println("cdate"+filename);
						
						
						System.out.println("--"+stuid+""+regno+""+staffid+""+im);
						
System.out.println("unique--id "+unique_id);
						filepath = "webapps/D/approved_student_lof/";
						String path = filepath;

						File f = new File(path);
						if (!f.exists()) {
							f.mkdirs();
						}
						filename = locFileItem.getName();
					
						System.out.println("Filename is ====" + filename);
						File tosave = new File(path, filename);
						locFileItem.write(tosave);
						
						//inserting approved lof 
						
						
						
						
						DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
						Date dateobj = new Date();
						System.out.println(df.format(dateobj));
						String d = df.format(dateobj);
						
						System.out.println("Date-----"+d);

						
						 try { 
							  
							  System.out.println("filename---------"+filename);
							String x = filename;
							String z = "accept";
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
						     ps.setString(17,z);
						     ps.setString(18, unique_id);
						     
						
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
						     ps1.setString(17,z);
						     ps1.setString(18, unique_id);
						       int   status1=ps1.executeUpdate();
						      System.out.println("Inserting Data==="+status1);
						      
						      
						      
						      //delete lof request and lof request_copy
						      
						      
						  	Connection con2= ConnectionProvider.getCon();  
							Statement st1=con2.createStatement();
							
								System.out.println("Deleting lofreq");
							
							 String sq1 = "delete from lofrequest where unique_id='"+unique_id+"'";
						st1.executeUpdate(sq1);


						Connection con21= ConnectionProvider.getCon();  
						Statement st11=con21.createStatement();

							System.out.println("Deleting lof req_copy");

						 String sq11 = "delete from lofrequest_copy where unique_id='"+unique_id+"'";
						st11.executeUpdate(sq11);
		      
						      
						      
						      
						      
						      
						      
						      
						      
						      
						      
						      
						      
						      
						    //  response.sendRedirect("viewreqlistlor.jsp");  
						      request.setAttribute("success", "LOF ISSUED !");
						      RequestDispatcher rd=request.getRequestDispatcher("viewreqlistlor.jsp");  
						        rd.forward(request, response);  
						 }
						
						
		  
					  
					  catch(Exception e) 
					  { 
					
						  e.printStackTrace();
						  System.out.println("Filenotfound 1---"+e);
					  }
					
						
						  }
					}
				}
							
						
						      
									
				catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					  System.out.println("Filenotfound 2---"+e);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					request.setAttribute("img", "Please Upload Image");
					RequestDispatcher rd=request.getRequestDispatcher("lofpage.jsp");  
			        rd.forward(request, response);  
					  System.out.println("Filenotfound 3---"+e);
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
