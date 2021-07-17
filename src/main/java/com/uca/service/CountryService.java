package com.uca.service;

import com.uca.model.Country;

import java.util.ArrayList;

public interface CountryService {

    ArrayList<Country> getAllCountry();

    Country getCountryById(int id);
}
