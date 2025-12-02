package com.demofirma.messages.validations.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "ValidationError", description = "Description of the validation error")
public class ValidationErrorDto {

    @Schema(description = "Name of the field in which the error occurred", example = "email")
    private String field;
    @Schema(description = "The value entered by the user and which was rejected by the server", example = "error-gmail.com")
    private String rejectedValue;
    @Schema(description = "Message to user", example = "Must be a valid email address")
    private String message;
}
