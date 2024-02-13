package com.d4u.Decision4You.data;

import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.mapping.JpaPersistentEntity;

public class Alternative extends AbstractPersistable<Long> {
    private String name;
    private String beschreibung;
    private Bewertungsgegenstand gegenstand;

}
