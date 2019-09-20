package com.virtusa.vrps.testcase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.virtusa.vrps.model.UserInfo;

class UserInfoTest {

	@Test
	void userEmail() {
		UserInfo ui=new UserInfo();
		ui.setEmail("barkhagupta@gmail.com");
		assertTrue(ui.getEmail().equalsIgnoreCase("barkhagupta@gmail.com"));
	}

	@Test
	void userPassword() {
		UserInfo ui=new UserInfo();
		ui.setPassword("78965");
		assertTrue(ui.getPassword().equalsIgnoreCase("78965"));
	} 
	
	@Test
	void userInfo() {
		UserInfo ui=new UserInfo("barkha@gmail.com", "7412365");
	}
}
