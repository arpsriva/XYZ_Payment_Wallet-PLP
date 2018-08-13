package com.xyz.ui;

import java.util.Scanner;

import com.xyz.customer.Customer;
import com.xyz.exception.CustomerException;
import com.xyz.services.CustomerServiceImpl;
import com.xyz.services.CustomerServices;

public class CustomerUI {

	public static void main(String[] args) {
		CustomerServices cser = new CustomerServiceImpl();
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		
		do{
			
		System.out.println("     ");
		System.out.println("1) Create Account");
		System.out.println("2) Account Balance Enquiry");
		System.out.println("3) Deposit into Account");
		System.out.println("4) Withdraw Money from Account");
		System.out.println("5) Fund Tranfer to other Account");
		System.out.println("6) Print Transaction");
		System.out.println("7) Exit");
		System.out.println();
		System.out.println("Enter Your choice:");

		int choice=sc.nextInt();
		
		switch(choice){
	case 1:
		System.out.println("Enter Mobile No: ");
		String mobileNo=sc.next();
			try {
				cser.validateMobile(mobileNo);
			} catch (CustomerException e2) {
				
				e2.getMessage();
				break;
			}
		System.out.println("Enter Customer Name: ");
		String name=sc.next();
		try{
				cser.validateCustomer(name);
			} catch (CustomerException e1) {
				
				e1.getMessage();
				break;
			}
		Customer d=new Customer();
		d.setCustomerName(name);
		d.setAccountBalance(0);
				String s=cser.createAccount(mobileNo, d);
				System.out.println("Account with Mobile No. "+s+" is created with Opening Balance "+d.getAccountBalance());
		
			break;
	case 2:
		System.out.println("Enter Mobile No: ");
		String mobileNo1=sc.next();
			try {
				cser.validateMobile(mobileNo1);
			} catch (CustomerException e1) {
			
				e1.getMessage();
				break;
			}
			try {
				double balance=cser.showBalance(mobileNo1);
				System.out.println("The total balance of the Account with mobile no. "+mobileNo1+" is "+balance);
			} catch (CustomerException e) {
				
				e.getMessage();
			}
			break;
	case 3:
		
		System.out.println("Enter Mobile No.: ");
		String mobileNo2=sc.next();
		try {
			cser.validateMobile(mobileNo2);
		} catch (CustomerException e1) {
		
			e1.getMessage();
			break;
		}
		System.out.println("Enter Deposit Amount: ");
		double amt=sc.nextDouble();
		if(amt<0){
			try {
				throw new CustomerException("Amount should not be less than 0");
			} catch (CustomerException e) {
				
				e.getMessage();
				break;
			}
		}
			try {
				double balance1=cser.deposit(mobileNo2, amt);
				System.out.println("The total balance of the Account with mobile no. "+mobileNo2+" after deposition of "+amt+" amount is "+balance1);
			} catch (CustomerException e) {
			
				e.getMessage();
			}
			break;
	case 4:
		System.out.println("Enter Mobile No.: ");
		String mobileNo3=sc.next();
		try {
			cser.validateMobile(mobileNo3);
		} catch (CustomerException e1) {
		
			e1.getMessage();
			break;
		}
		System.out.println("Enter withdraw Amount: ");
		double amt1=sc.nextDouble();
		if(amt1<0){
			try {
				throw new CustomerException("Amount should not be less than 0");
			} catch (CustomerException e) {
				
				e.getMessage();
				break;
			}
		}
			try {
				double balance2=cser.withdraw(mobileNo3, amt1);
				System.out.println("The total balance of the Account with mobile no. "+mobileNo3+" after withdrawing "+amt1+" amount is "+balance2);
			} catch (CustomerException e) {
			
				e.getMessage();
			}
			break;
	case 5:
		System.out.println("Enter Mobile No. from which Fund is to be Transferred: ");
		String mob1=sc.next();
		try {
			cser.validateMobile(mob1);
		} catch (CustomerException e1) {
		
			e1.getMessage();
			break;
		}
		System.out.println("Enter Mobile No. to which Fund is to be Transferred: ");
		String mob2=sc.next();
		try {
			cser.validateMobile(mob2);
		} catch (CustomerException e1) {
		
			e1.getMessage();
			break;
		}
		System.out.println("Enetr the Amount to be Transferred: ");
		double amt2=sc.nextDouble();
		if(amt2<0){
			try {
				throw new CustomerException("Amount should not be less than 0");
			} catch (CustomerException e) {
				
				e.getMessage();
				break;
			}
		}
			try {
				@SuppressWarnings("unused")
				double amt3=cser.fundTransfer(mob1, mob2, amt2);
				System.out.println("Transfer of amount "+amt2+" from "+mob1+" to "+mob2+" is successful");
				double b1=cser.printTransaction(mob1);
				double b2=cser.printTransaction(mob2);
				System.out.println("The updated balance of mobile No. "+mob1+" is "+b1);
				System.out.println("The updated balance of mobile No. "+mob2+" is "+b2);
			} catch (CustomerException e) {
			
				e.getMessage();
			}
			break;
	case 6:
		System.out.println("Enter Mobile No.: ");
		String mobileNo4=sc.next();
		try {
			cser.validateMobile(mobileNo4);
		} catch (CustomerException e1) {
		
			e1.getMessage();
			break;
		}
			try {
				double b3=cser.printTransaction(mobileNo4);
				System.out.println("Balance of Mobile No. "+mobileNo4+" is "+b3);
			} catch (CustomerException e) {
				
				e.getMessage();
			}
			break;
	case 7:
		System.out.println("Application Exiting..........");
		System.exit(0);
		break;
		}
		System.out.println();
		System.out.println("Do you want to continue?");
		System.out.println("1) Yes    2)No)");
		int i=sc.nextInt();
		if(i==2){
			System.out.println("Application Exiting..............");
			System.exit(0);
		}
		
		}while(true);
	}

}
