package com.vwits.accounts.mapper;

import com.vwits.accounts.dto.AccountsDto;
import com.vwits.accounts.entity.Accounts;

public class AccountsMapper {

    public static AccountsDto mapToAccountsDto(Accounts accounts,AccountsDto accountsDto) {
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccount_type(accounts.getAccount_type());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        return accountsDto;
    }

    public static Accounts mapToAccounts(AccountsDto accountsDto,Accounts accounts) {
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccount_type(accountsDto.getAccount_type());
        accounts.setBranchAddress(accountsDto.getBranchAddress());
        return accounts;
    }
}
