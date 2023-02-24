package com.example.cursospring.controller;

import com.example.cursospring.entity.Pedido_proveedor;
import com.example.cursospring.entity.Usuario;
import com.example.cursospring.repository.PedidoProveedorRepository;
import com.example.cursospring.repository.UsuarioRepository;
import com.example.cursospring.service.PedidoproveedorServiceImp;
import com.example.cursospring.service.UsuarioServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedprovee")
@CrossOrigin("http://localhost:3000")
public class PedidoProveedorController {
    @Autowired
    private PedidoProveedorRepository cursoRepository;

    @Autowired
    private PedidoproveedorServiceImp s3service;

    //Listar
    @GetMapping("/getpedido")
    List<Pedido_proveedor> getAll(){
        return  cursoRepository.findAll();
    }

    //Crear
    @PostMapping("/crearpedido")
    @ResponseStatus(HttpStatus.CREATED)
    Pedido_proveedor create(@RequestBody Pedido_proveedor user){
        cursoRepository.save(user);
        return  user;
    }


    @DeleteMapping("/eliminarpedido")
    @ResponseStatus(HttpStatus.CREATED)
    public String delete(@RequestParam("id") int id) {
        s3service.deleteById(id);
        return "Id: "+ id+ " Eliminado correctamente";
    }



}
