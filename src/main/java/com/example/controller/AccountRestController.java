package com.example.controller;

import com.example.dto.*;
import com.example.exception.HttpMessage;
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
    public AccountDtoForGet getAccount(@PathVariable("id") Long id) throws EntityNotFoundException {
        return accountService.getAccount(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public AccountDtoWithoutPassword createAccount(@RequestBody AccountDtoForCreate dto) {
        return accountService.createAccount(dto);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpMessage updateAccount(@RequestBody AccountDtoForUpdate dto) {
        HttpMessage httpMessage;
        try {
            accountService.updateAccount(dto);
            return httpMessage = new HttpMessage("OK");
        } catch (Exception ex) {
            return httpMessage = new HttpMessage("ERROR", ex.getMessage());
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public HttpMessage deleteAccount(@PathVariable("id") Long id) {
        HttpMessage httpMessage;
        try {
            accountService.deleteAccount(id);
            return httpMessage = new HttpMessage("OK");
        } catch (Exception ex) {
            return httpMessage = new HttpMessage("ERROR", ex.getMessage());
        }
    }

    @RequestMapping(value = "/generateAccounts")
    public HttpMessage generateAccounts() {
        HttpMessage httpMessage;
        try {
            accountService.generateRandomAccounts();
            return httpMessage = new HttpMessage("OK");
        } catch (Exception ex) {
            return httpMessage = new HttpMessage("ERROR", ex.getMessage());
        }
    }

}
