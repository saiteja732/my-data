package com.virtusa.vrps.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.vrps.dao.JSPasswordChange;
import com.virtusa.vrps.dao.Password;


public class JSForgotPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public JSForgotPass() {
        super();

    }

	
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("text/html");
		String em=request.getParameter("em");
		String ques=request.getParameter("ques");
		String ans=request.getParameter("ans");
		String newpass=request.getParameter("newpass");
		Password p=new Password();
		String encnew=p.encrypt(newpass);
		
		
		//ServletContext sc = getServletContext();
		//Connection con = (Connection) sc.getAttribute("callconn");
		//JSRegistrationDAO j=new JSRegistrationDAOImpl(con);
		//boolean flag=j.getQA(ques, ans, em);
		JSPasswordChange o=new JSPasswordChange();
		int val=o.checkCredentialFP(em,ques,ans);
		System.out.println(val);
		
		if(val==1) {
		
		boolean bt=new JSPasswordChange().changePassword(em, encnew);
		boolean f=true;
		System.out.println(bt);
		if(bt==f) {
			request.getRequestDispatcher("JobSeekerLogin.jsp").include(request, response);
		} else {
			response.getWriter().println("Incorrect old password or question or answer..");
			request.getRequestDispatcher("JSForgotPass.jsp").include(request, response);
		}
		}else {
			response.getWriter().println("Incorrect old password or question or answer..");
			request.getRequestDispatcher("JSForgotPass.jsp").include(request, response);
		}
	}catch(Exception e) {}
	}
		
	}

