package in.techm.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import in.techm.pojo.TransactionDetails;

public interface TransactionService {

	String credit(TransactionDetails transactionDetails);

	String debit(TransactionDetails transactionDetails);

	int getTotalAmount(String accountNumber);

	List<TransactionDetails> getTransactions();

}
