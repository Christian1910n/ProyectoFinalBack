package com.example.cursospring.service;

import com.example.cursospring.entity.Curso;
import com.example.cursospring.entity.Pedido_cliente;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface PedidoClienteService {
    public List<Pedido_cliente> findAll();

    public Pedido_cliente  save(Pedido_cliente c);

    public Pedido_cliente findById(Integer id);

    public void delete(Integer id);

}
