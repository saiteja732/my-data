package com.virtusa.vrps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class JSDAOImpl implements JSDAO {
	static Logger logger = Logger.getLogger(JSDAOImpl.class);
	
	Connection con;
	PreparedStatement ps=null;
	ResultSet rs=null;

	public JSDAOImpl(Connection con) {

		this.con = con;
	}

	@Override
	public String getJSid(String jsemail) {
		String st;
		try {
			 ps = con.prepareStatement("select JSid from jsregistration where jsemail=?");
			ps.setString(1, jsemail);
			 rs = ps.executeQuery();
			if (rs.next()) {
				st=rs.getString(1);
				return st;
			} else {
				
				return "not found";
			}
		} catch (Exception e) {

			logger.error(e);
			return e.getMessage();
		}
		finally {
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


