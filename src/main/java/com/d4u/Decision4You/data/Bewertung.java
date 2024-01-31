package com.d4u.Decision4You.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bewertung")
public class Bewertung extends AbstractPersistable<Long> {

    @ManyToOne
    @JoinColumn(name = "bewertungsgegenstand_id")
    private Bewertungsgegenstand bewertungsgegenstand;

    @OneToMany(mappedBy = "bewertungsteilnahme")
    private List<Benutzer> teilnehmendeBenutzer;

    @OneToMany(mappedBy = "bewertung")
    private List<Bewertungskriterium> bewertungskriterien = new ArrayList<>();

    private LocalDateTime erstellungsdatum;
}
