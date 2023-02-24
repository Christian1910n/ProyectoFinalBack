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
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ruc_proveedor", nullable = false)
    private Integer id_proveedor;

    private Persona persona;

    @NonNull
    private String nombre_comercial;

    private String celular;

    public Proveedor(Integer id_proveedor, Persona persona, @NonNull String nombre_comercial, String celular) {
        this.id_proveedor = id_proveedor;
        this.persona = persona;
        this.nombre_comercial = nombre_comercial;
        this.celular = celular;
    }

}
