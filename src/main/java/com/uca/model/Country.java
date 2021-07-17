package com.uca.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(generator = "country_country_id_seq",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "country_country_id_seq", sequenceName = "public.country_country_id_seq", allocationSize = 1)
    @Column(name = "country_id")
    int id;

    @Column(name = "country_name")
    String name;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Delegates> delegatesList;

    public Country() {
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
