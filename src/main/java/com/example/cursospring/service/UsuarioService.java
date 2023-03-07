package com.example.cursospring.service;

import com.example.cursospring.entity.Curso;
import com.example.cursospring.entity.Usuario;
import com.example.cursospring.security.dto.CreateUserDto;

import java.util.Optional;

public interface UsuarioService {

    public Iterable<Usuario> findAll();
    public Usuario findById(Integer id);
    public Usuario save(CreateUserDto user);

    public Usuario saveuser(Usuario user);
    public void deleteById(Integer id);
    Optional<Usuario> findByUsuario(String usuario);}
