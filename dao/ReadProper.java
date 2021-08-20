package com.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProper {
	public String getURLDetails() throws IOException {
		String ipAddress = "";
		String portNumber = "";
		String projectName="";
		String folder ="";
		InputStream inputStream = null;
		

		try {
			Properties prop = new Properties();
			String propFileName = "a.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 
//			Date time = new Date(System.currentTimeMillis());
 
			// get the property value and print it out
			ipAddress = prop.getProperty("ip");
			portNumber = prop.getProperty("port");
		    projectName=prop.getProperty("server");
		    folder = prop.getProperty("folder");
			System.out.println(ipAddress);
			System.out.println(portNumber);
			System.out.println(projectName);
			System.out.println(folder);
 
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return "http://"+ipAddress+":"+portNumber+"/"+projectName+"/"+folder+"/";
	}
	
	//------------------------------
	
	public String getURLDetailss() throws IOException {
		String ipAddresss = "";
		String portNumbers = "";
		String projectNames="";
		String folders ="";
		InputStream inputStream1 = null;
		

		try {
			Properties prop1 = new Properties();
			String propFileName1 = "a.properties";
 
			inputStream1 = getClass().getClassLoader().getResourceAsStream(propFileName1);
 
			if (inputStream1 != null) {
				prop1.load(inputStream1);
			} else {
				throw new FileNotFoundException("property file '" + propFileName1 + "' not found in the classpath");
			}
 
//			Date time = new Date(System.currentTimeMillis());
 
			// get the property value and print it out
			ipAddresss = prop1.getProperty("ips");
			portNumbers = prop1.getProperty("ports");
		    projectNames=prop1.getProperty("servers");
		    folders = prop1.getProperty("folders");
			System.out.println(ipAddresss);
			System.out.println(portNumbers);
			System.out.println(projectNames);
			System.out.println(folders);
 
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream1.close();
		}
		return "http://"+ipAddresss+":"+portNumbers+"/"+projectNames+"/"+folders+"/";
	}
	
	
	
	// approved staffsigns
	
	public String getURLDetailss1() throws IOException {
		String ipAddresss1 = "";
		String portNumbers1 = "";
		String projectNames1="";
		String folders1 ="";
		InputStream inputStream11 = null;
		

		try {
			Properties prop11 = new Properties();
			String propFileName11 = "a.properties";
 
			inputStream11 = getClass().getClassLoader().getResourceAsStream(propFileName11);
 
			if (inputStream11 != null) {
				prop11.load(inputStream11);
			} else {
				throw new FileNotFoundException("property file '" + propFileName11 + "' not found in the classpath");
			}
 
//			Date time = new Date(System.currentTimeMillis());
 
			// get the property value and print it out
			ipAddresss1 = prop11.getProperty("ips1");
			portNumbers1 = prop11.getProperty("ports1");
		    projectNames1=prop11.getProperty("servers1");
		    folders1 = prop11.getProperty("folders1");
			System.out.println(ipAddresss1);
			System.out.println(portNumbers1);
			System.out.println(projectNames1);
			System.out.println(folders1);
 
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream11.close();
		}
		return "http://"+ipAddresss1+":"+portNumbers1+"/"+projectNames1+"/"+folders1+"/";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		 
		ReadProper property=new ReadProper();
		System.out.println(property.getURLDetailss1());
		System.out.println(property.getURLDetailss());
		System.out.println(property.getURLDetails());
		//System.out.println(property.getURLDetails());
		
	
	}
}
