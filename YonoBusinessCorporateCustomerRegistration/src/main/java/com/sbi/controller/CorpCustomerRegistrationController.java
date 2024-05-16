package com.sbi.controller;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbi.crypto.EncryptionService;
import com.sbi.model.CustomerRegistration;
import com.sbi.service.CustomerRegistrationService;

@RestController
@CrossOrigin
@RequestMapping("/corpcustomer")
public class CorpCustomerRegistrationController {
	
	@Autowired
	private EncryptionService encryptionService;
	
	@Autowired
	private CustomerRegistrationService custService;
	
	
	
	@PostMapping("/addcorpcust")
	public ResponseEntity<?> addCustomer(@RequestBody CustomerRegistration registration)
	{
		
		try {
			
		
		
		
		//registration.setPassword(etemp);
		
		
		
		
		
		
		
		String result = custService.addCustomer(registration);
		
		
		
		return new ResponseEntity(result,HttpStatus.ACCEPTED);
		
		}catch (Exception e) {
		  
			return new ResponseEntity(e,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		
	}
	
	@GetMapping("/getcorpcust/{id}")
	public ResponseEntity<CustomerRegistration> getCorpCust(@PathVariable Integer id)
	{
		
		CustomerRegistration result = custService.getCustomerById(id);
		
		
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
		
	}
	
	@GetMapping("/getcorpcustbyusername/{username}")
	public ResponseEntity<CustomerRegistration> getCorpCust(@PathVariable String username)
	{
		
		CustomerRegistration result = custService.finByusername(username);
		
		
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
		
	}
	
	
	@GetMapping("/allCustData")
	public ResponseEntity<?> getAllCustData()
	{
		
		try {
		
		Iterable<CustomerRegistration> result = custService.getAllCustData();
		
		return new ResponseEntity(result,HttpStatus.CREATED);
		
		}catch (Exception e) {
			
			return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
	} 
	
	
	@GetMapping("/getbymobilenoandpassword/{mobile}/{password}")
	public ResponseEntity<CustomerRegistration> findBymobileNoandpassword(@PathVariable(value = "mobile") String mobile , @PathVariable String password)
	{
		
		
		CustomerRegistration result = custService.findByMobileandpassword(mobile, password);
		
		
		return new ResponseEntity<CustomerRegistration>(result,HttpStatus.OK);
		
		
	}
	
	

}
