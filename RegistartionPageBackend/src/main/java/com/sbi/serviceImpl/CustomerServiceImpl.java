package com.sbi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbi.model.Customer;
import com.sbi.repo.CustomerRepo;
import com.sbi.service.ICustomerService;

@Service
public class CustomerServiceImpl  implements ICustomerService{

	@Autowired
	private CustomerRepo repo;
	
	@Override
	public String saveCustomer(Customer customer) {
		
		
		
		return "Customer save succefully with Id::"+ repo.save(customer).getId();
	}

}
