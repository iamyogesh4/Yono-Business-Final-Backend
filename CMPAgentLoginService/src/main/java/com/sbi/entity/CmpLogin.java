package com.sbi.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CmpLogin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cmpLoginId;
	
	private String mobileno;
	
	private String password;
}
