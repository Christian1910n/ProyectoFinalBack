package com.example.cursospring.service;


import com.example.cursospring.entity.Pedido_cliente;
import com.example.cursospring.entity.Proveedor;
import com.example.cursospring.repository.PedidoClienteRepository;
import com.example.cursospring.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServiceImp implements ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;
    @Override
    public List<Proveedor> findAll() {
        return (List<Proveedor>) proveedorRepository.findAll();
    }

    @Override
    public Proveedor save(Proveedor c) {
        return proveedorRepository.save(c);
    }

    @Override
    public Proveedor findById(Integer id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        proveedorRepository.deleteById(id);
    }
}
