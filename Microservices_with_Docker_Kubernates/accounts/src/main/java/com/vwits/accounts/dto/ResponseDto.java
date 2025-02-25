package com.vwits.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(
        name = "Response",
        description = "Schema to hold Successful response information"
)
@Data
@AllArgsConstructor
public class ResponseDto {

    @Schema(
            description = "Status Code of the Response",example = "200"
    )
    private String statusCode;

    @Schema(
            description = "Request processed Successfully",example = "Success"
    )
    private String statusMessage;
}
