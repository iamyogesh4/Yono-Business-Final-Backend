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


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "custlogin")
public class CustomerLogin {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer lid;
	
	private String  username;
	
	private String  password;

}
