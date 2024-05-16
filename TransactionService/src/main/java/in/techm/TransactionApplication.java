package in.techm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;



@SpringBootApplication
@EnableFeignClients
public class TransactionApplication {

	public static void main(String[] args) {
		
		// Generate API key
//        String apiKey = ApiKeyGenerator.generateApiKey();
//        System.out.println("Generated API Key: " + apiKey);
        
		SpringApplication.run(TransactionApplication.class, args);
		
		
	}
	
}
