package com.uca.service;

import com.uca.model.Publication;
import com.uca.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PublicationServiceImpl implements PublicationService {

    @Autowired
    PublicationRepository publicationRepository;

    @Override
    public void save(Publication publication) {
        publicationRepository.save(publication);
    }

    @Override
    public void edit(Publication publication) {
        publicationRepository.save(publication);
    }

    @Override
    public void delete(Publication publication) {
        publicationRepository.delete(publication);
    }

    @Override
    public ArrayList<Publication> getAllPublications() {
        ArrayList<Publication> publications = (ArrayList<Publication>) publicationRepository.findAll();
        return publications;
    }

    @Override
    public Publication getPublicationById(int id) {
        Publication publication = publicationRepository.getOne(id);
        return publication;
    }
}
