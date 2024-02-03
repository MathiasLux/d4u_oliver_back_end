package com.d4u.Decision4You.persistence;

import com.d4u.Decision4You.TestFixtures;
import com.d4u.Decision4You.data.Benutzer;
import com.d4u.Decision4You.data.Rolle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
public class BenutzerRepositoryTest {
    @Autowired
    private BenutzerRepository repository;

    @Test
    void ensureSaveAndReReadWorks() {
        Benutzer benutzer = TestFixtures.benutzer();
        var saved = repository.saveAndFlush(benutzer);
        assertThat(saved).isNotNull();
        assertThat(saved).isSameAs(benutzer);
        assertThat(saved.getId()).isNotNull();
    }

    @Test
    void ensureUpdateWorks() {
        Benutzer benutzer = TestFixtures.benutzer();
        //benutzer speichern
        Benutzer savedBenutzer = repository.save(benutzer);
        //Vorname ändern
        savedBenutzer.setVorname("UpdatedFirstName");
        //aktualiesierte Benutzer speichern
        Benutzer updatedBenutzer = repository.saveAndFlush(savedBenutzer);
        //überprüfen, ob die Aktualisierung erfolgreich war
        assertThat(updatedBenutzer).isNotNull().isEqualTo(savedBenutzer);
    }

    @Test
    void ensureDeleteWorks() {
        Benutzer benutzer = TestFixtures.benutzer();
        //benutzer speichern
        Benutzer savedBenutzer = repository.save(benutzer);
        //benutzer löschen
        repository.delete(benutzer);
        //überprüfen, ob der Benutzer gelöscht wurde
        assertThat(repository.findById(benutzer.getId())).isEmpty();
    }

    @Test
    void ensureFindAllWorks() {
        Benutzer benutzer = TestFixtures.benutzer();
        Benutzer benutzer1 = Benutzer.builder()
                .vorname("ben")
                .nachname("nutzer2")
                .rolle(Rolle.BEWERTER)
                .email("benutzer2@spg.at")
                .gebDatum("01.01.2000")
                .handyNummer("011234553234")
                .build();
        repository.saveAndFlush(benutzer);
        repository.saveAndFlush(benutzer1);
        //Alle Benutzer abrufen
        Iterable<Benutzer> alleBenutzer = repository.findAll();
        //Überprüfen, ob alle Benutzer zurückgegen wurden
        assertThat(alleBenutzer).containsExactly(benutzer, benutzer1);

    }
}















































