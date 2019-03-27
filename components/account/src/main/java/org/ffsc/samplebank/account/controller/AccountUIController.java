package org.ffsc.samplebank.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Felipe Carvalho on 2019-03-10.
 */

@RestController
@RequestMapping("/account/admin")
public class AccountUIController {

    @GetMapping
    public String getAccount() {
        return "Welcome Page!";
    }
}