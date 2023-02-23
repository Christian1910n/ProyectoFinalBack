package com.example.springboots3.web_api;


import com.example.springboots3.model.Curso;
import com.example.springboots3.repository.CursoRepository;
import com.example.springboots3.service.S3service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    //Implementamos

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private S3service s3service;

    //Listar
    @GetMapping
    List<Curso> getAll(){
        return  cursoRepository.findAll()
                .stream()
                .peek(curso -> curso.setImagenUrl(s3service.getObjectUrl(curso.getImagenPath())))
                .collect(Collectors.toList());
    }

    //Crear
    @PostMapping
    Curso create(@RequestBody Curso curso){
         cursoRepository.save(curso);
         curso.setImagenUrl(s3service.getObjectUrl(curso.getImagenPath()));
        return  curso;
    }

}
