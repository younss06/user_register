package com.register.manager.mapper.converter;

import com.register.common.exceptionhandler.BusinessException;
import com.register.common.exceptionhandler.CustomErrorCode;
import com.register.model.CountryModel;
import com.register.model.UserModel;
import com.register.manager.mapper.dto.UserDto;
import com.register.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    @Autowired
    private CountryService countryService;

    public UserDto convertTo(UserModel source) {
        if (source == null)
            return null;
        return UserDto.builder()
                .id(source.getId())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .age(source.getAge())
                .countryCode(source.getCountry().getCode())
                .address(source.getAddress())
                .build();
    }

    public UserModel convertFrom(UserDto source) {
        if (source == null)
            return null;
        UserModel target = new UserModel();
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setAge(source.getAge());
        CountryModel country = countryService.findByCode(source.getCountryCode());
        if (country == null) {
            throw new BusinessException(CustomErrorCode.NOT_FOUND, HttpStatus.NOT_FOUND);
        } else if (!country.getAllowed()) {
            throw new BusinessException(CustomErrorCode.REQUIRED_FIELD, HttpStatus.BAD_REQUEST);
        }
        target.setCountry(country);
        target.setAddress(source.getAddress());
        return target;
    }

}
