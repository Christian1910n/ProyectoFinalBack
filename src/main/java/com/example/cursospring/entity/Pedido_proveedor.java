package com.example.cursospring.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Pedido_proveedor {
    @Id
    @GeneratedValue
    private Integer numero_pedido;

    private String fecha;
    private Double precio_total;

    public Pedido_proveedor(Integer numero_pedido, String fecha, Double precio_total) {
        this.numero_pedido = numero_pedido;
        this.fecha = fecha;
        this.precio_total = precio_total;
    }

}
