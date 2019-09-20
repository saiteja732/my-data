package com.virtusa.vrps.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.virtusa.vrps.dao.AppIdGenerator;
import com.virtusa.vrps.dao.JSRegistrationDAO;
import com.virtusa.vrps.dao.JSRegistrationDAOImpl;
import com.virtusa.vrps.dao.JobApplicationDao;
import com.virtusa.vrps.dao.JobApplicationDaoImpl;
import com.virtusa.vrps.model.JobApplicationInfo;



public class JobApplication extends HttpServlet {
	static Logger logger = Logger.getLogger(JobApplication.class);
	private static final long serialVersionUID = 1L;
       
    
    public JobApplication() {
        super();

    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		HttpSession hs = request.getSession();
		

		if (hs == null || hs.getAttribute("email") == null) {

			try{response.sendRedirect("JobSeekerLogin.jsp");}catch (Exception e) {
				logger.error(e);
			}
		}
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			String nid=null;
			String jobid=null;
			ServletContext sc = getServletContext();
			Connection con = (Connection) sc.getAttribute("callconn");
			String sid=(String)hs.getAttribute("email");
			ps=con.prepareStatement("Select JSid from jsregistration where jsemail=?");
			ps.setString(1,sid);
			rs=ps.executeQuery();
			if(rs.next()){
				
			 nid=rs.getString("jsid");
			 jobid=request.getParameter("Jid");
			}
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		JSRegistrationDAO j=new JSRegistrationDAOImpl(con);
		String e=j.getOneParam(sid);
		if((e==null) ) {
			

			 pw.println("<script type=\"text/javascript\">");
			   pw.println("alert('Complete your Profile to Apply.');");
			   pw.println("</script>");
			RequestDispatcher rd = request.getRequestDispatcher("JSEditProfile.jsp");
			rd.include(request, response);
		}
		if(!(e.equals("")) ){
		
		AppIdGenerator obj=new AppIdGenerator(con);
		int id=obj.getIdApp();
		String applicationId=obj.getAppId();
		
		JobApplicationDao jd=new JobApplicationDaoImpl(con);
		JobApplicationInfo jdi=new JobApplicationInfo(id, applicationId, jobid, nid); 
		
		boolean status = jd.insert(jdi);

		boolean s=true;

		if (status == s) {
			pw.print("<center><font color=green size=7>Your application id is "+applicationId +"</font></center>");
			pw.println("<script type=\"text/javascript\">");
			   pw.println("alert('Successfully Applied...');");
			   pw.println("</script>");
			   
			RequestDispatcher rd = request.getRequestDispatcher("JSHome.jsp");
			rd.include(request, response);
			
		} else {

			pw.println("<script type=\"text/javascript\">");
			   pw.println("alert('You Can Apply for one job at a time');");
			   pw.println("</script>");
			RequestDispatcher rd = request.getRequestDispatcher("JSHome.jsp");
			rd.include(request, response);

		}}
		
	} catch (Exception e) {
		logger.error(e);
		
	}finally {
		try {
			if(ps!=null) {
			ps.close();
		} 
		}catch (SQLException e) {
			logger.error(e);
	}try {
		if(rs!=null) {
			rs.close();
		}
	}catch (SQLException e) {
		logger.error(e);
	}
}
		

}
		
		
	}
	


