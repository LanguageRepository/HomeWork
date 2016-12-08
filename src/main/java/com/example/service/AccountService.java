package com.example.service;

import com.example.dto.AccountDto;
import com.example.entity.Account;
import com.example.repository.AccountRepository;
import com.example.util.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountUtils accountUtils;

    @Transactional
    public void createAccount(AccountDto dto) {
        accountRepository.save(accountUtils.convertDtoToEntity(dto));
    }

    @Transactional
    public AccountDto getAccount(Long id) {
        return accountUtils.convertEntityToDto(accountRepository.getOne(id));
    }

    @Transactional
    public void updateAccount(AccountDto dto) {
        accountRepository.saveAndFlush(accountUtils.convertDtoToEntity(dto));
    }

    @Transactional
    public void deleteAccount(Long id) {
        accountRepository.delete(id);
    }

    @Transactional
    public void generateRandomAccounts() {
        List<Account> accounts = new ArrayList<>();
        int index;
        String data;
        for(int i = 0; i <= 10; i++) {
            data = getRandomUsername();
            accounts.add(new Account(data, data));
            accountRepository.save(accounts.get(i));
        }
    }

    private String getRandomUsername() {
        String[] usernames = {"Meanal", "Ilindu", "Danayn", "Conind", "Orderi", "Baicetoll",
                "Mbra", "Azic", "Orinnesac", "Kabawamic", "Erele", "Vefo", "Aronk",
                "Qulil", "Xiesht", "Zsisttya", "Kareri", "Beri", "Dyedatha", "Ynnanam",
                "Unen", "Plaracear", "Wiel", "Kacis", "Janainye", "Gonze", "Kamanton",
                "Pabrto", "Xydai", "Nema", "Islira", "Stenn", "Daxa", "Xioni", "Her",
                "Atana", "Get", "Medvo", "Ndena", "Qus", "Ndol", "Myaraga", "Enil"};
        return usernames[(int)(Math.random()*(usernames.length-1))];
    }

}
