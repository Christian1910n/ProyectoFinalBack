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
public class Pedido_cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "numero_pedido", nullable = false)
    private Integer numero_pedido;

    @NonNull
    private String fecha_pedido;

    private String precio_total;

    private Persona persona;

    public Pedido_cliente(Integer numero_pedido, @NonNull String fecha_pedido, String precio_total, Persona persona) {
        this.numero_pedido = numero_pedido;
        this.fecha_pedido = fecha_pedido;
        this.precio_total = precio_total;
        this.persona = persona;
    }
}
