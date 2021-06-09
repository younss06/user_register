package com.register.common.exceptionhandler;

import lombok.Getter;

/**
 * The CustomErrorCode Enum
 *
 * @author Younuss EL KASSMI
 */
public enum CustomErrorCode {
    MISSING_ID("common.missing-id"),
    NOT_FOUND("common.not-found"),
    REQUIRED_FIELD("common.required-field"),
    COUNTRY_REQUIREMENT("users.country-must-be-france"),
    AGE_REQUIREMENT("users.age-must-be-greater-than-eighteen");

    @Getter
    private final String value;

    CustomErrorCode(String value) {
        this.value = value;
    }
}
