package com.d4u.Decision4You;

import com.d4u.Decision4You.data.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestFixtures {
    public static Bewertungsgegenstand bewertungsgegenstand() {
        return Bewertungsgegenstand.builder()
                .gegenstandName("Testgegenstand")
                .beschreibung("Testbeschreibung")
                .bewertungen(new ArrayList<>())
                .build();
    }

    public static Benutzer benutzer() {
        return Benutzer.builder()
                .vorname("TestVorname")
                .nachname("TestNachname")
                .email("test@example.com")
                .handyNummer("123456789")
                .gebDatum("2000-01-01")
                .rolle(Rolle.BEWERTER)
                .build();
    }

    public static Bewertung bewertung(/*List<Bewertungskriterium> kriterium, List<Benutzer> benutzer, String code, String link*/) {
        return Bewertung.builder()
                .name("TestBewertung")
                .bewertungsgegenstand(bewertungsgegenstand())
                .erstellungsdatum(LocalDateTime.now())
                .build();
    }

    public static List<Bewertungskriterium> bewertungskriterien() {
        List<Bewertungskriterium> bewertungskriterien = new ArrayList<>();
        bewertungskriterien.add(Bewertungskriterium.builder()
                .kriteriumName("Kriterium1")
                .beschreibung("Beschreibung1")
                .gewichtung(3)
                .build());
        bewertungskriterien.add(Bewertungskriterium.builder()
                .kriteriumName("Kriterium2")
                .beschreibung("Beschreibung2")
                .gewichtung(5)
                .build());

        return bewertungskriterien;
    }
}
