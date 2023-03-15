package com.example.cursospring.controller;

import com.example.cursospring.entity.Cliente;
import com.example.cursospring.entity.Persona;
import com.example.cursospring.repository.ClienteRepository;
import com.example.cursospring.repository.PersonaRepository;
import com.example.cursospring.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    List<Cliente> listaclientes = clienteService.findAll(); // obtiene la lista completa de proveedores
    List<Cliente> listaClientesact = listaclientes
            .stream() // convierte la lista en un flujo
            .filter(p ->p.isEstado()) // filtra solo los proveedores cuyo estado es true
            .collect(Collectors.toList()); // convierte el flujo filtrado en una lista
    return listaClientesact; // retorna la lista filtrada
}
    @PostMapping("/crearcliente")
    public Cliente save(@RequestBody Cliente libro){
    Optional<Persona> p=clienteService.findAllPersona(libro.getPersona().getCedula());
    if(p.isPresent()) {
        System.out.println("Cedula duplicada");
        return null;

    }else{
        System.out.println("else null");
        return clienteService.save(libro);
    }
    }

    @GetMapping("/getpersonas/{cedula}")
    public Optional<Persona> getper(@PathVariable String cedula){
        return clienteService.findAllPersona(cedula);
    }

    @GetMapping("/cliente/{id}")
    public Cliente findById(@PathVariable Integer id){
        return clienteService.findById(id);
    }

    @PutMapping("/editarcliente/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente editar(@RequestBody Cliente cliente, @PathVariable Integer id){
        Cliente  clienteactual=clienteService.findById(id);
        clienteactual.setEdad(cliente.getEdad());



        return clienteService.save(clienteactual);
    }

    @PutMapping("/eliminarcliente")
    @ResponseStatus(HttpStatus.CREATED)
    public String delete(@RequestParam("id") int id) {
        Cliente p=clienteService.findById(id);
        if(p.isEstado()==true){
            p.setEstado(false);
        }else{
            p.setEstado(true);
        }
        clienteService.save(p);
        return "Id: "+ id+ " Eliminado correctamente";
    }


    @GetMapping("/clienteced/{ced}")
    public Optional<Cliente> clientecedula(@PathVariable String ced) {
        return clienteService.buscarporcedula(ced);
    }



}
