package com.sbi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbi.service.FetchBalaneceService;



@RestController
@RequestMapping("/api/")
public class FetchBalenceController {
	
	@Autowired
	private FetchBalaneceService balaneceService;
	
	@GetMapping("/fetchBalenceById/{aactId}")
	public ResponseEntity<?> fetchBalanceByAcctId(@PathVariable int aactId){
		double balence =0;
		try {
			 balence = balaneceService.fetchBlanceById(aactId);
		} catch (Exception e) {
			e.printStackTrace();
			return (ResponseEntity<?>) ResponseEntity.internalServerError();
		}
		return ResponseEntity.ok(balence);
		
	}

}
