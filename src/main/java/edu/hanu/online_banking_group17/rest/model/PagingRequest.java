package edu.hanu.online_banking_group17.rest.model;

import lombok.Data;

import java.util.List;

@Data
public class PagingRequest {
    private int start;
    private int length;
    private int draw;
    private List<Order> order;
    private List<Column> columns;
    private Search search;
}
