package com.xyz.exception;

@SuppressWarnings("serial")
public class CustomerException extends Exception{

	public CustomerException(){}
	
	public CustomerException(String m){
		getMessage(m);
	}
	
	public void getMessage(String m){
		System.out.println(m);
	}
}
