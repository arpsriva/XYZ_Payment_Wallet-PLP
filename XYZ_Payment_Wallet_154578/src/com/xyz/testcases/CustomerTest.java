package com.xyz.testcases;

import static org.junit.Assert.*;

import org.junit.Test;

import com.xyz.customer.Customer;

public class CustomerTest {
	
	Customer c1= new Customer();
	@Test
	public void test1(){
		
		assertEquals(null,c1.getCustomerName());
		
	}
	@Test
	public void test2(){
	
		c1.setCustomerName("arpit");
		assertEquals("arpit",c1.getCustomerName());
		
	}
	
	@Test
	public void test3(){
		
		assertEquals(0,c1.getAccountBalance(),0.001);
		
	}	
	@Test
	public void test4(){
		c1.setAccountBalance(23.3);
		assertEquals(23.3,c1.getAccountBalance(),0.001);
		
	}
}
