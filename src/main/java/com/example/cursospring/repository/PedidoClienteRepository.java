package com.example.cursospring.repository;

import com.example.cursospring.entity.Curso;
import com.example.cursospring.entity.Pedido_cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PedidoClienteRepository extends JpaRepository<Pedido_cliente, Integer> {
}
