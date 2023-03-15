package com.example.cursospring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Cliente implements Serializable {
    @Id
    @GeneratedValue
    private Integer id_cliente;

    @NonNull
    private int edad;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cedula", referencedColumnName = "cedula")
    private Persona persona;

    private boolean estado;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Pedido_cliente> pedidos;

    public Cliente(Integer id_cliente, @NonNull int edad, Persona persona, boolean estado, List<Pedido_cliente> pedidos) {
        this.id_cliente = id_cliente;
        this.edad = edad;
        this.persona = persona;
        this.estado = estado;
        this.pedidos = pedidos;
    }
}
