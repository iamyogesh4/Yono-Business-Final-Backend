package com.sbi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbi.model.CustomerLogin;
import com.sbi.model.CustomerRegistration;
import com.sbi.repo.CustomerLoginRepo;
import com.sbi.service.CustomerLoginService;

@Service
public class CustomerLoginImpl implements CustomerLoginService {

	@Autowired
	private CustomerLoginRepo repo;

	@Autowired
	private RestTemplate template;

	@Override
	public String loginCustomer(CustomerLogin login) throws JsonMappingException, JsonProcessingException {
		
		
		/*

		CustomerRegistration result = template
				.getForObject("http://YonoBusinessCorporateCustomerRegistration/corpcustomer/getcorpcustbyusername/"
						+ login.getUsername(), CustomerRegistration.class);

		System.out.println(result);
		
		*/
		
		//prepare Url 
		
		String url = "http://localhost:2000/corpcustomer/getcorpcustbyusername/{username}";
		
		//send request to provider application
		
		ResponseEntity<String> response = template.exchange(url, HttpMethod.GET, null, String.class, login.getUsername());
		
		//get Json body from response
		
		String jsonBody = response.getBody();
		
		//prepare ObjectMapper Object
		
		ObjectMapper mapper = new ObjectMapper();
		//Convert Json Response into Java Object
		
	
		
		CustomerRegistration result = mapper.readValue(jsonBody,CustomerRegistration.class);
				
		System.out.println("CustomerRegistaration Object::"+result);
		

		if (login.getUsername().equals(result.getUsername()) && login.getPassword().equals(result.getPassword())) {

			System.out.println(result);
			repo.save(login);

			return "Corporate Customer Login Succesfully::";
		}

		/*
		 * if((login==null)) {
		 * 
		 * repo.save(login);
		 * 
		 * return "Corporate Login Success::";
		 * 
		 * }
		 */

		return "Invalid Username & Password";

	}

}
