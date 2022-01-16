package com.mobei.tx.controller;

import com.mobei.tx.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Bank1Controller {

    @Autowired
    AccountInfoService accountInfoService;

    /**
     * 张三转账
     */
    @GetMapping("/transfer")
    public String transfer(@RequestParam Double amount) {
        accountInfoService.updateAccountBalance("1", amount);
        return "bank1" + 1000;
    }
}
