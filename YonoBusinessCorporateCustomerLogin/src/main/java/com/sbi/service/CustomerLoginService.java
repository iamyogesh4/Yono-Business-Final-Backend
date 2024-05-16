package com.sbi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sbi.model.CustomerLogin;

public interface CustomerLoginService {
	
	public String loginCustomer(CustomerLogin login) throws JsonMappingException, JsonProcessingException;

}
