package com.virtusa.vrps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.virtusa.vrps.model.Employee;

public class EmpData {
	static Logger logger = Logger.getLogger(EmpData.class);
	
	public Employee getData(String id) {
		Connection con=DaoConnection.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Employee emp=null;
		try {
			ps=con.prepareStatement("select * from employeeinfo where empid=?");
			ps.setString(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				
				emp=new Employee();
				emp.setEmpId(rs.getString("Empid"));
				emp.setEmpFirstName(rs.getString("EMPFIRSTNAME"));
				emp.setEmpLastName(rs.getString("EMPLASTNAME"));
				emp.setEmpEmail(rs.getString("EMPEMAIL"));
				emp.setEmpPhone(rs.getString("EMPPHONENO"));
				emp.setEmpDesignation(rs.getString("EMPDESIGNATION"));
				emp.setEmpDepartment(rs.getString("EMPDEPARTMENT"));
			}
		} catch (SQLException e) {

			logger.error(e);
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

		return emp;
	}

}
