package com.uca.service;

import com.uca.model.Region;
import com.uca.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RegionServiceImpl implements RegionService{

    @Autowired
    RegionRepository regionRepository;

    @Override
    public ArrayList<Region> getAllRegion() {
        ArrayList<Region> regions = (ArrayList<Region>) regionRepository.findAll();
        return regions;
    }

    @Override
    public Region getRegionById(int id) {
        Region region = regionRepository.getOne(id);
        return region;
    }

}
