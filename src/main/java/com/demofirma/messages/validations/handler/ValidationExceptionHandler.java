package com.demofirma.messages.validations.handler;

import com.demofirma.messages.validations.dto.ValidationErrorDto;
import com.demofirma.messages.validations.dto.ValidationErrorsDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * 06.05.2025
 * ni-xconnect-b2b-shop-registration
 *
 * @author Wladimir Weizen
 */
@Slf4j
@ControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorsDto> handleValidationException(
            MethodArgumentNotValidException e) {
        List<ValidationErrorDto> validationErrors = new ArrayList<>();
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        for (ObjectError error : errors) {
            FieldError fieldError = (FieldError) error;
            ValidationErrorDto errorDto = ValidationErrorDto.builder()
                    .field(fieldError.getField())
                    .message(fieldError.getDefaultMessage())
                    .build();
            if (fieldError.getRejectedValue() != null) {
                errorDto.setRejectedValue(fieldError.getRejectedValue().toString());
            }
            validationErrors.add(errorDto);
        }
        return ResponseEntity
                .badRequest()
                .body(ValidationErrorsDto.builder()
                        .errors(validationErrors)
                        .build());
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<ValidationErrorsDto> handleNotReadableException(
            HttpMessageNotReadableException e) {

        List<ValidationErrorDto> validationErrors = new ArrayList<>();
        String errorMessage = e.getMessage();
        String field = extractFieldName(errorMessage);
        String rejectedValue = extractRejectedValue(errorMessage);
        ValidationErrorDto errorDto = ValidationErrorDto.builder()
                .field(field != null ? field : "Unknown Field")
                .rejectedValue(rejectedValue != null ? rejectedValue : "Unknown Value")
                .message(e.getMessage())
                .build();
        validationErrors.add(errorDto);

        return ResponseEntity
                .badRequest()
                .body(ValidationErrorsDto.builder()
                        .errors(validationErrors)
                        .build());
    }

    private String extractFieldName(String errorMessage) {
        String prefix = "Cannot deserialize value of type `";
        int startIndex = errorMessage.indexOf(prefix);
        if (startIndex != -1) {
            int endIndex = errorMessage.indexOf("`", startIndex + prefix.length());
            if (endIndex != -1) {
                String fieldWithClass = errorMessage.substring(startIndex + prefix.length(), endIndex);
                return fieldWithClass.substring(fieldWithClass.lastIndexOf('.') + 1);
            }
        }
        return null;
    }

    private String extractRejectedValue(String errorMessage) {
        String prefix = "from String \"";
        int startIndex = errorMessage.indexOf(prefix);
        if (startIndex != -1) {
            int endIndex = errorMessage.indexOf("\"", startIndex + prefix.length());
            if (endIndex != -1) {
                return errorMessage.substring(startIndex + prefix.length(), endIndex);
            }
        }
        return null;
    }
}
