package edu.hanu.online_banking_group17.Service;

//import com.example.online_banking.exception.DataInvalidException;
import edu.hanu.online_banking_group17.Model.*;
import edu.hanu.online_banking_group17.Repository.*;
import edu.hanu.online_banking_group17.utils.Constants;
import edu.hanu.online_banking_group17.utils.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class SavingMoneyService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SavingPackageRepository savingPackageRepository;

    @Autowired
    private SavingRepositoy savingRepositoy;

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CardRepository cardRepository;

    public SavingMoneyOutput doSavingMoney(Authentication authentication, SavingMoneyInput input) throws DataInvalidException {
        String userName = authentication.getName();
        User user = userRepository.findByUsername(userName);

        if (input.getAmount() == null){
            throw new DataInvalidException(ErrorCode.NO_AMOUNT);
        } else if(input.getSavingPackageID() == null) {
            throw new DataInvalidException(ErrorCode.NO_SAVING_PACKAGE);
        } else {
            Saving saving = new Saving();
            saving.setUserId(user.getId());
            saving.setSavingPackageId(input.getSavingPackageID());
            saving.setSavingAmountTaken(input.getAmount());
            saving.setStatus(Constants.STATUS_WAITING);

            SavingPackage savingPackage = savingPackageRepository.getById(input.getSavingPackageID());
            BigDecimal amountProfit = BigDecimal.valueOf(Double.valueOf(input.getAmount().toString()) * savingPackage.getInterestRate() * savingPackage.getDuration());
            saving.setSavingAmounProfit(input.getAmount().add(amountProfit));
            saving.setRegistrationDate(new Date());

            Account account = accountRepository.findFirstByUserId(user.getId());
            account.setCurrentBalance(account.getCurrentBalance().subtract(input.getAmount()));
            accountRepository.save(account);

            Card card = cardRepository.findByUserId(user.getId());
            card.setCurrentBalance(account.getCurrentBalance().subtract(input.getAmount()));
            cardRepository.save(card);

            savingRepositoy.save(saving);
            return SavingMoneyOutput.builder().status(Constants.STATUS_SUCCESS).build();
        }


    }
}
