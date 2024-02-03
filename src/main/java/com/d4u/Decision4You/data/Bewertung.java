package com.d4u.Decision4You.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bewertung")
public class Bewertung extends AbstractPersistable<Long> {
    @Column(name = "name")
    private @NotBlank String name;

    @Column(name = "code")
    private @NotNull String code;

    @Getter
    @Column(name = "link")
    private @NotNull String link;

    /*@Column(name = "qr-code")
    private @NotNull String qrcode;*/

    @ManyToOne
    @JoinColumn(name = "bewertungsgegenstand_id")
    private Bewertungsgegenstand bewertungsgegenstand;

    @ManyToOne
    @JoinColumn(name = "benutzer_id")
    private Benutzer benutzer;

    @ManyToMany
    @JoinTable(
            name = "bewertung_benutzer",
            joinColumns = @JoinColumn(name = "bewertung_id"),
            inverseJoinColumns = @JoinColumn(name = "benutzer_id"))
    private List<Benutzer> teilnehmendeBenutzer;

    @OneToMany(mappedBy = "bewertung")
    private List<Bewertungskriterium> bewertungskriterien;

    @Column(name = "gewichtung")
    private double gewichtung;

    @Column(name = "erstellungsdatum")
    private @NotNull LocalDateTime erstellungsdatum;

    public void generiereCode() {
        // code kann z.B. durch Kombination von Datum und zufälligen Zeichen sein.
        String datumTeil = LocalDate.now().toString();
        String zufallsTeil = RandomStringUtils.randomAlphanumeric(8);
        this.code = datumTeil + "-" + zufallsTeil;
    }

  /*  Dieser Methode verwendet die BenutzerID als Token und generiert einen Link,
    der zur Login-Seite und dann zur Bewertungsseite weiterleitet. */
    public void generiereLink(Benutzer benutzer) {
        if (benutzer.getId() == null) {
            throw new IllegalStateException("Benutzer-ID darf nicht null sein");
        }
        String benutzerToken = benutzer.getId().toString();
        String loginUrl = "https://UnsereDomain.com/login?token" + benutzerToken;
        String bewertungsUrl = "https://UnsereDomain.com/bewertung" + benutzerToken;

        // Überprüfe, ob loginUrl oder bewertungsUrl null sind
        if (loginUrl == null || bewertungsUrl == null) {
            throw new IllegalStateException("loginUrl or bewertungsUrl is null");
        }
       this.link = loginUrl + "&redirect=" + bewertungsUrl;
    }

    public void addBenutzer(Benutzer benutzer) {
        if (teilnehmendeBenutzer == null) {
            teilnehmendeBenutzer = new ArrayList<>();
        }
        teilnehmendeBenutzer.add(benutzer);
    }
    public void addKriterium(Bewertungskriterium kriterium) {
        if (bewertungskriterien == null) {
            bewertungskriterien = new ArrayList<>();
        }
        bewertungskriterien.add(kriterium);
    }


    public void setGewichtungForKriterien(Map<Long, Double> gewichtungen) {
        for (Bewertungskriterium kriterium : bewertungskriterien) {
            Long kriteriumId = kriterium.getId();

            if (gewichtungen.containsKey(kriteriumId)) {
                double benutzerGewichtung = gewichtungen.get(kriteriumId);
                kriterium.setGewichtung(benutzerGewichtung);
            }
        }
    }
}
