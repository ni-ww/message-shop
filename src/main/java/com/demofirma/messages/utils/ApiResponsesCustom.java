package com.demofirma.messages.utils;

import com.demofirma.messages.validations.dto.ValidationErrorsDto;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ApiResponses(value = {
        @ApiResponse(
                responseCode = "400",
                description = "Request validation failed due to incorrect or missing data.",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = RuntimeException.class))),
        @ApiResponse(
                responseCode = "401",
                description = "User unauthorized",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = RuntimeException.class))),
        @ApiResponse(
                responseCode = "403",
                description = "Access denied",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = RuntimeException.class))),
        @ApiResponse(
                responseCode = "404",
                description = "Entity not found",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = RuntimeException.class))),
})
public @interface ApiResponsesCustom {
}


















