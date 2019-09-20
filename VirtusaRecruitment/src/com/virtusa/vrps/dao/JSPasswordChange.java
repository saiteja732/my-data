package com.virtusa.vrps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class JSPasswordChange {
	static Logger logger = Logger.getLogger(JSPasswordChange.class);
	
		Connection con=DaoConnection.getConnection();
		PreparedStatement ps;
		
		
		public boolean changePassword(String email,String pass) {


			
			
				try {
					ps=con.prepareStatement("Update jsregistration Set jspassword=? where jsemail=? ");
					ps.setString(1, pass);
					ps.setString(2, email);
					ps.executeUpdate();
					return true;
				} catch (SQLException e) {

					logger.error(e);
					return false;
				}
			}
		

		public int checkCredentialFP(String email,String ques,String ans) {
			
			System.err.println(email);
			System.err.println(ques);
			System.err.println(ans);
			
			int val=0;
			try {
				ps=con.prepareStatement("select count(*) AS ct from jsregistration where jsemail=? AND QUESTION=? AND ANSWER=?");
				ps.setString(1, email);
				ps.setString(2, ques);
				ps.setString(3, ans);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					val=rs.getInt("ct");
				}
				
			} catch (SQLException e) {
				logger.error(e);
			}
			
			return val;
			
		}
		
}
