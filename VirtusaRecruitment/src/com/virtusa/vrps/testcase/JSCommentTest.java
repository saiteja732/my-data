package com.virtusa.vrps.testcase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.virtusa.vrps.model.JSComment;

class JSCommentTest {

	String comment="good";
	String empid="8796";
	JSComment jc=new JSComment();
	
	@Test
	void commentTest() {
		jc.setComment(comment);
		assertTrue(jc.getComment().equalsIgnoreCase(comment));
	}
	
	@Test
	void empidTest() {
		jc.setEmpid(empid);
		assertTrue(jc.getEmpid().equalsIgnoreCase(empid));
	}

}
