package com.vwits.accounts.service;

import com.vwits.accounts.dto.CustomerDto;

public interface IAccountsService {


    /**
     *
     * @param customerDto
     */
    void createAccount(CustomerDto customerDto);
}
