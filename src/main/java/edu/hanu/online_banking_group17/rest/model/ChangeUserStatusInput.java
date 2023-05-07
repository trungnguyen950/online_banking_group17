package edu.hanu.online_banking_group17.rest.model;

import lombok.Data;

@Data
public class ChangeUserStatusInput {
    private Long id;
    private Integer status;
}
