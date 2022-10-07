package com.inha.fabricApp.model;

import java.time.LocalDateTime;

public class AccountHistory {

    private Long id;

    private String userId;

    private Integer income;

    private Integer outcome;

    private String bankName;

    private String accountNumber;

    private LocalDateTime timeStamp; // 예산을 사용하거나 또는 예산이 입금된 시각.

    private String remarks;

    private Boolean isAudited = false;
}
