package com.virtusa.vrps.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
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

import com.virtusa.vrps.dao.EditProfileDAO;
import com.virtusa.vrps.dao.EditProfileDAOImpl;
import com.virtusa.vrps.model.EditProfileInfo;


public class EditProfileServlet extends HttpServlet {
	static Logger logger = Logger.getLogger(EditProfileServlet.class);
	private static final long serialVersionUID = 1L;
       
    
    public EditProfileServlet() {
        super();
    }

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		HttpSession hs = request.getSession();
		
		

		if (hs == null || hs.getAttribute("email") == null) {

			try{response.sendRedirect("JobSeekerLogin.jsp");}catch(Exception e) {
				logger.error(e);
			}
		}
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			String nid = null;
			ServletContext sc = getServletContext();
			Connection con = (Connection) sc.getAttribute("callconn");
			String sid=(String)hs.getAttribute("email");
			String cmd="Select Jsid from jsregistration where jsemail=?";
			ps=con.prepareStatement(cmd);
			ps.setString(1,sid);
			rs=ps.executeQuery();
			if(rs.next()){
				
			 nid=rs.getString("jsid");
			 
			}
			
		
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			Date dob = Date.valueOf(request.getParameter("dob"));
			String gender=request.getParameter("gender");
			String add=request.getParameter("address");
			String city=request.getParameter("city");
			String state=request.getParameter("state");
			String country=request.getParameter("country");
			int pincode=Integer.parseInt(request.getParameter("pincode"));
			String stream=request.getParameter("stream");
			String degree=request.getParameter("degree");
			double cgpa=Double.parseDouble(request.getParameter("cgpa"));
			String inst=request.getParameter("institute");
			String university=request.getParameter("university");
			Date pass= Date.valueOf(request.getParameter("passout"));
			String gap=request.getParameter("gap");
			String hb=request.getParameter("hboard");
			double hp=Double.parseDouble(request.getParameter("hpercentage"));
			String sb=request.getParameter("sboard");
			double sp=Double.parseDouble(request.getParameter("spercentage"));
			double ey=Double.parseDouble(request.getParameter("experience"));
			String comp=request.getParameter("company");
			String loc=request.getParameter("work");

			EditProfileDAO ed=new EditProfileDAOImpl(con);
			EditProfileInfo edi=new EditProfileInfo(dob, gender, add, city, state, country, pincode, stream, degree, cgpa, inst, university, pass, gap, hb, hp, sb, sp, ey, comp, loc);


			boolean status = ed.updateProfile(edi,nid);
			boolean s=true;

			if (status == s) {
				pw.print("<center><font color=green size=7>Successfully Updated...</font></center>");
				RequestDispatcher rd = request.getRequestDispatcher("JSHome.jsp");
				rd.include(request, response);
			} else {
				pw.print("<center><font color=green size=7>Cannot Update..</font></center>");
			}
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
