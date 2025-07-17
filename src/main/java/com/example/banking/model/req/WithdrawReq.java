package com.example.banking.model.req;
import lombok.Data;

@Data
public class WithdrawReq {
    private String cardId;
    private Double amount;
}
