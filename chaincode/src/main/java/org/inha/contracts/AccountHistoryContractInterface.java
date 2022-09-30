package org.inha.contracts;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.hyperledger.fabric.contract.Context;
import org.inha.models.AccountHistory;

public interface AccountHistoryContractInterface {


    /**
     * @param ctx hyperledger fabric transaction context
     * @param income income price
     * @param outcome outcome price
     * @param bankName bank name of the account
     * @param accountNumber the number of the account to get income or outcome.
     * @param timeStamp the datetime of this transaction on this account.
     * @param remarks extra information to be noted.
     */
    void createAccountHistory(Context ctx, Integer income, Integer outcome, String bankName,
            String accountNumber, LocalDateTime timeStamp, String remarks);

    /**
     * @param ctx hyperledger fabric transaction context
     * @param historyId target id to modify
     * @param income income price
     * @param outcome outcome price
     * @param bankName bank name of the account
     * @param accountNumber the number of the account to get income or outcome.
     * @param timeStamp the datetime of this transaction on this account.
     * @param remarks extra information to be noted.
     */
    void updateAccountHistory(Context ctx, String historyId, Integer income, Integer outcome,
            String bankName, String accountNumber, LocalDateTime timeStamp, String remarks);

    /**
     * @param ctx hyperledger fabric transaction context
     * @param historyId target id to delete
     */
    void deleteAccountHistory(Context ctx, String historyId);

    /**
     *
     * @param ctx hyperledger fabric transaction context
     * @param historyId target id to get one history record.
     * @return One history record whose id is {@code historyId}
     */
    AccountHistory getAccountHistory(Context ctx, String historyId);

    /**
     *
     * @param ctx hyperledger fabric transaction context
     * @param startDate
     * @param endDate
     * @return history records between {@code startDate} and {@code endDate}
     */
    List<AccountHistory> getAccountHistoriesBetween(Context ctx, Date startDate, Date endDate);

}
