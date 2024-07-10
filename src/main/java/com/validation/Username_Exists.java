package com.validation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.Get_Connection;
import com.pojo.User;

public class Username_Exists {
	public static boolean Username(User user) {
		boolean x=false;
		Connection c = Get_Connection.getConnection();
		PreparedStatement pstmt = null;

        try {
            // Step 3: Create a SQL insert statement
            String sql = "SELECT * FROM users WHERE username = ? ";
            pstmt = c.prepareStatement(sql);

            // Step 4: Set the values
            pstmt.setString(1, user.getUsername());
            // Step 5: Execute the insert
            ResultSet resultSet = pstmt.executeQuery();

            // Process the result
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count > 0) {
                    System.out.println("Username exists.");
                    x= true;
                } else {
                    System.out.println("Username does not exist.");
                    x= false;
                }
            }

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (c != null) c.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
		return x;
    }
}
