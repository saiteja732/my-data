package com.virtusa.vrps.testcase;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import com.virtusa.vrps.db.ConnDB;

class ConnectionTest {

	@Test
	void test() {
		Connection con=ConnDB.getCon();
		assertEquals(con != null, true);
	}

}
