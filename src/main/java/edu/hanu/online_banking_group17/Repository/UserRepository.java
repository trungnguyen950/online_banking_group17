package edu.hanu.online_banking_group17.Repository;

import edu.hanu.online_banking_group17.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByPhoneNumber(String phoneNumber);
    User findByUsername(String userName);

}
