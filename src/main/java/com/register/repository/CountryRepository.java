package com.register.repository;

import com.register.model.CountryModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountryRepository extends MongoRepository<CountryModel, String> {
    CountryModel findByCode(String code);
}
