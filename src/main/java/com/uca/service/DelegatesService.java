package com.uca.service;

import com.uca.model.Country;
import com.uca.model.Delegates;
import com.uca.model.Region;

import java.util.ArrayList;

public interface DelegatesService {

    ArrayList<Delegates> findByCharge(String charge);

    ArrayList<Delegates> findByArea(boolean area);

    ArrayList<Delegates> findByCountry(Country country);

    ArrayList<Delegates> findByRegion(Region region);

    ArrayList<Delegates> getAllDelegates();

    Delegates getDelegateById(int id);

    void save(Delegates delegate);
}
