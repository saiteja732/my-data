package com.virtusa.vrps.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

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

public class FinalSelect extends HttpServlet {
	static Logger logger = Logger.getLogger(FinalSelect.class);
	private static final long serialVersionUID = 1L;

	public FinalSelect() {
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

			try{response.sendRedirect("loginPage1.jsp");}catch(Exception e) {logger.error(e);}
		}
		response.setContentType("text/html");
		
		ServletContext sc = getServletContext();
		if (request.getParameterValues("selection") != null) {

			String []str= request.getParameterValues("selection");
			PreparedStatement ps=null;
			PreparedStatement ps1=null;
			PreparedStatement ps2=null;
			PreparedStatement ps3=null;
			PreparedStatement ps4=null;
			PreparedStatement ps5=null;
			
			Connection con = (Connection) sc.getAttribute("callconn");
				for (String s : str) {
					char ch = s.charAt(0);
					String str1 = s.substring(1);
					
					if (ch == 's') {
						
						String sql = "SELECT * FROM jobapplication WHERE jsid = ? ";
					   try { ps = con.prepareStatement(sql);
					    ps.setString(1, str1);
						ps.executeQuery();}catch(Exception e) {
							logger.error(e);
						}finally {
							try {
								if(ps!=null) {
								ps.close();
							} 
							}catch (Exception e) {
								logger.error(e);
						}
						}
						
						String sql1 = "update jobapplication set appstatus='selected' where jsid='" + str1 + "'";
						try{ps1 = con.prepareStatement(sql1);
						ps1.executeUpdate();}catch(Exception e) {
							logger.error(e);
						}finally {
							try {
								if(ps1!=null) {
								ps1.close();
							} 
							}catch (Exception e) {
								logger.error(e);
						}
						}
						
						String sql2 = "update jobapplication set hrstatus='done' where jsid='" + str1 + "'";
						try{ps2 = con.prepareStatement(sql2);
						ps2.executeUpdate();}catch(Exception e) {
							logger.error(e);
						}finally {
							try {
								if(ps2!=null) {
								ps2.close();
							} 
							}catch (Exception e) {
								logger.error(e);
						}
						}
						

					}
					if (ch == 'r') {
						
						String sql = "SELECT * FROM jobapplication WHERE jsid = ? ";
						try{ps3 = con.prepareStatement(sql);
						ps3.setString(1, str1);
						ps3.executeQuery();}catch(Exception e) {
							logger.error(e);
						}finally {
							try {
								if(ps3!=null) {
								ps3.close();
							} 
							}catch (Exception e) {
								logger.error(e);
						}
						}
						String sql1 = "update jobapplication set appstatus='rejected' where jsid='" + str1 + "'";
						try{ps4 = con.prepareStatement(sql1);
						ps4.executeUpdate();}catch(Exception e) {
							logger.error(e);
						}finally {
							try {
								if(ps4!=null) {
								ps4.close();
							} 
							}catch (Exception e) {
								logger.error(e);
						}
						}
						String sql2 = "update jobapplication set hrstatus='done' where jsid='" + str1 + "'";
					    try{ps5 = con.prepareStatement(sql2);
						ps5.executeUpdate();}catch(Exception e) {
							logger.error(e);
						}finally {
							try {
								if(ps5!=null) {
								ps5.close();
							} 
							}catch (Exception e) {
								logger.error(e);
						}
						}

					}

				}
				JobSeekerDAO jid = new JobSeekerDAOImpl2(con);
				List<JobApplicationInfo> jListInfo = jid.getSelectInfo();

				request.setAttribute("jListInfo", jListInfo);
				try{request.getRequestDispatcher("trselect.jsp").forward(request, response);}catch(Exception e) {
					logger.error(e);
				}


		} else {
			try {
				PrintWriter pw = response.getWriter();
			pw.print("<center><font color=red size=7>No Selection</font></center>");}catch(Exception e) {logger.error(e);}
			

		}
	}

}
