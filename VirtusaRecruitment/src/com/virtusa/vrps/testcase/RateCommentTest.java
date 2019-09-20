package com.virtusa.vrps.testcase;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;

import com.virtusa.vrps.model.RateComment;




class RateCommentTest { 

	@Test
	void test() {
		RateComment rc=new RateComment();

		boolean res=rc.insertRateComment("nice", "JSK-3", "EMP-2", 3);
		
//		assertTrue(res);
		assertEquals(true,res);
		
		
	}
	
	@Test
	void testFalse() {
		RateComment rc=new RateComment();

		boolean res=rc.insertRateComment("good", "JSK-2", "890", 4.0f);
		assertEquals(false, res);

	}

}
