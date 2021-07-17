package com.uca.service;

import com.uca.model.Publication;

import java.util.ArrayList;

public interface PublicationService {

    void save(Publication publication);

    void edit(Publication publication);

    void delete(Publication publication);

    ArrayList<Publication> getAllPublications();

    Publication getPublicationById(int id);

}
