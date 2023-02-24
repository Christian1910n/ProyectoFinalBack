package com.example.cursospring.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Pedido_proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_usuarios", nullable = false)
    private Integer numero_pedido;

    private String fecha;
    private Double precio_total;
    private Proveedor proveedor;

    public Pedido_proveedor(Integer numero_pedido, String fecha, Double precio_total, Proveedor proveedor) {
        this.numero_pedido = numero_pedido;
        this.fecha = fecha;
        this.precio_total = precio_total;
        this.proveedor = proveedor;
    }
}
