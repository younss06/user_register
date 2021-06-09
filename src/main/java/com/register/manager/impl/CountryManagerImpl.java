package com.register.manager.impl;

import com.register.manager.CountryManager;
import com.register.manager.mapper.converter.CountryConverter;
import com.register.manager.mapper.dto.CountryDto;
import com.register.model.CountryModel;
import com.register.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountryManagerImpl implements CountryManager {

    private CountryService countryService;
    private CountryConverter countryConverter;

    @Override
    public String createCountry(CountryDto countryDto) {

        CountryModel country = countryConverter.convertFrom(countryDto);
        return countryService.save(country).getId();
    }
}
