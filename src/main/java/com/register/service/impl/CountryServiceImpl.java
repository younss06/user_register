package com.register.service.impl;

import com.register.model.CountryModel;
import com.register.repository.CountryRepository;
import com.register.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public CountryModel save(CountryModel countryModel) {
        return countryRepository.save(countryModel);
    }

    @Override
    public CountryModel findById(String id) {
        return countryRepository.findById(id)
                .orElse(null);
    }

    @Override
    public CountryModel findByCode(String code) {
        return countryRepository.findByCode(code);
    }
}
