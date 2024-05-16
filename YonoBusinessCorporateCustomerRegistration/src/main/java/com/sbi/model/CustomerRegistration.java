package com.sbi.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="CorpCustReg")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegistration {
	
	
	@Id
	@SequenceGenerator(name = "ybseq",sequenceName = "ybgen",allocationSize = 1,initialValue = 1)
	@GeneratedValue(generator = "ybseq",strategy = GenerationType.SEQUENCE)
    private Integer cid;
	
	private String name;
	
	private String email;
	
	private String username;
	
	private String password;
	
	private String address;
	
	private String mobile;
	
	

}
