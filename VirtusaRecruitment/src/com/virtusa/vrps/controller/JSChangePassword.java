package com.virtusa.vrps.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtusa.vrps.dao.JSPasswordChange;
import com.virtusa.vrps.dao.JSRegistrationDAO;
import com.virtusa.vrps.dao.JSRegistrationDAOImpl;
import com.virtusa.vrps.dao.Password;


public class JSChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public JSChangePassword() {
        super();

    }

	
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("text/html");
		Password p=new Password();
		String oldpass=request.getParameter("oldpass");
		String encold=p.encrypt(oldpass);
		String newpass=request.getParameter("newpass");
		String encnew=p.encrypt(newpass);
		HttpSession hs = request.getSession();
		String em=(String)hs.getAttribute("email");
		ServletContext sc = getServletContext();
		Connection con = (Connection) sc.getAttribute("callconn");
		JSRegistrationDAO j=new JSRegistrationDAOImpl(con);
		boolean flag=j.getPassword(encold, em);
		System.out.println(flag);
		
		if(flag) {
		
		boolean bt=new JSPasswordChange().changePassword(em, encnew);
		boolean f=true;
		if(bt==f) {
			request.getRequestDispatcher("JobSeekerLogin.jsp").include(request, response);
		} else {
			response.getWriter().println("Incorrect old password..");
			request.getRequestDispatcher("JSChangePassword.jsp").include(request, response);
		}
		}else {
			response.getWriter().println("Incorrect old password..");
			request.getRequestDispatcher("JSChangePassword.jsp").include(request, response);
		}
		}catch(Exception e) {}
	}
		
	}

