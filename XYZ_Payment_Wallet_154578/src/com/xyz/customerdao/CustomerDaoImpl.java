package com.xyz.customerdao;

import java.util.HashMap;
import java.util.Map;

import com.xyz.customer.Customer;
import com.xyz.exception.CustomerException;

public class CustomerDaoImpl implements CustomerDao {

	Map<String,Customer> customerDetails;
	
	
	public CustomerDaoImpl(){
		customerDetails=new HashMap<>();
		//Storing details of customer
		customerDetails.put("9010210139", new Customer("Vaishali",200));
		customerDetails.put("9823920123", new Customer("Megha",453));
		customerDetails.put("9932012345", new Customer("Vikas",631));
		customerDetails.put("9010210131", new Customer("Anju",521));
		customerDetails.put("9010210130", new Customer("Tushar",632));
	}
	

	@Override
	public String createAccount(String mobileNo,Customer cust){
		
		customerDetails.put(mobileNo, cust);
		return mobileNo;
	}

	@Override
	public double showBalance(String mobileNo) throws CustomerException {
	
		if(customerDetails.containsKey(mobileNo)){
			Customer c1=new Customer();
			c1=customerDetails.get(mobileNo); //accessing value Account through key mobile no 
			return c1.getAccountBalance();
		}
		else
			throw new CustomerException("ERROR: Given Account Does Not Exists");
	}
	
	@Override
	public double deposit(String mobileNo,double depositAmount) throws CustomerException {
		
				//checking if the mobile number is in the database
				if(!customerDetails.containsKey(mobileNo)){
					throw new CustomerException("Error: Cannot Deposit into Account as Given Mobile No Does Not Exists"); 
				}
				else{
					Customer a=new Customer();
					a=customerDetails.get(mobileNo); //getting account details by key of hashMap
					double i=a.getAccountBalance();
					i=i+depositAmount;
					a.setAccountBalance(i); //Updating Account Balance
					return i;
				}
	}

	@Override
	public double withdraw(String mobileNo,double withdrawAmount) throws CustomerException {
		
		//checking if the mobile number is in the database
		if(!customerDetails.containsKey(mobileNo)){
			throw new CustomerException("Error: Cannot Deposit into Account as Given Mobile No Does Not Exists"); 
		}
		else{
			Customer a1=new Customer();
			a1=customerDetails.get(mobileNo); //getting account details by key of hashMap
			double i=a1.getAccountBalance();
			if(withdrawAmount>i){
				throw new CustomerException("The Amount to be withdrawn is greater than the amount in your Account");
			}
			i=i-withdrawAmount;
			a1.setAccountBalance(i); //Updating Account Balance
			return i;
		}
	}

	@Override
	public double fundTransfer(String mob1,String mob2,double transferAmount) throws CustomerException{
		
		if(!customerDetails.containsKey(mob1) || !customerDetails.containsKey(mob2)){
			throw new CustomerException("Error: Cannot transfer into Account as Given Mobile No. Does Not Exists"); 
		}
		else{
			Customer a2=new Customer();
			a2=customerDetails.get(mob1); //getting account details by key of hashMap
			double i=a2.getAccountBalance();
			i=i-transferAmount;
			a2.setAccountBalance(i); //Updating Account Balance
			a2=customerDetails.get(mob2); //getting account details by key of hashMap
			i=a2.getAccountBalance();
			i=i+transferAmount;
			a2.setAccountBalance(i);
			return transferAmount;
		}
	}

	@Override
	public double printTransaction(String mobileNo) throws CustomerException {
	
		//checking if the mobile number is in the database
		if(!customerDetails.containsKey(mobileNo)){
			throw new CustomerException("Error: Cannot Deposit into Account as Given Mobile No Does Not Exists"); 
		}
		
		Customer c3=new Customer();
		c3=customerDetails.get(mobileNo);
		return c3.getAccountBalance();
	}
	public void validateMobile(String mobileNo) throws CustomerException{
		if(mobileNo.length()!=10){
			throw new CustomerException("Mobile No. should be of 10 digit.");
		}
		
		if(!mobileNo.matches("[0-9]{10}")){
			throw new CustomerException("Mobile No. should only contain digits.");
		}
		
	}
	public void validateCustomer(String name) throws CustomerException{
		if(!name.matches("[A-Z][a-z]{3,15}")){
			throw new CustomerException("Customer Name does not matches the criteria as it must have at least 3 letters and maximum of 15 letters and starts with a capital letter");
		}
	}
}
