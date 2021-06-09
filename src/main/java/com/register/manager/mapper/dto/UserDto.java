package com.register.manager.mapper.dto;

import com.register.common.exceptionhandler.CustomErrorCode;
import com.register.common.exceptionhandler.InvalidPayloadException;
import com.register.common.exceptionhandler.ValidationMessage;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


/**
 * The User DTO
 *
 * @author Younuss EL KASSMI
 */
@Getter
@Setter
@Builder
public class UserDto {

    /** the user generated id*/
    private String id;

    /** the first name of the user */
    private String firstName;

    /** the last name of the user */
    private String lastName;

    /** the age of the user */
    private Integer age;

    /** the user country code */
    private String countryCode;

    /** the user address*/
    private String address;

    // TODO: other att
    public void validate() {
        List<ValidationMessage> validationMessages = new ArrayList<>();
        if (firstName == null || firstName.isEmpty()) {
            validationMessages.add(new ValidationMessage(
                    "firstName",
                    "",
                    getClass().getSimpleName(),
                    CustomErrorCode.REQUIRED_FIELD
            ));
        }
        if (lastName == null || lastName.isEmpty()) {
            validationMessages.add(new ValidationMessage(
                    "lastName",
                    "",
                    getClass().getSimpleName(),
                    CustomErrorCode.REQUIRED_FIELD
            ));
        }
        if (age == null) {
            validationMessages.add(new ValidationMessage(
                    "age",
                    "",
                    getClass().getSimpleName(),
                    CustomErrorCode.REQUIRED_FIELD
            ));
        } else if (age < 18) {
            validationMessages.add(new ValidationMessage(
                    "age",
                    String.valueOf(age),
                    getClass().getSimpleName(),
                    CustomErrorCode.AGE_REQUIREMENT
            ));
        }
        if (countryCode == null) {
            validationMessages.add(new ValidationMessage(
                    "countryCode",
                    "",
                    getClass().getSimpleName(),
                    CustomErrorCode.REQUIRED_FIELD
            ));
        }

        if (!validationMessages.isEmpty()) {
            throw new InvalidPayloadException(validationMessages);
        }
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", countryCode=" + countryCode +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
