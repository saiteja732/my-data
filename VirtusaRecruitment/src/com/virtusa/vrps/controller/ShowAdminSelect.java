package com.virtusa.vrps.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.virtusa.vrps.dao.JobSeekerDAO;
import com.virtusa.vrps.dao.JobSeekerDAOImpl2;
import com.virtusa.vrps.model.JobApplicationInfo;

public class ShowAdminSelect extends HttpServlet {
	static Logger logger = Logger.getLogger(ShowAdminSelect.class);
	private static final long serialVersionUID = 1L;

	public ShowAdminSelect() {
		super();

	}
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
		HttpSession hs = request.getSession();

		if (hs == null || hs.getAttribute("empid") == null) {

			try{response.sendRedirect("loginPage1.jsp");}catch (Exception e) {
				logger.error(e);
			}
		}

		response.setContentType("text/html");
		

		try {
			
			ServletContext sc = getServletContext();
			Connection con = (Connection) sc.getAttribute("callconn");
			JobSeekerDAO jid = new JobSeekerDAOImpl2(con);
			List<JobApplicationInfo> jListInfo = jid.getSelectInfo();
			request.setAttribute("jListInfo", jListInfo);

			request.getRequestDispatcher("select.jsp").forward(request, response);


		} catch (Exception e) {
			logger.error(e);
		}

	}
}