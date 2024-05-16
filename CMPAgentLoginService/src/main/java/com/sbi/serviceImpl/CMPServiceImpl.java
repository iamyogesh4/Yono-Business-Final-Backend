package com.sbi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbi.entity.CmpLogin;
import com.sbi.entity.CustomerRegistration;
import com.sbi.repo.ICmpRepository;
import com.sbi.service.ICMPService;

@Service
public class CMPServiceImpl implements ICMPService {
	
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private ICmpRepository repo;

	@Override
	public String loginCmpProcess(CmpLogin login) throws JsonMappingException, JsonProcessingException {
		
		
		
		//prepare Url 
		
				String url = "http://localhost:2000/corpcustomer/getbymobilenoandpassword/{mobile}/{password}";
				
				//send request to provider application
				
				ResponseEntity<String> response = template.exchange(url, HttpMethod.GET, null, String.class, login.getMobileno(),login.getPassword());
				
				//get Json body from response
				
				String jsonBody = response.getBody();
				
				//prepare ObjectMapper Object
				
				ObjectMapper mapper = new ObjectMapper();
				//Convert Json Response into Java Object
				
			
				
				CustomerRegistration result = mapper.readValue(jsonBody,CustomerRegistration.class);
						
				System.out.println("CustomerRegistaration Object::"+result);
				

				if (login.getMobileno().equals(result.getMobile()) && login.getPassword().equals(result.getPassword())) {

					System.out.println(result);
					repo.save(login);

					return "CMP/AGENT  Login Succesfully::";
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
