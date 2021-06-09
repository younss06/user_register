package com.register.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The User Entity
 * @author Younuss EL KASSMI
 */

@Getter
@Setter
@Document(collection = "users")
public class UserModel {
    @Id
    private String id;

    // required

    /** the first name of the user */
    private String firstName;

    /** the last name of the user */
    private String lastName;

    /** the age of the user */
    private Integer age;

    /** the country of the user */
    @DBRef
    private CountryModel country;


    // optional
    /** the address of user*/
    private String address;

    // TODO: other att
}
