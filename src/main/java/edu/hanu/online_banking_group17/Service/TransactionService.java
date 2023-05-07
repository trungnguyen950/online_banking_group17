package edu.hanu.online_banking_group17.Service;


import edu.hanu.online_banking_group17.Model.Account;
import edu.hanu.online_banking_group17.Model.Transaction;
import edu.hanu.online_banking_group17.Model.User;
import edu.hanu.online_banking_group17.Repository.AccountRepository;
import edu.hanu.online_banking_group17.Repository.TransactionRepository;
import edu.hanu.online_banking_group17.Repository.UserRepository;
import edu.hanu.online_banking_group17.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class TransactionService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;

}