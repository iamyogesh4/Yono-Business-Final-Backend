package com.sbi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountBalance {
	
	
	@Id
	private int acctId;
	

	private double balence;

	
	

}
