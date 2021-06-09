package com.register.manager.mapper.dto;

import com.register.common.exceptionhandler.CustomErrorCode;
import com.register.common.exceptionhandler.ValidationMessage;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


/**
 * The Country DTO
 *
 * @author Younuss EL KASSMI
 */
@Getter
@Setter
@Builder
public class CountryDto {

    /**
     * the code of the country Ex: FR is the code for France
     */
    private String code;

    /**
     * the name of country, Eg: France, Spain .....
     */
    private String value;

    /**
     * the country whose users can subscribe (true = can subscribe)
     */
    private Boolean allowed;

    public void validate() {
        List<ValidationMessage> validationMessages = new ArrayList<>();
        if (code == null || code.isEmpty()) {
            validationMessages.add(new ValidationMessage(
                    "code",
                    "",
                    getClass().getSimpleName(),
                    CustomErrorCode.REQUIRED_FIELD
            ));
        }
        if (value == null || value.isEmpty()) {
            validationMessages.add(new ValidationMessage(
                    "value",
                    "",
                    getClass().getSimpleName(),
                    CustomErrorCode.REQUIRED_FIELD
            ));
        }
        if (allowed == null || allowed.toString().isEmpty()) {
            validationMessages.add(new ValidationMessage(
                    "allowed",
                    "",
                    getClass().getSimpleName(),
                    CustomErrorCode.REQUIRED_FIELD
            ));
        }
    }
}
