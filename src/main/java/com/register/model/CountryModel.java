package com.register.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The Country Entity
 *
 * @author Younuss EL KASSMI
 */
@Getter
@Setter
@Builder
@Document(collection = "countries")
public class CountryModel {
    @Id
    private String id;

    /** the code of the country Ex: FR is the code for France*/
    private String code;

    /** the name of country, Eg: France, Spain .....  */
    private String value;

    /** the country whose users can subscribe (true = can subscribe) */
    private Boolean allowed;
}
