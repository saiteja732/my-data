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

public class Validate extends HttpServlet {
	static Logger logger = Logger.getLogger(Validate.class);
	private static final long serialVersionUID = 1L;

	public Validate() {
		super();

	}
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
		HttpSession hs = request.getSession();

		response.setContentType("text/html");
		
		String email = request.getParameter("email");
		String psw = request.getParameter("psw");

		try {
			PrintWriter pw = response.getWriter();
			ServletContext sc = getServletContext();
			Connection con = (Connection) sc.getAttribute("callconn");
			UserDAO uid = new UserDAOImpl1(con);
			int status = uid.getById(email, psw);

			if (status == 1) {
				hs.setAttribute("email", email);
				hs.setAttribute("psw", psw);

				hs.setMaxInactiveInterval(86400);
				RequestDispatcher rd = request.getRequestDispatcher("welcomeUser.jsp");
				rd.forward(request, response);
			} else {
				pw.print("<center><font color=red size=7>Wrong Email or Password</font></center>");
				RequestDispatcher rd = request.getRequestDispatcher("loginPage.jsp");
				rd.include(request, response);
			}

		} catch (Exception e) {
			logger.error(e);
		}

	}

}
