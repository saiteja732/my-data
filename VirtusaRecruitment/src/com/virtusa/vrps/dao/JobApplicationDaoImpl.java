package com.virtusa.vrps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.virtusa.vrps.model.JobApplicationInfo;

public class JobApplicationDaoImpl implements JobApplicationDao {
	static Logger logger = Logger.getLogger(JobApplicationDaoImpl.class);
	Connection con = null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public JobApplicationDaoImpl(Connection con)
	{
		this.con=con;
	}

	@Override
	public boolean insert(JobApplicationInfo jainfo) {
		boolean status=false;
		try {
			AppIdGenerator obj=new AppIdGenerator(con);
			
			ps = con.prepareStatement("insert into jobapplication(id,applicationId,Jbid,Jsid) values(?,?,?,?) ");
			ps.setInt(1, obj.getIdApp());
			ps.setString(2,obj.getAppId());
			ps.setString(3,jainfo.getJbId());
			ps.setString(4,jainfo.getJsId());
			ps.execute();
			status=true;
		} catch (SQLException e) {

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
	public String getStatus(String appid, String jsid) {
		String st;
		try {
			ps = con.prepareStatement("select appstatus from jobapplication where applicationid=? and jsid=?");
			ps.setString(1, appid);
			ps.setString(2, jsid);
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
	public String getJSid(String email) {
		String st;
		try {
			ps = con.prepareStatement("select jsid from jsregistration where jsemail=?");
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

	
}
