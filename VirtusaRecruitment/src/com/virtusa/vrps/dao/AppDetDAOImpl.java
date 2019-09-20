package com.virtusa.vrps.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.virtusa.vrps.model.ApplicantDet;

public class AppDetDAOImpl implements AppDetDAO{
	public AppDetDAOImpl( )
	{
	}
	public AppDetDAOImpl(Connection con)
	{
		this.con=con;
	}
	static Logger logger = Logger.getLogger(JsDetailsDAOImpl.class);
	Statement st;
	Connection con;
	ResultSet rs;

	@Override
	public List<ApplicantDet> getAppList() {
		List<ApplicantDet> jList = new ArrayList<>();
		try {

			st = con.createStatement();
			rs = st.executeQuery("SELECT applicationid, jbid, jobapplication.jsid, applydate, trstatus, hrstatus, appstatus, jsfirstname, jslastname, city, state, stream, degree FROM jobapplication  INNER JOIN jsregistration on jobapplication.jsid=jsregistration.jsid");
			while (rs.next()) {
				ApplicantDet ad = new ApplicantDet();
				ad.setAppid(rs.getString(1));
				ad.setJbid(rs.getString(2));
				ad.setJsid(rs.getString(3));
				ad.setApplydate(rs.getDate(4));
				ad.setTrstatus(rs.getString(5));
				ad.setHrstatus(rs.getString(6));
				ad.setAppstatus(rs.getString(7));
				ad.setFname(rs.getString(8));
				ad.setLname(rs.getString(9));
				ad.setCity(rs.getString(10));
				ad.setState(rs.getString(11));
				ad.setStream(rs.getString(12));
				ad.setDegree(rs.getString(13));
				jList.add(ad);
			}
		} catch (Exception e) {

			logger.error(e);
			jList=null;
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

		return jList;
	}

	}


