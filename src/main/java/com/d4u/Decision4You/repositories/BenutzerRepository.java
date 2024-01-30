package com.d4u.Decision4You.repositories;

import com.d4u.Decision4You.data.Benutzer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenutzerRepository extends JpaRepository<Benutzer, Long> {
}
