package com.d4u.Decision4You.service;


import com.d4u.Decision4You.data.Bewertungsgegenstand;
import com.d4u.Decision4You.persistence.BewertungsgegenstandRepository;
import com.d4u.Decision4You.persistence.exception.DataQualityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BewertungsgegenstandService {
    @Autowired
    private BewertungsgegenstandRepository bewertungsgegenstandRepository;

    public Bewertungsgegenstand findById(Long id) {
        return bewertungsgegenstandRepository.findById(id).orElse(null);
    }

    public List<Bewertungsgegenstand> findAll() {
        return bewertungsgegenstandRepository.findAll();
    }

    public void save(Bewertungsgegenstand bewertungsgegenstand) {
        bewertungsgegenstandRepository.save(bewertungsgegenstand);
    }

    public void deleteById(Long id) {
        bewertungsgegenstandRepository.deleteById(id);
    }
    public Bewertungsgegenstand updateBewertungsgegenstand(Bewertungsgegenstand bewertungsgegenstand) {
        Long bewertungsgegenstandId = bewertungsgegenstand.getId();
        if (bewertungsgegenstandId == null || !bewertungsgegenstandRepository.existsById(bewertungsgegenstandId)) {
            throw new DataQualityException("Benwertung nicht geunden");
        }
        return bewertungsgegenstandRepository.save(bewertungsgegenstand);
    }
}
