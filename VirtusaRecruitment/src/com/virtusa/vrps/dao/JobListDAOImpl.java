package com.virtusa.vrps.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.virtusa.vrps.model.JobListInfo;

public class JobListDAOImpl implements JobListDAO {
	static Logger logger = Logger.getLogger(JobListDAOImpl.class);
	Connection con = null;
	Statement st=null;
	ResultSet rs=null;

	public JobListDAOImpl(Connection con) {

		this.con = con;
	}

	@Override
	public List<JobListInfo> getJobList() {
		List<JobListInfo> jList = new ArrayList<>();
		try {

			st = con.createStatement();
			rs = st.executeQuery(
					"select JbId,Title ,Description ,Eligibility ,TechReq ,Location, ExpRequired, CTC, PostDate, ExpireDate, Gap from joblist");
			while (rs.next()) {
				JobListInfo jl = new JobListInfo();
				jl.setJbId(rs.getString(1));
				jl.setJbTitle(rs.getString(2));
				jl.setJbDesc(rs.getString(3));
				jl.setJbEligibility(rs.getString(4));
				jl.setJbTechReq(rs.getString(5));
				jl.setJbLoc(rs.getString(6));
				jl.setJbExpReq(rs.getFloat(7));
				jl.setJbPackage(rs.getFloat(8));
				jl.setJbPostDate(rs.getDate(9));
				jl.setJbExpireDate(rs.getDate(10));
				jl.setGap(rs.getString(11));

				jList.add(jl);
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
