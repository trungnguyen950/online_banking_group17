package edu.hanu.online_banking_group17.Service;

import edu.hanu.online_banking_group17.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    UserRepository registerRepository;

}
