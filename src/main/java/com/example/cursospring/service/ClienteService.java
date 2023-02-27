package com.example.cursospring.service;

import com.example.cursospring.entity.Cliente;
import com.example.cursospring.entity.Proveedor;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    public List<Cliente> findAll();

    public Cliente  save(Cliente c);

    public Cliente findById(Integer id);

    public void delete(Integer id);

    Optional<Cliente> buscarporcedula(String cedula);
}
