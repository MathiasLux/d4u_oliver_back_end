package com.d4u.Decision4You.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "benutzer")

public class Benutzer extends AbstractPersistable <Long>{

    @NotBlank
    @Column(name = "vorname")
    private String vorname;

    @NotBlank
    @Column(name = "nachname")
    private String nachname;

    @NotBlank
    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "handyNummer")
    private String handyNummer;

    @Column(name = "gebDatum")
    private String gebDatum;

    //basierend auf rolle wird verschiedene Rechte vergeben bzw. nicht vergeben.
    @NotNull
    @Column(name = "rolle")
    @Enumerated(EnumType.STRING)
    private Rolle rolle;

    @ManyToMany(mappedBy = "teilnehmendeBenutzer")
    private List<Bewertung> bewertungenTeilnahme;

    @OneToMany(mappedBy = "benutzer")
    private List<Bewertung> bewertungen;

    public Benutzer(String vorname, String nachname, String email, String handyNummer
    ,String gebDatum) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
        this.handyNummer = handyNummer;
        this.gebDatum = gebDatum;
    }

}
