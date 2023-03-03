package com.example.cursospring.security.dto;
import com.example.cursospring.entity.Persona;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class CreateUserDto {
    @NotBlank(message = "Usuario es obligatorio")
    private String usuario;

    @NotBlank(message = "Contraseña es obligatorio")
    private String contra;

    @NotEmpty(message = "Persona es obligatorio")
    private Persona persona;

    @NotEmpty(message = "Rol es obligatorio")
    List<String> roles;

    public CreateUserDto() {
    }

    public CreateUserDto(String usuario, String contra, Persona persona, List<String> roles) {
        this.usuario = usuario;
        this.contra = contra;
        this.persona = persona;
        this.roles = roles;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
