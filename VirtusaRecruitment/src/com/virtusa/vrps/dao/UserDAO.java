package com.virtusa.vrps.dao;

import com.virtusa.vrps.model.UserInfo;

public interface UserDAO {
	public boolean insert(UserInfo stuinfo);

	public int getById(String email, String psw);

}
