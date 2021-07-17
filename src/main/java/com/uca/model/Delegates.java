package com.uca.model;

import javax.persistence.*;

@Entity
@Table(name = "delegates")
public class Delegates {

    @Id
    @GeneratedValue(generator = "regions_regions_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "regions_regions_id_seq", sequenceName = "public.regions_regions_id_seq", allocationSize = 1)
    @Column(name = "delegates_id")
    int id;

    @Column(name = "delegates_name")
    String name;

    @Column(name = "delegates_last_name")
    String last;

    @Column(name = "delegates_charge")
    String charge;

    @Column(name = "delegates_area")
    boolean area;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "delegates_country_id")
    Country country;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "delegates_region_id")
    Region region;

    public Delegates() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public boolean isArea() {
        return area;
    }

    public void setArea(boolean area) {
        this.area = area;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

}
