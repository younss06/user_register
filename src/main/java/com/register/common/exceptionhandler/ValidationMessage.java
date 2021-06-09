package com.register.common.exceptionhandler;

import lombok.Getter;
import lombok.Setter;


/**
 * The ValidationMessage class
 *
 * @author Younuss EL KASSMI
 */

@Getter
@Setter
public class ValidationMessage {
    private String field;
    private String rejectedValue;
    private String objectName;
    private CustomErrorCode errorCode;

    public ValidationMessage() {
    }

    public ValidationMessage(String field, String rejectedValue, String objectName, CustomErrorCode errorCode) {
        this.field = field;
        this.rejectedValue = rejectedValue;
        this.objectName = objectName;
        this.errorCode = errorCode;
    }
}
