package com.example.cursospring.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
public class Inventario {
    @Id
    @GeneratedValue
    private Integer codigo;
    private String nombre;
    private String descripcion;
    private Integer cantidad;
    private Double valor;
    private String fecha_caducidad;
    private String tipo;
    private String imagen;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;

    public Inventario(Integer codigo, String nombre, String descripcion, Integer cantidad, Double valor, String fecha_caducidad, String tipo, String imagen, Proveedor proveedor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.valor = valor;
        this.fecha_caducidad = fecha_caducidad;
        this.tipo = tipo;
        this.imagen = imagen;
        this.proveedor = proveedor;
    }
}
