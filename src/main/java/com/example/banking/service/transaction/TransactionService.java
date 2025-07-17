package com.example.banking.service.transaction;

import com.example.banking.entities.User;
import com.example.banking.model.req.DepositReq;
import com.example.banking.model.req.TransferReq;
import com.example.banking.model.req.WithdrawReq;
import com.example.banking.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class TransactionService implements ITransactionService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public String deposit(DepositReq req) {
        if (req.getAmount() == null || req.getAmount() <= 0) {
            throw new RuntimeException("ไม่สามารถฝากเงินได้ต่ำกว่า 0 บาท");
        }
        User user = userRepository.getUser(req.getCardId());
        user.setAmount(user.getAmount() + req.getAmount());
        userRepository.save(user);
        return "ฝากเงินสำเร็จ";
    }

    @Override
    @Transactional
    public String transfer(TransferReq req) {
        try {
            if (req.getAmount() == null || req.getAmount() <= 0) {
                throw new RuntimeException("ไม่สามารถฝากเงินได้ต่ำกว่า 0 บาท");
            }
            User fromUser = userRepository.getUser(req.getIdCard());
            User toUser = userRepository.getUser(req.getToIdCard());
            fromUser.setAmount(fromUser.getAmount() - req.getAmount());
            toUser.setAmount(toUser.getAmount() + req.getAmount());
            userRepository.save(fromUser);
            userRepository.save(toUser);
            return "โอนเงินสำเร็จ";
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String withdraw(WithdrawReq req) {
        if (req.getAmount() == null || req.getAmount() <= 0) {
            throw new RuntimeException("ไม่สามารถฝากเงินได้ต่ำกว่า 0 บาท");
        }
        User user = userRepository.getUser(req.getCardId());
        boolean b = user.getAmount() < req.getAmount();
        if (b) {
            throw new RuntimeException("ไม่สามารถถอนเงินได้ เนื่องจากยอดเงินไม่พอ");
        }
        user.setAmount(user.getAmount() - req.getAmount());
        return "ถอนเงินสำเร็จ";
    }
}
