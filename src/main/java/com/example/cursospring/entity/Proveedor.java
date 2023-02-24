package com.example.cursospring.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Proveedor{
    @Id
    @GeneratedValue
    private Integer id;
    @NonNull
    private String nombre_comercial;

    private String celular;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cedula", referencedColumnName = "cedula")
    private Persona persona;



    public Proveedor(@NonNull String nombre_comercial, String celular, Persona persona) {
        this.nombre_comercial = nombre_comercial;
        this.celular = celular;
        this.persona = persona;
    }
}
