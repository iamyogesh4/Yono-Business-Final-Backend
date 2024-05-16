package in.techm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.techm.pojo.TransactionDetails;

@Repository
public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, Long> {

	 @Query(value = "SELECT * FROM transaction_details ORDER BY id DESC LIMIT 10", nativeQuery = true)
	    List<TransactionDetails> findTransactions();
}
