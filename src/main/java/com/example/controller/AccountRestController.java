package com.example.controller;

import com.example.dto.*;
import com.example.exception.RestResult;
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
    public RestResult updateAccount(@RequestBody AccountDtoForUpdate dto) {
        RestResult restResult;
        try {
            accountService.updateAccount(dto);
            return restResult = new RestResult("OK");
        } catch (Exception ex) {
            return restResult = new RestResult("ERROR", ex.getMessage());
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public RestResult deleteAccount(@PathVariable("id") Long id) {
        RestResult restResult;
        try {
            accountService.deleteAccount(id);
            return restResult = new RestResult("OK");
        } catch (Exception ex) {
            return restResult = new RestResult("ERROR", ex.getMessage());
        }
    }

    @RequestMapping(value = "/generateAccounts")
    public RestResult generateAccounts() {
        RestResult restResult;
        try {
            accountService.generateRandomAccounts();
            return restResult = new RestResult("OK");
        } catch (Exception ex) {
            return restResult = new RestResult("ERROR", ex.getMessage());
        }
    }

}
