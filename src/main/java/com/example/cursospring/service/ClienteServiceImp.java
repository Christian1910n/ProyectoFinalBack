package com.example.cursospring.service;

import com.example.cursospring.entity.Cliente;
import com.example.cursospring.entity.Proveedor;
import com.example.cursospring.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteServiceImp implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @Override
    public Cliente save(Cliente c) {
        return clienteRepository.save(c);
    }

    @Override
    public Cliente findById(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        clienteRepository.deleteById(id);
    }
}
