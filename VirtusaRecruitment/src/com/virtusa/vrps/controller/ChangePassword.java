package com.virtusa.vrps.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.virtusa.vrps.dao.PasswordChange;


public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(ChangePassword.class);
       
    
    public ChangePassword() {
        super();

    }

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("text/html");
		String id=request.getParameter("id");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		HttpSession hs = request.getSession();
		String i=(String)hs.getAttribute("empid");
		if(id.equals(i)) {
		
		boolean bt=new PasswordChange().changePassword(id, email, pass);
		boolean flag=true;
		if(bt==flag) {
			try{request.getRequestDispatcher("loginPage1.jsp").include(request, response);}catch(Exception e) {logger.error(e);}
		} else {
			try{response.getWriter().println("Incorrect Email OR Employee Id..");
			request.getRequestDispatcher("ChangePassword.jsp").include(request, response);}catch(Exception e) {logger.error(e);}
		}
		}else {
			try{response.getWriter().println("Incorrect Email OR Employee Id..");
			request.getRequestDispatcher("ChangePassword.jsp").include(request, response);}catch(Exception e) {logger.error(e);}
		}
	}

}
