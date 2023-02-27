package com.example.cursospring.controller;

import com.example.cursospring.entity.Persona;
import com.example.cursospring.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/persona")
@CrossOrigin(origins = {"*"})
public class PersonaController {

    @Autowired
    PersonaRepository personadao;

    @GetMapping("/cliente/{cedula}")
    public Optional<Persona> findByCedula(@PathVariable String cedula){
        return personadao.findByCedula(cedula);
    }
}
