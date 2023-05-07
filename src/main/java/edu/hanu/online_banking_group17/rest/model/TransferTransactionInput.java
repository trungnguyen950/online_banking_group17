package edu.hanu.online_banking_group17.rest.model;

import lombok.Data;

@Data
public class TransferTransactionInput {

    private Long bankReceiveId;
    private String accountNumber;
    private String amount;
    private String description;
}
