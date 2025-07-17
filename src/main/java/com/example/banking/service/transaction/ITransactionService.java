package com.example.banking.service.transaction;


import com.example.banking.model.req.DepositReq;
import com.example.banking.model.req.TransferReq;
import com.example.banking.model.req.WithdrawReq;

public interface ITransactionService {
    String deposit(DepositReq req);
    String transfer(TransferReq req);
    String withdraw(WithdrawReq req);
}
