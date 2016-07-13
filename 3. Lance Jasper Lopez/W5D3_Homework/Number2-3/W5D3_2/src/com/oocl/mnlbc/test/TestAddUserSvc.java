package com.oocl.mnlbc.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.oocl.mnlbc.service.AddUserSvc;

public class TestAddUserSvc {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEmpty() {
		AddUserSvc userSvc = new AddUserSvc();
		String sampleField = "";
		userSvc.fieldEmpty(sampleField);
		assertEquals(sampleField, "");
	}
	
	@Test
	public void testNotEmpty() {
		AddUserSvc userSvc = new AddUserSvc();
		String sampleField = "Aasd";
		userSvc.fieldEmpty(sampleField);
		assertEquals(sampleField, "Aasd");
	}

}
