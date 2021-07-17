package com.uca.model;

import javax.persistence.*;

@Entity
@Table(name = "regions")
public class Region {

    @Id
    @GeneratedValue(generator = "regions_regions_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "regions_regions_id_seq", sequenceName = "public.regions_regions_id_seq", allocationSize = 1)
    @Column(name = "regions_id")
    int id;

    @Column(name = "regions_name")
    String name;

    public Region() {
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
}
