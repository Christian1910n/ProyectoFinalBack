package com.example.cursospring.service;

import com.example.cursospring.entity.Curso;
import com.example.cursospring.entity.Usuario;
import com.example.cursospring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsuarioServiceImp implements UsuarioService{


    @Autowired
    private UsuarioRepository userR;



    @Override
    @Transactional(readOnly=true)
    public Iterable<Usuario> findAll() {
        return userR.findAll();
    }

    @Override
    public Usuario findById(Integer id) {
        return userR.findById(id).orElse(null);
    }

    @Override
    public Usuario save(Usuario user) {
        return userR.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        userR.deleteById(id);
    }

    @Override
    public Optional<Usuario> findByUsuario(String usuario) {
        return Optional.empty();
    }

    public boolean validacionLogin(String usuario, String contrasena) {
        Optional<Usuario> per=userR.findByUsuario(usuario);
        if(per.isPresent() && per.get().getContra().equals(contrasena)){
            return true;
        }
        return false;
    }

    public boolean esAdministrador(String usuario) {
        Optional<Usuario> usuarioOptional = userR.findByUsuario(usuario);
        if (usuarioOptional.isPresent()) {
            Usuario usuarioEncontrado = usuarioOptional.get();
            return usuarioEncontrado.getUsuario().equals("administrador");
        }
        return false;
    }

}
