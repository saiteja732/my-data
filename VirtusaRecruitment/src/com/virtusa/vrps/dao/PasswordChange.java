package com.virtusa.vrps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class PasswordChange {
	static Logger logger = Logger.getLogger(PasswordChange.class);
	
		Connection con=DaoConnection.getConnection();
		PreparedStatement ps;
		
		public boolean searchEmp(String id ,String email) {
			try {
				ps=con.prepareStatement("select * from EMployeeInfo where empid=? AND EmpEmail=?");
				ps.setString(1, id);
				ps.setString(2, email);
				ResultSet rs=ps.executeQuery();
				boolean flag=false;
				if(rs.next()==flag) {
					return false;
				}else {
					return true;
				}
			} catch (SQLException e) {

				logger.error(e);
				return false;
			}
		}
		
		public boolean changePassword(String id,String email,String pass) {


			boolean status=new PasswordChange().searchEmp(id,email);
			boolean flag=true;
			
			if(status==flag) {
				try {
					ps=con.prepareStatement("Update EmployeeInfo Set EmpPassword=? where empid=? AND EmpEmail=? ");
					ps.setString(1, pass);
					ps.setString(2, id);
					ps.setString(3, email);
					ps.executeUpdate();
					return true;
				} catch (SQLException e) {

					logger.error(e);
					return false;
				}
			} else {
				return false;
			}
		}

		public int checkCredentialFP(String id,String que,String pass) {
			
			System.err.println(id);
			System.err.println(que);
			System.err.println(pass);
			
			int val=0;
			try {
				ps=con.prepareStatement("select count(*) AS ct from jsregistration where JSID=? AND QUESTION=? AND ANSWER=?");
				ps.setString(1, id);
				ps.setString(2, que);
				ps.setString(3, pass);
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
