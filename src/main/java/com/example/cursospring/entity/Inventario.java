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
public class Inventario {
    @Id
    @GeneratedValue
    private Integer id_inventario;

    @NonNull
    private String codigo;
    private String descripcion;
    private Integer cantidad;
    private Double valor;
    private String fecha_caducidad;
    private String tipo;
    private String imagen;

    public Inventario(Integer id_inventario, Proveedor proveedor, @NonNull String codigo, String descripcion, Integer cantidad, Double valor, String fecha_caducidad, String tipo, String imagen) {
        this.id_inventario = id_inventario;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.valor = valor;
        this.fecha_caducidad = fecha_caducidad;
        this.tipo = tipo;
        this.imagen = imagen;
    }
}
