package edu.hanu.online_banking_group17.rest.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoansMoneyOutput {
    private String status;
}