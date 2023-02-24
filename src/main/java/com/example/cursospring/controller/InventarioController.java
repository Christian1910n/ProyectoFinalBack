package com.example.cursospring.controller;

import com.example.cursospring.entity.Curso;
import com.example.cursospring.entity.Inventario;
import com.example.cursospring.entity.Proveedor;
import com.example.cursospring.repository.CursoRepository;
import com.example.cursospring.repository.InventarioRepository;
import com.example.cursospring.service.CursoService;
import com.example.cursospring.service.CursoServiceImp;
import com.example.cursospring.service.InventarioService;
import com.example.cursospring.service.InventarioServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/inventario")
@CrossOrigin("http://localhost:3000")
public class InventarioController {
//Implementamos

    @Autowired
    private InventarioRepository inventarioRepository;

    @Autowired
    private InventarioServiceImp  s3service;

    private InventarioService inventarioService;

    //Listar
    @GetMapping("/listarinventario")
    List<Inventario> getAll(){
        return  inventarioRepository.findAll();
    }

    //Crear
    @PostMapping("/crearinventario")
    @ResponseStatus(HttpStatus.CREATED)
    Inventario create(@RequestBody Inventario inventario){
        inventarioRepository.save(inventario);
        return inventario;
    }

    //
    @DeleteMapping("/eliminarinventario")
    @ResponseStatus(HttpStatus.CREATED)
    public String delete(@RequestParam("id") int id) {
        s3service.deleteById(id);
        return "Id: "+ id+ " Eliminado correctamente";
    }

    @PutMapping("/editarinventario/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Inventario editar(@RequestBody Inventario inventario, @PathVariable Integer id){
        Inventario inventarioActual=inventarioService.findById(id);
        inventarioActual.setDescripcion(inventario.getDescripcion());
        inventarioActual.setCantidad(inventario.getCantidad());
        inventarioActual.setValor(inventario.getValor());
        inventarioActual.setFecha_caducidad(inventario.getFecha_caducidad());
        inventarioActual.setTipo(inventario.getTipo());
        inventarioActual.setImagen(inventario.getImagen());
        
        return inventarioService.save(inventarioActual);
    }

}