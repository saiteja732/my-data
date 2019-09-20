package com.virtusa.vrps.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class Logout extends HttpServlet {
	static Logger logger = Logger.getLogger(Logout.class);
	private static final long serialVersionUID = 1L;

	public Logout() {
		super();

	}
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
		HttpSession hs = request.getSession();

		response.setContentType("text/html");

		try{request.getRequestDispatcher("process.jsp").include(request, response);}catch (Exception e) {
			logger.error(e);
		}

		hs.removeAttribute("email");
		hs.invalidate();

		try{response.sendRedirect("loginPage.jsp");}catch (Exception e) {
			logger.error(e);
		}
	}

}
