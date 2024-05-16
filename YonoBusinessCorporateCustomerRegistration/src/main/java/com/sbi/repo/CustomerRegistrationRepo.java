package com.sbi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sbi.model.CustomerRegistration;


public interface CustomerRegistrationRepo extends JpaRepository<CustomerRegistration, Integer> {
	
	public CustomerRegistration findByusername(String username);
	
	
	@Query("from  CustomerRegistration where mobile=:mobileno and password=:password")
	public CustomerRegistration findBymobileandpassword(String mobileno , String password);

}
