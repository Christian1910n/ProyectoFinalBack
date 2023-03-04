package com.example.cursospring.service;

import com.example.cursospring.entity.Persona;
import com.example.cursospring.entity.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {

    private String usuario;
    private String contra;
    private Persona persona;

    public UserPrincipal(String usuario, String contra, Persona persona ) {
        this.usuario = usuario;
        this.contra = contra;
        this.persona = persona;
    }

    public static UserPrincipal build(Usuario usuario){

        return new UserPrincipal(usuario.getUsuario(), usuario.getContra(), usuario.getPersona());
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return contra;
    }

    @Override
    public String getUsername() {
        return usuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Persona getPersona() {
        return persona;
    }
}
