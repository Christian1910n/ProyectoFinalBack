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
    @GeneratedValue
    private Integer numero_pedido;

    @NonNull
    private String fecha_pedido;

    private String precio_total;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Pedido_cliente(Integer numero_pedido, @NonNull String fecha_pedido, String precio_total, Cliente cliente) {
        this.numero_pedido = numero_pedido;
        this.fecha_pedido = fecha_pedido;
        this.precio_total = precio_total;
        this.cliente = cliente;
    }

}
