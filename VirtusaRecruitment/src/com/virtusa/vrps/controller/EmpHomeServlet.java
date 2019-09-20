package com.virtusa.vrps.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.virtusa.vrps.dao.EmpDAO;
import com.virtusa.vrps.dao.EmpDAOImpl;
import com.virtusa.vrps.dao.JobseekerList;
import com.virtusa.vrps.model.JobSeeker;


public class EmpHomeServlet extends HttpServlet {
	static Logger logger = Logger.getLogger(EmpHomeServlet.class);
	private static final long serialVersionUID = 1L;
       
    
    public EmpHomeServlet() {
        super();

    }

	
	


	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		try {
		PrintWriter pw=response.getWriter();
		HttpSession hs = request.getSession();
		String loc=request.getParameter("loc");
		String qual=request.getParameter("qual");
		String exp=request.getParameter("exp");
		int flag=0;
		ServletContext sc = getServletContext();
		Connection con = (Connection) sc.getAttribute("callconn");
		String empid=(String) hs.getAttribute("empid");
		EmpDAO eid = new EmpDAOImpl(con);
		String desig = eid.getDesig(empid);
		System.out.println(desig);
		
		
		if(loc.equals("") && qual.equals("") && exp.equals("")) {

			 pw.println("<script type=\"text/javascript\">");
			   pw.println("alert('Fields should not be empty.');");

			   pw.println("</script>");
			if(desig.equals("HR"))request.getRequestDispatcher("Home1.jsp").include(request, response);
			if(desig.equals("Technical"))request.getRequestDispatcher("Home.jsp").include(request, response);
		} else if((!loc.equals("")) && qual.equals("") && exp.equals("")){
			flag=1;
			
		}else if(loc.equals("") && qual!=null && exp.equals("")) {
			flag=1;
		} else if(loc.equals("") && qual.equals("") && exp!=null) {
			flag=1;
		}  else if(loc!=null && qual!=null && exp.equals("")) {
			List<JobSeeker> jsl=new JobseekerList().jsFiterDataLQ(loc,qual);
			request.setAttribute("listAttr", jsl);
			request.getRequestDispatcher("FilterInfo.jsp?d="+desig).forward(request, response);
		} else if(loc!=null && qual.equals("") && exp!=null) {
			List<JobSeeker> jsl=new JobseekerList().jsFiterDataLE(loc,exp);
			request.setAttribute("listAttr", jsl);
			request.getRequestDispatcher("FilterInfo.jsp?d="+desig).forward(request, response);
		} else if(loc.equals("") && qual!=null && exp!=null) {
			List<JobSeeker> jsl=new JobseekerList().jsFiterDataQE(qual,exp);
			request.setAttribute("listAttr", jsl);
			request.getRequestDispatcher("FilterInfo.jsp?d="+desig).forward(request, response);
		}else if(loc!=null && qual!=null && exp!=null) {
			List<JobSeeker> jsl=new JobseekerList().jsFiterDataLQE(loc,qual,exp);
			request.setAttribute("listAttr", jsl);
			request.getRequestDispatcher("FilterInfo.jsp?d="+desig).forward(request, response);
		}
		else {
			pw.println("<br/>**** You should enter two feild ***");
		}
		
		if(flag==1) {
			List<JobSeeker> jsl=new JobseekerList().jsFiterDataSL(loc,qual,exp);
			request.setAttribute("listAttr", jsl);
			request.getRequestDispatcher("FilterInfo.jsp?d="+desig).forward(request, response);
		}
		}catch(Exception e) {logger.error(e);}
	
	}

}
