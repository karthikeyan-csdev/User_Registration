package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.pojo.User;
import com.validation.Username_Exists;

public class SignupDB {

    public boolean main(User user) {
    	boolean x=false;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            
    		conn = Get_Connection.getConnection();

            if(Username_Exists.Username(user)) {
            	System.out.println("Username Exists");
            	
            }
            else {
            	try {
	            	// Step 3: Create a SQL insert statement
	                String sql = "INSERT INTO users (Username, Email,Password) VALUES (?, ?, ?)";
	                pstmt = conn.prepareStatement(sql);
	
	                // Step 4: Set the values
	                pstmt.setString(1, user.getUsername());
	                pstmt.setString(2, user.getEmail());
	                pstmt.setString(3, user.getPassword());
	                // Step 5: Execute the insert
	                int rowsInserted = pstmt.executeUpdate();
	                if (rowsInserted > 0) {
	                    System.out.println("A new record was inserted successfully!");
	                    x=true;
	                }
                }
            	catch(Exception e) {
            		
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
        System.out.println("Goodbye!");	
        return x;
    }
}
