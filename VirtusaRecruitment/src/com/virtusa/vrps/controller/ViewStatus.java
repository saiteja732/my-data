package com.virtusa.vrps.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.virtusa.vrps.dao.JobApplicationDao;
import com.virtusa.vrps.dao.JobApplicationDaoImpl;


public class ViewStatus extends HttpServlet {
	static Logger logger = Logger.getLogger(ViewStatus.class);
	private static final long serialVersionUID = 1L;
       
    
    public ViewStatus() {
        super();

    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);

    	HttpSession hs = request.getSession();
    	String i=(String)hs.getAttribute("email");

		response.setContentType("text/html");
		
		
		String appid = request.getParameter("appid");
		hs.setAttribute("appids", appid);
		try {
			
			ServletContext sc = getServletContext();
			Connection con = (Connection) sc.getAttribute("callconn");
			JobApplicationDao jd = new JobApplicationDaoImpl(con);
			String jid=jd.getJSid(i);
			String status = jd.getStatus(appid,jid);

			request.getRequestDispatcher("statusView.jsp?st="+status).forward(request, response);
		} catch (Exception e) {
			logger.error(e);
		}
	}

	
	
}
