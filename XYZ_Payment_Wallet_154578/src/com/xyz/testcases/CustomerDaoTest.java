package com.xyz.testcases;

import static org.junit.Assert.*;

import org.junit.Test;

import com.xyz.customer.Customer;
import com.xyz.customerdao.CustomerDao;
import com.xyz.customerdao.CustomerDaoImpl;
import com.xyz.exception.CustomerException;

public class CustomerDaoTest {

	CustomerDao cd=new CustomerDaoImpl();
	@Test
	public void Test1(){
		Customer c =new Customer("Arpit",234);

		assertEquals("9035677121",cd.createAccount("9035677121", c));
	}
	
	@Test
	public void Test2(){
		try {
			
			assertEquals(632,(int)cd.showBalance("9010210130"));
		} catch (CustomerException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void Test3(){
		
		try {
			assertEquals(721,(int)cd.deposit("9010210131", 200));
		} catch (CustomerException e) {
		
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void Test4(){
		
		try {
			assertEquals(321,(int)cd.withdraw("9010210131", 200));
		} catch (CustomerException e) {
		
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void Test5(){
		
		try {
			assertEquals(151,(int)cd.fundTransfer("9010210130", "9932012345", 151));
		} catch (CustomerException e) {
			
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void Test6(){
		try {
			assertEquals(631,(int)cd.printTransaction("9932012345"));
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
