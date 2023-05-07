package edu.hanu.online_banking_group17.Repository;

import com.example.online_banking.model.Saving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavingRepositoy extends JpaRepository<Saving, Long> {
    List<Saving> findUserByUserId(Long userId);
}
