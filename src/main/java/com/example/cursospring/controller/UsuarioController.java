package com.example.cursospring.controller;

import com.example.cursospring.entity.Curso;
import com.example.cursospring.entity.Usuario;
import com.example.cursospring.repository.CursoRepository;
import com.example.cursospring.repository.UsuarioRepository;
import com.example.cursospring.security.dto.CreateUserDto;
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
@CrossOrigin(origins = {"*"})
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
    Usuario create(@RequestBody CreateUserDto user){

        return  s3service.save(user);
    }


    @DeleteMapping("/eliminarusuario")
    @ResponseStatus(HttpStatus.CREATED)
    public String delete(@RequestParam("id") int id) {
        s3service.deleteById(id);
        return "Id: "+ id+ " Eliminado correctamente";
    }


    /*
    @PutMapping("/modificausuario/{id}")
    @ResponseStatus (HttpStatus.CREATED)
    public Usuario update(@RequestBody Usuario usuario , @PathVariable int id) {

        Usuario Actual = s3service.findById(id);
        Actual.setContra(usuario.getContra());

        return s3service.save(Actual);

    }

     */

    @GetMapping("/validarLogin")
    public boolean validarLogin(@RequestParam("usuario") String usuario, @RequestParam("contrasena")String clave){
        if (s3service.validacionLogin(usuario,clave)){
            return true;

        }else {
            System.out.println("No inicia");
            return false;
        }

    }
    @GetMapping("/esAdministrador")
    public boolean esAdministrador(@RequestParam("usuario") String usuario) {
        return s3service.esAdministrador(usuario);
    }


    @GetMapping("/validarusuario")
    public boolean validarusuario(@RequestParam("usuario") String usuario){
        Optional<Usuario> per=s3service.findByUsuario(usuario);
        if(per.isPresent()){
            return true;
        }else{
            return false;
        }
    }

}
