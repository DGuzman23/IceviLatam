package com.uca.model;

import javax.persistence.*;

@Entity
@Table(name = "publications")
public class Publication {

    @Id
    @GeneratedValue(generator = "publications_publications_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "publications_publications_id_seq", sequenceName = "public.publications_publications_id_seq", allocationSize = 1)
    @Column(name = "publications_id")
    int id;

    @Column(name = "publications_title")
    String title;

    @Column(name = "publications_description")
    String description;

    @Column(name = "publications_link")
    String link;

    public Publication() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
