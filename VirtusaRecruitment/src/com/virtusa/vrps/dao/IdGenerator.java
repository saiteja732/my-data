package com.virtusa.vrps.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class IdGenerator {
	static Logger logger = Logger.getLogger(IdGenerator.class);
	Connection con = null;
	Statement st=null;
	ResultSet rs=null;

	public IdGenerator(Connection con) {

		this.con = con;
	}

	public int getIdJob() {

		
		int id = 0;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select max(id) As jid from joblist");
			if (rs.next()) {
				if (rs.getInt("jid") == 0) {
					return 1;
				} else {
					id = rs.getInt("jid");
					return id + 1;
				}

			}
		} catch (SQLException e) {

			logger.error(e);
		}finally {
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

	public String getJobId() {
		
		int id = 0;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select max(id) As jid from joblist");
			if (rs.next()) {
				if (rs.getInt("jid") == 0) {
					return "JOB-1";
				} else {
					
					id = rs.getInt("jid") + 1;
					return "JOB-" + id;
				}

			}
		} catch (SQLException e) {
			
			logger.error(e);
		}finally {
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
	public int getIdJS() {
		
		
		int id=0;
		try {
			st=con.createStatement();
			rs=st.executeQuery("select max(id) As jid from jsregistration");
			if(rs.next()) {
				if(rs.getInt("jid")==0) {
					return 1;
				} else {
					id=rs.getInt("jid");
					return id+1;
				}
				
			} 
		} catch (SQLException e) {

			logger.error(e);
		}finally {
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
	
	public String getJSId() { 
		
		
		int id=0;
		try {
			st=con.createStatement();
			rs=st.executeQuery("select max(id) As jid from jsregistration");
			if(rs.next()) {
				if(rs.getInt("jid")==0) {
					return "JSK-1";
				} else {
					id=rs.getInt("jid")+1;
					return "JSK-"+id;
				}
				
			} 
		} catch (SQLException e) {

			logger.error(e);
		}finally {
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


