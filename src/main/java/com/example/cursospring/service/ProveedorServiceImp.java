package com.example.cursospring.service;


import com.example.cursospring.entity.Cliente;
import com.example.cursospring.entity.Pedido_cliente;
import com.example.cursospring.entity.Persona;
import com.example.cursospring.entity.Proveedor;
import com.example.cursospring.repository.PedidoClienteRepository;
import com.example.cursospring.repository.PersonaRepository;
import com.example.cursospring.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServiceImp implements ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private PersonaRepository personaDao;
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
    @Override
    public void deleteById(Integer id) {
        proveedorRepository.deleteById(id);
    }

    @Override
    public Optional<Proveedor> buscarporcedula(String cedula) {
        Persona per= personaDao.findByCedula(cedula).orElse(null);
        return proveedorRepository.findByPersona(per);
    }
}
