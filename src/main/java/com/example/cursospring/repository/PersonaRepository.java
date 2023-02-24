package com.example.cursospring.repository;

import com.example.cursospring.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, String> {
    Optional<Persona>findByPersona(String persona);
}
