package com.xyz.testcases;

import static org.junit.Assert.*;

import org.junit.Test;

import com.xyz.customer.Customer;
import com.xyz.exception.CustomerException;
import com.xyz.services.CustomerServiceImpl;
import com.xyz.services.CustomerServices;

public class ServiceTest {

	CustomerServices cs= new CustomerServiceImpl();
	
	@Test
	public void test() {
		Customer cu=new Customer("Arpit",234);
		assertEquals("9712150496",cs.createAccount("9712150496", cu));
	}
	
	@Test
	public void test1() {
		
		try {
			assertEquals(632,(int)cs.showBalance("9010210130"));
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2() {
		try {
			assertEquals(752,(int)cs.deposit("9010210130",120));
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test3() {
		try {
			assertEquals(512,(int)cs.withdraw("9010210130",120));
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test4() {
		
		try {
			assertEquals(195,(int)cs.fundTransfer("9010210130","9010210131", 195));
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void test5() {
		
		try {
			assertEquals(632,(int)cs.printTransaction("9010210130"));
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
