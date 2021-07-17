package com.uca.service;

import com.uca.model.Country;
import com.uca.model.Delegates;
import com.uca.model.Region;
import com.uca.repository.DelegatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DelegatesServiceImpl implements DelegatesService {

    @Autowired
    DelegatesRepository delegatesRepository;

    @Override
    public ArrayList<Delegates> findByCharge(String charge) {
        ArrayList<Delegates> delegates = delegatesRepository.findByCharge(charge);
        return delegates;
    }

    @Override
    public ArrayList<Delegates> findByArea(boolean area) {
        ArrayList<Delegates> delegates = delegatesRepository.findByArea(area);
        return delegates;
    }

    @Override
    public ArrayList<Delegates> findByCountry(Country country) {
        ArrayList<Delegates> delegates = delegatesRepository.findByCountry(country);
        return delegates;
    }

    @Override
    public ArrayList<Delegates> findByRegion(Region region) {
        ArrayList<Delegates> delegates = delegatesRepository.findByRegion(region);
        return delegates;
    }

    @Override
    public ArrayList<Delegates> getAllDelegates() {
        ArrayList<Delegates> delegates = (ArrayList<Delegates>) delegatesRepository.findAll();
        return delegates;
    }

    @Override
    public Delegates getDelegateById(int id) {
        Delegates delegate = delegatesRepository.getOne(id);
        return delegate;
    }

    @Override
    public void save(Delegates delegate) {
        delegatesRepository.save(delegate);
    }

}
