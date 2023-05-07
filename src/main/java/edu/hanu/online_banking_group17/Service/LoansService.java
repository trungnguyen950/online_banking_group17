package edu.hanu.online_banking_group17.Service;


import edu.hanu.online_banking_group17.Model.Loans;
import edu.hanu.online_banking_group17.Model.LoansPackage;
import edu.hanu.online_banking_group17.Model.User;
import edu.hanu.online_banking_group17.Repository.*;
import edu.hanu.online_banking_group17.handling_exepctions.DataInvalidException;
import edu.hanu.online_banking_group17.rest.model.LoansMoneyInput;
import edu.hanu.online_banking_group17.rest.model.LoansMoneyOutput;
import edu.hanu.online_banking_group17.rest.model.PagingRequest;
import edu.hanu.online_banking_group17.utils.Constants;
import edu.hanu.online_banking_group17.utils.ErrorCode;
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

    @Autowired
    private LoansPackageRepositoryCustom loansPackageRepositoryCustom;


    public LoansMoneyOutput doMoneyLoans(Authentication authentication, LoansMoneyInput input) throws DataInvalidException {
        String userName = authentication.getName();
        User user = userRepository.findByUsername(userName);

        if (input.getAmount() == null) {
            throw new DataInvalidException(ErrorCode.NO_AMOUNT);
        } else if (input.getLoansPackageID() == null) {
            throw new DataInvalidException(ErrorCode.NO_LOANS_PACKAGE);
        } else {
            Loans loans = new Loans();
            loans.setLoansPackId(input.getLoansPackageID());
            loans.setLoansAmountTaken(input.getAmount());
            loans.setStatus(Constants.STATUS_WAITING);
            loans.setUserId(user.getId());

            LoansPackage loansPackage = loansPackageRepository.getById(input.getLoansPackageID());
            BigDecimal interestAmount = BigDecimal.valueOf(Double.valueOf(input.getAmount().toString()) * loansPackage.getInterestRate() * loansPackage.getDuration());
            loans.setLoansAmountRepaid(input.getAmount().add(interestAmount));
            loans.setDateOfPayment(new Date());


            //case success
            loansRepository.save(loans);
            return LoansMoneyOutput.builder().status(Constants.STATUS_SUCCESS).build();
        }

    }

    // TODO: manage loans package
    public Page<LoansPackage> getLoansPackageList(PagingRequest pagingRequest) {
        Integer total = loansPackageRepositoryCustom.getTotalLoansPackage(pagingRequest);
        List<LoansPackage> loansPackageList = loansPackageRepositoryCustom.getLoansPackageList(pagingRequest);
        Page<LoansPackage> page = new Page<>(loansPackageList);
        page.setRecordsFiltered(loansPackageList.size());
        page.setRecordsTotal(total);
        page.setDraw(pagingRequest.getDraw());
        return page;
    }
}
