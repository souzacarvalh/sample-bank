package org.ffsc.samplebank.account.controller;

import lombok.RequiredArgsConstructor;
import org.ffsc.samplebank.account.resource.AccountResource;
import org.ffsc.samplebank.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Felipe Carvalho on 2019-03-10.
 */

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {

    @Autowired
    private final AccountService accountService;

    @GetMapping("/{accountId}")
    public AccountResource getAccount(@PathVariable String accountId) {
        return accountService.getAccountById(accountId);
    }

    @GetMapping
    public List<AccountResource> listAccounts() {
        return accountService.listAccounts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccount(@Valid AccountResource accountResource) {
        accountService.createAccount(accountResource);
    }

    @DeleteMapping("/{accountId}")
    @ResponseStatus(HttpStatus.GONE)
    public void deleteAccount(@PathVariable String accountId) {
        accountService.deleteAccount(accountId);
    }
}