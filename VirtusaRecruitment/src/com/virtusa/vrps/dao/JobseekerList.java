package com.virtusa.vrps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.virtusa.vrps.model.JobSeeker;


public class JobseekerList {
	static Logger logger = Logger.getLogger(JobseekerList.class);

	Connection con=DaoConnection.getConnection();
	List<JobSeeker> as=new ArrayList<>();
	Statement st;
	PreparedStatement ps;
	PreparedStatement pst;
	PreparedStatement pst1;
	DecimalFormat df = new DecimalFormat();
	int sum;
	int count;
	
	
	
	public List<JobSeeker> getJSList(){
		JobSeeker js;
		ResultSet rs;
		ResultSet rd;
			try {
				st=con.createStatement();
				rs=st.executeQuery("select * from JSRegistration");
				while(rs.next()) {
					js=new JobSeeker();
					js.setJsid(rs.getString("JSId"));
					
					ps=con.prepareStatement("select count(*) As ct from ratecomment where jsid=? AND commentdes IS NOT NULL");
					ps.setString(1, rs.getString("JSId"));
					rd=ps.executeQuery();
					if(rd.next()) {
						js.setCommentNo(rd.getInt("ct"));
					}
					ps=con.prepareStatement("select count(*) As ct,Sum(rating) As st from ratecomment where jsid=?");
					ps.setString(1, rs.getString("JSId"));
					rd=ps.executeQuery();
					if(rd.next()) {
						sum=rd.getInt("st");
						
						count=rd.getInt("ct");
						
					}
					
					js.setRateAVG(new ValidateItem().rateCalculation(sum,count));
					

					js.setFisrtName(rs.getString("JSFIRSTNAME"));
					js.setLastName(rs.getString("JSLASTNAME"));
					js.setEmail(rs.getString("JSEMAIL"));
					js.setPhone(rs.getString("JSPHONENO"));
					as.add(js);
					
				}
			} catch (SQLException e) {
				logger.error(e);
			}
			
			return as;
	}

	public List<JobSeeker> jsFiterDataSL(String...s){

		String loc=s[0];
		String qual=s[1];
		String exp=s[2];
		int c;
		
		if(loc.isEmpty())
		{
			loc=null;
		}
		if(qual.isEmpty()) {
			qual=null;
		}
		if(exp.isEmpty())
		{
			c=-1;
			
		}else {
			c=Integer.parseInt(exp);
		}
	
		JobSeeker js;
		try {
			pst1=con.prepareStatement("select * from JSRegistration where STATE=? OR DEGREE=? OR ExpYear=?");
			pst1.setString(1, loc);
			pst1.setString(2, qual);
			pst1.setInt(3, c);
			ResultSet rs=pst1.executeQuery();
			while(rs.next()) {
				js=new JobSeeker();
				js.setJsid(rs.getString("JSId"));
				ps=con.prepareStatement("select count(*) As ct from ratecomment where jsid=? AND commentdes IS NOT NULL");
				ps.setString(1, rs.getString("JSId"));
				ResultSet rd=ps.executeQuery();
				if(rd.next()) {
					js.setCommentNo(rd.getInt("ct"));
				}
				ps=con.prepareStatement("select count(*) As ct,Sum(rating) As st from ratecomment where jsid=?");
				ps.setString(1, rs.getString("JSId"));
				rd=ps.executeQuery();
				if(rd.next()) {
					sum=rd.getInt("st");
					
					count=rd.getInt("ct");
					
				}
				js.setRateAVG(new ValidateItem().rateCalculation(sum,count));
				js.setFisrtName(rs.getString("JSFIRSTNAME"));
				js.setLastName(rs.getString("JSLASTNAME"));
				js.setEmail(rs.getString("JSEMAIL"));
				js.setPhone(rs.getString("JSPHONENO"));
				as.add(js);
				
			}
		} catch (SQLException e) {
			logger.error(e);
		}
		
		return as;
	}

	public List<JobSeeker> jsFiterDataLQ(String...s){

		 String loc=s[0];
		 String qual=s[1];
		 JobSeeker js;
			try {
				pst1=con.prepareStatement("select * from JSRegistration where STATE=? AND DEGREE=?");
				pst1.setString(1, loc);
				pst1.setString(2, qual);

				ResultSet rs=pst1.executeQuery();
				while(rs.next()) {
					js=new JobSeeker();
					js.setJsid(rs.getString("JSId"));
					ps=con.prepareStatement("select count(*) As ct from ratecomment where jsid=? AND commentdes IS NOT NULL");
					ps.setString(1, rs.getString("JSId"));
					ResultSet rd=ps.executeQuery();
					if(rd.next()) {
						js.setCommentNo(rd.getInt("ct"));
					}
					ps=con.prepareStatement("select count(*) As ct,Sum(rating) As st from ratecomment where jsid=?");
					ps.setString(1, rs.getString("JSId"));
					rd=ps.executeQuery();
					if(rd.next()) {
						sum=rd.getInt("st");
						
						count=rd.getInt("ct");
						
					}
					js.setRateAVG(new ValidateItem().rateCalculation(sum,count));
					js.setFisrtName(rs.getString("JSFIRSTNAME"));
					js.setLastName(rs.getString("JSLASTNAME"));
					js.setEmail(rs.getString("JSEMAIL"));
					js.setPhone(rs.getString("JSPHONENO"));
					as.add(js);
					
				}
			} catch (SQLException e) {
				logger.error(e);
			}
			
			return as;
	}

	public List<JobSeeker> jsFiterDataLE(String...s) {
		String loc=s[0];
		String exp=s[1];
		 JobSeeker js;
			try {
				pst1=con.prepareStatement("select * from JSRegistration where STATE=? AND ExpYear=?");
				pst1.setString(1, loc);
				pst1.setString(2, exp);

				ResultSet rs=pst1.executeQuery();
				while(rs.next()) {
					js=new JobSeeker();
					js.setJsid(rs.getString("JSId"));
					ps=con.prepareStatement("select count(*) As ct from ratecomment where jsid=? AND commentdes IS NOT NULL");
					ps.setString(1, rs.getString("JSId"));
					ResultSet rd=ps.executeQuery();
					if(rd.next()) {
						js.setCommentNo(rd.getInt("ct"));
					}
					ps=con.prepareStatement("select count(*) As ct,Sum(rating) As st from ratecomment where jsid=?");
					ps.setString(1, rs.getString("JSId"));
					rd=ps.executeQuery();
					if(rd.next()) {
						sum=rd.getInt("st");
						
						count=rd.getInt("ct");
						
					}
					js.setRateAVG(new ValidateItem().rateCalculation(sum,count));
					js.setFisrtName(rs.getString("JSFIRSTNAME"));
					js.setLastName(rs.getString("JSLASTNAME"));
					js.setEmail(rs.getString("JSEMAIL"));
					js.setPhone(rs.getString("JSPHONENO"));
					as.add(js);
					
				}
			} catch (SQLException e) {
				logger.error(e);
			}
			
			return as;
	}
	
	public List<JobSeeker> jsFiterDataQE(String...s){
		String qual=s[0];
		String exp=s[1];
		int c;
		if(exp.isEmpty())
		{
			c=-1;
			
		}else {
			c=Integer.parseInt(exp);
		}
		
		JobSeeker js;
		try {
			pst1=con.prepareStatement("select * from JSRegistration where  DEGREE=? AND ExpYear=?");
			pst1.setString(1, qual);
			pst1.setInt(2, c);
			ResultSet rs=pst1.executeQuery();
			while(rs.next()) {
				js=new JobSeeker();
				js.setJsid(rs.getString("JSId"));
				ps=con.prepareStatement("select count(*) As ct from ratecomment where jsid=? AND commentdes IS NOT NULL");
				ps.setString(1, rs.getString("JSId"));
				ResultSet rd=ps.executeQuery();
				if(rd.next()) {
					js.setCommentNo(rd.getInt("ct"));
				}
				ps=con.prepareStatement("select count(*) As ct,Sum(rating) As st from ratecomment where jsid=?");
				ps.setString(1, rs.getString("JSId"));
				rd=ps.executeQuery();
				if(rd.next()) {
					sum=rd.getInt("st");
					
					count=rd.getInt("ct");
					
				}
				js.setRateAVG(new ValidateItem().rateCalculation(sum,count));
				js.setFisrtName(rs.getString("JSFIRSTNAME"));
				js.setLastName(rs.getString("JSLASTNAME"));
				js.setEmail(rs.getString("JSEMAIL"));
				js.setPhone(rs.getString("JSPHONENO"));
				as.add(js);
				
			}
		} catch (SQLException e) {
			logger.error(e);
		}
		
		return as;
		
	}
	
	public List<JobSeeker> jsFiterDataLQE(String...s){
		String loc=s[0];
		String qual=s[1];
		String exp=s[2];
		int c;
		if(exp.isEmpty())
		{
			c=-1;
			
		}else {
			c=Integer.parseInt(exp);
		}
		
		JobSeeker js;
		try {
			pst1=con.prepareStatement("select * from JSRegistration where STATE=? AND DEGREE=? AND ExpYear=?");
			pst1.setString(1, loc);
			pst1.setString(2, qual);
			pst1.setInt(3, c);
			ResultSet rs=pst1.executeQuery();
			while(rs.next()) {
				js=new JobSeeker();
				js.setJsid(rs.getString("JSId"));
				ps=con.prepareStatement("select count(*) As ct from ratecomment where jsid=? AND commentdes IS NOT NULL");
				ps.setString(1, rs.getString("JSId"));
				ResultSet rd=ps.executeQuery();
				if(rd.next()) {
					js.setCommentNo(rd.getInt("ct"));
				}
				ps=con.prepareStatement("select count(*) As ct,Sum(rating) As st from ratecomment where jsid=?");
				ps.setString(1, rs.getString("JSId"));
				rd=ps.executeQuery();
				if(rd.next()) {
					sum=rd.getInt("st");
					
					count=rd.getInt("ct");
					
				}
				js.setRateAVG(new ValidateItem().rateCalculation(sum,count));
				js.setFisrtName(rs.getString("JSFIRSTNAME"));
				js.setLastName(rs.getString("JSLASTNAME"));
				js.setEmail(rs.getString("JSEMAIL"));
				js.setPhone(rs.getString("JSPHONENO"));
				as.add(js);
				
			}
		} catch (SQLException e) {
			logger.error(e);
		}
		return as;
	}

	
}
