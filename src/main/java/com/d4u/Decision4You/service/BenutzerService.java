package com.d4u.Decision4You.service;

import com.d4u.Decision4You.data.Benutzer;
import com.d4u.Decision4You.persistence.BenutzerRepository;
import com.d4u.Decision4You.persistence.exception.DataQualityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenutzerService {
    @Autowired
    private BenutzerRepository benutzerRepository;

    public Benutzer findById(Long id) {
        return benutzerRepository.findById(id).orElse(null);
    }

    public List<Benutzer> findAllBenutzer() {
        return benutzerRepository.findAll();
    }

    public Benutzer saveBenutzer(Benutzer benutzer) {
        return benutzerRepository.save(benutzer);
    }

    public void deleteBenutzerId(Long id) {
        benutzerRepository.deleteById(id);
    }

    public Benutzer updateBenutzer(Benutzer benutzer) {
        Long benutzerId = benutzer.getId();
        if (benutzerId == null || !benutzerRepository.existsById(benutzerId)) {
            throw new DataQualityException("Benutzer nicht geunden");
        }
        return benutzerRepository.save(benutzer);
    }
}
