package com.example.cursospring.controller;

import com.example.cursospring.entity.Cliente;
import com.example.cursospring.entity.Persona;
import com.example.cursospring.repository.ClienteRepository;
import com.example.cursospring.repository.PersonaRepository;
import com.example.cursospring.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class ClienteController {
@Autowired
private ClienteService clienteService;

ClienteRepository clienteRepository;
PersonaRepository personaRepository;
@GetMapping("/listarcliente")
    public List<Cliente> indext(){
    return clienteService.findAll();
}
    @PostMapping("/crearcliente")
    public Cliente save(@RequestBody Cliente libro){
        return clienteService.save(libro);
    }

    @GetMapping("/cliente/{id}")
    public Cliente findById(@PathVariable Integer id){
        return clienteService.findById(id);
    }
    @DeleteMapping("/eliminarcliente/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void eliminar(@PathVariable int id){
        clienteService.delete(id);
    }
    @PutMapping("/editarcliente/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente editar(@RequestBody Cliente cliente, @PathVariable Integer id){
        Cliente  clienteactual=clienteService.findById(id);
        clienteactual.setEdad(cliente.getEdad());



        return clienteService.save(clienteactual);
    }



    @GetMapping("/clienteced/{ced}")
    public Optional<Cliente> clientecedula(@PathVariable String ced) {
        return clienteService.buscarporcedula(ced);
    }



}
