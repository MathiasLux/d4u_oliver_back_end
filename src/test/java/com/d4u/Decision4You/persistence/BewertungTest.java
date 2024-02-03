package com.d4u.Decision4You.persistence;

import com.d4u.Decision4You.TestFixtures;

import com.d4u.Decision4You.data.Benutzer;
import com.d4u.Decision4You.data.Bewertung;
import com.d4u.Decision4You.data.Bewertungsgegenstand;
import com.d4u.Decision4You.data.Rolle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
public class BewertungTest {
    @Autowired
    private BewertungRepository repository;
    @Autowired
    private BenutzerRepository benutzerRepository;
    @Autowired
    private BewertungsgegenstandRepository bewertungsgegenstandRepository;
    @Autowired
    private BewertungskriteriumRepository bewertungskriteriumRepository;




    @Test
    public void testCode() {
        Bewertung bewertung = TestFixtures.bewertung();
        bewertung.generiereCode();
        System.out.println(bewertung.getCode());
    }


    @Test
    public void testLink() {
        Bewertung bewertung = new Bewertung();
        Benutzer benutzer = Benutzer.builder()
                .vorname("ben")
                .nachname("utzer")
                .rolle(Rolle.BEWERTER)
                .email("benutzer@spg.at")
                .handyNummer("0245465435")
                .gebDatum("01.10.2010")
                .build();
        benutzerRepository.save(benutzer);
        repository.save(bewertung);
        bewertung.generiereLink(benutzer);
        bewertung.generiereLink(benutzer);

        System.out.println(benutzer.getId());

     System.out.println(bewertung.generiereLink(benutzer));
    }


    @Test
    public void testBewerter() {
        Benutzer benutzer = TestFixtures.benutzer();
        List<Benutzer> teilnehmendeBenutzer = new ArrayList<>();
        teilnehmendeBenutzer.add(benutzer);
        System.out.println(teilnehmendeBenutzer);
    }

    @Test
    public void testBewertungsgegenstand() {
        Bewertungsgegenstand gegenstand = Bewertungsgegenstand.builder()
                .gegenstandName("Hotel")
                .beschreibung("Hotels vergleichen")
                .build();
        bewertungsgegenstandRepository.save(gegenstand);
        System.out.println(gegenstand);

    }

}
