package org.inha.models;

import java.time.LocalDateTime;
import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

@DataType
public class AccountHistory {

    @Property
    private Integer income;

    @Property
    private Integer outcome;

    @Property
    private String bankName;

    @Property
    private String accountNumber;

    @Property
    private LocalDateTime timeStamp; // 예산을 사용하거나 또는 예산이 입금된 시각.

    @Property
    private String remarks;

    @Property
    private Boolean isAudited = false;

    public AccountHistory(Integer income, Integer outcome, String bankName, String accountNumber,
            LocalDateTime timeStamp, String remarks) {
        this.income = income;
        this.outcome = outcome;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.timeStamp = timeStamp;
        this.remarks = remarks;
    }

}
