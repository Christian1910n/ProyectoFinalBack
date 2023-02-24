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
public class Proveedor extends Persona{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ruc_proveedor", nullable = false)
    private Integer id_proveedor;

    @NonNull
    private String nombre_comercial;

    private String celular;


    public Proveedor(String cedula, @NonNull String nombre, String apellido, String direccion, String genero, Integer id_proveedor, @NonNull String nombre_comercial, String celular) {
        super(cedula, nombre, apellido, direccion, genero);
        this.id_proveedor = id_proveedor;
        this.nombre_comercial = nombre_comercial;
        this.celular = celular;
    }
}
