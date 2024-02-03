package com.d4u.Decision4You.service;

import com.d4u.Decision4You.data.Bewertung;
import com.d4u.Decision4You.persistence.BewertungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BewertungService {
    @Autowired
    private BewertungRepository bewertungRepository;

    public Bewertung findByCode(String code) {
        return bewertungRepository.findByCode(code);
    }
}
