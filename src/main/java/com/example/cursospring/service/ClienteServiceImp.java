package com.example.cursospring.service;

import com.example.cursospring.entity.Cliente;
import com.example.cursospring.entity.Persona;
import com.example.cursospring.entity.Proveedor;
import com.example.cursospring.repository.ClienteRepository;
import com.example.cursospring.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImp implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PersonaRepository personaDao;

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @Override
    public Optional<Persona> findAllPersona(String cedula) {
        return personaDao.findByCedula(cedula);
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

    @Override
    public Optional<Cliente> buscarporcedula(String cedula) {
        Persona per= personaDao.findByCedula(cedula).orElse(null);
        return clienteRepository.findByPersona(per);
    }
}
