package com.example.util;

import com.example.dto.AccountDto;
import com.example.entity.Account;
import com.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountUtils {

    @Autowired
    private AccountRepository accountRepository;

    public AccountDto convertEntityToDto(Account account) {
        AccountDto dto = new AccountDto();
        dto.setId(account.getId());
        dto.setUsername(account.getUsername());
        dto.setName(account.getName());
        dto.setSurname(account.getSurname());
        dto.setPassword(account.getPassword());
        return dto;
    }

    public Account convertDtoToEntity(AccountDto dto) {
        Account account = new Account();
        account.setId(dto.getId()); //For method update
        account.setPassword(dto.getPassword());
        account.setUsername(dto.getUsername());
        account.setName(dto.getName());
        account.setSurname(dto.getSurname());
        return account;
    }

}
