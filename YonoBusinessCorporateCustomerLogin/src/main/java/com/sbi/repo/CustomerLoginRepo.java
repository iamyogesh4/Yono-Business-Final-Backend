package com.sbi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbi.model.CustomerLogin;

public interface CustomerLoginRepo extends JpaRepository<CustomerLogin, Integer> {

}
