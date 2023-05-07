package edu.hanu.online_banking_group17.rest.model;

import lombok.Data;

@Data
public class LoansInput {
    private String SNN;
    private String amount;
    private Long loansPackageID;
}
