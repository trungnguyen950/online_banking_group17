package edu.hanu.online_banking_group17.rest.model;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SavingMoneyInput {
    private Long savingPackageID;
    private BigDecimal amount;
}
