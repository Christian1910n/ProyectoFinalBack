package com.example.cursospring.service;

import com.example.cursospring.entity.Cliente;
import com.example.cursospring.entity.Pedido_cliente;
import com.example.cursospring.entity.Proveedor;

import java.util.List;
import java.util.Optional;

public interface ProveedorService {

    public List<Proveedor> findAll();

    public Proveedor  save(Proveedor c);

    public Proveedor findById(Integer id);
    public void deleteById(Integer id);

    public void delete(Integer id);

    Optional<Proveedor> buscarporcedula(String cedula);
}
