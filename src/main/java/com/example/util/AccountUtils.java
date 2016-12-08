package com.example.util;

import com.example.dto.*;
import com.example.entity.Account;
import com.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountUtils {

    public Account convertDtoToEntityForCreate(AccountDtoForCreate dtoForCreate) {
        Account account = new Account();
        account.setUsername(dtoForCreate.getUsername());
        account.setPassword(dtoForCreate.getPassword());
        account.setName(dtoForCreate.getName());
        account.setSurname(dtoForCreate.getSurname());
        return account;
    }

    public Account convertDtoToEntityForUpdate(AccountDtoForUpdate dtoForUpdate) {
        Account account = new Account();
        account.setId(dtoForUpdate.getId());
        account.setUsername(dtoForUpdate.getUsername());
        account.setPassword(dtoForUpdate.getPassword());
        account.setSurname(dtoForUpdate.getSurname());
        account.setName(dtoForUpdate.getName());
        return account;
    }

    public AccountDtoForGet convertEntityToDtoForGet(Account account) {
        AccountDtoForGet accountDtoForGet = new AccountDtoForGet();
        accountDtoForGet.setId(account.getId());
        accountDtoForGet.setPassword(account.getPassword());
        accountDtoForGet.setUsername(account.getUsername());
        accountDtoForGet.setName(account.getName());
        accountDtoForGet.setSurname(account.getSurname());
        return accountDtoForGet;
    }

    public AccountDtoForSimpleGet convertEntityToDtoForSimpleGet(Account account) {
        AccountDtoForSimpleGet dtoForSimpleGet = new AccountDtoForSimpleGet();
        dtoForSimpleGet.setId(account.getId());
        dtoForSimpleGet.setUsername(account.getUsername());
        return dtoForSimpleGet;
    }

    public AccountDtoWithoutPassword convertEntityToDtoWithoutPassword(Account account) {
        AccountDtoWithoutPassword dtoWithoutPassword = new AccountDtoWithoutPassword();
        dtoWithoutPassword.setId(account.getId());
        dtoWithoutPassword.setUsername(account.getUsername());
        dtoWithoutPassword.setName(account.getName());
        dtoWithoutPassword.setSurname(account.getSurname());
        return dtoWithoutPassword;
    }

}
