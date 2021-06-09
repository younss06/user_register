package com.register.service;


import com.register.model.CountryModel;

public interface CountryService {

   CountryModel save(CountryModel countryModel);
   CountryModel findById(String id);
   CountryModel findByCode(String code);
}
