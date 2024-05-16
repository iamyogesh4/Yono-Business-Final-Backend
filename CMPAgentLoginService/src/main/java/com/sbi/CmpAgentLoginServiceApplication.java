package com.sbi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CmpAgentLoginServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmpAgentLoginServiceApplication.class, args);
	}

	
	@Bean
	public RestTemplate createTemplate() 
	{
		
		return new RestTemplate();
	}
}
