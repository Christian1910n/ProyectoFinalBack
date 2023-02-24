package com.example.cursospring.controller;

import com.example.cursospring.entity.Curso;
import com.example.cursospring.entity.Usuario;
import com.example.cursospring.repository.CursoRepository;
import com.example.cursospring.repository.UsuarioRepository;
import com.example.cursospring.service.CursoService;
import com.example.cursospring.service.CursoServiceImp;
import com.example.cursospring.service.UsuarioServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("http://localhost:3000")
public class UsuarioController {
    @Autowired
    private UsuarioRepository cursoRepository;

    @Autowired
    private UsuarioServiceImp s3service;

    //Listar
    @GetMapping("/getusuario")
    List<Usuario> getAll(){
        return  cursoRepository.findAll();
    }

    //Crear
    @PostMapping("/crearusuario")
    @ResponseStatus(HttpStatus.CREATED)
    Usuario create(@RequestBody Usuario user){
        cursoRepository.save(user);
        return  user;
    }


    @DeleteMapping("/eliminarusuario")
    @ResponseStatus(HttpStatus.CREATED)
    public String delete(@RequestParam("id") int id) {
        s3service.deleteById(id);
        return "Id: "+ id+ " Eliminado correctamente";
    }


    @PutMapping("/modificausuario/{id}")
    @ResponseStatus (HttpStatus.CREATED)
    public Usuario update(@RequestBody Usuario usuario , @PathVariable int id) {

        Usuario Actual = s3service.findById(id);
        Actual.setContra(usuario.getContra());

        return s3service.save(Actual);

    }

}
