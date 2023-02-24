package com.example.cursospring.controller;


import com.example.cursospring.entity.Pedido_cliente;
import com.example.cursospring.entity.Proveedor;
import com.example.cursospring.service.PedidoClienteService;
import com.example.cursospring.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/proveedor")
@CrossOrigin("http://localhost:3000")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;
    @GetMapping("/listarproveedor")
    public List<Proveedor> indext(){
        return proveedorService.findAll();
    }

    @PostMapping("/crearproveedor")
    public Proveedor save(@RequestBody Proveedor libro){
        return proveedorService.save(libro);
    }

    @GetMapping("/proveedor/{id}")
    public Proveedor findById(@PathVariable Integer id){
        return proveedorService.findById(id);
    }

    @DeleteMapping("/eliminarproveedor/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void eliminar(@PathVariable int id){
        proveedorService.delete(id);
    }

    @PutMapping("/editarproveedor/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Proveedor editar(@RequestBody Proveedor proveedor, @PathVariable Integer id){
        Proveedor proveedoractual=proveedorService.findById(id);
        proveedoractual.setNombre_comercial(proveedor.getNombre_comercial());
        proveedoractual.setCelular(proveedor.getCelular());


        return proveedorService.save(proveedoractual);
    }
}
