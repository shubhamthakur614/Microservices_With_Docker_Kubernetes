package com.vwits.accounts.dto;

import com.vwits.accounts.entity.Accounts;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Schema(
        name = "Customer",
        description = "Schema to Hold Customer and Account Information"
)
public class CustomerDto {

    @Schema(
            description = "Name of the Customer", example = "John Doe", required = true
    )
    @NotEmpty(message = "Name can be null or empty!!!")
    @Size(min = 2, max = 30, message = "The length of Customer Name should be between 2 to 30 ")
    private String name;

    @Schema(
            description = "Email Address of the Customer", example = "tjE5o@example.com", required = true
    )
    @NotEmpty(message = "Email can be null or empty!!!")
    @Email(message = "Email Address should be valid value")
    private String email;

    @Schema(
            description = "Mobile Number of the Customer", example = "1234567890", required = true
    )
    @Pattern(message = "Mobile Number Must be 10 Digits", regexp = "(^$|[0-9]{10})")
    private String mobileNumber;

    private AccountsDto accountsDto;
}
