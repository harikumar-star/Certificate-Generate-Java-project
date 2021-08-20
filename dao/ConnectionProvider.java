package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import static com.service.Provider.CONNECTION_URL;
import static com.service.Provider.DRIVER;
import static com.service.Provider.PASSWORD;
import static com.service.Provider.USERNAME;

public class ConnectionProvider {
	private static Connection con=null;  
	private static Connection con1=null; 

	static{  
	try{  
	Class.forName(DRIVER);  
	con=DriverManager.getConnection(CONNECTION_URL,USERNAME,PASSWORD);  

	}catch(Exception e){}  
	}  
	  
	public static Connection getCon(){  
	    return con;  
	}  
	
	public static Connection getCon1(){  
	    return con1;  
	}  
}
