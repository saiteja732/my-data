package com.virtusa.vrps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.virtusa.vrps.model.UserInfo;

public class UserDAOImpl2 implements UserDAO {
	static Logger logger = Logger.getLogger(UserDAOImpl2.class);
	Connection con = null;
	PreparedStatement ps=null;
	ResultSet rs=null;

	public UserDAOImpl2(Connection con) {

		this.con = con;
	}

	@Override
	public boolean insert(UserInfo stuinfo) {

		boolean status = false;
		try {
			 ps = con.prepareStatement("insert into adminlogin values(?,?)");
			ps.setString(1, stuinfo.getEmail());
			ps.setString(2, stuinfo.getPassword());

			ps.execute();
			status = true;
		} catch (Exception e) {

			logger.error(e);
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

		return status;
	}

	@Override
	public int getById(String email, String psw) {
		int status = 0;
		try {
			ps = con.prepareStatement("select * from adminlogin where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, psw);
			 rs = ps.executeQuery();
			if (rs.next()) {
				status = 1;
			} else {
				status = 0;
			}
		} catch (Exception e) {

			logger.error(e);
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
		return status;
	}

}
