package com.virtusa.vrps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.virtusa.vrps.model.JobListInfo;

public class JobPostDAOImpl implements JobPostDAO {
	Connection con = null;
	static Logger logger = Logger.getLogger(JobPostDAOImpl.class);
	PreparedStatement ps=null;

	public JobPostDAOImpl(Connection con) {

		this.con = con;
	}

	@Override
	public boolean insert(JobListInfo jlinfo) {
		boolean status = false;
		try {
			ps = con.prepareStatement(
					"insert into joblist(id,jbid,title,description,eligibility,techreq,location,exprequired,ctc,expiredate,gap) values(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, jlinfo.getId());
			ps.setString(2, jlinfo.getJbId());
			ps.setString(3, jlinfo.getJbTitle());
			ps.setString(4, jlinfo.getJbDesc());
			ps.setString(5, jlinfo.getJbEligibility());
			ps.setString(6, jlinfo.getJbTechReq());
			ps.setString(7, jlinfo.getJbLoc());
			ps.setFloat(8, jlinfo.getJbExpReq());
			ps.setFloat(9, jlinfo.getJbPackage());
			ps.setDate(10, (java.sql.Date) jlinfo.getJbExpireDate());
			ps.setString(11, jlinfo.getGap());

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

}
