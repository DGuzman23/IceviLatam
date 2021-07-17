package com.uca.service;

import com.uca.model.Country;
import com.uca.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryRepository countryRepository;

    @Override
    public ArrayList<Country> getAllCountry() {
        ArrayList<Country> countries = (ArrayList<Country>) countryRepository.findAll();
        return countries;
    }

    @Override
    public Country getCountryById(int id) {
        Country country = countryRepository.getOne(id);
        return country;
    }

}
