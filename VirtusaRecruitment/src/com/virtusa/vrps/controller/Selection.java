package com.virtusa.vrps.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class Selection extends HttpServlet {
	static Logger logger = Logger.getLogger(Selection.class);
	private static final long serialVersionUID = 1L;

	public Selection() {
		super();

	}
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
		
		ServletContext sc = getServletContext();
		if (request.getParameterValues("selection") != null) {

			String []str = request.getParameterValues("selection");
			try {
				PrintWriter pw=response.getWriter();
				
				Connection con = (Connection) sc.getAttribute("callconn");
				for (String s : str) {
					char ch = s.charAt(0);
					String str1 = s.substring(1);
					
					if (ch == 's') {
						
						String sql = "SELECT * FROM jobapplication WHERE jsid = ? ";
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setString(1, str1);
						ps.executeQuery();
						String sql1 = "update jobapplication set appstatus='tr' where jsid='" + str1 + "'";
						PreparedStatement ps1 = con.prepareStatement(sql1);
						ps1.executeUpdate();

					}
					if (ch == 'r') {
						
						String sql = "SELECT * FROM jobapplication WHERE jsid = ? ";
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setString(1, str1);
						ps.executeQuery();
						String sql1 = "update jobapplication set appstatus='rejected' where jsid='" + str1 + "'";
						PreparedStatement ps1 = con.prepareStatement(sql1);
						ps1.executeUpdate();

					}

				}
				 pw.println("<script type=\"text/javascript\">");
				   pw.println("alert('Thanks For Selection');");

				   pw.println("</script>");
				   response.sendRedirect("Required");

			}

			catch (Exception e) {
				logger.error(e);

			}
		} else {
			try {
				PrintWriter pw=response.getWriter();
				pw.println("hello");

		
			}catch (Exception e) {
				logger.error(e);
			}

		}
	}
}
