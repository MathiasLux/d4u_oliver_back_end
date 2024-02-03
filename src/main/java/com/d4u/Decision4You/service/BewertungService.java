package com.d4u.Decision4You.service;

import com.d4u.Decision4You.data.Benutzer;
import com.d4u.Decision4You.data.Bewertung;
import com.d4u.Decision4You.persistence.BewertungRepository;
import com.d4u.Decision4You.persistence.exception.DataQualityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BewertungService {
    @Autowired
    private BewertungRepository bewertungRepository;

    public Bewertung findByCode(String code) {
        return bewertungRepository.findByCode(code);
    }

    public List<Bewertung> findAllBewertungen() {
        return bewertungRepository.findAll();
    }

    public Bewertung saveBewertung(Bewertung bewertung) {
        return bewertungRepository.save(bewertung);
    }

    public void deleteBewertungById(Long id) {
        bewertungRepository.deleteById(id);
    }

    public Bewertung updateBewertung(Bewertung bewertung) {
        Long bewertungId = bewertung.getId();
        if (bewertungId == null || !bewertungRepository.existsById(bewertungId)) {
            throw new DataQualityException("Benwertung nicht geunden");
        }
        return bewertungRepository.save(bewertung);
    }
}
