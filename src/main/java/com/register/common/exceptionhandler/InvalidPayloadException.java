package com.register.common.exceptionhandler;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;


/**
 * The InvalidPayloadException class
 *
 * @author Younuss EL KASSMI
 */
@Getter
@Setter
public class InvalidPayloadException extends RuntimeException {
    private HttpStatus status = HttpStatus.BAD_REQUEST;
    private List<ValidationMessage> validationMessages;

    public InvalidPayloadException(List<ValidationMessage> validationMessages) {
        super("Invalid payload");
        this.setValidationMessages(validationMessages);
    }
}
