package com.example.cursospring.controller;

import com.example.cursospring.entity.Usuario;
import com.example.cursospring.repository.UsuarioRepository;
import com.example.cursospring.security.dto.CreateUserDto;
import com.example.cursospring.security.dto.JwtTokenDto;
import com.example.cursospring.security.dto.LoginUserDto;
import com.example.cursospring.service.UsuarioServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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



    @PutMapping("/modificausuario/{id}")
    @ResponseStatus (HttpStatus.CREATED)
    public Usuario update(@RequestBody CreateUserDto usuario , @PathVariable String id) {

        Usuario Actual = s3service.findByUsuario(id).get();


        Actual.setContra(usuario.getContra());
        Actual.setUsuario(usuario.getUsuario());
        Actual.setPersona(usuario.getPersona());


        return s3service.saveuser(Actual);

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

    @PostMapping("/login")
    public JwtTokenDto login (@Valid @RequestBody LoginUserDto dto){
        JwtTokenDto jwtTokenDto =s3service.login(dto);
        return jwtTokenDto;

    }

    @GetMapping("/getusuario/{id}")
    Optional<Usuario> getUserById(@PathVariable String id) {
        return s3service.findByUsuario(id);
    }

}
