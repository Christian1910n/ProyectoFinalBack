package com.example.springboots3.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor

public class Curso  implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @NonNull
    private String titulo;

    private String imagenPath;

    @Transient  //No va a persistir en la base de datos y va a servir para retornar la url completa de la img
    private String imagenUrl;
}
