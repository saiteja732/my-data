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

import com.virtusa.vrps.dao.EmpDAO;
import com.virtusa.vrps.dao.EmpDAOImpl;

public class EmpValidate extends HttpServlet {
	static Logger logger = Logger.getLogger(EmpValidate.class);
	private static final long serialVersionUID = 1L;

	public EmpValidate() {
		super();

	}
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	 response.setIntHeader("Refresh", 3); 
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
		HttpSession hs = request.getSession();

		response.setContentType("text/html");
		
		String empid = request.getParameter("empid");
		String psw = request.getParameter("psw");

		try {
			PrintWriter pw = response.getWriter();
			ServletContext sc = getServletContext();
			Connection con = (Connection) sc.getAttribute("callconn");
			EmpDAO eid = new EmpDAOImpl(con);
			int status = eid.getById(empid, psw);
			String desig = eid.getDesig(empid);
			

			if (status == 1 && desig.equals("Technical")) {
				hs.setAttribute("empid", empid);
				hs.setAttribute("psw", psw);

				hs.setMaxInactiveInterval(86400);


				response.sendRedirect("Home.jsp");
			} else if (status == 1 && desig.equals("HR")) {
				hs.setAttribute("empid", empid);
				hs.setAttribute("psw", psw);

				hs.setMaxInactiveInterval(86400);

				response.sendRedirect("Home1.jsp");
			}

			else {

				 pw.println("<script type=\"text/javascript\">");
				   pw.println("alert('Employee ID or Passwrod is invalid.');");

				   pw.println("</script>");
				RequestDispatcher rd = request.getRequestDispatcher("loginPage1.jsp");
				rd.include(request, response);
			}

		} catch (Exception e) {
			logger.error(e);
		}

	}

}
