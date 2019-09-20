package com.virtusa.vrps.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class AppIdGenerator {
	static Logger logger = Logger.getLogger(AppIdGenerator.class);
	Connection con = null;
	Statement st=null;
	ResultSet rs=null;

	public  AppIdGenerator(Connection con) {

		this.con = con;
	}
	public int getIdApp() {
		
		int id=0;
		try {
			st=con.createStatement();
		    rs=st.executeQuery("select max(id) As apid from jobapplication");
			if(rs.next()) {
				if(rs.getInt("apid")==0) {
					return 1;
				} else {
					id=rs.getInt("apid");
					return id+1;
				}
				
			} 
		} catch (SQLException e) {

			logger.error(e);
		}
		finally {
			try {
				if(st!=null) {
				st.close();
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
		return 0;
	}
	
	public String getAppId() { 
		
		
		int id=0;
		try {
			st=con.createStatement();
			 rs=st.executeQuery("select max(id) As apid from jobapplication");
			if(rs.next()) {
				if(rs.getInt("apid")==0) {
					return "APP-1";
				} else {
					
					id=rs.getInt("apid")+1;
					return "APP-"+id;
				}
				
			} 
		} catch (SQLException e) {
			logger.error(e);
		}
		finally {
			try {
				if(st!=null) {
				st.close();
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
		return null;
	}

}
