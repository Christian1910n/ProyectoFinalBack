package com.example.cursospring.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue
    private Integer id_usuarios;
    @NonNull
    private String usuario;
    private String contra;

    public Usuario(Integer id_usuarios, Persona persona, @NonNull String usuario, String contra) {
        this.id_usuarios = id_usuarios;
        this.usuario = usuario;
        this.contra = contra;
    }
}
