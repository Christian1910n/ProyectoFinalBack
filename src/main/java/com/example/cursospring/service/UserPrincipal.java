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
    private Collection<? extends GrantedAuthority>authorities;

    public UserPrincipal(String usuario, String contra, Persona persona, Collection<? extends GrantedAuthority> authorities) {
        this.usuario = usuario;
        this.contra = contra;
        this.persona = persona;
        this.authorities = authorities;
    }

    public static UserPrincipal build(Usuario usuario){
        Collection<GrantedAuthority>authorities=
                usuario.getRoles().stream().map(rol->new SimpleGrantedAuthority(rol.name())).collect(Collectors.toList());
        return new UserPrincipal(usuario.getUsuario(), usuario.getContra(), usuario.getPersona(),authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
