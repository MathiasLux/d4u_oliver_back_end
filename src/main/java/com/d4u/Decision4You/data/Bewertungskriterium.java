package com.d4u.Decision4You.data;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class Bewertungskriterium extends AbstractPersistable<Long> {

    private @NotNull String kriteriumName;
    private @NotNull String kriteriumBeschreibung;
    private @NotNull Integer kriterium;

    @ManyToOne
    @JoinColumn(name = "bewertung_id")
    private Bewertung bewertung;
}
