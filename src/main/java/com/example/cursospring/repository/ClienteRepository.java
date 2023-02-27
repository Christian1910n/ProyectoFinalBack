package com.example.cursospring.repository;

import com.example.cursospring.entity.Cliente;
import com.example.cursospring.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findByPersona(Persona persona);

}
