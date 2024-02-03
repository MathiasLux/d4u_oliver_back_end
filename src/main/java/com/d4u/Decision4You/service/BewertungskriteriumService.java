package com.d4u.Decision4You.service;

import com.d4u.Decision4You.data.Bewertungsgegenstand;
import com.d4u.Decision4You.data.Bewertungskriterium;
import com.d4u.Decision4You.persistence.BewertungskriteriumRepository;
import com.d4u.Decision4You.persistence.exception.DataQualityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BewertungskriteriumService {
    @Autowired
    private BewertungskriteriumRepository bewertungskriteriumRepository;

    public Bewertungskriterium findById(Long id) {
        return bewertungskriteriumRepository.findById(id).orElse(null);
    }

    public List<Bewertungskriterium> findAll() {
        return bewertungskriteriumRepository.findAll();
    }

    public void save(Bewertungskriterium bewertungskriterium) {
        bewertungskriteriumRepository.save(bewertungskriterium);
    }

    public void deleteById(Long id) {
        bewertungskriteriumRepository.deleteById(id);
    }
    public Bewertungskriterium updateBewertungskriterium(Bewertungskriterium bewertungskriterium) {
        Long bewertungskriteriumId = bewertungskriterium.getId();
        if (bewertungskriteriumId == null || !bewertungskriteriumRepository.existsById(bewertungskriteriumId)) {
            throw new DataQualityException("Benwertung nicht geunden");
        }
        return bewertungskriteriumRepository.save(bewertungskriterium);
    }
}
