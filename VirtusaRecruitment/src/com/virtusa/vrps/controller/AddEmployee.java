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
import com.virtusa.vrps.model.EmployeeInfo;

public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(AddEmployee.class);

	public AddEmployee() {
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

			try {
				response.sendRedirect("loginPage.jsp");
			} catch (Exception e) {
				logger.error(e);
			}
		}
		response.setContentType("text/html");

		String empid = request.getParameter("empid");
		String empFirstName = request.getParameter("empFirstName");
		String empLastName = request.getParameter("empLastName");
		String empEmail = request.getParameter("empEmail");
		String empPhone = request.getParameter("empPhone");
		String empPassword = request.getParameter("empPassword");
		String empDesignation = request.getParameter("empDesignation");
		String empDepartment = request.getParameter("empDepartment");
		String empStatus = request.getParameter("empStatus");
		String empRole = request.getParameter("empRole");

		try {
			PrintWriter pw = response.getWriter();

			ServletContext sc = getServletContext();
			Connection con = (Connection) sc.getAttribute("callconn");
			EmpDAO uid = new EmpDAOImpl(con);
			EmployeeInfo ui = new EmployeeInfo(empid, empFirstName, empLastName, empEmail, empPhone, empPassword,
					empDesignation, empDepartment, empStatus, empRole);
			boolean status = uid.insert(ui);
			boolean s = true;

			if (status == s) {


				pw.println("<script type=\"text/javascript\">");
				   pw.println("alert('Successfully Added...');");
				   pw.println("</script>");
				RequestDispatcher rd = request.getRequestDispatcher("addEmployee.jsp");
				rd.include(request, response);
			}

			else {

				pw.println("<script type=\"text/javascript\">");
				   pw.println("alert('Employee Id or Email already exists...');");
				   pw.println("</script>");
				RequestDispatcher rd = request.getRequestDispatcher("addEmployee.jsp");
				rd.include(request, response);
			}

		} catch (Exception e) {
			logger.error(e);
		}

	}
}
