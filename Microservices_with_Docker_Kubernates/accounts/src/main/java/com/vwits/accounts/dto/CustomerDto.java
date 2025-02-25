package com.vwits.accounts.dto;

import com.vwits.accounts.entity.Accounts;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {

    @NotNull(message = "Name can be null or empty!!!")
    @Size(min=2,max = 30,message = "The length of Customer Name should be between 2 to 30 ")
    private String name;

    @NotNull(message = "Email can be null or empty!!!")
    @Email(message = "Email Address should be valid value")
    private String email;

    @Pattern(message = "Mobile Number Must be 10 Digits",regexp = "(^$|[0-9]{10})")
    private String mobileNumber;

    private AccountsDto accountsDto;
}
