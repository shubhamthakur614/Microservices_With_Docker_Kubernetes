package com.vwits.accounts.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDto {
    @NotNull(message = "Account Number can not be null or Empty")
    @Pattern(message = "accountNumber Must be 10 Digits",regexp = "(^$|[0-9]{10})")
    private Long accountNumber;

    @NotNull(message = "Account Type can not be null or Empty")
    private String account_type;

    @NotNull(message = "Branch Address can not be null or Empty")
    private String branchAddress;
}
