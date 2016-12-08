package com.example.controller;

import com.example.dto.AccountDto;
import com.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping(value = "/account")
public class AccountRestController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public AccountDto getAccount(@PathVariable("id") Long id) throws EntityNotFoundException {
        return accountService.getAccount(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createAccount(@RequestBody AccountDto dto) {
        accountService.createAccount(dto);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateAccount(@RequestBody AccountDto dto) {
        accountService.updateAccount(dto);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteAccount(@PathVariable("id") Long id) {
        accountService.deleteAccount(id);
    }

    @RequestMapping(value = "/generateAccounts")
    public void generateAccounts() {
        accountService.generateRandomAccounts();
    }

}
