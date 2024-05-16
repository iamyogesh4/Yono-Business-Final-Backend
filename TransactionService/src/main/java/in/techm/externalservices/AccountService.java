package in.techm.externalservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.techm.pojo.Account;



@FeignClient(name = "ACCOUNT-SERVICE", url = "http://localhost:9091")
public interface AccountService {

	@GetMapping("/{accountNumber}")
    public Account getAccountByAccountNumber(@PathVariable String accountNumber);
        
    
	@PutMapping("/updatebalance")
	public ResponseEntity<String> updateAccountBalance(@RequestParam String accountNumber, @RequestParam int balance);
		
	}

