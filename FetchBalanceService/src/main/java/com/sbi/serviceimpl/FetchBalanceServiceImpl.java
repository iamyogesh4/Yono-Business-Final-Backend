package com.sbi.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbi.entity.AccountBalance;
import com.sbi.repo.FetchBalRepo;
import com.sbi.service.FetchBalaneceService;




@Service
public class FetchBalanceServiceImpl  implements FetchBalaneceService{

	@Autowired
	private  FetchBalRepo balRepo;
	
	
	@Override
	public double fetchBlanceById(int acctId) {
		AccountBalance accTemp =  balRepo.findById(acctId).get();
		double bal = accTemp.getBalence();
		return bal;
	
	}

}
