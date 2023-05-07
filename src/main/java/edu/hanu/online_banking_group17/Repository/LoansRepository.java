package edu.hanu.online_banking_group17.Repository;

import edu.hanu.online_banking_group17.Model.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoansRepository extends JpaRepository<Loans, Long> {
    List<Loans> findUserByUserId(Long userId);
}
