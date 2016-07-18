package com.oocl.demo.el.service;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.oocl.mnlbc.java.service.DemoWithSpringService;
import com.oocl.mnlbc.model.Customer;

import junit.framework.TestCase;


/**
*
* @author Danna Soquiat
* @since 2016-07-18
*
*
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class DemoServiceWithSpringTest extends TestCase {
	
	private static final Long id = 1L;
	
	@Autowired
	private DemoWithSpringService demoService;
	
	public DemoServiceWithSpringTest(){
		super();
	}
	
	@Test
	public void testCURDCustomer(){
		
		saveCustomerTest();
		findCustomerTest();
		updateCustomerTest();
		deleteCustomerTest();
		
	}
	
	public void saveCustomerTest (){
		
		System.out.println(">>>>>> saveCustomerTest begin...");
		
		Customer cus = new Customer();
		cus.setAge(44);
		cus.setName("Rose");
		demoService.saveCustomer(cus);
		
		Customer cus1 = demoService.findCustomer(id);
		
		assertNotNull(cus1);
		verifyCustomer(cus,cus1);
		
		System.out.println(">>>>>> saveCustomerTest ended");
		
	}
	
	
	public void findCustomerTest(){
		
		System.out.println(">>>>>> findCustomerTest begin...");
		
		Customer cus = demoService.findCustomer(id);
		assertNotNull(cus);
		assertTrue("The customer's id is not matched",cus.getId() == id);
		
		System.out.println(">>>>>> findCustomerTest ended");
		
	}
	
	public void updateCustomerTest() {
		
		System.out.println(">>>>>> updateCustomerTest begin...");
		
		Customer cus = demoService.findCustomer(id);
		
		cus.setAge(25);
		
		demoService.updateCustomer(cus);
		
		Customer cus1 = demoService.findCustomer(1L);
		
		assertTrue("The age of customer is wrong",cus.getAge() == 25);
		
		System.out.println(">>>>>> updateCustomerTest ended");
	}
	
	public void deleteCustomerTest() {
		
		System.out.println(">>>>>> deleteCustomerTest begin...");
		
		Customer cus = demoService.findCustomer(id);
		
		demoService.deleteCustomer(cus);
		
		Customer cus1 = demoService.findCustomer(1L);
		
		assertNull("Customer which id = 1L was not deleted.", cus1 == null);
		
		System.out.println(">>>>>> deleteCustomerTest ended");
		
	}

	private void verifyCustomer(Customer original, Customer target) {
		
		assertNotNull(target);
		assertEquals("Customer's name is not equal",original.getName(),target.getName());
		assertTrue("Customer's age is not equal",original.getAge()==target.getAge());
		assertTrue("The number of orders is not equal",original.getOrders().size() == target.getOrders().size());
		
	}

}
