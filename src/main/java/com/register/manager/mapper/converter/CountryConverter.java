package com.register.manager.mapper.converter;

import com.register.model.CountryModel;
import com.register.manager.mapper.dto.CountryDto;
import com.register.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountryConverter {
    @Autowired
    private CountryService countryService;

    public CountryDto convertTo(CountryModel source) {
        if (source == null)
            return null;
        return CountryDto.builder()
                .code(source.getCode())
                .value(source.getValue())
                .allowed(source.getAllowed())
                .build();
    }

    public CountryModel convertFrom(CountryDto source) {
        if (source == null)
            return null;
        CountryModel target = CountryModel.builder()
                .code(source.getCode())
                .value(source.getValue())
                .allowed(source.getAllowed())
                .build();
        return target;
    }
}
