package com.vwits.accounts.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AccountsDto {
    private Long accountNumber;

    private String account_type;

    private String branchAddress;
}
