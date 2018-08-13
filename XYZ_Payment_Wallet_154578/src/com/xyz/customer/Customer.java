package com.xyz.customer;

public class Customer {

	private String customerName;
	private double accountBalance;
	
	public Customer(){}
	
	public Customer(String customerName, double accountBalance) {
		this.customerName = customerName;
		this.accountBalance = accountBalance;
	}

	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", accountBalance="
				+ accountBalance + "]";
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public double getAccountBalance() {
		return accountBalance;
	}
	
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	
}


