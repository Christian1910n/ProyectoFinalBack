package com.example.cursospring.service;

import com.example.cursospring.entity.Pedido_cliente;
import com.example.cursospring.entity.Proveedor;

import java.util.List;

public interface ProveedorService {

    public List<Proveedor> findAll();

    public Proveedor  save(Proveedor c);

    public Proveedor findById(Integer id);

    public void delete(Integer id);
}
