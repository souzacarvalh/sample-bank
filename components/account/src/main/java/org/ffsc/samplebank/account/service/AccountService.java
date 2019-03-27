package org.ffsc.samplebank.account.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ffsc.samplebank.account.entity.Account;
import org.ffsc.samplebank.account.exception.AccountNotFoundException;
import org.ffsc.samplebank.account.repository.AccountRepository;
import org.ffsc.samplebank.account.resource.AccountResource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Felipe Carvalho on 2019-03-10.
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountResource getAccountById(final String accountId) {
        Account account = Optional.ofNullable(accountRepository.findOne(accountId))
                .orElseThrow(() -> new AccountNotFoundException("Account not found."));
        return account.transform(AccountResource.class);
    }

    public List<AccountResource> listAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map(acct -> acct.transform(AccountResource.class)).collect(Collectors.toList());
    }

    public void createAccount(final AccountResource accountResource) {
        accountRepository.save(accountResource.transform(Account.class));
    }

    public void deleteAccount(final String accountId) {
        Account account = Optional.ofNullable(accountRepository.findOne(accountId))
                .orElseThrow(() -> new AccountNotFoundException("Account not found."));
        accountRepository.delete(account);
    }
}