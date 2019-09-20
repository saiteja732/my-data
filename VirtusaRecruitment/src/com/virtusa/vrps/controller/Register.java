package com.virtusa.vrps.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.virtusa.vrps.dao.UserDAO;
import com.virtusa.vrps.dao.UserDAOImpl1;
import com.virtusa.vrps.model.UserInfo;

public class Register extends HttpServlet {
	static Logger logger = Logger.getLogger(Register.class);
	private static final long serialVersionUID = 1L;

	public Register() {
		super();

	}
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
		HttpSession hs = request.getSession();

		if (hs == null || hs.getAttribute("email") == null) {

			try{response.sendRedirect("loginPage.jsp");}catch (Exception e) {
				logger.error(e);
			}
		}
		response.setContentType("text/html");
		
		String email = request.getParameter("email");
		String psw = request.getParameter("psw");

		try {
			PrintWriter pw = response.getWriter();
			ServletContext sc = getServletContext();
			Connection con = (Connection) sc.getAttribute("callconn");
			UserDAO uid = new UserDAOImpl1(con);
			UserInfo ui = new UserInfo(email, psw);
			boolean status = uid.insert(ui);
			boolean s=true;

			if (status == s) {
				pw.print("<center><font color=green size=7>Successfully Registered...</font></center>");
				RequestDispatcher rd = request.getRequestDispatcher("loginPage.jsp");
				rd.include(request, response);
			} else {
				pw.print("<center><font color=green size=7>UserName already Registered...</font></center>");
				
			}
		} catch (Exception e) {
			logger.error(e);
		}

	}

}
