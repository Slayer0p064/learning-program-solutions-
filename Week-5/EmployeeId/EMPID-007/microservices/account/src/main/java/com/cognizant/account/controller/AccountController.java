package com.cognizant.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/accounts")
public class AccountController {
        @GetMapping("/{number}")
        public Map<String, Object> getAccount(@PathVariable String number) {
            Map<String, Object> account = new HashMap<>();
            account.put("number", "00987987973432");
            account.put("type", "savings");
            account.put("balance", 2000000);
            return account;
        }
    }

