package com.example.cursospring.repository;

import com.example.cursospring.entity.Cliente;
import com.example.cursospring.entity.Curso;
import com.example.cursospring.entity.Persona;
import com.example.cursospring.entity.Proveedor;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
    @Override
    List<Proveedor> findAll();

    Optional<Proveedor> findByPersona(Persona persona);
}
