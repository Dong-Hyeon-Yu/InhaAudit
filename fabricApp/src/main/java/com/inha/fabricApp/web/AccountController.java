package com.inha.fabricApp.web;

import com.inha.fabricApp.model.AccountHistory;
import com.inha.fabricApp.usecase.AccountService;
import java.util.Date;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/history")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{org}/account/histories")
    public ResponseEntity<List<AccountHistory>> getAccountHistory(
            @PathVariable String org, @RequestParam Date start, @RequestParam Date end) {

        return ResponseEntity.ok(
                accountService.getAccountHistoryBetween(start, end));
    }
}
