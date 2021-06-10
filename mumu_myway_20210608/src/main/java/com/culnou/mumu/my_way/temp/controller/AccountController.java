package com.culnou.mumu.my_way.temp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.culnou.mumu.my_way.temp.entity.mongo.Account;
import com.culnou.mumu.my_way.temp.service.AccountMongoService;


@RestController
public class AccountController {
	
	@Autowired
    private AccountMongoService accountService;

    @GetMapping("/accounts")
    public ResponseEntity< List< Account >> getAllAccount() {
        return ResponseEntity.ok().body(accountService.getAllAccount());
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity < Account > getAccountById(@PathVariable String id) {
        return ResponseEntity.ok().body(accountService.getAccountById(id));
    }

    @PostMapping("/accounts")
    public ResponseEntity < Account > createAccount(@RequestBody Account account) {
        return ResponseEntity.ok().body(this.accountService.createAccount(account));
    }

    @PutMapping("/accounts/{id}")
    public ResponseEntity < Account > updateAccount(@PathVariable String id, @RequestBody Account account) {
        account.setId(id);
        return ResponseEntity.ok().body(this.accountService.updateAccount(account));
    }

    @DeleteMapping("/accounts/{id}")
    public HttpStatus deleteAccount(@PathVariable String id) {
        this.accountService.deleteAccount(id);
        return HttpStatus.OK;
    }

}
