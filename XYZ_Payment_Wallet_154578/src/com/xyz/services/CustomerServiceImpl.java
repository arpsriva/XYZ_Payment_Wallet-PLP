package com.xyz.services;

import com.xyz.customer.Customer;
import com.xyz.customerdao.CustomerDao;
import com.xyz.customerdao.CustomerDaoImpl;
import com.xyz.exception.CustomerException;

public class CustomerServiceImpl implements CustomerServices {

	CustomerDao cdao=new CustomerDaoImpl();
	
	@Override
	public String createAccount(String mobileNo, Customer cust){
		
		return cdao.createAccount(mobileNo, cust);
	}

	@Override
	public double showBalance(String mobNumber) throws CustomerException {
		return cdao.showBalance(mobNumber);
	}

	@Override
	public double deposit(String mobileNo, double depositAmount)
			throws CustomerException {
		return cdao.deposit(mobileNo, depositAmount);
	}

	@Override
	public double withdraw(String mobNumber, double withdrawAmount)
			throws CustomerException {
		return cdao.withdraw(mobNumber, withdrawAmount);
	}

	@Override
	public double fundTransfer(String mob1, String mob2, double transferAmount)
			throws CustomerException {
		return cdao.fundTransfer(mob1, mob2, transferAmount);
	}

	@Override
	public double printTransaction(String mobileNo) throws CustomerException {
		return cdao.printTransaction(mobileNo);
	}

	@Override
	public void validateMobile(String mobileNo) throws CustomerException {
		
		cdao.validateMobile(mobileNo);
		
	}

	@Override
	public void validateCustomer(String name) throws CustomerException {
		cdao.validateCustomer(name);
		
	}

}
