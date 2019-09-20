package com.virtusa.vrps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.virtusa.vrps.model.JobSeeker;

public class JSRegistrationDAOImpl implements JSRegistrationDAO{
	static Logger logger = Logger.getLogger(JSRegistrationDAOImpl.class);

	Connection con;
	PreparedStatement ps=null;
	ResultSet rs=null;

	public JSRegistrationDAOImpl(Connection con) {

		this.con = con;
	}
	
	@Override
	public boolean insert(JobSeeker jsinfo) {
		boolean status = false;
		try {
			 ps = con.prepareStatement("insert into jsregistration(id,jsid,jsfirstname,jslastname,jsemail,jspassword,jsphoneno,question,answer) values(?,?,?,?,?,?,?,?,?)");
			IdGenerator obj=new IdGenerator(con);
			ps.setInt(1,obj.getIdJS());
			ps.setString(2, obj.getJSId());
			ps.setString(3, jsinfo.getFisrtName());
			ps.setString(4, jsinfo.getLastName());
			ps.setString(5,jsinfo.getEmail());
			ps.setString(6,jsinfo.getPassword());
			ps.setString(7, jsinfo.getPhone());
			ps.setString(8, jsinfo.getQuestion());
			ps.setString(9, jsinfo.getAnswer());
			ps.execute();

			
			status = true;
		} catch (Exception e) {

			logger.error(e);
			
		}finally {
			try {
				if(ps!=null) {
				ps.close();
			} 
			}catch (SQLException e) {
				logger.error(e);
		}
	}

		return status;
	}

	@Override
	public String getOneParam(String email) {
		String st;
		try {
			ps = con.prepareStatement("select degree from jsregistration where jsemail=?");
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				st = rs.getString(1);
				return st;
			} else {
				return "not found";
			}
		} catch (Exception e) {

			logger.error(e);
			return e.getMessage();
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

	@Override
	public boolean getPassword(String pass, String email) {
		boolean st=false;
		try {
			ps = con.prepareStatement("select count(*) from jsregistration where jspassword=? and jsemail=?");
			ps.setString(1, pass);
			ps.setString(2, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				st = true;
				return st;
			} else {
				return false;
			}
		} catch (Exception e) {

			logger.error(e);
			
			return false;
			
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

	@Override
	public boolean getQA(String ques, String ans, String email) {
		boolean st=false;
		try {
			ps = con.prepareStatement("select count(*) from jsregistration where question=? and answer=? and jsemail=?");
			ps.setString(1, ques);
			ps.setString(2, ans);
			ps.setString(3, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				st = true;
				return st;
			} else {
				return false;
			}
		} catch (Exception e) {

			logger.error(e);
			
			return false;
			
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
