package com.virtusa.vrps.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class EmpLogout extends HttpServlet {
	static Logger logger = Logger.getLogger(EmpLogout.class);
	private static final long serialVersionUID = 1L;

	public EmpLogout() {
		super();

	}
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	try {
		HttpSession hs = request.getSession();

		response.setContentType("text/html");


		hs.removeAttribute("empid");
		hs.invalidate();

		response.sendRedirect("index.jsp");
	}catch(Exception e) {logger.error(e);}
	}

}
