package in.techm.service;

import org.springframework.stereotype.Service;

import in.techm.entity.Account;

public interface AccountService {

	Account createAccount(Account account);

	Account getAccountByAccountNumber(String accountNumber);

	public Account updateBalance(String accountNumber, int balance);
}
