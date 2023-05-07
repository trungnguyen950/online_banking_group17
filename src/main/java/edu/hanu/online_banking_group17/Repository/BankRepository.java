package edu.hanu.online_banking_group17.Repository;

import edu.hanu.online_banking_group17.Model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {

    Bank findByBankCode(String bankCode);
}
