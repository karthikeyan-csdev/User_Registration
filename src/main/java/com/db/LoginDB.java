package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.pojo.User;
import com.validation.Email_Exists;
import com.validation.Password_Get;
import com.validation.Username_Exists;

public class LoginDB {
	public boolean main(User user) {
		
    	boolean x=false;
    	String pswd = null;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            
    		conn = Get_Connection.getConnection();

            if(Email_Exists.Email(user)) {
            	
            	pswd = Password_Get.Password(user,user.getPassword());
            	
            	if(pswd.equals(user.getPassword()));{
            		x=true;	
            	}
            }
        }
            
        
    	catch (Exception e) {
            // Handle errors for Class.forName
        	e.printStackTrace();
        } 
        finally {

        	try {
        			if (pstmt != null) pstmt.close();
	            } 
        	catch (SQLException se2) {
	        } // nothing we can do
	        try {
	            if (conn != null) conn.close();
	        } 
	        catch (SQLException se) {
	                se.printStackTrace();
	        }
     	}
        return x;

	}
}
