package com.sbi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbi.entity.CmpLogin;

public interface ICmpRepository extends JpaRepository<CmpLogin, Integer> {

}
