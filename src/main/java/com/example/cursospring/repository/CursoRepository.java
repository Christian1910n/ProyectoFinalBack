package com.example.cursospring.repository;


import com.example.cursospring.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

    Optional<Curso> findByUsuario(String usuario);
}
