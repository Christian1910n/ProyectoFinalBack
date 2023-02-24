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
public class Persona implements Serializable {
    @Id
    private String cedula;

    @NonNull
    private String nombre;
    private String apellido;
    private String direccion;
    private String genero;

    public Persona(String cedula, @NonNull String nombre, String apellido, String direccion, String genero) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.genero = genero;
    }
}
