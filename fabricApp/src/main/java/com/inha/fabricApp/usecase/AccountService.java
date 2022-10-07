package com.inha.fabricApp.usecase;

import com.inha.fabricApp.model.AccountHistory;
import java.util.Date;
import java.util.List;

public interface AccountService {

    List<AccountHistory> getAccountHistoryBetween(Date start, Date end);

    void addAccountHistory(AccountHistory newHistory);

    void deleteAccountHistory(String historyId);

    void updateAccountHistory(AccountHistory param);
}
