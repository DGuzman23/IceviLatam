package com.uca.service;

import com.uca.model.Region;

import java.util.ArrayList;

public interface RegionService {

    ArrayList<Region> getAllRegion();

    Region getRegionById(int id);

}
