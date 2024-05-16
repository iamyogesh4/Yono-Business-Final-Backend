package com.sbi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegistration {
	
	    private Integer cid;
		
		private String name;
		
		private String email;
		
		private String username;
		
		private String password;
		
		private String address;
		
		private String mobile;

}
