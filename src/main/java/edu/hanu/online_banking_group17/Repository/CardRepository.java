package edu.hanu.online_banking_group17.Repository;


import edu.hanu.online_banking_group17.Model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
    Card findByCardNumber(String accNum);
    Card findByUserId(Long userId);
}
