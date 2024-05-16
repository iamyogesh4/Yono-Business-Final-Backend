package com.sbi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.sbi.entity.AccountBalance;



@Repository
public interface FetchBalRepo  extends JpaRepository<AccountBalance, Integer>{

}
