package com.cognizant.spring_learn.services;

import com.cognizant.spring_learn.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final List<Country> countryList;
    private final Country country;

    @Autowired
    public CountryService(List<Country> countryList, Country country) {
        this.countryList = countryList;
        this.country = country;
    }

    public Country getCountry(String code) {
        return countryList.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }

    public Country getDefaultCountry() {
        return country;
    }
}
