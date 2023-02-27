package com.example.cursospring.repository;

import com.example.cursospring.entity.Curso;
import com.example.cursospring.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    Optional<Usuario> findByUsuario(String usuario);
}
