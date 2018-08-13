package com.xyz.customerdao;

import com.xyz.customer.Customer;
import com.xyz.exception.CustomerException;

public interface CustomerDao {
	
	String createAccount(String mobileNo,Customer cust);
	double showBalance(String mobNumber) throws CustomerException;
	double deposit(String mobileNo, double depositAmount) throws CustomerException;
	double withdraw(String mobNumber,double withdrawAmount) throws CustomerException;

	double fundTransfer(String mob1,String mob2,double transferAmount) throws CustomerException;
	double printTransaction(String mobileNo) throws CustomerException;
	void validateMobile(String mobileNo) throws CustomerException;
	void validateCustomer(String name) throws CustomerException;
	
}
