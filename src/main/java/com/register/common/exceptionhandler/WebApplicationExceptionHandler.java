package com.register.common.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * The WebApplicationExceptionHandler class
 *
 * @author Younuss EL KASSMI
 */

@RestControllerAdvice
public class WebApplicationExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> handleBusinessException(BusinessException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String errorMessage = ex.getErrorCode() != null ? ex.getErrorCode().getValue() : ex.getMessage();
        return new ResponseEntity<>(errorMessage, headers, ex.getStatus());
    }

    @ExceptionHandler(InvalidPayloadException.class)
    public ResponseEntity<List<ValidationMessage>> handleInvalidPayloadException(InvalidPayloadException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(ex.getValidationMessages(), headers, ex.getStatus());
    }

}
