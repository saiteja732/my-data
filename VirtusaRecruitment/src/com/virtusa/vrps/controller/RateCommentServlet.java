package com.virtusa.vrps.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.virtusa.vrps.model.RateComment;




public class RateCommentServlet extends HttpServlet {
	static Logger logger = Logger.getLogger(RateCommentServlet.class);
	private static final long serialVersionUID = 1L;
       
   
    public RateCommentServlet() {
        super();

    }
 
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			response.setHeader("Pragma", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String cmt=request.getParameter("cmt");
		int rate=0;
		String jsid=request.getParameter("id");
		
		try {
			rate=Integer.parseInt(request.getParameter("star"));
		} catch (Exception e) {
			rate=0;
		}

		HttpSession hs = request.getSession();
		String s=(String)hs.getAttribute("empid");
		System.out.println(cmt);
		System.out.println("rating is this:"+rate);
		Boolean bt=new RateComment().insertRateComment(cmt, jsid, s, rate);
		boolean f=true;
		if(bt==f){
			pw.println("<script type=\"text/javascript\">");
			   pw.println("alert('your comment is registered');");
			   pw.println("</script>");
			
//			pw.println("your comment is registered");
//			pw.println(request.getParameter("id"));
//			pw.println(request.getParameter("cmt"));
			request.getRequestDispatcher("JobseekerInfo.jsp?info="+request.getParameter("id")).include(request, response);
	}
}catch (Exception e) {
	logger.error(e);
	
}

}
}