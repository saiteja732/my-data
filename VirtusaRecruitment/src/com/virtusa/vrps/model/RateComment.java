package com.virtusa.vrps.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.virtusa.vrps.dao.DaoConnection;

public class RateComment {
	static Logger logger = Logger.getLogger(RateComment.class);

	
		Connection con=DaoConnection.getConnection();
		PreparedStatement ps;
		
		public Boolean insertRateComment(String cmt,String jsid,String empid,float rate) {
			if(cmt.isEmpty()) {
				cmt=null;
			}
	
			
			try {
				ps=con.prepareStatement("insert into ratecomment(jsid,empid,rating,commentdes) values(?,?,?,?)");
				ps.setString(1, jsid);
				ps.setString(2, empid);
				ps.setFloat(3, rate);
				ps.setString(4, cmt);
				ps.executeQuery();
				return true;
			} catch (SQLException e) {

				logger.error(e);
			}
			return false;
		}
}
