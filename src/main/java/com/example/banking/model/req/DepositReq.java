package com.example.banking.model.req;

import lombok.Data;

@Data
public class DepositReq {
    private String cardId;
    private Double amount;

}
