package com.d4u.Decision4You.persistence;

import com.d4u.Decision4You.data.Bewertungsgegenstand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BewertungsgegenstandRepository extends JpaRepository<Bewertungsgegenstand, Long> {
}
