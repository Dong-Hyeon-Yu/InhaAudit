package com.inha.fabricApp.usecase;

import com.inha.fabricApp.model.AccountHistory;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    static final AtomicLong historyNo = new AtomicLong(0);

    @Override
    public List<AccountHistory> getAccountHistoryBetween(Date start, Date end) {
        return null;
    }

    @Override
    public void addAccountHistory(AccountHistory newHistory) {

    }

    @Override
    public void deleteAccountHistory(String historyId) {

    }

    @Override
    public void updateAccountHistory(AccountHistory param) {

    }
}
