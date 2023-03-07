package com.example.cursospring.service;

import com.example.cursospring.entity.Curso;
import com.example.cursospring.entity.Usuario;
import com.example.cursospring.repository.UsuarioRepository;
import com.example.cursospring.security.dto.CreateUserDto;
import com.example.cursospring.security.dto.JwtTokenDto;
import com.example.cursospring.security.dto.LoginUserDto;
import com.example.cursospring.security.enums.RoleEnum;
import com.example.cursospring.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImp implements UsuarioService{


    @Autowired
    private UsuarioRepository userR;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioRepository usuariodao;



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
    public Usuario save(CreateUserDto user){

        String password=passwordEncoder.encode(user.getContra());
        Usuario usuario = new Usuario(0, user.getUsuario(), password, user.getPersona());
        return userR.save(usuario);

    }

    @Override
    public Usuario saveuser(Usuario user) {
        String password=passwordEncoder.encode(user.getContra());
        user.setContra(password);
        return userR.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        userR.deleteById(id);
    }

    @Override
    public Optional<Usuario> findByUsuario(String usuario) {
        return usuariodao.findByUsuario(usuario);
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

    public JwtTokenDto login(LoginUserDto dto){
        Authentication authentication=
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsuario(),dto.getContra()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token=jwtProvider.generatedToken(authentication);
        return new JwtTokenDto(token);

    }

}
