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

import com.virtusa.vrps.dao.Password;
import com.virtusa.vrps.dao.UserDAO;
import com.virtusa.vrps.dao.UserDAOImpl1;


public class JSValidate extends HttpServlet {
	static Logger logger = Logger.getLogger(JSValidate.class);
	private static final long serialVersionUID = 1L;

	public JSValidate() {
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
			Password p=new Password();
			String pass=p.encrypt(psw);
			UserDAO uid = new UserDAOImpl1(con);
			int status = uid.getById(email, pass);

			System.out.println("status from login:"+status);
			if (status == 1) {
				
				
				hs.setAttribute("email", email);
				hs.setAttribute("psw", pass);

				hs.setMaxInactiveInterval(86400);

				response.sendRedirect("JSHome.jsp");
			} else {
				pw.println("<script type=\"text/javascript\">");
				   pw.println("alert('Email or Passwrod is invalid.');");

				   pw.println("</script>");
				RequestDispatcher rd = request.getRequestDispatcher("JobSeekerLogin.jsp");
				rd.include(request, response);
			}

		} catch (Exception e) {
			logger.error(e);
		}

	}

}
