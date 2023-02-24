package com.example.cursospring.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Cliente implements Serializable {
    @Id
    @GeneratedValue
    private String cedula_cliente;

    @NonNull
    private int edad;
}
