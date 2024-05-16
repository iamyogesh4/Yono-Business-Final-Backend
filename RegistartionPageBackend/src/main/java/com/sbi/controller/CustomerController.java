package com.sbi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sbi.model.Customer;
import com.sbi.service.ICustomerService;

@RestController
@CrossOrigin
public class CustomerController {
	
	
	@Autowired
	private ICustomerService custService;
	
	
	@PostMapping("/saveCustomer")
	public ResponseEntity<String> registerCustomer(@RequestBody Customer customer)
	{
	
		String result = custService.saveCustomer(customer);
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
		
		
	}
	
	
	
	
	
	
	

}
