package com.virtusa.vrps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.virtusa.vrps.model.EmployeeInfo;

public class EmpDAOImpl implements EmpDAO {
	static Logger logger = Logger.getLogger(EmpDAOImpl.class);
	Connection con = null;
	PreparedStatement ps=null;
	ResultSet rs=null;

	public EmpDAOImpl(Connection con) {

		this.con = con;
	}

	@Override
	public int getById(String empid, String psw) {
		int status = 0;
		try {
			ps = con.prepareStatement("select * from employeeinfo where empid=? and emppassword=?");
			ps.setString(1, empid);
			ps.setString(2, psw);
			rs = ps.executeQuery();
			if (rs.next()) {
				status = 1;
			} else {
				status = 0;
			}
		} catch (Exception e) {

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
		return status;
	}

	@Override
	public String getDesig(String empid) {
		String st;
		try {
			ps = con.prepareStatement("select empdesignation from employeeinfo where empid=?");
			ps.setString(1, empid);
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
	public boolean insert(EmployeeInfo empinfo) {
		boolean status = false;
		try {
			ps = con.prepareStatement("insert into employeeinfo values(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, empinfo.getEmpid());
			ps.setString(2, empinfo.getEmpFirstName());
			ps.setString(3, empinfo.getEmpLastName());
			ps.setString(4, empinfo.getEmpEmail());
			ps.setString(5, empinfo.getEmpPhone());
			ps.setString(6, empinfo.getEmpPassword());
			ps.setString(7, empinfo.getEmpDesignation());
			ps.setString(8, empinfo.getEmpDepartment());
			ps.setString(9, empinfo.getEmpStatus());
			ps.setString(10, empinfo.getEmpRole());

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
