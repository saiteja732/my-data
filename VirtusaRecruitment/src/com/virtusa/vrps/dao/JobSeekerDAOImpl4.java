package com.virtusa.vrps.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.virtusa.vrps.model.JobApplicationInfo;

public class JobSeekerDAOImpl4 implements JobSeekerDAO {
	Connection con = null;
	static Logger logger = Logger.getLogger(JobSeekerDAOImpl4.class);
	Statement st=null;
	ResultSet rs=null;

	public JobSeekerDAOImpl4(Connection con) {

		this.con = con;
	}

	@Override
	public List<JobApplicationInfo> getSelectInfo() {
		List<JobApplicationInfo> jList = new ArrayList<>();
		try {

			 st = con.createStatement();
			 rs = st.executeQuery(
					"select ApplicationId,JbId,JSId,ApplyDate,TRStatus,HRStatus,AppStatus from jobapplication where appstatus='selected' and trstatus='done' and hrstatus='done'");
			while (rs.next()) {
				JobApplicationInfo ji = new JobApplicationInfo();
				ji.setApplicationId(rs.getString(1));
				ji.setJbId(rs.getString(2));
				ji.setJsId(rs.getString(3));
				ji.setApplyDate(rs.getDate(4));
				ji.setTrStatus(rs.getString(5));
				ji.setHrStatus(rs.getString(6));
				ji.setAppStatus(rs.getString(7));
				jList.add(ji);
			}
		} catch (Exception e) {

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

		return jList;
	}

}
