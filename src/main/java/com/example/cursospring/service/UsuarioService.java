package com.example.cursospring.service;

import com.example.cursospring.entity.Curso;
import com.example.cursospring.entity.Usuario;

import java.util.Optional;

public interface UsuarioService {

    public Iterable<Usuario> findAll();
    public Usuario findById(Integer id);
    public Usuario save(Usuario user);
    public void deleteById(Integer id);
    Optional<Usuario> findByUsuario(String usuario);}
