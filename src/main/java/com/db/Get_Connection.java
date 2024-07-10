package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Get_Connection {
	static final String DB_URL = "jdbc:mysql://localhost:3306/authentication";
    static final String USER = "root";
    static final String PASS = "kkkk";
    
    static Connection conn = null;
    
    public static Connection getConnection() {
    	
    	try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
		return conn;
    	
    }
}
