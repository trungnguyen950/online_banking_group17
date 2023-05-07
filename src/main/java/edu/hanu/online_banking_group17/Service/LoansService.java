package edu.hanu.online_banking_group17.Service;


import edu.hanu.online_banking_group17.Model.Loans;
import edu.hanu.online_banking_group17.Model.LoansPackage;
import edu.hanu.online_banking_group17.Model.User;
import edu.hanu.online_banking_group17.Repository.*;
import edu.hanu.online_banking_group17.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class LoansService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private LoansRepository loansRepository;

    @Autowired
    private LoansPackageRepository loansPackageRepository;

    @Autowired
    private BankRepository bankRepository;


}
