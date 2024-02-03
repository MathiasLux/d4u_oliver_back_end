package com.d4u.Decision4You.persistence;

import com.d4u.Decision4You.TestFixtures;
import com.d4u.Decision4You.data.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
public class BewertungRepositoryTest {
    @Autowired
    private BewertungRepository repository;
    @Autowired
    private BenutzerRepository benutzerRepository;
    @Autowired
    private BewertungsgegenstandRepository bewertungsgegenstandRepository;
    @Autowired
    private BewertungskriteriumRepository bewertungskriteriumRepository;

    @Test
    void ensureSaveAndReReadWork() {
        Benutzer benutzer = TestFixtures.benutzer();
        Bewertungsgegenstand bewertungsgegenstand = TestFixtures.bewertungsgegenstand();
        List<Bewertungskriterium> bewertungskriterien = TestFixtures.bewertungskriterien();
        //   Bewertung bewertung = TestFixtures.bewertung(benutzer, bewertungskriterien, bewertungsgegenstand);
        Bewertung bewertung = Bewertung.builder()
                .name("Schule")
                .bewertungskriterien(bewertungskriterien)
                .bewertungsgegenstand(bewertungsgegenstand)
                .benutzer(benutzer)
                .erstellungsdatum(LocalDateTime.now())
                .build();
//überprüfen, ob benutzer oder bewertung null sind
        if (benutzer == null || bewertung == null) {
            throw new IllegalStateException("benutzer oder bewertung ist null");
        }
        bewertung.addBenutzer(benutzer);
        bewertung.setBewertungsgegenstand(bewertungsgegenstand);
        bewertung.setBewertungskriterien(bewertungskriterien);

        benutzerRepository.save(benutzer);
        bewertungsgegenstandRepository.save(bewertungsgegenstand);
        bewertungskriteriumRepository.saveAll(bewertungskriterien);
        bewertung.generiereCode();
        bewertung.generiereLink(benutzer);

        //bewertung speichern
        var saved = repository.saveAndFlush(bewertung);

//überprüfen, ob die Bewertung gespeichert wurde
        assertThat(saved).isNotNull();
        assertThat(saved).isSameAs(bewertung);
        assertThat(saved.getId()).isNotNull();
    }

    @Test
    void ensureUpdateWorks() {
        Benutzer benutzer = TestFixtures.benutzer();
        Bewertungsgegenstand bewertungsgegenstand = TestFixtures.bewertungsgegenstand();
        List<Bewertungskriterium> bewertungskriterien = TestFixtures.bewertungskriterien();
        Bewertung bewertung = Bewertung.builder()
                .name("Schule")
                .bewertungskriterien(bewertungskriterien)
                .bewertungsgegenstand(bewertungsgegenstand)
                .benutzer(benutzer)
                .erstellungsdatum(LocalDateTime.now())
                .build();

        bewertung.addBenutzer(benutzer);
        bewertung.setBewertungsgegenstand(bewertungsgegenstand);
        bewertung.setBewertungskriterien(bewertungskriterien);

        benutzerRepository.save(benutzer);
        bewertungsgegenstandRepository.save(bewertungsgegenstand);
        bewertungskriteriumRepository.saveAll(bewertungskriterien);
        bewertung.generiereCode();
        bewertung.generiereLink(benutzer);

        var saved = repository.saveAndFlush(bewertung);
        saved.setName("bewertung2");
        Bewertung updateBewertung = repository.saveAndFlush(saved);
        assertThat(updateBewertung).isNotNull().isEqualTo(saved);
    }

    @Test
    void ensureDeleteWorks() {
        Benutzer benutzer = TestFixtures.benutzer();
        Bewertungsgegenstand bewertungsgegenstand = TestFixtures.bewertungsgegenstand();
        List<Bewertungskriterium> bewertungskriterien = TestFixtures.bewertungskriterien();
        Bewertung bewertung = Bewertung.builder()
                .name("Schule")
                .bewertungskriterien(bewertungskriterien)
                .bewertungsgegenstand(bewertungsgegenstand)
                .benutzer(benutzer)
                .erstellungsdatum(LocalDateTime.now())
                .build();

        bewertung.addBenutzer(benutzer);
        bewertung.setBewertungsgegenstand(bewertungsgegenstand);
        bewertung.setBewertungskriterien(bewertungskriterien);

        benutzerRepository.save(benutzer);
        bewertungsgegenstandRepository.save(bewertungsgegenstand);
        bewertungskriteriumRepository.saveAll(bewertungskriterien);
        bewertung.generiereCode();
        bewertung.generiereLink(benutzer);

        //bewertung speichern
        var saved = repository.saveAndFlush(bewertung);

        //bewertung löschen
        repository.delete(bewertung);

        //überprüfen, ob die Bewertung gelöscht wurde:
        assertThat(repository.findById(bewertung.getId())).isEmpty();
    }

    @Test
    void ensureFindAllWorks() {
        Benutzer benutzer = TestFixtures.benutzer();
        Bewertungsgegenstand bewertungsgegenstand = TestFixtures.bewertungsgegenstand();
        List<Bewertungskriterium> bewertungskriterien = TestFixtures.bewertungskriterien();
        Bewertung bewertung = Bewertung.builder()
                .name("bewertung")
                .bewertungskriterien(bewertungskriterien)
                .bewertungsgegenstand(bewertungsgegenstand)
                .benutzer(benutzer)
                .erstellungsdatum(LocalDateTime.now())
                .build();

        Bewertung bewertung1 = Bewertung.builder()
                .name("bewertung1")
                .bewertungskriterien(bewertungskriterien)
                .bewertungsgegenstand(bewertungsgegenstand)
                .benutzer(benutzer)
                .erstellungsdatum(LocalDateTime.now())
                .build();

        bewertung.addBenutzer(benutzer);
        bewertung.setBewertungsgegenstand(bewertungsgegenstand);
        bewertung.setBewertungskriterien(bewertungskriterien);

        benutzerRepository.save(benutzer);
        bewertungsgegenstandRepository.save(bewertungsgegenstand);
        bewertungskriteriumRepository.saveAll(bewertungskriterien);
        bewertung.generiereCode();
        bewertung.generiereLink(benutzer);

        bewertung1.generiereCode();
        bewertung1.generiereLink(benutzer);

        //bewertung speichern
        repository.saveAndFlush(bewertung);
        repository.saveAndFlush(bewertung1);

        //alle Bewertungen abrufenI
        Iterable<Bewertung> alleBewertungen = repository.findAll();

        //Überprüfen, ob alle Bewertungen zurückgegeben werden
        assertThat(alleBewertungen).containsExactly(bewertung, bewertung1);
    }

    @Test
    public void testCodeGenerationWorks() {
        Benutzer benutzer = TestFixtures.benutzer();
        Bewertungsgegenstand bewertungsgegenstand = TestFixtures.bewertungsgegenstand();
        List<Bewertungskriterium> bewertungskriterien = TestFixtures.bewertungskriterien();
        //   Bewertung bewertung = TestFixtures.bewertung(benutzer, bewertungskriterien, bewertungsgegenstand);
        Bewertung bewertung = Bewertung.builder()
                .name("Schule")
                .bewertungskriterien(bewertungskriterien)
                .bewertungsgegenstand(bewertungsgegenstand)
                .benutzer(benutzer)
                .erstellungsdatum(LocalDateTime.now())
                .build();
//überprüfen, ob benutzer oder bewertung null sind
        if (benutzer == null || bewertung == null) {
            throw new IllegalStateException("benutzer oder bewertung ist null");
        }
        bewertung.addBenutzer(benutzer);
        bewertung.setBewertungsgegenstand(bewertungsgegenstand);
        bewertung.setBewertungskriterien(bewertungskriterien);

        benutzerRepository.save(benutzer);
        bewertungsgegenstandRepository.save(bewertungsgegenstand);
        bewertungskriteriumRepository.saveAll(bewertungskriterien);
        bewertung.generiereCode();
        bewertung.generiereLink(benutzer);

        //bewertung speichern
        var saved = repository.saveAndFlush(bewertung);
        System.out.println(bewertung.getCode());
    }

    @Test
    public void testLinkGenerationWorks() {
        Benutzer benutzer = TestFixtures.benutzer();
        Bewertungsgegenstand bewertungsgegenstand = TestFixtures.bewertungsgegenstand();
        List<Bewertungskriterium> bewertungskriterien = TestFixtures.bewertungskriterien();
        //   Bewertung bewertung = TestFixtures.bewertung(benutzer, bewertungskriterien, bewertungsgegenstand);
        Bewertung bewertung = Bewertung.builder()
                .name("Schule")
                .bewertungskriterien(bewertungskriterien)
                .bewertungsgegenstand(bewertungsgegenstand)
                .benutzer(benutzer)
                .erstellungsdatum(LocalDateTime.now())
                .build();
//überprüfen, ob benutzer oder bewertung null sind
        if (benutzer == null || bewertung == null) {
            throw new IllegalStateException("benutzer oder bewertung ist null");
        }
        bewertung.addBenutzer(benutzer);
        bewertung.setBewertungsgegenstand(bewertungsgegenstand);
        bewertung.setBewertungskriterien(bewertungskriterien);

        benutzerRepository.save(benutzer);
        bewertungsgegenstandRepository.save(bewertungsgegenstand);
        bewertungskriteriumRepository.saveAll(bewertungskriterien);
        bewertung.generiereCode();
        bewertung.generiereLink(benutzer);

        //bewertung speichern
        var saved = repository.saveAndFlush(bewertung);

        System.out.println(bewertung.getLink());
    }

}
