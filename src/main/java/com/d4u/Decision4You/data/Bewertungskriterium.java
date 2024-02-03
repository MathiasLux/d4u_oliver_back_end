package com.d4u.Decision4You.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bewertungskriterium")
public class Bewertungskriterium extends AbstractPersistable<Long> {

    @Column(name = "name")
    private @NotNull String kriteriumName;

    @Column(name = "beschreibung")
    private @NotNull String beschreibung;

    @Min(1)
    @Max(5)
    @Column(name = "gewichtung")
    private @NotNull Integer gewichtung;

    @ManyToOne
    @JoinColumn(name = "bewertung_id")
    private Bewertung bewertung;

    public double berechneGewichteteBewertung() {
        // da wird die Logik implementiert, die Bewertung zu berechnen
        // zum Beispiel: return gewichtung * andere Attribute / irgendwas
        return 0.0;
    }
}

