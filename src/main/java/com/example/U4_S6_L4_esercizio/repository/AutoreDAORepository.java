package com.example.U4_S6_L4_esercizio.repository;

import com.example.U4_S6_L4_esercizio.model.Autore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoreDAORepository extends JpaRepository<Autore, Long> {
}