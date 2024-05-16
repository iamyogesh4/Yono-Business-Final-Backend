package com.sbi.serviceImpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbi.exception.CustomerNotFoundException;
import com.sbi.model.CustomerRegistration;
import com.sbi.repo.CustomerRegistrationRepo;
import com.sbi.service.CustomerRegistrationService;

@Service
public class CustomerRegistartionServiceImpl implements CustomerRegistrationService {

	@Autowired
	private CustomerRegistrationRepo custRepo;
	
	@Override
	public String addCustomer(CustomerRegistration registration ) {
		 
		
		
		return "Corporate Customer Register Succefully With Id::"+  custRepo.save(registration).getCid() ;
	}

	@Override
	public CustomerRegistration getCustomerById(Integer id) {
	
		CustomerRegistration cust = custRepo.findById(id).orElseThrow(()-> new CustomerNotFoundException("Corporate Customer Not Found"));
		
		
		return cust;
		
	}

	@Override
	public CustomerRegistration finByusername(String username) {
		
		
		
		return custRepo.findByusername(username);
	}

	@Override
	public Iterable<CustomerRegistration> getAllCustData() {
		
		return custRepo.findAll();
	}

	@Override
	public CustomerRegistration findByMobileandpassword(String mobileno, String password) {
		
		
		CustomerRegistration result = custRepo.findBymobileandpassword(mobileno, password);
		
		
		return result;
	}

}
