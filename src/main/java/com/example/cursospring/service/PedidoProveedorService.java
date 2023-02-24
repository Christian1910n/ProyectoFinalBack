package com.example.cursospring.service;

import com.example.cursospring.entity.Pedido_proveedor;
import com.example.cursospring.entity.Usuario;

public interface PedidoProveedorService {
    public Iterable<Pedido_proveedor> findAll();
    public Pedido_proveedor findById(Integer id);
    public Pedido_proveedor save(Pedido_proveedor user);
    public void deleteById(Integer id);
}
