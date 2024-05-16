package com.sbi.service;

import com.sbi.model.CustomerRegistration;


public interface CustomerRegistrationService {
	
	
	public String addCustomer(CustomerRegistration register);
	
	public CustomerRegistration getCustomerById(Integer id);
	
	public CustomerRegistration finByusername(String username);
	
	public Iterable<CustomerRegistration> getAllCustData();
	
	
	public CustomerRegistration findByMobileandpassword(String mobileno ,String password);
	
	

}
