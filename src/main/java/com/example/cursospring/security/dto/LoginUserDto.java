package com.example.cursospring.security.dto;

import javax.validation.constraints.NotBlank;

public class LoginUserDto {
    @NotBlank(message = "Usuario es obligatorio")
    private String usuario;

    @NotBlank(message = "Contraseña es obligatorio")
    private String contra;

    public LoginUserDto(String usuario, String contra) {
        this.usuario = usuario;
        this.contra = contra;
    }

    public LoginUserDto() {
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
}
