package com.d4u.Decision4You.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "benutzer")

public class Benutzer extends AbstractPersistable<Long> {

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

    @Past
    @Column(name = "gebDatum")
    private LocalDate gebDatum;

    //basierend auf rolle wird verschiedene Rechte vergeben bzw. nicht vergeben.
    @NotNull
    @Column(name = "rolle")
    @Enumerated(EnumType.STRING)
    private Rolle rolle;

    public Benutzer(String vorname, String nachname, String email, String handyNummer
    ,LocalDate gebDatum) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
        this.handyNummer = handyNummer;
        this.gebDatum = gebDatum;
    }

}
