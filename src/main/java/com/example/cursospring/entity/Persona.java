package com.example.cursospring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "persona")
public class Persona implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    private String cedula;

    @NonNull
    private String nombre;
    private String apellido;
    private String direccion;
    private String genero;


    public Persona(Integer id, String cedula, @NonNull String nombre, String apellido, String direccion, String genero) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.genero = genero;
    }

    public Persona() {

    }




}
