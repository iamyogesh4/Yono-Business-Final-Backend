package in.techm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.techm.entity.Account;
import in.techm.repository.AccountRepository;
import in.techm.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account createAccount(Account account) {
		account.generateAccountNumber();
		account.setBalance(1000);
		return accountRepository.save(account);
	}

	public Account getAccountByAccountNumber(String accountNumber) {
		return accountRepository.findByAccountNumber(accountNumber);
	}

	
	
	@Override
	public Account updateBalance(String accountNumber, int balance) {
	    Account account = accountRepository.findByAccountNumber(accountNumber);
	    if (account != null) {
	        account.setBalance(balance); // Update the balance
	        return accountRepository.save(account);
	    }
	    return null;
	}
	


}
