package in.techm.entity;

import java.util.Random;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String accountNumber;

	private String accountHolderName;

	private int balance;

	private String email;

	private String phoneNumber;

	public void generateAccountNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(900_000_000) + 100_000_000;
		this.accountNumber = String.format("%011d", randomNumber);
	}

}
