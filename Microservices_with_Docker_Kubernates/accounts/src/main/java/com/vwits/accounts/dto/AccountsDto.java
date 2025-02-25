package com.vwits.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Schema(
        name = "Account",
        description = "Account Details"
)
@Data
public class AccountsDto {

    @Schema(
            description = "Account Number of the Customer", example = "1234567890"
    )
    @NotEmpty(message = "Account Number can not be null or Empty")
    @Pattern(message = "accountNumber Must be 10 Digits", regexp = "(^$|[0-9]{10})")
    private Long accountNumber;

    @Schema(
            description = "Account Type of the Customer", example = "Saving"
    )
    @NotEmpty(message = "Account Type can not be null or Empty")
    private String account_type;

    @Schema(
            description = " Branch Address of the Customer"
    )
    @NotEmpty(message = "Branch Address can not be null or Empty")
    private String branchAddress;
}
