package com.sbi.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbi.crypto.EncryptionService;
import com.sbi.model.CustomerLogin;
import com.sbi.service.CustomerLoginService;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class CustomerLoginController {
	
	
	@Autowired
	private CustomerLoginService loginService;
	
	@Autowired
	private EncryptionService encryptionService;
	
	
	@PostMapping("/login")
	public ResponseEntity<?> corpCustomerLogin(@RequestBody CustomerLogin login) 
	{
		
		try {
		 
		
		
			
			 
	        
	      String dtemp = encryptionService.decrypt(login.getPassword());
		
		   //System.out.println(dtemp);
			
			
		
		  login.setPassword(dtemp);
		
		
		String result = loginService.loginCustomer(login);
		
		
		return new  ResponseEntity(result , HttpStatus.ACCEPTED);
		
		}catch (Exception e) {
			
			return new  ResponseEntity(e , HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		
		
		
		
	}
	
	
	

}
