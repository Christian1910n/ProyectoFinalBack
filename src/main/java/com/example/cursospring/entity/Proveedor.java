package com.example.cursospring.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Proveedor{
    @Id
    @GeneratedValue
    private Integer id_proveedor;

    @NonNull
    private String nombre_comercial;

    private String celular;

    private boolean estado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cedula", referencedColumnName = "cedula")
    private Persona persona;

    @OneToMany(mappedBy = "proveedor")
    @JsonIgnore
    private List<Pedido_proveedor> pedidos;

    @OneToMany(mappedBy = "proveedor")
    @JsonIgnore
    private List<Inventario> inventario;


    public Proveedor(Integer id_proveedor, @NonNull String nombre_comercial, String celular, boolean estado, Persona persona) {
        this.id_proveedor = id_proveedor;
        this.nombre_comercial = nombre_comercial;
        this.celular = celular;
        this.estado = estado;
        this.persona = persona;
    }
}
