package com.example.cursospring.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor

public class Curso implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @NonNull
    private String usuario;
    private String contrasena;

    private String imagenPath;

    @Transient  //No va a persistir en la base de datos y va a servir para retornar la url completa de la img
    private String imagenUrl;

    public Curso(Integer id, @NonNull String usuario, String contrasena, String imagenPath, String imagenUrl) {
        this.id = id;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.imagenPath = imagenPath;
        this.imagenUrl = imagenUrl;
    }


}
