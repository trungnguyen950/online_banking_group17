package edu.hanu.online_banking_group17.Repository;

import com.example.online_banking.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
