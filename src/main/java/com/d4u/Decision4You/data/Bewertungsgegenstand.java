package com.d4u.Decision4You.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
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

public class Bewertungsgegenstand extends AbstractPersistable<Long> {
    @Column(name = "name")
    private @NotBlank String gegenstandName;

    @Column(name = "beschreibung")
    private @NotBlank String beschreibung;


    @OneToMany(mappedBy = "bewertungsgegenstand")
    private List<Bewertung> bewertungen;
}
