package in.techm.serviceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import in.techm.externalservices.AccountService;
import in.techm.pojo.Account;
import in.techm.pojo.TransactionDetails;
import in.techm.repository.TransactionDetailsRepository;
import in.techm.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private AccountService accountService;

	@Autowired
	private TransactionDetailsRepository transactionDetailsRepository;

	public String credit(TransactionDetails transactionDetails) {
		int amount = transactionDetails.getAmount();
		String fromAccountNumber = transactionDetails.getFromAccountNumber();
		String toAccountNumber = transactionDetails.getToAccountNumber();
		Account fromAccount = accountService.getAccountByAccountNumber(fromAccountNumber);
		Account toAccount = accountService.getAccountByAccountNumber(toAccountNumber);

		if (fromAccount.getBalance() >= amount) {
			int updatedFromAccountBalance = fromAccount.getBalance() - amount;
			int updatedToAccountBalance = toAccount.getBalance() + amount;

			accountService.updateAccountBalance(fromAccountNumber, updatedFromAccountBalance);
			accountService.updateAccountBalance(toAccountNumber, updatedToAccountBalance);

			transactionDetails.setTransactionType("Credit");

			LocalDateTime transactionDateTime = LocalDateTime.now();
			String formattedTransactionDateTime = transactionDateTime
					.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));
			transactionDetails.setTransactionDateTime(formattedTransactionDateTime);
			transactionDetailsRepository.save(transactionDetails);
			return "Amount Credited Successfully";
		} else {
			return "Insufficient balance in the from account";
		}
	}

	public String debit(TransactionDetails transactionDetails) {
		int amount = transactionDetails.getAmount();
		String fromAccountNumber = transactionDetails.getFromAccountNumber();
		String toAccountNumber = transactionDetails.getToAccountNumber();

		Account fromAccount = accountService.getAccountByAccountNumber(fromAccountNumber);
		Account toAccount = accountService.getAccountByAccountNumber(toAccountNumber);
		if (fromAccount.getBalance() >= amount) {
			int updatedFromAccountBalance = fromAccount.getBalance() - amount;
			int updatedToAccountBalance = toAccount.getBalance() + amount;
			accountService.updateAccountBalance(fromAccountNumber, updatedFromAccountBalance);
			accountService.updateAccountBalance(toAccountNumber, updatedToAccountBalance);
			transactionDetails.setTransactionType("Debit");
			LocalDateTime transactionDateTime = LocalDateTime.now();
			String formattedTransactionDateTime = transactionDateTime
					.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));
			transactionDetails.setTransactionDateTime(formattedTransactionDateTime); // Set formatted date-time string
																						// directly

			transactionDetailsRepository.save(transactionDetails);

			return "Amount Debited Successfully";
		} else {
			return "Insufficient balance in the from account";
		}
	}

	public int getTotalAmount(String accountNumber) {
		Account account = accountService.getAccountByAccountNumber(accountNumber);
		return account.getBalance();
	}

	@Override
	public List<TransactionDetails> getTransactions() {
		return transactionDetailsRepository.findTransactions();
	}

}
