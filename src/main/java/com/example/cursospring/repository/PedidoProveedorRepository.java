package com.example.cursospring.repository;

import com.example.cursospring.entity.Pedido_proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoProveedorRepository extends JpaRepository<Pedido_proveedor,Integer> {

}
