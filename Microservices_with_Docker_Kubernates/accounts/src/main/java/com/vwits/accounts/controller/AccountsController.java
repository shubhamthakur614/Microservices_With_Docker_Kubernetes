package com.vwits.accounts.controller;

import com.vwits.accounts.constants.AccountsConstants;
import com.vwits.accounts.dto.CustomerDto;
import com.vwits.accounts.dto.ErrorResponseDto;
import com.vwits.accounts.dto.ResponseDto;
import com.vwits.accounts.service.IAccountsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "EasyBank Account Management APIs",
        description = "The EasyBank Account Management API offers a full set of RESTful endpoints for performing CRUD operations on customer accounts. It supports the creation, updating, deletion, and retrieval of account details, ensuring efficient and seamless account management."
)
@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class AccountsController {

    private IAccountsService iAccountsService;

    @Operation(
            summary = "Create Account REST APIs",
            description = "This API is used to create a new account for a customer."
    )
    @ApiResponse(
            responseCode = "201", description = "Account created Successfully")
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto) {
        iAccountsService.createAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }


    @Operation(
            summary = "Fetch All Details REST APIs",
            description = "This API is used to fetch all details of a customer."
    )
    @ApiResponse(
            responseCode = "200", description = "Request processed Successfully"
    )
    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAllDetail(@RequestParam
                                                      @Pattern(message = "Mobile Number Must be 10 Digits", regexp = "(^$|[0-9]{10})")
                                                      String mobileNumber) {
        CustomerDto customerDto = iAccountsService.fetchAllDetails(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }

    @Operation(
            summary = "Update Account REST APIs",
            description = "This API is used to update account details of a customer."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Request processed Successfully"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "An error occured. Please try again or contact support",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class))
            )
            ,
            @ApiResponse(
                    responseCode = "417",
                    description = "Update operation failed please try again",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)))
    }

    )
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateDetails(@Valid @RequestBody CustomerDto customerDto) {
        boolean isUpdated = iAccountsService.updateAccount(customerDto);
        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AccountsConstants.STATUS_417, AccountsConstants.MESSAGE_417));
        }
    }

    @Operation(
            summary = "Delete Account REST APIs",
            description = "This API is used to delete account details of a customer."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Request processed Successfully"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "An error occured. Please try again or contact support",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)))

    })
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccount(@RequestParam
                                                     @Pattern(message = "Mobile Number Must be 10 Digits", regexp = "(^$|[0-9]{10})")
                                                     String mobileNumber) {
        boolean isDeleted = iAccountsService.deleteAccount(mobileNumber);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(AccountsConstants.MESSAGE_500, AccountsConstants.MESSAGE_500));
        }

    }
}
