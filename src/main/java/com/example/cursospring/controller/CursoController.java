package com.example.cursospring.controller;


import com.example.cursospring.entity.Curso;
import com.example.cursospring.repository.CursoRepository;
import com.example.cursospring.service.CursoService;
import com.example.cursospring.service.CursoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cursos")
@CrossOrigin(origins = {"*"})
public class CursoController {
    //Implementamos

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CursoServiceImp s3service;

    private CursoService cursoService;

    //Listar
    @GetMapping("/getcurso")
    List<Curso> getAll(){
        return  cursoRepository.findAll()
                .stream()
                .peek(curso -> curso.setImagenUrl(s3service.getObjectUrl(curso.getImagenPath())))
                .collect(Collectors.toList());
    }

    //Crear
    @PostMapping("/crearcurso")
    @ResponseStatus(HttpStatus.CREATED)
    Curso create(@RequestBody Curso curso){
         cursoRepository.save(curso);
        return  curso;
    }

    @GetMapping("/validarLogin")
    public boolean validarLogin(@RequestParam("usuario") String usuario, @RequestParam("contrasena")String clave){
        if (s3service.validacionLogin(usuario,clave)){
                return true;

        }else {
            System.out.println("No inicia");
            return false;
        }

    }

    @GetMapping("/obt_id")
    public Optional<Curso> obt_id(@RequestParam("usuario") String usuario, @RequestParam("contrasena")String clave){
        Optional<Curso> per=s3service.findByUsuario(usuario);
        if (s3service.validacionLogin(usuario,clave)){
            return per;

        }else{
            return null;
        }

    }

    @GetMapping("/validarusuario")
    public boolean validarusuario(@RequestParam("usuario") String usuario){
        Optional<Curso> per=s3service.findByUsuario(usuario);
        if(per.isPresent()){
            return true;
        }else{
            return false;
        }
    }

    @DeleteMapping("/eliminarcurso")
    @ResponseStatus(HttpStatus.CREATED)
    public String delete(@RequestParam("id") int id) {
        s3service.deleteById(id);
        return "Id: "+ id+ " Eliminado correctamente";
    }


    @PutMapping("/modificausuario/{id}")
    @ResponseStatus (HttpStatus.CREATED)
    public Curso update(@RequestBody Curso producto , @PathVariable int id) {

        Curso productoActual = s3service.findById(id);
        productoActual.setContrasena(producto.getContrasena());

            System.out.println("Path Actual: "+productoActual.getImagenPath());
            System.out.println("Path nuevo: "+producto.getImagenPath());
            s3service.deleteObject(productoActual.getImagenPath());
            productoActual.setImagenPath(producto.getImagenPath());

        return s3service.save(productoActual);

    }
    @GetMapping("/modificausuario/{id}")
    Curso getUserById(@PathVariable int id) {
        return s3service.findById(id);
    }


    






}
