package com.sbi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbi.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
