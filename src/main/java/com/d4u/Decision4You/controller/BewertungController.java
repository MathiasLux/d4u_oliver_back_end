package com.d4u.Decision4You.controller;

import org.springframework.ui.Model;
import com.d4u.Decision4You.data.Bewertung;
import com.d4u.Decision4You.service.BewertungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class BewertungController {
    @Autowired
    private BewertungService bewertungService;

    @GetMapping("/bewertung/{code}")
    public String bewertungAnzeigen(@PathVariable String code, Model model) {
        Bewertung bewertung = bewertungService.findByCode(code);

        if (bewertung != null) {
            // Hier kann man die Bewertungsinformationen an das View-Model übergeben
            model.addAttribute("bewertung", bewertung);
            return "bewertung"; // Der Name des Views für die Bewertungsanzeige
        } else {
            return "redirect:/fehlerseite"; // Wenn der Code nicht gefunden wurde, zur Fehlerseite weiterleiten
            //also es ist eine Option, dass wir eine Fehler Seite haben. oder halt ein pop-up
        }
    }
}
