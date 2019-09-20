package com.virtusa.vrps.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.virtusa.vrps.model.JsSignup;

public class JsDetailsDAOImpl implements JsDetailsDAO {
	static Logger logger = Logger.getLogger(JsDetailsDAOImpl.class);
	Connection con = null;
	Statement st=null;
	ResultSet rs=null;

	public JsDetailsDAOImpl(Connection con) {

		this.con = con;
	}

	@Override
	public List<JsSignup> getJsDetails() {
		List<JsSignup> jList = new ArrayList<>();
		try {

		     st = con.createStatement();
		     rs = st.executeQuery("select jsid,jsfirstname,jslastname,jsemail,jsstatus from jsregistration");
			while (rs.next()) {
				JsSignup ji = new JsSignup();
				ji.setJsId(rs.getString(1));
				ji.setFirstName(rs.getString(2));
				ji.setLastName(rs.getString(3));
				ji.setJsEmail(rs.getString(4));
				ji.setJsStatus(rs.getString(5));
				jList.add(ji);
			}
		} catch (Exception e) {

			logger.error(e);
		}
		finally {
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
