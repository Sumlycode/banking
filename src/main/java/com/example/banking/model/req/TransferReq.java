package com.example.banking.model.req;
import lombok.Data;

@Data
public class TransferReq {
    private String toIdCard;
    private String idCard;
    private Double amount;
}