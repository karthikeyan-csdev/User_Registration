package com.servlets;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.LoginDB;
import com.pojo.User;

@WebServlet("/login")
public class Login_Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("/Login.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    
    	User u = new User();
    	u.setEmail(req.getParameter("email").toString());
    	u.setPassword(req.getParameter("password").toString());
    	
    	
    	LoginDB ldb = new LoginDB();
    	if(ldb.main(u)) {
            req.getRequestDispatcher("/Home.jsp").forward(req, res);

    	}
    	else {
            req.getRequestDispatcher("/Signup.jsp").forward(req, res);

    	}
    	
    	
    }
}
