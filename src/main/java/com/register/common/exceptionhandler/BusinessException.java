package com.register.common.exceptionhandler;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * The BusinessException class
 *
 * @author Younuss EL KASSMI
 */

@Getter
@Setter
public class BusinessException extends RuntimeException {

    private HttpStatus status;
    private CustomErrorCode errorCode;

    public BusinessException(CustomErrorCode errorCode, HttpStatus status) {
        super(errorCode.getValue());
        this.status = status;
        this.setErrorCode(errorCode);
    }
}
