package com.d4u.Decision4You.persistence;


import com.d4u.Decision4You.data.Bewertungskriterium;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static com.d4u.Decision4You.TestFixtures.bewertungskriterien;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
public class BewertungskriteriumRepositoryTest {
    @Autowired
    private BewertungskriteriumRepository repository;

    @Test
    void ensureSaveAndReReadWorks() {
        List<Bewertungskriterium> bewertungskriterien = bewertungskriterien();
        var saved = repository.saveAllAndFlush((bewertungskriterien));
        Iterable<Bewertungskriterium> alleKriterien = repository.findAll();
    }
}
