package com.d4u.Decision4You.persistence;


import com.d4u.Decision4You.data.Bewertung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BewertungRepository extends JpaRepository<Bewertung, Long> {
    Bewertung findByCode(String code);

}
