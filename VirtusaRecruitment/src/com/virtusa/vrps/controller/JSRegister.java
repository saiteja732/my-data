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

import org.apache.log4j.Logger;

import com.virtusa.vrps.dao.IdGenerator;
import com.virtusa.vrps.dao.JSRegistrationDAO;
import com.virtusa.vrps.dao.JSRegistrationDAOImpl;
import com.virtusa.vrps.dao.Password;
import com.virtusa.vrps.model.JobSeeker;



public class JSRegister extends HttpServlet {
	static Logger logger = Logger.getLogger(JSRegister.class);
	private static final long serialVersionUID = 1L;

	public JSRegister() {
		super();

	}
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		


		response.setContentType("text/html");
		
		String email = request.getParameter("email");
		String pwd = request.getParameter("psw");
		String fstname=request.getParameter("firstname");
		String lstname=request.getParameter("lastname");
		String phonenumber=request.getParameter("phone");
		String securityanswer=request.getParameter("ans");
		String questions=request.getParameter("ques");
		
		

		try {
			PrintWriter pw = response.getWriter();

			ServletContext sc = getServletContext();
			Connection con = (Connection) sc.getAttribute("callconn");
			JSRegistrationDAO uid = new JSRegistrationDAOImpl(con);
			IdGenerator obj=new IdGenerator(con);
			int id=obj.getIdJS();
			String jsid=obj.getJSId();
			Password p=new Password();
			String pass=p.encrypt(pwd);
			
			JobSeeker ui = new JobSeeker(id,jsid,fstname,lstname,email,pass,phonenumber,questions,securityanswer);
			boolean status1 = uid.insert(ui);
			boolean s=true;

			if (status1 == s) {
				 
				pw.println("<script type=\"text/javascript\">");
				   pw.println("alert('Successfully Registered...');");
				   pw.println("</script>");
				RequestDispatcher rd = request.getRequestDispatcher("JobSeekerLogin.jsp");
				rd.include(request, response);
			} else {
				pw.print("<center><font color=green size=7>UserName already Registered...</font></center>");
				RequestDispatcher rd = request.getRequestDispatcher("JobListDisplay.jsp");
				rd.include(request, response);
			}
		} catch (Exception e) {
			logger.error(e);
		}

	}

}
