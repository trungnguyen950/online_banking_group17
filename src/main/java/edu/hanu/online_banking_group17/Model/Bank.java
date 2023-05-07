package edu.hanu.online_banking_group17.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "bank")
@Data
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "bankCode")
    private String bankCode;

    @Column(name = "bankName")
    private String bankName;

    @Column(name = "bankMoney")
    private Long bankMoney;
}
