package com.sbi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/systemip")
public class SystemIpAddress {
	
	
	@GetMapping("/getIp")
	public ResponseEntity<String> getSystemIpAddress(HttpServletRequest request)
	{
		
		String result = request.getLocalAddr();
		
		
		return new ResponseEntity<String>(result,HttpStatus.OK);
		
		
	}
	
	

}
