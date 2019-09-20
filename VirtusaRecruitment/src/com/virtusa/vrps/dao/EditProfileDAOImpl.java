package com.virtusa.vrps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.virtusa.vrps.model.EditProfileInfo;

public class EditProfileDAOImpl implements EditProfileDAO{
	static Logger logger = Logger.getLogger(EditProfileDAOImpl.class);
	
	Connection con;

	public EditProfileDAOImpl(Connection con)
	{
		this.con=con;
	}

	@Override
	public boolean updateProfile(EditProfileInfo edi, String nid) {
		boolean status=false;
		PreparedStatement ps=null;
		try {
			
			
			ps = con.prepareStatement("Update jsregistration set DOB=?,Gender=?,Address=?,City=?,State=?,Country=?,Pincode=?,Stream=?,Degree=?,CGPA=?,Institute=?,University=?,Passout=?,Gap=?,HSBoard=?,HSPercentage=?,SBoard=?,SBPercentage=?,ExpYear=?,Company=?, Location=? where Jsid=?");
			ps.setDate(1, (java.sql.Date) edi.getDob());
			ps.setString(2,edi.getGender());
			ps.setString(3, edi.getAdd());
			ps.setString(4, edi.getCity());
			ps.setString(5,edi.getState());
			ps.setString(6, edi.getCountry());
			ps.setInt(7,edi.getPincode());
			ps.setString(8,edi.getStream());
			ps.setString(9,edi.getDegree());
			ps.setDouble(10,edi.getCgpa());
			ps.setString(11, edi.getInst());
			ps.setString(12, edi.getUniversity());
			ps.setDate(13,(java.sql.Date)edi.getPass());
			ps.setString(14,edi.getGap());
			ps.setString(15, edi.getHb());
			ps.setDouble(16,edi.getHp());
			ps.setString(17,edi.getSb());
			ps.setDouble(18, edi.getSp());
			ps.setDouble(19,edi.getEy());
			ps.setString(20, edi.getComp());
			ps.setString(21, edi.getLoc());
			ps.setString(22,nid);
			ps.execute();
			status=true;
		} catch (SQLException e) {
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
