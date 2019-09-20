package com.virtusa.vrps.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.virtusa.vrps.dao.IdGenerator;
import com.virtusa.vrps.dao.JobPostDAO;
import com.virtusa.vrps.dao.JobPostDAOImpl;
import com.virtusa.vrps.model.JobListInfo;

public class JobPost extends HttpServlet {
	static Logger logger = Logger.getLogger(JobPost.class);
	private static final long serialVersionUID = 1L;

	public JobPost() {
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
		

		try {
			PrintWriter pw = response.getWriter();
			ServletContext sc = getServletContext();
			Connection con = (Connection) sc.getAttribute("callconn");
			IdGenerator obj = new IdGenerator(con);
			int id = obj.getIdJob();
			String jid = obj.getJobId();
			String title = request.getParameter("Title");
			String description = request.getParameter("Description");
			String eligibility = request.getParameter("Eligibility");
			String techReq = request.getParameter("TechReq");
			String location = request.getParameter("Location");
			float expRequired = Float.parseFloat(request.getParameter("ExpRequired"));
			float ctc =  Float.parseFloat(request.getParameter("Package"));
			Date expireDate = Date.valueOf(request.getParameter("ExpireDate"));
			String gap = request.getParameter("gap");

			JobPostDAO uid = new JobPostDAOImpl(con);
			JobListInfo ui = new JobListInfo(id, jid, title, description, eligibility, techReq, location, expRequired,
					ctc, expireDate, gap);
			boolean status = uid.insert(ui);
			boolean s=true;

			if (status == s) {

				pw.println("<script type=\"text/javascript\">");
				   pw.println("alert('Successfully Posted...');");
				   pw.println("</script>");
				RequestDispatcher rd = request.getRequestDispatcher("jobPost.jsp");
				rd.include(request, response);
			} else {
				pw.print("<center><font color=green size=7>Cannot Post Job</font></center>");

			}
		} catch (Exception e) {
			logger.error(e);
		}

	}

}
