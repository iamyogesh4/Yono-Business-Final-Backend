package in.techm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.techm.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    
	Account findByAccountNumber(String accountNumber);
}