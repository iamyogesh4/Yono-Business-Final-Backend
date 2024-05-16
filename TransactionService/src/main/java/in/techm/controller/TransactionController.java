package in.techm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import in.techm.pojo.TransactionDetails;
import in.techm.repository.TransactionDetailsRepository;
import in.techm.service.TransactionService;

@RestController
@CrossOrigin()
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private TransactionDetailsRepository transactionDetailsRepository;

	@Value("${expected.api.key}")
	private String expectedApiKey;

	@PostMapping("/credit")
	public String credit(@RequestBody TransactionDetails transactionDetails,
			@RequestHeader("Authorization") String apiKey) {
		if (!apiKey.equals("Bearer " + expectedApiKey)) {
			return "Unauthorized";
		}
		String creditResult = transactionService.credit(transactionDetails);
		return creditResult;
	}

	@GetMapping("/total-amount/{accountNumber}")
	public double getTotalAmount(@PathVariable String accountNumber) {
		return transactionService.getTotalAmount(accountNumber);
	}

	@PostMapping("/debit")
	public String debit(@RequestBody TransactionDetails transactionDetails,
			@RequestHeader("Authorization") String apiKey) {
		if (!apiKey.equals("Bearer " + expectedApiKey)) {
			return "Unauthorized";
		}

		String debitResult = transactionService.debit(transactionDetails);

		return debitResult;
	}

	@GetMapping("/all")
    public List<TransactionDetails> getLast10Transactions() {
        return transactionService.getTransactions();
    }
}
