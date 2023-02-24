package com.example.cursospring.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_cliente", nullable = false)
    private Integer id_cliente;

    private Persona persona;
    @NonNull
    private int edad;

    public Cliente(Integer id_cliente, Persona persona, @NonNull int edad) {
        this.id_cliente = id_cliente;
        this.persona = persona;
        this.edad = edad;
    }
}
