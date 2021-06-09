package com.register.controller;



import com.register.manager.CountryManager;
import com.register.manager.mapper.dto.CountryDto;
import com.register.controller.param.EndPointPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(EndPointPath.CountryResourcePath.COUNTRY)
public class CountryResource {

    private final CountryManager countryManager;

    @Autowired
    public CountryResource(CountryManager countryManager) {
        this.countryManager = countryManager;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CountryDto countryDto) {

        String id = countryManager.createCountry(countryDto);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
