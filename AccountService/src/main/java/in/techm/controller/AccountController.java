package in.techm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.techm.entity.Account;
import in.techm.service.AccountService;

@RestController
@CrossOrigin()
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/createAccount")
	public ResponseEntity<String> createAccount(@RequestBody Account account) {
		accountService.createAccount(account);
		return new ResponseEntity<>("Account created successfully", HttpStatus.OK);
	}

	@GetMapping("/{accountNumber}")
	public Account getAccountByAccountNumber(@PathVariable String accountNumber) {
		return accountService.getAccountByAccountNumber(accountNumber);
	}


	@PutMapping("/updatebalance")
	public ResponseEntity<String> updateAccountBalance(@RequestParam String accountNumber, @RequestParam int balance) {
		Account updatedAccount = accountService.updateBalance(accountNumber, balance);
		if (updatedAccount != null) {
			return ResponseEntity.ok("Account balance updated successfully: " + updatedAccount.toString());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Account not found with account number: " + accountNumber);
		}
	}
}
