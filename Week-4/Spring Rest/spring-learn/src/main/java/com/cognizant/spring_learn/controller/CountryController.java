package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Country;
import com.cognizant.spring_learn.services.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    @GetMapping("/country/{code}")
    public Country getCountry(@PathVariable String code) {
        logger.info("START - getCountry() with code: {}", code);

        Country country = countryService.getCountry(code);

        logger.info("END - getCountry()");
        return country;
    }

    @GetMapping("/country")
    public Country getCountry() {
        Country country = new Country();
        country.setName("India");
        country.setCode("IN");
        return country;
    }
}
