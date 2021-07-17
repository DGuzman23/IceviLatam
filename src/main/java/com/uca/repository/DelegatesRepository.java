package com.uca.repository;

import com.uca.model.Country;
import com.uca.model.Delegates;
import com.uca.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface DelegatesRepository extends JpaRepository<Delegates, Integer> {

    ArrayList<Delegates> findByCharge(String charge);

    ArrayList<Delegates> findByArea(boolean area);

    ArrayList<Delegates> findByCountry(Country country);

    ArrayList<Delegates> findByRegion(Region region);

}
